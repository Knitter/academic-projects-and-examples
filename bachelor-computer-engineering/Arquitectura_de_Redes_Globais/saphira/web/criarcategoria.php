<?php
	session_start();
	require_once("sys/configuracoes.php");
	if(isset($_SESSION["autenticado"]) && $_SESSION["autenticado"] && ($_SESSION["papel"] == getIDAdministrador())) {
		require_once("sys/template_functions.php");
		require_once("content/content_administracao.php");
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
	
		if(isset($_POST["categoria"]) && isset($_POST["categoriaTopo"])) {
			if($_POST["descricao"] == "")
				$_POST["descricao"] = "sem descrição";
			criarCategoria(quoteSmart($_POST["categoria"]), quoteSmart($_POST["descricao"]), quoteSmart($_POST["categoriaTopo"]));
			$_POST = array();
		}
	
		getMenuSecundarioCategorias();
		getPesquisaListas();
		getPesquisa();

		echo '			</div>';
		
		getContentAdministracaoNovaCategoria();

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