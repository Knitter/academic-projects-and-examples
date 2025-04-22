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

	echo '<div class="content">';
	echo '	<div class="navegacao">';
	echo '		<p class="navegacaoTitulo">';
	echo ' 			<strong>Lista de Utilizadores</strong>';
	echo '		</p>';
	echo '	</div>';
	echo '	<br />';
	if(isset($_GET["r"])) {
		removerUtilizador(quoteSmart($_GET["r"]));
		unset($_GET["r"]);
	}	

	$rowsPerPage = 10;
	$pageNum = 1;
	
	if(isset($_GET['page'])) {
		$pageNum = $_GET['page'];
	}

	$offset = ($pageNum - 1) * $rowsPerPage;

	$temp = getListaUtilizadores();
	$listaUtilizadores = getListaUtilizadoresComLimite($offset, $rowsPerPage);
	
	$numrows = count($temp);
	if($numrows > 0){
		
		$maxPage = ceil($numrows/$rowsPerPage);
		$self = $_SERVER['PHP_SELF'];
				
		if ($pageNum > 1) {
		  $page = $pageNum - 1;

		  $prev = ' <a href="$self?&page=$page"><img class="navegacao" src="images/prev.png" /></a> &nbsp;&nbsp;';
		  $first = ' <a href="$self?&page=1"><img class="navegacao" src="images/first.png" /></a> &nbsp;&nbsp;';
		} 
		else {
			$prev  = ' <img class="navegacao" src="images/fade_prev.png" /> &nbsp;&nbsp;';
			$first = ' <img class="navegacao" src="images/fade_first.png" /> &nbsp;&nbsp;';
		}
			
		if ($pageNum < $maxPage) {
			$page = $pageNum + 1;
			$next = '&nbsp;&nbsp; <a href="$self?&page=$page"><img class="navegacao" src="images/next.png" /></a> ';
			$last = '&nbsp;&nbsp; <a href="$self?&page=$maxPage"><img class="navegacao" src="images/last.png" /></a> ';
		} 
		else {
			$next = '&nbsp;&nbsp; <img class="navegacao" src="images/fade_next.png" />';
			$last = '&nbsp;&nbsp; <img class="navegacao" src="images/fade_last.png" />';
		}
		
		echo '<div class="navegacao">';
		echo '	<div class="navegacaoSide">';
		echo '		<form>';
		echo '			resultados por p�gina: <select><option>5</option><option selected="selected">10</option><option>15</option><option>20</option></select>'; 
		echo '		</form>';
		echo '	</div>';
		echo '	<p class="navegacao">' . $first . $prev . " p�gina <strong>$pageNum</strong> de <strong>$maxPage</strong>" . $next . $last . '</p>';
		echo '</div>';
		
		
		
		for($i = 0; $i < count($listaUtilizadores) - 1; $i++) {
			echo '<div class="lista">';
			echo "	<a href=\"listarutilizadores.php?r={$listaUtilizadores[$i][0]}\"><img class=\"lista\" src=\"images/drop.png\" /></a>"; 			
			echo "	<p class=\"lista\">{$listaUtilizadores[$i][1]}&nbsp;{$listaUtilizadores[$i][2]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>utilizador:</strong> {$listaUtilizadores[$i][6]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"mailto:{$listaUtilizadores[$i][8]}\">{$listaUtilizadores[$i][8]}</a></p>"; 			
			echo '</div>';
		}
		echo '<div class="ultimaLista">';
		echo "	<a href=\"listarutilizadores.php?r={$listaUtilizadores[$i][0]}\"><img class=\"lista\" src=\"images/drop.png\" /></a>"; 			
		echo "	<p class=\"lista\">{$listaUtilizadores[$i][1]}&nbsp;{$listaUtilizadores[$i][2]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>utilizador:</strong> {$listaUtilizadores[$i][6]}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"mailto:{$listaUtilizadores[$i][8]}\">{$listaUtilizadores[$i][8]}</a></p>";
		echo '</div>';
		
		echo '<div class="navegacao">';
		echo '	<div class="navegacaoSide">';
		echo '		<form>';
		echo '			resultados por p�gina: <select><option>5</option><option selected="selected">10</option><option>15</option><option>20</option></select>'; 
		echo '		</form>';
		echo '	</div>';
		echo '	<p class="navegacao">' . $first . $prev . " p�gina <strong>$pageNum</strong> de <strong>$maxPage</strong>" . $next . $last . '</p>';
		echo '</div>';
		
	}else{
		echo '<p>N�o existem utilizadores a mostrar.</p>';
	}	
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