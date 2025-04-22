<?php

	function getConteudoAlterarPassword($isAdmin) {
		$cancelar = "perfil.php";
		if($isAdmin) {
			$cancelar = "index.php";
		} 
		echo '	</div>';
		echo '	<div class="contentLeftAlign" id="content">';
		echo '		<div class="navegacao">';
		echo '			<p class="navegacaoTitulo">';
		echo '				<strong>Alterar palavra-passe</strong>';
		echo '			</p>';
		echo '		</div>';
		echo '		<br />';
		echo '		<form class="frm" method="post" name="registar" id="formPassword" action="sys/updatePassword.php" target="_top">';
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="nome">Palavra-passe antiga:</label>';
		echo '					</div>';
		echo '					<div class="contentRight">';
		echo '						<input type="password" id="antiga" name="antiga" />*';
		echo '					</div>';
		echo '				</div>';  					
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="apelido">Palavra-passe nova:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="password" id="nova" name="nova" />*';	
		echo '					</div>';
		echo '				</div>';
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo '						<label for="apelido">Repita a nova palavra:</label>';
		echo '					</div>';
		echo '					<div class = "contentRight" >';
		echo '						<input type="password" id="repetida" name="repetida" />*';	
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
		echo '				<a onclick=' . 'javascript:document.getElementById("formPassword").submit()' . ' href="#">submeter</a>&nbsp;-&nbsp;';
		echo "				<a href=\"{$cancelar}\">cancelar</a>";
		echo '			</p>';
		echo '		</div>';
		echo '		</form>';
		echo '	</div>';
	}
?>
