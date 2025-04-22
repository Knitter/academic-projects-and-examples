<?php
	session_start();
	require_once("db_functions.php");
	require_once("configuracoes.php");
	
	if(isset($_POST["nome"]) && isset($_POST["apelido"]) && isset($_POST["endereco"]) && isset($_POST["cod_postal"]) && isset($_POST["localidade"]) && isset($_POST["contribuinte"]) && isset($_POST["email"]) && isset($_POST["sexo"])){
		$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
		updateUtilizador($_SESSION["id"], $_POST["nome"], $_POST["apelido"], $_POST["endereco"], $_POST["cod_postal"], $_POST["localidade"], $_POST["contribuinte"], $_POST["sexo"], $_POST["email"]);
		closeConnection($conn);
		$move = "Location: http://".$_SERVER['HTTP_HOST'] . rtrim(dirname($_SERVER['PHP_SELF']), '/\\') . "/../perfil.php";
		header($move);
	}	
		
?>
