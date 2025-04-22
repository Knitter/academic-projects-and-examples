<?php
	include_once("sys/search_functions.php");
	include_once("sys/db_functions.php");
	include_once("sys/configuracoes.php");
	
	$conn = openConnection(getDatabaseHost(), getDatabaseUser(), getDatabasePassword(), getDatabaseName());
	//echo pesquisaSimplesNome("Maria");
	//echo pesquisaSimplesNome("Maria Josefina");
	//echo pesquisaSimplesNome("Maria Josefina das Couves");
	//echo criarPasswordAleatoria(13);
	//echo enviarMailRecuperacao('john.doe@xpto.moc');
	/*$array = obterSuperCategorias();
	$i = 0;
	$total = count($array);
	echo '<p>';
	for($i; $i < $total; $i++) {
		echo $array[$i][0];
		echo '&nbsp;';
		echo $array[$i][1];
		echo '<br / >';
	}
	echo '</p>';
	
		
	$array = obterSubcategorias(5);
	$total = count($array);
	echo '<p>';
	for($i = 0; $i < $total; $i++) {
		echo $array[$i][0];
		echo '&nbsp;';
		echo $array[$i][1];
		echo '<br / >';
	}
	echo '<p>';
	
	$array = listarProdutos(5, 0, 30);
	$total = count($array);
	for($i = 0; $i < $total; $i++) {
		echo $array[$i][0];
		echo '&nbsp;';
		echo $array[$i][1];
		echo '<br / >';
	}*/
	
	/*$array = pesquisaSimplesNome('nome');*/
	$array = 	getListaUtilizadores();
	$total = count($array);
	for($i = 0; $i < $total; $i++) {
		echo $array[$i][0];
		echo '<br / >';
		echo $array[$i][1];
		echo '<br / >';
		echo $array[$i][2];
		echo '<br / >';
		echo $array[$i][3];
		echo '<br / >';
		echo $array[$i][4];
		echo '<br / >';
		echo $array[$i][5];
		echo '<br / >';
		echo $array[$i][6];
		echo '<br / >';
		echo $array[$i][7];
		echo '<br / >';
		echo $array[$i][8];
		
	}
	//$userPretendido = antonio;
	//echo quoteSmart("SELECT 1 FROM tbl_utilizador WHERE username LIKE {$userPretendido}");
	//$array = getListaAdministradores();
	//echo $array[0][1];
	closeConnection($conn);
?>
