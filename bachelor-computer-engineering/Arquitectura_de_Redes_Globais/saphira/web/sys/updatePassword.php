<?php
	session_start();
	require_once("db_functions.php");
	require_once("configuracoes.php");
	
	if(isset($_POST["antiga"]) && isset($_POST["nova"]) && isset($_POST["repetida"])) {//TODO mudar strings de ligacao a base de dados do admin e do utilizador normal
		$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
		if($_POST["nova"] != $_POST["repetida"]) {
			echo 'nova != repetida';//TODO mudar texto
		} else {
			if($_SESSION["papel"] == getIDNoivo()) {
				if(updatePasswordUtilizador($_SESSION["id"], $_POST["antiga"], $_POST["nova"]) == 0){
					$move = "Location: http://".$_SERVER['HTTP_HOST'] . rtrim(dirname($_SERVER['PHP_SELF']), '/\\') . "/../perfil.php";
					header($move);
				}else {
					echo 'a pass não é a correcta';//TODO
				}
			}else {
				if(updatePasswordAdmin($_SESSION["id"], $_POST["antiga"], $_POST["nova"]) == 0){
					$move = "Location: http://".$_SERVER['HTTP_HOST'] . rtrim(dirname($_SERVER['PHP_SELF']), '/\\') . "/../index.php";
					header($move);
				}else {
				echo 'a pass não é a correcta';//TODO
				}
			}
		}
		closeConnection($conn);	
	}			
?>