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
		removerListaCasamento($_GET['remover']);
		unset($_GET['remover']);
	}elseif(isset($_GET['cancelar'])) {
		cancelarAderir($_GET['cancelar']);
		unset($_GET['cancelar']);
	}
	
	echo '<div class="content">';
	echo '	<div class="navegacao">';
	echo '		<p class="navegacaoTitulo">';
	echo ' 			<strong>Lista activa:</strong>';
	echo '		</p>';
	echo '	</div>';

	if(isset($_POST["activa"])){
		$_SESSION["activa"] = $_POST["activa"];
		unset($_POST["activa"]);
	}
		
	$listaActiva = getListaActiva($_SESSION["activa"]);//getListaActiva($_SESSION["id"]);
	if(count($listaActiva)>0){
		$noivo = getUtilizador($listaActiva[0][6]);
		$noiva = getUtilizador($listaActiva[0][7]);
		echo "<div class=\"ultimaLista\">";
			echo '<a title="ver detalhes" href="detalhesLista.php?lista='.$listaActiva[0][0].'"><img class="lista" src="images/detalhes.png" /></a>'; 			
			echo '<p class="lista">' .$listaActiva[0][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
		echo "</div>";
	}else{
		echo '<p>Não tem nenhuma lista activa.</p>';
	}
	echo '	<br />';
	echo '	<div class="navegacao">';
	echo '  	<div class="navegacaoSide">';
	echo '			activa &nbsp;&nbsp;&nbsp;&nbsp;';
	echo '  	</div>';
	echo '		<p class="navegacaoTitulo">';
	echo ' 			<strong>Listas criadas:</strong>';
	echo '		</p>';
	echo '	</div>';

	echo '	<form class="frm" id="activar" name="activar" method="post" action="minhaslistas.php">';

	$listas = getListasCasamentoNoivo($id);
	if(count($listas)>0){
		for($i=0; $i<count($listas) - 1; $i++){
			$noivo = getUtilizador($listas[$i][6]);
			$noiva = getUtilizador($listas[$i][7]);
			echo "<div class=\"lista\">";
			echo '<a title="remover lista" href="minhaslistas.php?remover='.$listas[$i][0].'"><img class="lista" src="images/drop.png" /></a>'; 			
			if($_SESSION["activa"] == $listas[$i][0])
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' checked />";
			else
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' />";
			echo '<p class="lista">' .$listas[$i][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
			echo "</div>";
		}
		$noivo = getUtilizador($listas[$i][6]);
		$noiva = getUtilizador($listas[$i][7]);
		echo "<div class=\"ultimaLista\">";
			echo '<a title="remover lista" href="minhaslistas.php?remover='.$listas[$i][0].'"><img class="lista" src="images/drop.png" /></a>'; 			
			if($_SESSION["activa"] == $listas[$i][0])
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' checked />";
			else
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' />";
			echo '<p class="lista">' .$listas[$i][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
		echo '</div>';
	}else{
		echo '<p>Não criou listas.</p>';
	}	
	echo '	<br />';
	echo '	<div class="navegacao">';
	echo '  	<div class="navegacaoSide">';
	echo '			activa &nbsp;&nbsp;&nbsp;&nbsp;';
	echo '  	</div>';
	echo '		<p class="navegacaoTitulo">';
	echo ' 			<strong>Listas a que aderiu:</strong>';
	echo '		</p>';
	echo '	</div>';

	$listas = getListasAderidas($_SESSION["id"]);
	if(count($listas)>0){
		for($i=0; $i<count($listas) - 1; $i++){
			$noivo = getUtilizador($listas[$i][6]);
			$noiva = getUtilizador($listas[$i][7]);
			echo "<div class=\"lista\">";
			echo '<a title="cancelar aderência" href="minhaslistas.php?cancelar='.$listas[$i][0].'"><img class="lista" src="images/desaderir.png" /></a>'; 			
			if($_SESSION["activa"] == $listas[$i][0])
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' checked />";
			else
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' />";
			echo '<p class="lista">' .$listas[$i][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
			echo "</div>";
		}
		$noivo = getUtilizador($listas[$i][6]);
		$noiva = getUtilizador($listas[$i][7]);
		echo "<div class=\"ultimaLista\">";
			echo '<a title="cancelar aderência" href="minhaslistas.php?cancelar='.$listas[$i][0].'"><img class="lista" src="images/desaderir.png" /></a>'; 			
			if($_SESSION["activa"] == $listas[$i][0])
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' checked />";
			else
				echo '<input type="radio" class="radioactiva" name="activa" value="'. $listas[$i][0] . "\" onchange='javascript:document.getElementById(\"activar\").submit()' />";
			echo '<p class="lista">' .$listas[$i][1]." &nbsp;&nbsp;&nbsp; " . $noivo[0][1] . " " . $noivo[0][2] .  " e " . $noiva[0][1] . " " . $noiva[0][2] .'</p>';
		echo '</div>';
	}else{
		echo '<p>Não aderiu a listas.</p>';
	}	

	echo '</form>';
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
