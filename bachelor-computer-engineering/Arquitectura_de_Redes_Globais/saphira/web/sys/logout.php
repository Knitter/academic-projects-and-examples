<?php
	session_start();
	unset($_SESSION["autenticado"]);
	unset($_SESSION["erroAutenticacao"]);
	unset($_SESSION["papel"]);
	unset($_SESSION["id"]);
	unset($_SESSION["nome"]);

	$_SESSION = array();
	session_destroy();
	$move = "Location: http://".$_SERVER['HTTP_HOST'] . rtrim(dirname($_SERVER['PHP_SELF']), '/\\') . "/../index.php";
	header($move);
?>
