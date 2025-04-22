<?php
	session_start();
	if(isset($_SESSION["autenticado"]) && $_SESSION["autenticado"]) {
		require_once("sys/template_functions.php");
		require_once("content/content_registar.php");
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
		echo '				<strong>Perfil de '. $dados[0][6] .'</strong>';
		echo '			</p>';
		echo '		</div>';
		echo '		<br />';
		echo '	<fieldset class = "fset">';
		echo '		<form class="frm" method="post" name="registar" id="formPerfil" action="sys/updateUtilizador.php" target="_top">';
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="nome">Nome:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		echo '						<input type="text" id="nome" name="nome" value="'.$dados[0][1].'" />*';
		echo '					</div>';
		echo '				</div>';  					
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="apelido">Apelido:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="apelido" name="apelido" value="'.$dados[0][2].'" />*';	
		echo '					</div>';
		echo '				</div>';

		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="sexo">Sexo:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" id="notred">';
		
		if 	($dados[0][10] == "M"){
			echo '					<input type="radio" id="sexoM" name="sexo" value="M" checked="checked"/>Masculino &nbsp;';
			echo '					<input type="radio" id="sexoF" name="sexo" value="F" />Feminino';		
		}else{
			echo '					<input type="radio" id="sexoM" name="sexo" value="M" />Masculino &nbsp;';
			echo '					<input type="radio" id="sexoF" name="sexo" value="F" checked="checked" />Feminino';		
		}
		echo '					</div>';
		echo '				</div>';
												
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="email">E-mail:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="email" name="email" value="'.$dados[0][8].'" />*';
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="contribuinte">Contribuinte</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="contribuinte" name="contribuinte" value="'.$dados[0][9].'" />*';
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="endereco">Endereço</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="endereco" name="endereco" value="'.$dados[0][3].'" />*';		
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="codPostal">Código Postal:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="cod_postal" name="cod_postal" value="'.$dados[0][4].'" />*';	
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="codPostal">Localidade:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="localidade" name="localidade" value="'.$dados[0][5].'" />*';	
		echo '					</div>';
		echo '				</div>';

		echo '				<div class = "tablerow">';
		echo '					<div class="contentRight">';
		echo '						*campos de preenchimento obrigatório.';
		echo '					</div>';
		echo '				</div>';
		echo '		<br />';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<a onclick=' . 'javascript:document.getElementById("formPerfil").submit()' . ' href="#">submeter</a>&nbsp;-&nbsp;';
		echo '				<a onclick=' . 'javascript:document.getElementById("formPerfil").reset()' . ' href="#">anular alterações</a>&nbsp;-&nbsp';
		echo '				<a href="perfil.php">cancelar</a>';
		echo '			</p>';
		echo '		</div>';
		echo '		</form>';
		echo '	</fieldset>';
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
