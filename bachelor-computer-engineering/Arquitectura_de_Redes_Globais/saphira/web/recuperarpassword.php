<?php
	session_start();
	require_once("sys/template_functions.php");
	require_once("sys/db_functions.php");
	require_once("sys/configuracoes.php");
	require_once("content/content_recuperarpassword.php");
	require_once("sys/utils.php");
	echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">';
	echo '<html>';
	echo '	<head>';
	
	getHead("Saphira");
	
	echo '</head>';
	echo '	<body onload="startClock()">';
	echo '		<div class = "container">';
	
	getHeader();
	getMenuPrincipal();
	
	echo '			<div class = "side">';
	
	getMenuListas();
	$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
	
	getMenuSecundarioCategorias();
	getPesquisaListas();
	getPesquisa();
	
	echo '			</div>';
	
	echo '	<div class="contentLeftAlign" id="content">';
	echo '		<div class="navegacao">';
	echo '			<p class="navegacaoTitulo">';
	echo '				<strong>Recuperar palavra-passe</strong>';
	echo '			</p>';
	echo '		</div>';
	
	if(isset($_POST["userrecovery"])) {
		if($_POST["userrecovery"] != "") {
			echo '				<div class = "tablerow">';
			echo '					<div class="contentLeft">';
			//$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
			
			$email = pesquisaComoVector("SELECT email FROM tbl_utilizador WHERE username = '{$_POST["userrecovery"]}'");
			enviarMailRecuperacao( $email[0][0]);

			echo ' 						A nova palavra-passe foi enviada para o seu e-mail.';
			echo '					</div>';
			echo '				</div>';
		}
		else {
			getErroSemUtilizador();
		}
	}
	else {
		getContentRecuperarPassword();
	}
	closeConnection($conn);
	
	echo '	</div>'; 				

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
