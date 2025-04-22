<?php
	/**
 	 * TODO: passar para o ficheiro de configuracao
	 */
	$enderecoSite = 'www.saphira.pt';
	$tamanhoPasswords = 8;
	
	/**
	 *
	 */
	function quoteSmart($value) {
	  if (get_magic_quotes_gpc()) {
	  	$value = stripslashes($value);
	  }

	  if (!is_numeric($value)) {
	  	$value = "" . mysql_real_escape_string($value) . "";
	  }
		
		return $value;
	}
	
	function enviarMailRecuperacao($email) {
	  $from = 'apoio@saphira.pt';
	  $to = $email;
	  $subject = "Recupera��o de palavra-passe.";
		$pass = criarPasswordAleatoria($tamanhoPasswords);
	  $messageBody = "Foi pedida uma nova palavra-passe para acesso ao site {$enderecoSite}.\r\n" .
										"A sua nova password �:  {$pass}\\r\\r\\n\\r\\n" .
										"Se n�o pediu esta altera��o algu�m usando o seu nome de utilizador efectuou " .
										"o pedido de altera��o, por favor verifique o estado da sua conta.\\r\\n" .
										"Caso n�o seja nosso cliente pode ignorar esta mensagem. \\r\\n\\r\\n\\r\\n" .
										"Com os melhores cumprimentos,\\r\\n\\r\\nA administra��o.";
	  
		$messageBody = wordwrap($messageBody, 70);
		mail($to, $subject, $messageBody,"FROM: $from");
	}
	
	function criarPasswordAleatoria($tamanho){
  	srand((double)microtime()*1000000); 
     
    $vogais = array("a", "e", "i", "o", "u"); 
    $consoantes = array("b", "c", "d", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "u", "v", "w", "x", "y", "z");
		$numeros = array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"); 
    
    $numVogais = count($vogais); 
    $numConsoantes = count($consoantes);
		$numNumeros = count($numeros); 
     
    for($i = 0; $i < $tamanho; $i++){ 
        $password .= $consoantes[rand(0, $numConsoantes - 1)] . $numeros[rand(0, $numeros[$numNumeros - 1])]. $vogais[rand(0, $numVogais - 1)]; 
    } 
     
    return substr($password, 0, $tamanho); 
	}
	
?>
