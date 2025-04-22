<?php
	session_start();
	require_once("sys/template_functions.php");
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
	
	echo '			<div class = "side">';
	
	getMenuListas();
	$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
	getMenuSecundarioCategorias();
	getPesquisaListas();
	getPesquisa();
	
	echo '			</div>'; 

	if(isset($_GET['remover'])) {
		removerProdutoLista($_GET['lista'], $_GET['remover']);
		unset($_GET['remover']);
	}
	
	echo '<div class="content">';
	echo '	<div class="navegacao">';
	echo '		<p class="navegacaoTitulo">';
	echo ' 			<strong>Detalhes da lista:</strong>';
	echo '		</p>';
	echo '	</div>';

	$produtos = listarProdutosLista($_GET["lista"]);
	for($i=0; $i<count($produtos)-1; $i++){
		echo "<div class=\"produto\">";
		echo '<div class="produtoImg"><img class="produto" src="http://www.ip7.com.br/produtos/pap2/pap07.jpg" /></div>';
		echo '<div class="produtoCenter">';
		echo 	"<p class=\"nomeProduto\">{$produtos[$i][1]}</p>";
		echo 	"<p class=\"descricaoProduto\">{$produtos[$i][2]}</p>";
		echo "</div>";

		echo "<div class=\"produtoRighter\">";
		echo "	<a title=\"remover da lista\" href=\"detalhesLista.php?lista={$_GET['lista']}&remover={$produtos[$i][0]}\"><img class=\"produtoRighter\" src=\"images/remove.gif\" /></a>";
		echo "</div>";			
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
	echo '<div class="produtoImg"><img class="produto"$ src="http://www.ip7.com.br/produtos/pap2/pap07.jpg" /></div>';
	echo '<div class="produtoCenter">';
	echo 	"<p class=\"nomeProduto\">{$produtos[$i][1]}</p>";
	echo 	"<p class=\"descricaoProduto\">{$produtos[$i][2]}</p>";
	echo "</div>";

	echo "<div class=\"produtoRighter\">";
		echo "	<a title=\"remover da lista\" href=\"detalhesLista.php?lista={$_GET['lista']}&remover={$produtos[$i][0]}\"><img class=\"produtoRighter\" src=\"images/remove.gif\" /></a>";
	echo "</div>";			

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
	echo '	<br />';
	echo '</div>';
	
	closeConnection($conn);
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
