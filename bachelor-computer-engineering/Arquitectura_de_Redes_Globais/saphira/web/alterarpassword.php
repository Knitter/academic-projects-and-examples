<?php
	session_start();
	if(isset($_SESSION["autenticado"]) && $_SESSION["autenticado"]) {
		require_once("sys/template_functions.php");
		require_once("content/content_alterarpassword.php");
		require_once("sys/configuracoes.php");
		echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">';
		echo '<html>';
		echo '	<head>';
		
		getHead("Saphira");
		
		echo '</head>';
		echo '	<body onload="startClock()">';
		echo '		<div class = "container">';
		
		getHeader();
		getMenuPrincipal();
		
		echo '	<div class = "side">';
		
		getMenuListas();
		$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
		
		getMenuSecundarioCategorias();
		getPesquisaListas();
		getPesquisa();
		
		getConteudoAlterarPassword(($_SESSION["papel"] != getIDNoivo()) ? true : false);
		
		closeConnection($conn);
		getFooter();
		
		echo '		</div>';
		echo '	</body>';
		echo '</html>';
	}else{
		$move = "Location: http://".$_SERVER['HTTP_HOST'] . rtrim(dirname($_SERVER['PHP_SELF']), '/\\') . "/index.php";
		header($move);
	}
?>

<script type="text/javascript">
	<!--
		document.getElementById("username").onkeypress = handleEnterUsername;
		document.getElementById("password").onkeypress = handleEnterPassword;
	// -->
</script>
