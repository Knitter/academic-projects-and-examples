<?php
	session_start();
	if(isset($_SESSION["autenticado"]) && $_SESSION["autenticado"]) {
		require_once("sys/template_functions.php");
		require_once("sys/configuracoes.php");
		require_once("sys/db_functions.php");
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
		
		$dados = getUtilizador($_SESSION["id"]);
		
		echo '	</div>';
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo "				<strong>Perfil de {$dados[0][6]}</strong>";
		echo '			</p>';
		echo '		</div>';
		echo '		<br />';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Nome: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][1]} {$dados[0][2]}";
		echo '			</div>';
		echo '		</div>';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Sexo: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		if 	($dados[0][10] == "M")
			echo '				Masculino';
		else
			echo '				Feminino';
		
		echo '			</div>';
		echo '		</div>';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Email: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][8]}";
		echo '			</div>';
		echo '		</div>';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Número de Contribuinte: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][9]}";
		echo '			</div>';
		echo '		</div>';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Endereço: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][3]}";
		echo '			</div>';
		echo '		</div>';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Código Postal: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][4]}";
		echo '			</div>';
		echo '		</div>';
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Localidade: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][5]}";
		echo '			</div>';
		echo '		</div>';
		echo '		<br />';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<a href="alterarperfil.php">alterar perfil</a>&nbsp;-&nbsp;<a href="alterarpassword.php">alterar palavra-passe</a>';
		echo '			</p>';
		echo '		</div>';
		echo '	</div>';

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
