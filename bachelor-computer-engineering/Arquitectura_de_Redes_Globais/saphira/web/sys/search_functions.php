<?php
	/**
	 * search_functions.php
	 * Ficheiro com funcoes de pesquisa usadas no sistema.
	 * 
	 * @authors: Nelson Rodrigues, Sergio Lopes
	 */
	include_once("utils.php");

	/**
	 * Pesquisa simples por nome
	 */
	function pesquisaSimplesNomeComLimite($nome, $start, $offset) {
		$nomes = explode(' ', quoteSmart($nome));
		$length = count($nomes);

		$array;
		$pesquisa="SELECT * FROM tbl_produto WHERE nome LIKE '%";
		
		for($i = 0; $i < $length - 1; $i++){ 
			$pesquisa = $pesquisa . $nomes[$i] . "%' OR nome LIKE '%" ;
		}	
		$pesquisa = $pesquisa . $nomes[$length-1] . "%' LIMIT {$start}, $offset";
		
		$result = mysql_query($pesquisa);
		
		if($result) {
			while($row = mysql_fetch_array($result, MYSQL_NUM)) {
				$array[] = $row;
			}
		}		
		return $array;
	}
	
	function pesquisaSimplesNome($nome) {
		$nomes = explode(' ', quoteSmart($nome));
		$length = count($nomes);

		$array;
		$pesquisa="SELECT * FROM tbl_produto WHERE nome LIKE '%";
		
		for($i = 0; $i < $length - 1; $i++){ 
			$pesquisa = $pesquisa . $nomes[$i] . "%' OR nome LIKE '%" ;
		}	
		$pesquisa = $pesquisa . $nomes[$length-1] . "%'";
		
		$result = mysql_query($pesquisa);
		
		if($result) {
			while($row = mysql_fetch_array($result, MYSQL_NUM)) {
				$array[] = $row;
			}
		}		
		return $array;
	}

	/**
	 * Pesquisa avancada
	 */
	function pesquisaAvancadaComLimite($nome, $opcao, $categoria, $start, $offset) {
		$nomeLimpo = quoteSmart($nome);
		if(is_numeric($categoria)) {
			if($opcao == 0) {
				if($categoria == -1) {
					return pesquisaSimplesNomeComLimite($nomeLimpo, $start, $offset);
				}else {			
					$nomes = explode(' ', $nomeLimpo);
					$length = count($nomes);
					$pesquisa="SELECT * FROM tbl_produto WHERE (nome LIKE '%";
			
					for($i = 0; $i < $length - 1; $i++){ 
						$pesquisa = $pesquisa . $nomes[$i] . "%' OR nome LIKE '%" ;
					}	
					$pesquisa = $pesquisa . $nomes[$length-1] . "%') AND id = $categoria  LIMIT {$start}, $offset";
					
					$result = mysql_query($pesquisa);
			
					if($result) {
						while($row = mysql_fetch_array($result, MYSQL_NUM)) {
							$array[] = $row;
						}
					}		
					return $array;
				}	
			}elseif($categoria != -1) {
					$pesquisa="SELECT * FROM tbl_produto WHERE (nome LIKE '%{$nomeLimpo}' AND id = $categoria LIMIT {$start}, $offset";
					
					$result = mysql_query($pesquisa);
			
					if($result) {
						while($row = mysql_fetch_array($result, MYSQL_NUM)) {
							$array[] = $row;
						}
					}		
					return $array;
			}else {
				$pesquisa="SELECT * FROM tbl_produto WHERE (nome LIKE '%{$nomeLimpo}' LIMIT {$start}, $offset";
					$result = mysql_query($pesquisa);
			
					if($result) {
						while($row = mysql_fetch_array($result, MYSQL_NUM)) {
							$array[] = $row;
						}
					}		
					return $array;
			}
		}
	}
		
	function pesquisaAvancada($nome, $opcao, $categoria) {
		$nomeLimpo = quoteSmart($nome);
		if(is_numeric($categoria)) {
			if($opcao == 0) {
				if($categoria == -1) {
					return pesquisaSimplesNome($nomeLimpo, $start, $offset);
				}else {			
					$nomes = explode(' ', $nomeLimpo);
					$length = count($nomes);
					$pesquisa="SELECT * FROM tbl_produto WHERE (nome LIKE '%";
			
					for($i = 0; $i < $length - 1; $i++){ 
						$pesquisa = $pesquisa . $nomes[$i] . "%' OR nome LIKE '%" ;
					}	
					$pesquisa = $pesquisa . $nomes[$length-1] . "%') AND id = $categoria";
					
					$result = mysql_query($pesquisa);
			
					if($result) {
						while($row = mysql_fetch_array($result, MYSQL_NUM)) {
							$array[] = $row;
						}
					}		
					return $array;
				}	
			}elseif($categoria != -1) {
					$pesquisa="SELECT * FROM tbl_produto WHERE (nome LIKE '%{$nomeLimpo}' AND id = $categoria";
					
					$result = mysql_query($pesquisa);
			
					if($result) {
						while($row = mysql_fetch_array($result, MYSQL_NUM)) {
							$array[] = $row;
						}
					}		
					return $array;
			}else {
				$pesquisa="SELECT * FROM tbl_produto WHERE (nome LIKE '%{$nomeLimpo}'";
					$result = mysql_query($pesquisa);
			
					if($result) {
						while($row = mysql_fetch_array($result, MYSQL_NUM)) {
							$array[] = $row;
						}
					}		
					return $array;
			}
		}	
	}
?>