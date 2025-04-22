<?php
	session_start();
	//redireccionar, se estiver autenticadoTODO
	require_once("sys/db_functions.php");
	require_once("sys/utils.php");
	require_once("sys/template_functions.php");
	require_once("sys/configuracoes.php");
		require_once("content/content_registar.php");
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
	
	if(!isset($_POST["registo"])) {
		getMenuListas();
		getPassosRegisto(1);
		getPesquisaListas();
		getPesquisa();
		echo '			</div>';
		getPaginaRegisto();
	}else {
		getMenuListas();
		getPassosRegisto(2);
		getPesquisaListas();
		getPesquisa();
		echo '			</div>';
		
		$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
		
		$userPretendido = quoteSmart($_POST["usernameRegisto"]);
		
		if(count(pesquisaComoVector("SELECT 1 FROM tbl_utilizador WHERE username LIKE '{$userPretendido}'")) > 0) {
			getErroUtilizadorDuplicado();
		}elseif (!ctype_digit($_POST["contribuinte"])) {
			getErroContribuinte();
		}else {
			adicionarUtilizador($_POST["nome"], $_POST["apelido"], $_POST["endereco"], $_POST["codPostal"], $_POST["localidade"], $_POST["contribuinte"], $_POST["usernameRegisto"], $_POST["passwordRegisto"], $_POST["sexo"], $_POST["email"]);
			getPaginaSucesso();
		}
	}
	
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