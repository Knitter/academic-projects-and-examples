<?php
	session_start();
	require_once("sys/template_functions.php");
	require_once("content/content_fichatecnica.php");
	echo '<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">';
	echo '<html>';
	echo '	<head>';
	
	getHead("Saphira > Localização");
	
	echo '</head>';
	echo '	<body>';
	echo '		<div class = "container">';

	getHeader();				
	getMenuPrincipal();

	echo '			<div class = "side">';
	
	getMenuListas();
	getMenuSecundarioFichaTecnica();
	getPesquisaListas();
	getPesquisa();
	echo '			</div>';

	getContentQuemSomos();
	getFooter();

	echo '		</div>';
	echo '	</body>';
	echo '</html>';
?>

<script type="text/javascript">
	<!--
		document.getElementById("username").onkeypress = handleEnterUsername;
		document.getElementById("password").onkeypress = handleEnterPassword;
	// -->
</script>