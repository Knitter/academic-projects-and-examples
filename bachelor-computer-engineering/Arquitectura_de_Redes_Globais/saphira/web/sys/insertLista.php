<?php
	session_start();
	require_once("db_functions.php");
	
	if((isset($_POST["noivo"]) || isset($_POST["noiva"])) && isset($_POST["dia"]) && isset($_POST["mes"]) && isset($_POST["ano"]) && isset($_POST["endereco"]) && isset($_POST["codpostal"]) && isset($_POST["localidade"])){
		$conn = openConnection('localhost', 'root', 'n3witailuve', 'arg');
		if(isset($_POST["noivo"])){
			$noivo = $_POST["noivo"];
			$noiva = $_SESSION["id"];
		}else{
			$noivo = $_SESSION["id"];
			$noiva = $_POST["noiva"];
		}

		criarListaCasamento($noivo, $noiva, $_POST["ano"]. "-" . $_POST["mes"] . "-" . $_POST["dia"], $_POST["endereco"], $_POST["codpostal"], $_POST["localidade"]);
		$_POST = array();
		$move = "Location: http://".$_SERVER['HTTP_HOST'] . rtrim(dirname($_SERVER['PHP_SELF']), '/\\') . "/../minhaslistas.php";
		header($move);
		closeConnection($conn);
	}	
?>
 