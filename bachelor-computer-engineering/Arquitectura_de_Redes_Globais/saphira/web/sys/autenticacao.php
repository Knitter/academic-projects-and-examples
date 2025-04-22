<?php
	session_start();
	require_once("configuracoes.php");
	$erroAutenticacao;
	
	if(isset($_POST["username"]) && isset($_POST["password"])) {
		require_once("db_functions.php");
		require_once("utils.php");
		require_once("configuracoes.php");
	  	
		$conn = openConnection($host, $dbuser, $dbpass, $dbname);	
	
		$md5 = md5($salt."".$_POST["password"]."".$_POST["username"]."".$salt);
		$queryUtilizador = sprintf("SELECT id, nome FROM tbl_utilizador WHERE username LIKE '%s' AND chave LIKE '%s';", quoteSmart($_POST['username']), quoteSmart($md5));
		$queryAdmin = sprintf("SELECT id FROM tbl_admin WHERE username LIKE '%s' AND chave LIKE '%s';", quoteSmart($_POST['username']), quoteSmart($md5));
		
		$result = mysql_query($queryUtilizador);
		if($result && (mysql_num_rows($result) == 1)) {
			$_SESSION["autenticado"] = true;//autenticado como utilizador
			$_SESSION["erroAutenticacao"] = false;
			$_SESSION["papel"] = getIDNoivo();
			$resultAux = mysql_fetch_assoc($result);
			$_SESSION["nome"] = $resultAux["nome"];
			$_SESSION["id"] = $resultAux["id"];
		}else {
				$result = mysql_query($queryAdmin);
			 	if($result && mysql_num_rows($result) == 1) {
					$resultAux = mysql_fetch_assoc($result);
					$_SESSION["id"] = $resultAux["id"];
			 		$_SESSION["autenticado"] = true;//autenticado como admin
					$_SESSION["erroAutenticacao"] = false;
					$_SESSION["nome"] = $_POST["username"];
					$_SESSION["papel"] = getIDAdministrador();
			 	}else {
					$_SESSION["autenticado"] = false;
					$_SESSION["erroAutenticacao"] = true;
					closeConnection($conn);
					$move = "Location: " . $_POST["sender"];
					header($move);
					exit;			
			 	}
			}
		closeConnection($conn);
		header('Location: ' . $_POST["sender"]);
	}
?>