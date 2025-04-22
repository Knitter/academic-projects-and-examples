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
	echo ' 			<strong>Lista de administradores</strong>';
	echo '		</p>';
	echo '	</div>';
	echo '	<br />';
	if(isset($_GET["r"])) {
		removerAdmin(quoteSmart($_GET["r"]));
		unset($_GET["r"]);
	}	

	$listaAdmins = getListaAdministradores();
	$numAdmins = count($listaAdmins);
	if($numAdmins > 0){
		for($i = 0; $i < $numAdmins - 1; $i++){
			echo '<div class="lista">';
			echo "<a href=\"listaradministradores.php?r={$listaAdmins[$i][0]}\"><img class=\"lista\" src=\"images/drop.png\" /></a>"; 			
			echo "<p class=\"lista\">{$listaAdmins[$i][1]}&nbsp;&nbsp;&nbsp;</p>"; 			
			echo '</div>';
		}
		echo '<div class="ultimaLista">';
		echo "<a href=\"listaradministradores.php?r={$listaAdmins[$i][0]}\"><img class=\"lista\" src=\"images/drop.png\" /></a>"; 			
		echo "<p class=\"lista\">{$listaAdmins[$i][1]}&nbsp;&nbsp;&nbsp;</p>";
		echo '</div>';
	}else{
		echo '<p>Não existem administradores.</p>';
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
