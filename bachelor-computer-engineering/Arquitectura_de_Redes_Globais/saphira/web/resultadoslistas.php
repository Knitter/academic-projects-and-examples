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
	echo ' 			<strong>Listas de Casamento</strong>';
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

	$temp = mostrarTodasListas();
	$listas = getListasNoivoNoiva($_GET['noivo'], $_GET['noiva']);
	
	$numrows = count($temp);
	if($numrows > 0){
		
		$maxPage = ceil($numrows/$rowsPerPage);
		$self = $_SERVER['PHP_SELF'];
				
		if ($pageNum > 1) {
		  $page = $pageNum - 1;

		  $prev = " <a href=\"$self?&page=$page\">[anterior]</a> ";
		  $first = " <a href=\"$self?&page=1\">[primeira página]</a> ";
		} 
		else {
			$prev  = ' [anterior] ';
			$first = ' [primeira página] ';
		}
			
		if ($pageNum < $maxPage) {
			$page = $pageNum + 1;
			$next = " <a href=\"$self?&page=$page\">[próxima]</a> ";
			$last = " <a href=\"$self?&page=$maxPage\">[última página]</a> ";
		} 
		else {
			$next = '[próxima]';
			$last = '[última página]';
		}
		
/*		echo '<div class="navegacao">';
		echo '	<div class="navegacaoSide">';
		echo '		<form>';
		echo '			resultados por página: <select><option>5</option><option selected="selected">10</option><option>15</option><option>20</option></select>'; 
		echo '		</form>';
		echo '	</div>';
		echo '	<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong>" . $next . $last . '</p>';
		echo '</div>';
	*/	
		
		if(count($listas)>0){
			for($i=0; $i<count($listas) - 1; $i++){
				$noivo = getUtilizador($listas[$i][6]);
				$noiva = getUtilizador($listas[$i][7]);
				echo "<div class=\"lista\">";
				echo '<a href="aderirlista.php?aderir='.$listas[$i][0].'"><img class="lista" src="images/aderir.png" /></a>'; 			
				echo '<p class="lista">' .$listas[$i][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
				echo "</div>";
			}
			$noivo = getUtilizador($listas[$i][6]);
			$noiva = getUtilizador($listas[$i][7]);
			echo "<div class=\"ultimaLista\">";
				echo '<a href="aderirlista.php?aderir='.$listas[$i][0].'"><img class="lista" src="images/aderir.png" /></a>'; 			
				echo '<p class="lista">' .$listas[$i][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
			echo '</div>';
		}else{
			echo '<p>Não existem listas com os noivos especificados.</p>';
		}	
		
		/*echo '<div class="navegacao">';
		echo '	<div class="navegacaoSide">';
		echo '		<form>';
		echo '			resultados por página: <select><option>5</option><option selected="selected">10</option><option>15</option><option>20</option></select>'; 
		echo '		</form>';
		echo '	</div>';
		echo '	<p class="navegacao">' . $first . $prev . " página <strong>$pageNum</strong> de <strong>$maxPage</strong>" . $next . $last . '</p>';
		echo '</div>';
		*/
	}else{
		echo '<p>Não existem utilizadores a mostrar.</p>';
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