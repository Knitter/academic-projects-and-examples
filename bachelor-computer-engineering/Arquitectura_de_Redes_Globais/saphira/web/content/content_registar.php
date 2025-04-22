<?php	
	function getPaginaRegisto() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<strong>Registar novo utilizador</strong>';
		echo '			</p>';
		echo '		</div>';
		echo '		<br />';
		
		echo '	<fieldset class = "fset">';
		echo '		<form class="frm" method="post" name="registar" id="registar" action="registar.php" >';
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="nome">nome:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		echo '						<input type="text" id="nome" name="nome" />*';
		echo '					</div>';
		echo '				</div>';  					
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="apelido">apelido:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="apelido" name="apelido" />*';	
		echo '					</div>';
		echo '				</div>';

		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="sexo">sexo:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" id="notred">';
		echo '						<input type="radio" id="sexoM" name="sexo" value="M" checked="checked"/>Masculino &nbsp;';
		echo '						<input type="radio" id="sexoF" name="sexo" value="F" />Feminino';		
		echo '					</div>';
		echo '				</div>';
												
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="usernameRegisto">utilizador:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="usernameRegisto" name="usernameRegisto" />*';		
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="passwordRegisto">palavra-passe:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="password" id="passwordRegisto" name="passwordRegisto" />*';		
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="email">e-mail:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="email" name="email" />*';
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="contribuinte">contribuinte</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="contribuinte" name="contribuinte" />*';
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="endereco">endereço</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="endereco" name="endereco" />*';		
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="codPostal">código postal:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="text" id="codPostal" name="codPostal" />*';	
		echo '					</div>';
		echo '				</div>';
						
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="localidade">localidade:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<select id="localidade" name="localidade">';
		echo '							<option>Leiria</option>';
		echo '							<option>Maceira</option>';
		echo '							<option>Lisboa</option>';
		echo '							<option>Coimbra</option>';
		echo '							<option>Porto</option>';
		echo '							<option>Mais uma</option>';
		echo '							<option>Não sei</option>';
		echo '							<option>etc</option>';
		echo '						</select>*';
		echo '					</div>';
		echo '				</div>';
		
		echo '		<br />';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<a onclick=\'validarRegisto()\' href="#">registar</a>&nbsp;-&nbsp;';
		echo '				<a onclick=\'javascript:document.getElementById("registar").reset()\' href="#">limpar</a>&nbsp;-&nbsp';
		echo '				<a href=""index.php"">cancelar</a>';
		echo '			</p>';
		echo '		</div>';
		echo '			<input type="hidden" value="2" name="registo" />';
		echo '		</form>';
		echo '	</fieldset>';
		echo '</div>';	
	}
	
	function getPaginaSucesso() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<strong>Novo utilizador registado com sucesso.</strong>';
		echo '			</p>';
		echo '		</div>';
		echo ' </div>';
	}
	
	function getErroUtilizadorDuplicado() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacao">';
		echo '				<strong>O nome de utilizador não se encontra disponível. <a href="#" onclick="javascript:window.back()">voltar</strong>';
		echo '			</p>';
		echo '		</div>';
		echo ' </div>';
	}
	
	function getErroContribuinte() {
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacao">';
		echo '				Número de contribuinte inválido. <a href="#" onclick="javascript:window.back()">voltar</strong>';
		echo '			</p>';
		echo '		</div>';
		echo ' </div>';
	}
	
	function getPassosRegisto($passo) {
		echo '<div class = "menuSecundario" id="menuSecundario">';
		echo '	<p class = "tituloSecundario">Registo</p>';
		if($passo >= 1) {
			echo '<div class = "categoriaSecundaria">';
			echo '	<div class = "categoriaSecundariaSquare" name="square"></div>';
			echo '	Passo 1';
			echo '</div>';
		}
		
		if($passo == 2) {
			echo '<div class = "categoriaSecundaria">';
			echo '	<div class = "categoriaSecundariaSquare" name="square"></div>';
			echo '	Passo 2';
			echo '</div>';
		}
		echo '</div>';
	}
?>
