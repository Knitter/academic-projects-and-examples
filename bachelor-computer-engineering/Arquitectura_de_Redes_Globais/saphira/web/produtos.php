<?php
	session_start();
	require_once("sys/template_functions.php");
	require_once("sys/db_functions.php");
	require_once("sys/search_functions.php");
	require_once("sys/configuracoes.php");
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
/////////////////////////

	
	$rowsPerPage = 10;
	if(isset($_GET['rpp'])) {
		$rowsPerPage = $_GET['rpp'];
	}
	
	$pageNum = 1;
	if(isset($_GET['page'])) {
		$pageNum = $_GET['page'];
	}

	if(isset($_GET['adicionar'])) {
		adicionarProdutoLista($_GET['adicionar'], $_SESSION['activa'], 1);
		unset($_GET['adicionar']);
	}
					
	$offset = ($pageNum - 1) * $rowsPerPage;

	if(!ctype_digit($_GET["categoria"])) {
		$categoria = 0;
	}else{
		$categoria=$_GET["categoria"];
	}
	
	$query   = "SELECT COUNT(*) AS numrows FROM tbl_produto WHERE id_categoria = $categoria";
	$result  = mysql_query($query) or die('Error, query failed');
	$row     = mysql_fetch_array($result);
					
	$numrows = $row[0];
	if( $numrows > 0) {
		
		$maxPage = ceil($numrows/$rowsPerPage);
		$self = $_SERVER['PHP_SELF'];
	
		if ($pageNum > 1) {
		  $page = $pageNum - 1;

		  $prev = " <a title=\"anterior\" href=\"$self?super={$_GET['super']}&categoria={$_GET['categoria']}&page=$page&rpp={$rowsPerPage}\"><img class=\"navegacao\" src=\"images/prev.png\" /></a> &nbsp;&nbsp;";
		  $first = " <a title=\"primeira\" href=\"$self?super={$_GET['super']}&categoria={$_GET['categoria']}&page=1&rpp={$rowsPerPage}\"><img class=\"navegacao\" src=\"images/first.png\" /></a> &nbsp;&nbsp;";
		} 
		else {
			$prev  = ' <img src="images/fade_prev.png" /> &nbsp;&nbsp; ';
			$first = ' <img src="images/fade_first.png" /> &nbsp;&nbsp;';
		}
			
		if ($pageNum < $maxPage) {
			$page = $pageNum + 1;
			$next = " &nbsp;&nbsp;<a title=\"próxima\" href=\"$self?super={$_GET['super']}&categoria={$_GET['categoria']}&page=$page&rpp={$rowsPerPage}\"><img class=\"navegacao\" src=\"images/next.png\" /></a> ";
			$last = " &nbsp;&nbsp;<a title=\"última\" href=\"$self?super={$_GET['super']}&categoria={$_GET['categoria']}&page=$maxPage&rpp={$rowsPerPage}\"><img class=\"navegacao\" src=\"images/last.png\" /></a> ";
		} 
		else {
			$next = ' &nbsp;&nbsp;<img class="navegacao" src="images/fade_next.png" /> ';
			$last = ' &nbsp;&nbsp;<img src="images/fade_last.png" /> ';
		}
						
		echo '<div class="navegacao">';
		echo '<div class="navegacaoSide">';
		echo '<form>';
		echo '<input type="hidden" name="rpp" id="rpp" value=""/>';
		echo "resultados por página: <select id=\"selectRPPTop\" onchange='changeRPP(\"selectRPPTop\", \"{$_GET['super']}\", {$_GET['categoria']})'><option>5</option><option selected=\"selected\">10</option><option>15</option><option>20</option></select>"; 
		echo '</form>';
		echo '</div>';
		echo '<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong> " . $next ." " .  $last . '</p>';
		echo '</div>';

		$produtos = listarProdutos($categoria, $offset, $rowsPerPage);
		for($i=0; $i<count($produtos)-1; $i++){
			echo "<div class=\"produto\">";
			echo '<div class="produtoImg"><img class="produto"$ src="'.$produtos[$i][8].'" /></div>';
			echo '<div class="produtoCenter">';
			echo 	"<p class=\"nomeProduto\">{$produtos[$i][1]}</p>";
			echo 	"<p class=\"descricaoProduto\">{$produtos[$i][2]}</p>";
			echo "</div>";

			if($_SESSION["autenticado"]){
				echo "<div class=\"produtoRighter\">";
				echo "	<a title=\"adicionar à lista activa\" href=\"produtos.php?super={$_GET['super']}&categoria={$_GET['categoria']}&page={$pageNum}&adicionar={$produtos[$i][0]}\"><img class=\"produtoRighter\" src=\"images/add.gif\" /></a>";
				echo "</div>";			
			}
			echo "<div class=\"produtoRight\">";
			echo 	"<p class=\"descricaoProduto\"><strong>preço:&nbsp;</strong> {$produtos[$i][3]}&euro;</p>";
			echo 	"<p class=\"descricaoProduto\"><strong>desconto:&nbsp;</strong>{$produtos[$i][5]}%</p>";
			echo 	"<p class=\"descricaoProduto\"><strong>pvp recomendado:&nbsp;</strong>{$produtos[$i][6]}&euro;</p>";
			
			if ($produtos[$i][7] == 0) {
				echo 	"<p class=\"descricaoProduto\"><strong>disponível:</strong> sim</p>";
			}
			else {
				echo 	"<p class=\"descricaoProduto\"><strong>disponível:</strong> não</p>";
			}
			echo 	"</div>";
			echo "</div>";
		}
	
		echo "<div class=\"ultimoProduto\">";
		echo '<div class="produtoImg"><img class="produto"$ src="'.$produtos[$i][8].'" /></div>';
		echo '<div class="produtoCenter">';
		echo 	"<p class=\"nomeProduto\">{$produtos[$i][1]}</p>";
		echo 	"<p class=\"descricaoProduto\">{$produtos[$i][2]}</p>";
		echo "</div>";

		if($_SESSION["autenticado"]){
			echo "<div class=\"produtoRighter\">";
			echo "	<a title=\"adicionar à lista activa\" href=\"produtos.php?super={$_GET['super']}&categoria={$_GET['categoria']}&page={$pageNum}&adicionar={$produtos[$i][0]}\"><img class=\"produtoRighter\" src=\"images/add.gif\" /></a>";
			echo "</div>";			
		}
		echo "<div class=\"produtoRight\">";
		echo 	"<p class=\"descricaoProduto\"><strong>preço:&nbsp;</strong> {$produtos[$i][3]}&euro;</p>";
		echo 	"<p class=\"descricaoProduto\"><strong>desconto:&nbsp;</strong>{$produtos[$i][5]}%</p>";
		echo 	"<p class=\"descricaoProduto\"><strong>pvp recomendado:&nbsp;</strong>{$produtos[$i][6]}&euro;</p>";
	
		if ($produtos[$i][7] == 0) {
			echo 	"<p class=\"descricaoProduto\"><strong>disponível: </strong>sim</p>";
		}
		else {
			echo 	"<p class=\"descricaoProduto\"><strong>disponível: </strong>não</p>";
		}
	
		echo 	"</div>";

		echo "</div>";
	
		echo '<div class="navegacao">';
		echo '<div class="navegacaoSide">';
		echo '<form>';
		echo "resultados por página: <select id=\"selectRPPBottom\" onchange='changeRPP(\"selectRPPBottom\", \"{$_GET['super']}\", {$_GET['categoria']})'><option>5</option><option selected=\"selected\">10</option><option>15</option><option>20</option></select>"; 
		
		echo '</form>';
		echo '</div>';
		echo '<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong> " . $next ." " .  $last . '</p>';
		echo '</div>';
	}
	else {
		echo '<div class="navegacao">';
		echo '<p class="navegacao">Não existem produtos a mostrar.</p>';
		echo '</div>';
	}
	closeConnection($conn);

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
