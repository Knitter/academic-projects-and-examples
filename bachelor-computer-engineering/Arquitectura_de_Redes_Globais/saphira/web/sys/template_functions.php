<?php
 	require_once("configuracoes.php");
 	require_once("db_functions.php");
 
 	function getHead($title) {
		echo '<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />';
		echo '<meta name="description" content="" />';
	  	echo '<meta name="keywords" content="listas, casamento, noivos, prendas, convidados, festa" />';
	  	echo '<meta name="author" content="Sérgio Lopes, Nelson Rodrigues", />';
		echo '<link rel="StyleSheet" href="css/template.css" type="text/css" media="screen" />';
		echo "<title>{$title}</title>";
		echo '<script src="sys/utils.js" type="text/javascript"></script>';
	}
	
	function getHeader() {
		echo '<div class = "header">';
		echo '	<a href="index.php">';
		echo '		<img class = "logotipo" alt="Logotipo Saphira" src = "images/logo-color3a.jpg" />';
		echo '	</a>';
		if($_SESSION["autenticado"] && !$_SESSION["erroAutenticacao"]) {
			echo '<div class="login">';
			echo '	<br /><p class="login">Olá '. $_SESSION["nome"] . '!</p>';
			if($_SESSION["papel"] == getIDNoivo()) {
				echo '	<a class="login" href="perfil.php">o meu perfil</a><br />';
			}else {
				echo '	<a class="login" href="alterarpassword.php">alterar password</a><br />';
			}
			echo '	<a class="login" href="sys/logout.php">logout</a><br />';
			echo '</div>';
		}else if(!$_SESSION["autenticado"]) {
			echo '<div class = "login">';
			echo '	<form class="frm" id="login" method="post" action="sys/autenticacao.php">';
			echo '		<input type="hidden" id="sender" name="sender" />';
			echo '		<p class="login">utilizador:</p>';
			echo '		<input class="login" type="text" id="username" name="username" />';
			echo '		<p class="login">palavra-passe:</p>';
			echo '		<input class="login" type="password" id="password" name="password" />';
			echo '		<a class="login" href="registar.php">registar</a>';
			echo '		&nbsp;&nbsp;';
			echo '		<a class="login" onclick="login()" href="#">entrar</a>';
			echo '	</form>';
			echo '</div>';

			if($_SESSION["erroAutenticacao"]){
				$_SESSION["erroAutenticacao"] = false;
				echo '<div class="erroLogin">';
				echo 	'<p class="erroLogin"><br />';
				echo 		'nome de utilizador ou palavra-passe incorrectos<br /><br />';
				echo 	'</p>';
				echo 	'<a class="login" href="recuperarpassword.php">esqueceu a palavra passe?</a>';
				echo '</div>';
			}
		}
		echo '</div>';
	}
	
	function getMenuPrincipal() {
		echo '<div class = "menuPrincipal">';
		echo '	<div class = "horas">';
		echo '		<p class = "horas" id="horas"></p>';
		echo '	</div>';
		echo '</div>';
	}

	function getMenuListas(){
		if(isset($_SESSION["autenticado"]) && $_SESSION["autenticado"]) {
			if($_SESSION["papel"] == getIDNoivo()) {
			
				echo '<div class = "menuSecundario" id="menuSecundario">';
				echo '	<p class = "tituloSecundario">Listas</p>';
				echo '	<a class="cat" href="aderirlista.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Aderir a Lista';
				echo '		</div>';
				echo '	</a>';
				echo '	<a class="cat" href="criarlista.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Criar Lista';
				echo '		</div>';
				echo '	</a>';
				echo '	<a class="cat" href="minhaslistas.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Minhas Listas';
				echo '		</div>';
				echo '	</a>';
				echo '	<a class="cat" href="detalhesLista.php?lista='. $_SESSION["activa"] .'">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Ver Lista Activa';
				echo '		</div>';
				echo '	</a>';
				echo '</div>';
			}else {
				echo '<div class = "menuSecundario" id="menuSecundario">';
				echo '	<p class = "tituloSecundario">Administração</p>';
				echo '	<a class="cat" href="criarcategoria.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Criar Categorias';
				echo '		</div>';
				echo '	</a>';
				echo '	<a class="cat" href="introduzirprodutos.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Introduzir Produtos';
				echo '		</div>';
				echo '	</a>';
				echo '	<a class="cat" href="listaradministradores.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Listar Administradores';
				echo '		</div>';
				echo '	</a>';
				echo '	<a class="cat" href="listarutilizadores.php">';
				echo '		<div class = "categoriaSecundaria">';
				echo '			<div class = "categoriaSecundariaSquare" name="square"></div>';
				echo '				Mostrar Utilizadores';
				echo '		</div>';
				echo '	</a>';
				echo '</div>';
			}
		}
	}
	
	function getMenuSecundarioCategorias() {
		echo '<div class = "menuSecundario" id="menuSecundario">';
		echo '	<p class = "tituloSecundario">Categorias</p>';
		$super = obterSuperCategorias(); 
		for($i=0; $i<count($super); $i++){
			echo "	<a class=\"cat\" onclick='javascript:toggleLayer(\"{$super[$i][1]}\")' href=\"#\">";
			echo '		<div class = "categoriaSecundaria">';
			echo '			<div class = "categoriaSecundariaSquare" name="square" id="'. $super[$i][1] . "Square" .'"></div>';
			echo "			{$super[$i][1]}";
			echo '		</div>';
			echo "	</a>";
			echo '<div class="hidable" name="hidable" id="'.$super[$i][1].'">';
			$sub = obterSubCategorias($super[$i][0]);
			if(count($sub) >= 2){
				$j=0;
				for($j; $j<count($sub)-2; $j++){
					echo '	<div class = "linhaSubCategoria"><p class="extra">&#8212;</p></div>';
					echo "	<a class=\"sub\" href=\"produtos.php?super={$super[$i][1]}&categoria={$sub[$j][0]}\">";
					if($sub[$j][0] == $_GET["categoria"])
						echo '<div class = "subcategoriaHighlighted">';
					else
						echo '		<div class = "subcategoria">';
					echo "				{$sub[$j][1]}";
					echo '		</div>';
					echo "	</a>";
				}
				echo '		<div class = "linhaUltimasSub"><p class="extra">&#8212;</p></div>';
				echo "		<a class=\"sub\" href=\"produtos.php?super={$super[$i][1]}&categoria={$sub[$j][0]}\">";
					if($sub[$j][0] == $_GET["categoria"])
						echo '<div class = "subcategoriaHighlighted">';
					else
						echo '			<div class = "subcategoria">';
				echo "					{$sub[$j][1]}";
				echo '			</div>';
				echo "		</a>";
				echo "		<a class=\"sub\" href=\"produtos.php?super={$super[$i][1]}&categoria={$sub[$j+1][0]}\">";
					if($sub[$j+1][0] == $_GET["categoria"])
						echo '<div class = "subcategoriaHighlighted">';
					else
						echo '			<div class = "subcategoria">';
				echo "				{$sub[$j+1][1]}";
				echo '			</div>';
				echo "		</a>";
			}
			echo '</div>'; 
			if($super[$i][1] == $_GET["super"]){
				echo '<script type="text/javascript">';
				echo 'toggleLayer("'. $_GET["super"] .'");';
				echo '</script>';
			}
		}
		echo '</div>';	
	}

	function getMenuSecundarioFichaTecnica() {
		echo '<div class = "menuSecundario" id="menuSecundario">';
		echo '	<p class = "tituloSecundario">Categorias</p>';
		
		echo '	<a class="cat" href="contactos.php">';
		echo '		<div class = "categoriaSecundaria">';
		echo '					<div class = "categoriaSecundariaSquare" name="square"></div>';
		echo '						Contactos';
		echo '		</div>';
		echo '	</a>';
		echo '	<a class="cat" href="localizacao.php">';
		echo '		<div class = "categoriaSecundaria">';
		echo '					<div class = "categoriaSecundariaSquare" name="square"></div>';
		echo '						Localização';
		echo '		</div>';
		echo '	</a>';
		echo '	<a class="cat" href="mapasite.php">';
		echo '		<div class = "categoriaSecundaria">';
		echo '					<div class = "categoriaSecundariaSquare" name="square"></div>';
		echo '						Mapa do Site';
		echo '		</div>';
		echo '	</a>';
		echo '	<a class="cat" href="faq.php">';
		echo '		<div class = "categoriaSecundaria">';
		echo '					<div class = "categoriaSecundariaSquare" name="square"></div>';
		echo '						Perguntas Frequentes';
		echo '		</div>';
		echo '	</a>';
		echo '	<a class="cat" href="quemsomos.php">';
		echo '		<div class = "categoriaSecundaria">';
		echo '					<div class = "categoriaSecundariaSquare" name="square"></div>';
		echo '						Quem Somos';
		echo '		</div>';
		echo '	</a>';
		echo '	<a class="cat" href="termosecondicoes.php">';
		echo '		<div class = "categoriaSecundaria">';
		echo '					<div class = "categoriaSecundariaSquare" name="square"></div>';
		echo '						Termos e Condições';
		echo '		</div>';
		echo '	</a>';
		echo '</div>';
	}
	
	function getPesquisa() {
		echo '<div class = "pesquisa">';
		echo '	<form class = "frm" action="resultados.php" method="get" name="formPesquisa" id="formPesquisa">';
		echo '		<fieldset class="fset">';
		echo '			<p class="tituloSecundario">Encontrar Produto</p>';
		echo '			<input class="pesquisa" type="text" name="pesquisa" id="pesquisa"/>';
		echo '			<p class="pesquisa">';
		echo '				<a class="pesquisa"href="pesquisaavancada.php">avançada</a>&nbsp;&nbsp;&nbsp;&nbsp;';
		echo '				<a href="#" onclick=\'javascript:document.getElementById("formPesquisa").submit()\'>pesquisar &raquo;';
		echo '				</a>';
		echo '			</p>';
		echo '		</fieldset>';
		echo '	</form>';
		echo '</div>';
	}
	
	function getPesquisaListas() {
		echo '<div class = "pesquisa">';
		echo '	<form class = "frm" action="resultadoslistas.php" method="get" name="formPesquisaListas" id="formPesquisaListas">';
		echo '		<fieldset class="fset">';
		echo '			<p class="tituloSecundario">Encontrar Lista</p>';
		echo '			<label for"noivo" id="resetlabel">Noivo:</label>'; 
		echo '			<input class="pesquisalistas" type="text" name="noivo" id="noivo"/>';
		echo '			<label for"noiva" id="resetlabel">Noiva:</label>';
		echo'					 <input class="pesquisalistas" type="text" name="noiva" id="noiva"/>';
		echo '			<p class="pesquisa">';
		echo '				<a href="#" onclick=\'javascript:document.getElementById("formPesquisaListas").submit()\'>pesquisar &raquo;';
		echo '				</a>';
		echo '			</p>';
		echo '		</fieldset>';
		echo '	</form>';
		echo '</div>';
	}
		
	function getGeneralContent() {
		if($_SESSION["autenticado"] && !$_SESSION["erroAutenticacao"]) { 
			echo '<div class="content" id="after">';
		}else {
			echo '<div class="content" id="before">';
		}
			
		echo '	<p class="index">';
		echo '		Passam-se os anos e o casamento continua a ser uma das principais cerimónias para selar a união entre os que se amam.<br />';
		echo '	</p>';
		echo '	<p class="index">';
		echo '		Na igreja, em casa, num buffet ou até mesmo numa praia. O importante é reunir convidados que torçam pela felicidade do casal.<br />';
		echo '	</p>';
		echo '	<p class="index">';
		echo '		<strong>Saphira</strong> passa agora a ser parte dos preparativos desse grande evento com o serviço da Lista de Casamento.'; 
		echo '	</p>';
		echo '</div>';
	}
	
	function getFooter() {
		echo '<div class = "footer">'.
			/* 
			'<div class="validators">' .
			'<a href="http://validator.w3.org/check?uri=http://saphira.podzone.net/web/">' .
			'<img class="validator" src="http://www.w3.org/Icons/valid-xhtml10-blue" alt="Valid XHTML 1.0 Strict" height="31" width="88" />' .
			'</a>' .
			'&nbsp;' .
			'<a href="http://jigsaw.w3.org/css-validator/validator?uri=http://saphira.podzone.net/web/css/template.css">' .
			'<img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-css-blue" alt="Valid CSS" />' .
			'</a>&nbsp;&nbsp;' .
			'</div>' .
			'<p class = "footer">' .*/
			'&nbsp;&nbsp;<a href="contactos.php">ficha técnica</a>' .
			' &nbsp; - &nbsp; ' .
			'<a href="mapasite.php">mapa do site</a>' .
			' &nbsp; - &nbsp; ' . 
			'<a href="termosecondicoes.php">termos e condições</a>' .
/*			'</p>' .*/
			'</div>';
	}
?>
