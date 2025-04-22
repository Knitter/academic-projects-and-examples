<?php
	session_start();
	require_once("sys/template_functions.php");
	require_once("sys/db_functions.php");
	require_once("sys/search_functions.php");
	require_once("sys/configuracoes.php");
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
	$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
	
	getMenuSecundarioCategorias();
	getPesquisaListas();
	getPesquisa();
	
	echo '			</div>';
	echo '<div class="content">';
//////////////
	if(isset($_GET["pesquisa"]) && $_GET["pesquisa"] != "") {
	
		$rowsPerPage = 10;
		$pageNum = 1;
		
		if(isset($_GET['page'])) {
			$pageNum = $_GET['page'];
		}
						
		$offset = ($pageNum - 1) * $rowsPerPage;
		$temp = pesquisaSimplesNome(quoteSmart($_GET["pesquisa"]));
		$produtos = pesquisaSimplesNomeComLimite(quoteSmart($_GET["pesquisa"]), $offset, $rowsPerPage);
		
		$numrows = count($temp);
		if($numrows > 0) {
			$maxPage = ceil($numrows/$rowsPerPage);
			$self = $_SERVER['PHP_SELF'];
			
			if($pageNum > 1) {
				$page = $pageNum - 1;
				$prev = " <a href=\"$self?pesquisa={$_GET['pesquisa']}&page=$page\"><img class=\"navegacao\" src=\"images/prev.png\" /></a> &nbsp;&nbsp;";   
				$first = " <a href=\"$self?pesquisa={$_GET['pesquisa']}&page=1\"><img class=\"navegacao\" src=\"images/first.png\" /></a> &nbsp;&nbsp;";
			} 
			else {
				$prev  = " <img class=\"navegacao\" src=\"images/fade_prev.png\" /> &nbsp;&nbsp;";
				$first = " <img class=\"navegacao\" src=\"images/fade_first.png\" /> &nbsp;&nbsp;";
			}
							
			if($pageNum < $maxPage) {
				$page = $pageNum + 1;
				$next = "&nbsp;&nbsp; <a href=\"$self?pesquisa={$_GET['pesquisa']}&page=$page\"><img class=\"navegacao\" src=\"images/next.png\" /></a> ";   
				$last = "&nbsp;&nbsp; <a href=\"$self?pesquisa={$_GET['pesquisa']}&page=$maxPage\"><img class=\"navegacao\" src=\"images/last.png\" /></a> ";
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
			echo '	<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong> " . $next ." " .  $last . '</p>';
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
			echo '	<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong> " . $next ." " .  $last . '</p>';
			echo '</div>';
		}
		else {
			echo '<div class="navegacao">';
			echo '	<p class="navegacao">Não foram encontrados produtos pesquisando por: "' . $_GET["pesquisa"] .'"';
			echo '</div>';
		}
	}	else {
			echo '<div class="navegacao">';
			echo '	<p class="navegacao">Não especificou um termo de pesquisa';
			echo '</div>';
	}
	
	closeConnection($conn);
	//////////////
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