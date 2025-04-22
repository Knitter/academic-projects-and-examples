<?php
	function getContentRecuperarPassword() {
		echo '				<div class = "tablerow">';
		echo '					<div class="contentLeft">';
		echo ' 							<form method="post" action="recuperarpassword.php" name="formRecovery" id="formRecovery">';
		echo '						<label for="user">Utilizador: </label>';
		echo '							<input type="text" name="userrecovery" id="userrecovery" />&nbsp;';
		echo '							<a href="#" onclick=\'javascript:document.getElementById("formRecovery").submit()\'>enviar e-mail</a>';
		echo '						</form>';
		echo '					</div>';
		echo '				</div>';
	}
	
	function getErroSemUtilizador() {
		echo '	<div class = "tablerow">';
		echo '		<div class="contentLeft">';
		echo '			Tem de especificar um utilizador!&nbsp;&nbsp;&nbsp;<a href="recuperarpassword.php">voltar atrás</a>';
		echo '		</div>';
		echo '	</div>';
	}
?>
