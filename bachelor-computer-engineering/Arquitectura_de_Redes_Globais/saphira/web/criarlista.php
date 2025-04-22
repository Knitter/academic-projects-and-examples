<?php
	session_start();
	echo '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">';
	require_once("sys/template_functions.php");
	require_once("sys/db_functions.php");
	require_once("sys/configuracoes.php");
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
	
	echo '<div class="content">';
	echo '	<div class="navegacao">';
	echo '		<p class="navegacaoTitulo">';
	echo '			<strong>Criar Lista</strong>';
	echo '		</p>';
	echo '	</div>';
	echo '	<br />';
	echo '		<form class="frm" method="post" name="criarLista" id="criarLista" action="sys/insertLista.php" target="_top">';
	 
	$dados = getUtilizador($_SESSION["id"]);
	if($dados[0][10] == "M"){
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Noivo: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][1]} {$dados[0][2]}";
		echo '			</div>';
		echo '		</div>';
	}else{
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="noivo">Noivo:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		$noivos = getSolteiroBySexo("M");
		echo '						<select id="noivo" name="noivo">';
		for($i = 0; $i<count($noivos); $i++)
			echo "						<option value=\"{$noivos[$i][0]}\">" . $noivos[$i][1] . " " . $noivos[$i][2] . "</option>";
		echo '						</select>';
		echo '					</div>';
		echo '				</div>';
	}
	
	if($dados[0][10] == "F"){
		echo '		<div class="tablerow">';
		echo '			<div class="contentLeft">';
		echo '				<strong>Noiva: </strong>';
		echo '			</div>';
		echo '			<div class="contentRight" id="notred">';
		echo "				{$dados[0][1]} {$dados[0][2]}";
		echo '			</div>';
		echo '		</div>';
	}else{
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="noiva">Noiva:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		$noivos = getSolteiroBySexo("F");
		echo '						<select id="noiva" name="noiva">';
		for($i = 0; $i<count($noivos); $i++)
			echo "						<option value=\"{$noivos[$i][0]}\">" . $noivos[$i][1] . " " . $noivos[$i][2] . "</option>";
		echo '						</select>';
		echo '					</div>';
		echo '				</div>';
	}
	echo '				<div class = "tablerow">';
	echo '					<div class="contentLeft">';
	echo '						<label for="data">Data do Casamento:</label>';
	echo '					</div>';
	echo '					<div class = "contentRight">';
	echo '						<select id="dia" name="dia">';
	for($i = 1; $i<=31; $i++)
		if($i == date("d"))
			echo "						<option value=\"{$i}\" SELECTED>" . $i . "</option>";
		else
			echo "						<option value=\"{$i}\">" . $i . "</option>";
	echo '						</select>';
	echo '						<select id="mes" name="mes">';
	for($i = 1; $i<=12; $i++)
		if($i == date("m"))
			echo "						<option value=\"{$i}\" SELECTED>" . $i . "</option>";
		else
			echo "						<option value=\"{$i}\">" . $i . "</option>";
	echo '						</select>';
	echo '						<select id="ano" name="ano">';
	
	for($i = date("Y"); $i<=date("Y")+5; $i++)
		echo "						<option value=\"{$i}\">" . $i . "</option>";
	echo '						</select>';
	echo '					</div>';
	echo '				</div>';
											
	echo '				<div class = "tablerow">';
	echo '					<div class="contentLeft">';
	echo '						<label for="endereco:">Morada onde se realiza:</label>';
	echo '					</div>';
	echo '					<div class = "contentRight" >';
	echo '						<input type="text" id="endereco" name="endereco" />*';
	echo '					</div>';
	echo '				</div>';
					
	echo '				<div class = "tablerow">';
	echo '					<div class="contentLeft">';
	echo '						<label for="codpostal:">Código Postal:</label>';
	echo '					</div>';
	echo '					<div class = "contentRight" >';
	echo '						<input type="text" id="codpostal" name="codpostal" />*';
	echo '					</div>';
	echo '				</div>';
					
	echo '				<div class = "tablerow">';
	echo '					<div class="contentLeft">';
	echo '						<label for="localidade:">Localidade:</label>';
	echo '					</div>';
	echo '					<div class = "contentRight" >';
	echo '						<input type="text" id="localidade" name="localidade" />*';
	echo '					</div>';
	echo '				</div>';
					
	closeConnection($conn);

	echo '				<div class = "tablerow">';
	echo '					<div class="contentRight">';
	echo '						*campos de preenchimento obrigatório.';
	echo '					</div>';
	echo '				</div>';
	echo '		<br />';
	echo '	<div class="navegacao">';
	echo '		<p class="navegacaoTitulo">';
	echo '				<a onclick=' . 'javascript:document.getElementById("criarLista").submit()' . ' href="#">criar</a>';
	echo '		</p>';
	echo '	</div>';
	echo '</form>';
	echo '</div>';

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
