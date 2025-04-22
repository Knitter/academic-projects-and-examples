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
		
		echo '	</div>';
		
		$categoriaPai = -1;
		$descricao='';
		$desconto='';
		$pvp='';
		$preco='';
		$nomeProduto='';
		
		if(!isset($_POST["escondido"]) || ($_POST["escondido"] < 0)) {
			if(isset($_POST["categoriaPai"]))
				$categoriaPai = $_POST["categoriaPai"];
		
			if(isset($_POST["nomeProduto"]))
				$nomeProduto = $_POST["nomeProduto"];	
			
			if(isset($_POST["preco"]))
				$preco = $_POST["preco"];		
		
			if(isset($_POST["pvp"]))
				$pvp = $_POST["pvp"];	
		
			if(isset($_POST["desconto"]))
				$desconto = $_POST["desconto"];	

			if(isset($_POST["descricao"]))
				$descricao = $_POST["descricao"];
				
			if(isset($_POST["fotografia"]))
				$fotografia = $_POST["fotografia"];			
		
			echo '	<div class="contentLeftAlign" id="content">';
			echo '		<div class="navegacao">';
			echo '			<p class="navegacaoTitulo">';
			echo "				<strong>Novo Produto</strong>";
			echo '			</p>';
			echo '		</div>';
			echo '		<br />';
			echo ' <form id="formNovoProduto" id="formNovoProduto" action="introduzirprodutos.php" method="post"> ';
			
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="nomeProduto">Nome:</label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="text" name="nomeProduto" id="nomeProduto" value="'. $nomeProduto .'"/>*';
			echo '			</div>';
			echo '		</div>';
			
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="categoriaPai">Categoria Principal:</label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			
			$super = obterSuperCategorias();
			$lenght = count($super);
			echo '				<select name="categoriaPai" id="categoriaPai" onchange=\'javascript:document.getElementById("formNovoProduto").submit()\'>*';
			for($i = 0; $i < $lenght; $i++) {
				if($categoriaPai == $super[$i][0]) {
					echo "	<option value=\"{$super[$i][0]}\" selected=\"selected\">{$super[$i][1]}</option>";
				}else {
					echo "					<option value=\"{$super[$i][0]}\">{$super[$i][1]}</option>";
				}
			}
			echo '				</select>';
			echo '			</div>';
			echo '		</div>';
			
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="subCategoria">SubCategoria:</label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			if($categoriaPai > -1) {
				$sub = obterSubCategorias($categoriaPai);
				$lenght = count($sub);
				echo '				<select name="subCategoria" id="subCategoria">*';
				for($i = 0; $i < $lenght; $i++) {
					echo "					<option value=\"{$sub[$i][0]}\">{$sub[$i][1]}</option>";
				}
			}else{
				echo ' <select name="subCategoria" id="subCategoria">';
				echo '	<option value="-1">escolha categoria pai</option>';
			}
			echo '				</select>';
			echo '			</div>';
			echo '		</div>';
			
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="pvp">PVP: </label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="text" name="pvp" id="pvp" value="' . $pvp .'"/>*';
			echo '			</div>';
			echo '		</div>';
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="desconto">Desconto: </label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="text" name="desconto" id="desconto" value="' . $desconto .'"/>*';
			echo '			</div>';
			echo '		</div>';
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="preco">Preço: </label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="text" name="preco" id="preco" value="' . $preco .'"/>*';
			echo '			</div>';
			echo '		</div>';
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="descricao">Descrição: </label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="text" id="descricao" name="descricao" value="' . $descricao .'"/>*';
			echo '			</div>';
			echo '		</div>';

			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="fotografia">Fotografia: </label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="text" id="fotografia" name="fotografia" value="'. $fotografia.'"/>';
			echo '			</div>';
			echo '		</div>';
			
			echo '		<div class="tablerow">';
			echo '			<div class="contentLeft">';
			echo '				<label for="entrega">Entrega Imediata: </label>';
			echo '			</div>';
			echo '			<div class="contentRight">';
			echo '				<input type="checkbox" id="entrega" name="entrega" checked="checked" value="1" />';
			echo '			</div>';
			echo '		</div>';




			echo '		<br />';
			echo '		<div class="navegacao">';
			echo '			<p class="navegacaoTitulo">';
			echo '				<a href="#" onclick="validarNovoProduto()">criar</a>&nbsp;-&nbsp;<a href="index.php">cancelar</a>';
			echo '			</p>';
			echo '		</div>';
			echo ' <input type="hidden" id="escondido" value="-1" />';
			echo ' 	</form>';
			echo '	</div>';
		}else {
			introduzirNovoProduto(quoteSmart($_POST["nomeProduto"]), quoteSmart($_POST["descricao"]), quoteSmart($_POST["preco"]), quoteSmart($_POST["desconto"]), quoteSmart($_POST["pvp"]), (quoteSmart($_POST["entrega"]) == 1 ? 1 : 0), quoteSmart($_POST["fotografia"]), quoteSmart($_POST["categoriaPai"]));
			$_POST= array();
			//header();
			//closeConnection($conn);
		}

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
