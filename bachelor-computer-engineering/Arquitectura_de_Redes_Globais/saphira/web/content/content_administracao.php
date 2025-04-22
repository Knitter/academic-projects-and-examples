<?php
	require_once("sys/db_functions.php");

	function getContentAdministracaoNovoAdmin() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<strong>Novo Administrador</strong>';
		echo '			</p>';
		echo '		</div>';
		echo '		<br />';
		echo '	<fieldset class = "fset">';
		echo '		<form class="frm" method="post" name="formNovoAdministrador" id="formNovoAdministrador" action="adicionaradmin.php">';
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="utilizadorAdmin">Utilizador:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		echo '						<input type="text" id="utilizadorAdmin" name="utilizadorAdmin" />*';
		echo '					</div>';
		echo '				</div>';  					
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="apelido">Palavra-passe:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="passwordAdmin" name="passwordAdmin" />*';	
		echo '					</div>';
		echo '				</div>';						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="emailAdmin">E-mail:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="emailAdmin" name="emailAdmin" />*';
		echo '					</div>';
		echo '				</div>';	
		echo '				<div class = "tablerow">';
		echo '					<div class="contentRight">';
		echo '						*campos de preenchimento obrigatório.';
		echo '					</div>';
		echo '				</div>';
		echo '		<br />';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<a onclick="validarNovoAdmin()" href="#">submeter</a>&nbsp;-&nbsp;';
		echo '				<a onclick=' . 'javascript:document.getElementById("formNovoAdministrador").reset()' . ' href="#">limpar</a>&nbsp;-&nbsp';
		echo '				<a href="index.php">cancelar</a>';
		echo '			</p>';
		echo '		</div>';
		echo '		</form>';
		echo '	</fieldset>';
		echo '	</div>';
	}
	
	function getSucessoNovoAdmin() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				Administrador adicionado com sucesso.';
		echo '			</p>';
		echo '		</div>';
		echo '	</div>';	
	}
	
	function getErroNovoAdmin() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<strong>Erro a adicionar o administrador, verifique se o nome de utilizador</strong>';
		echo '			</p>';
		echo '		</div>';
		echo '	</div>';	
	}
	
	function getContentAdministracaoNovaCategoria() {
			
		$results = obterTodasSuperCategorias();
		$numCategorias = count($results);	
		
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<strong>Nova Categoria</strong>';
		echo '			</p>';
		echo '		</div>';
		echo '		<br />';
		echo '	<fieldset class = "fset">';
		echo '		<form class="frm" method="post" name="formNovaCategoria" id="formNovaCategoria" action="criarcategoria.php">';
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="categoria">Nome:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		echo '						<input type="text" size="25" id="categoria" name="categoria" />*';
		echo '					</div>';
		echo '				</div>';  					
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="categoriaTopo">Categoria Pai:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		
		echo '						<select id="categoriaTopo" name="categoriaTopo">';
		echo '							<option value="-1">categoria de topo</option>';		
		for($i = 0; $i < $numCategorias; $i++ ) {
			echo "	<option value=\"{$results[$i][0]}\">{$results[$i][1]}</option>";
		}
		echo '						</select>';
		echo '					</div>';
		echo '				</div>';						
		
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="descricao">Descricao:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		echo '						<input type="text" size="25" id="descricao" name="descricao" />*';
		echo '					</div>';
		echo '				</div>'; 
		
		echo '				<div class = "tablerow">';
		echo '					<div class="contentRight">';
		echo '						*campos de preenchimento obrigatório.';
		echo '					</div>';
		echo '				</div>';
		echo '		<br />';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<a onclick=\'javascript:document.getElementById("formNovaCategoria").submit()\' href="#">criar</a>&nbsp;-&nbsp;';
		echo '				<a href="index.php">cancelar</a>';
		echo '			</p>';
		echo '		</div>';
		echo '		</form>';
		echo '	</fieldset>';
		echo '	</div>';
	}
?>
