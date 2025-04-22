<?php
	session_start();
	require_once("sys/configuracoes.php");
	require_once("sys/template_functions.php");
	require_once("sys/db_functions.php");
	require_once("sys/search_functions.php");
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
	$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
	
	getMenuSecundarioCategorias();
	getPesquisaListas();
	getPesquisa();
	
	echo '			</div>';
	echo '<div class="content">';
	///////////////////////////
	if(!isset($_GET["campo_pesquisa"]) || $_GET["campo_pesquisa"] == "") {
		
		echo '<div class="navegacao">';
		echo '	<p class="navegacaoTitulo"><strong>Pesquisa avançada</strong></p>';
		echo '</div>';
			
		
		$results = obterSuperCategorias();
		$numCategorias = count($results);
		echo '<form action="pesquisaavancada.php" method="get" name="formPesquisaAvancada" id="formPesquisaAvancada">'; 
		echo '<div class= "tablerow">';
		echo '	<div class="contentLeft">';
		echo '		Procurar por:';
		echo '	</div>';
		echo '	<div class="contentRight" id="notred">';
		echo '		Categoria:';
		echo '	</div>';
		echo '</div>';
		
		echo '<div class= "tablerow">';
		echo '	<div class="contentLeft">';
		echo '		<input class="pesquisa" type="text" name="campo_pesquisa" id="campo_pesquisa" />';
		echo '	</div>';
		echo '	<div class="contentLeft">';
		echo '		<select name="combo_categorias" id="combo_categorias" />';
		echo '			<option value="-1">qualquer categoria</option>';
		
		for($i = 0; $i < $numCategorias; $i++ ) {
			echo "	<option value=\"{$results[$i][0]}\">{$results[$i][1]}</option>";
		}
		
		echo '		</select>';
		echo '	</div>';
		echo '</div>';
		
		echo '<div class= "tablerow">';
		echo '	<div class="contentLeft">';
		echo '		Opções:';
		echo '	</div>';
		echo '</div>';
		
		echo '<div class= "tablerow">';
		echo '	<div class="contentLeft">';
		echo '		<input type="radio" name="palavras" id="qualquer_palavras" value="qualquer" checked="checked"/> qualquer palavra';
		echo '	</div>';
		echo '</div>';
		
		echo '<div class= "tablerow">';
		echo '	<div class="contentLeft">';
		echo '		<input type="radio" name="palavras" id="todas_palavras" value="todas" /> todas as  palavras';
		echo '	</div>';
		echo '</div>';
		
		echo '<div class= "tablerow">';
		echo '</div>';
		
		echo '<div class= "tablerow">';
		echo '	<div class="contentLeft">';
		echo '		Resultados por página: <select name="resultados_pagina" id="resultados_pagina">';
		echo '			<option>5</option>';
		echo '			<option selected="selected">10</option>';
		echo '			<option>15</option>';
		echo '			<option>20</option>';
		echo '		</select>';
		echo '	</div>';
		echo '</div>';
		
		echo '		<br />';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<a onclick=\'javascript:document.getElementById("formPesquisaAvancada").submit()\' href="#">pesquisar &raquo;</a>';
		echo '			</p>';
		echo '		</div>';
		
		
		
		echo '</form>';
	}
	else {
	///////////////////////////			
		$rowsPerPage = quoteSmart($_GET["resultados_pagina"]);
		$pageNum = 1;
		
		if(isset($_GET['page'])) {
			$pageNum = $_GET['page'];
		}
						
		$offset = ($pageNum - 1) * $rowsPerPage;
		
		$opcao = 0;
		if($_GET["palavras"] != "qualquer") {
			$opcao = 1;
		}	
		
		$temp = pesquisaAvancada($_GET["campo_pesquisa"], $opcao, $_GET["combo_categorias"]);
		$produtos = pesquisaAvancadaComLimite($_GET["campo_pesquisa"], $opcao, $_GET["combo_categorias"],$offset, $rowsPerPage);
		
		$numrows = count($temp);

		if($numrows > 0) {
			$maxPage = ceil($numrows/$rowsPerPage);
			$self = $_SERVER['PHP_SELF'];
			
			if($pageNum > 1) {
				$page = $pageNum - 1;
				$prev = " <a href=\"$self?campo_pesquisa={$_GET['campo_pesquisa']}&combo_categorias={$_GET['combo_categorias']}&palavras={$_GET['palavras']}&resultados_pagina={$_GET['resultados_pagina']}&page=$page\"><img class=\"navegacao\" src=\"images/prev.png\" /></a> &nbsp;&nbsp;";   
				$first = " <a href=\"$self?campo_pesquisa={$_GET['campo_pesquisa']}&combo_categorias={$_GET['combo_categorias']}&palavras={$_GET['palavras']}&resultados_pagina={$_GET['resultados_pagina']}&page=1\"><img class=\"navegacao\" src=\"images/first.png\" /></a> &nbsp;&nbsp;";
			} 
			else {
				$prev  = " <img class=\"navegacao\" src=\"images/fade_prev.png\" /> &nbsp;&nbsp;";
				$first = " <img class=\"navegacao\" src=\"images/fade_first.png\" /> &nbsp;&nbsp;";
			}
							
			if($pageNum < $maxPage) {
				$page = $pageNum + 1;
				$next = "&nbsp;&nbsp; <a href=\"$self?campo_pesquisa={$_GET['campo_pesquisa']}&combo_categorias={$_GET['combo_categorias']}&palavras={$_GET['palavras']}&resultados_pagina={$_GET['resultados_pagina']}&page=$page\"><img class=\"navegacao\" src=\"images/next.png\" /></a> ";   
				$last = "&nbsp;&nbsp; <a href=\"$self?campo_pesquisa={$_GET['campo_pesquisa']}&combo_categorias={$_GET['combo_categorias']}&palavras={$_GET['palavras']}&resultados_pagina={$_GET['resultados_pagina']}&page=$maxPage\"><img class=\"navegacao\" src=\"images/last.png\" /></a> ";
			} 
			else {
				$next = "&nbsp;&nbsp; <img class=\"navegacao\" src=\"images/fade_next.png\" />";
				$last = "&nbsp;&nbsp; <img class=\"navegacao\" src=\"images/fade_last.png\" />";
			}
							
			echo '<div class="navegacao">';
			echo '	<div class="navegacaoSide">';
			echo '		<form>';
			echo '			resultados por página: <select><option selected="selected">5</option><option>10</option><option>15</option><option>20</option></select>'; 
			echo '		</form>';
			echo '	</div>';
			echo '	<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong> " . $next . " " .  $last . '</p>';
			echo '</div>';
		
			for($i=0; $i<count($produtos)-1; $i++) {
				echo '<div class="produto">';
				echo '	<div class="produtoImg"><img class="produto"$ src="http://www.ip7.com.br/produtos/pap2/pap07.jpg" /></div>';
				echo '	<div class="produtoCenter">';
				echo 	"<p class=\"nomeProduto\">{$produtos[$i][1]}</p>";
				echo 	"<p class=\"descricaoProduto\">{$produtos[$i][2]}</p>";
				echo "</div>";
				echo "<div class=\"produtoRight\">";
				echo 	"<p class=\"descricaoProduto\"><strong>preço:&nbsp;</strong> {$produtos[$i][3]}&euro;</p>";
				echo 	"<p class=\"descricaoProduto\"><strong>desconto:&nbsp;</strong>{$produtos[$i][5]}%</p>";
				echo 	"<p class=\"descricaoProduto\"><strong>pvp recomendado:&nbsp;</strong>{$produtos[$i][6]}&euro;</p>";
				
				if ($produtos[$i][7] == 0) {
					echo 	"<p class=\"descricaoProduto\"><strong>disponível:</strong>sim</p>";
				}
				else {
					echo 	"<p class=\"descricaoProduto\"><strong>disponível:</strong>não</p>";
				}
				
				echo 	"</div>";
				echo "</div>";
			}
			
			echo "<div class=\"ultimoProduto\">";
			echo '<div class="produtoImg"><img class="produto"$ src="http://www.ip7.com.br/produtos/pap2/pap07.jpg" /></div>';
			echo '<div class="produtoCenter">';
			echo 	"<p class=\"nomeProduto\">{$produtos[$i][1]}</p>";
			echo 	"<p class=\"descricaoProduto\">{$produtos[$i][2]}</p>";
			echo "</div>";
			echo "<div class=\"produtoRight\">";
			echo 	"<p class=\"descricaoProduto\"><strong>preço:&nbsp;</strong> {$produtos[$i][3]}&euro;</p>";
			echo 	"<p class=\"descricaoProduto\"><strong>desconto:&nbsp;</strong>{$produtos[$i][5]}%</p>";
			echo 	"<p class=\"descricaoProduto\"><strong>pvp recomendado:&nbsp;</strong>{$produtos[$i][6]}&euro;</p>";
			
			if ($produtos[$i][7] == 0) {
				echo 	"<p class=\"descricaoProduto\"><strong>disponível:</strong>sim</p>";
			}
			else {
				echo 	"<p class=\"descricaoProduto\"><strong>disponível:</strong>não</p>";
			}
			
			echo '</div>';
			echo '</div>';
			echo '<div class="navegacao">';
			echo '	<div class="navegacaoSide">';
			echo '		<form>';
			echo '			resultados por página: <select><option selected="selected">5</option><option>10</option><option>15</option><option>20</option></select>'; 
			echo '		</form>';
			echo '	</div>';
			echo '	<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong> " . $next . " " .  $last . '</p>';
			echo '</div>';
		}
		else {
			echo '<div class="navegacao">';
			echo '	<p class="navegacao">Não foram encontrados produtos pesquisando por: "' . $_GET["campo_pesquisa"] .'" &nbsp;&nbsp;&nbsp;';
			echo '	<a href="pesquisaavancada.php">Voltar à página de pesquisa avançada.</a></p>';
			echo '</div>';
		}
		//closeConnection($conn);
	 }
	closeConnection($conn);
	/////////////////////////
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