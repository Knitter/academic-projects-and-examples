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
	getPesquisa();
	
	echo '			</div>'; 
	if(isset($_GET['aderir'])) {
		aderirListaCasamento($_GET['aderir']);
		unset($_GET['aderir']);
	}
	
	echo '<div class="content">';
	echo '	<div class="navegacao">';
	echo '		<p class="navegacaoTitulo">';
	echo ' 			<strong>Listas a que pode aderir:</strong>';
	echo '		</p>';
	echo '	</div>';

	$listas = getListasAderiveis($_SESSION["id"]);
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
		echo '<p>Não existem listas activas a que possa aderir.</p>';
	}	
	echo '	<br />';

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
