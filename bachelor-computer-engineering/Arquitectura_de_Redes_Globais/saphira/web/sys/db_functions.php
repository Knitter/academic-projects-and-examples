<?php
	/**
	 * db_functions.php
	 * Ficheiro com funcoes de manipulacao de base de dados.
	 * 
	 * @authors: Nelson Rodrigues, Sergio Lopes
	 */
	require_once("utils.php");
	
	/* Chave de poluicao das passwords */
	$salt = 'S@7t';
	
	/**
	 * Funcao que permite abrir uma ligacao 'a base de dados e ao schema usando as configuracoes
	 * no ficheiro 'configuracoes.php'.
	 */
	function openConnection($host, $dbuser, $dbpass, $dbname) {
		$conn = mysql_connect($host, $dbuser, $dbpass) or die ('Error connecting to mysql');
		
		mysql_select_db($dbname);
		return $conn;
	}
	
	/**
	 * Funcao que permite fechar a base de dados.
	 */
	function closeConnection($conn) {
		mysql_close($conn);
	}
	
	/**
	 * Insercao dos dados do administrador.
	 */
	function adicionarAdmin($username, $pass, $email) {
		$insert = '';
		global $salt;
		
		$md5 = md5($salt."".$pass."".$username."".$salt);
		$insert = "INSERT INTO tbl_admin(username, chave, email) VALUES('" . quoteSmart($username) . "', '{$md5}', '" . quoteSmart($email) . "')";
		
		return mysql_query($insert);
	}
	
	/**
	 * Insercao dos dados de um utilizador.
	 */
	function adicionarUtilizador($nome, $apelido, $endereco, $cod_postal, $localidade, $contribuinte, $username, $password, $sexo) {
		$insert = '';
		global $salt;
		
		$md5 = md5($salt."".$password."".$username."".$salt);
		
		$insert = "INSERT INTO tbl_utilizador(nome, apelido, endereco, cod_postal, localidade, contribuinte, username, chave, sexo) VALUES('" . quoteSmart($nome) . "', '".
		quoteSmart($apelido) . "' , '" . quoteSmart($endereco) . "', '" . quoteSmart($cod_postal) . "', '" . quoteSmart($localidade) . 
		"', '" . quoteSmart($contribuinte) . "', '" . quoteSmart($username) . "', '{$md5}', '" . quoteSmart($sexo) . "')";
		return mysql_query($insert);
	}
	
	/**
	 * insercao de novas categorias.
	 */
	function criarCategoria($nome, $descricao, $superCategoria) {
		if($superCategoria > -1) {
			$insert = "INSERT INTO tbl_categoria(nome, descricao, id_categoria) VALUES('{$nome}', '${descricao}', ${superCategoria})";
		}else {
			$insert = "INSERT INTO tbl_categoria(nome, descricao) VALUES('{$nome}', '${descricao}')";
		}
		return mysql_query($insert);
	}
	
	
	/**
	 * Permite criar listas de casamento.
	 */
	function criarListaCasamento($idNoivo, $idNoiva, $data, $endereco, $codPostal, $localidade) {
		$insert = "INSERT INTO tbl_lista_casamento(data_casamento, endereco, cod_postal, localidade, id_noivo, id_noiva, valor_total) VALUES('{$data}', '{$endereco}', '{$codPostal}', '{$localidade}', {$idNoivo}, {$idNoiva}, 0)";		
		return mysql_query($insert);
	}
	
	/**
	 * Permite criar linhas de casamento, adicionando produtos 'a lista.
	 */
	function adicionarProdutoListaCasamento($idCasamento, $idProduto, $quantidade) {
		$insert = '';
		
		$resultSet = mysql_query("SELECT preco FROM tbl_produto WHERE id = $idProduto");	
		$preco = mysql_fetch_row($resultSet);
		$subTotal = $quantidade * $preco[0];//NOTA	actualizar casamento total
		$insert = "INSERT INTO tbl_linha_casamento(id_lista_casamento, id_produto, quantidade, sub_total) VALUES($idCasamento, $idProduto, $quantidade, $subTotal)";
		
		return mysql_query($insert);
	}
	
	/**
	 * Pemite criar a ligacao entre o 'utilizador' e o casamento a que este assiste.
	 */
	function assistirCasamento($idCasamento, $idUtilizador, $subscrito) {
		$insert = "INSERT INTO tbl_assistir(id_casamento, id_utilizador, subscrito) VALUES($idCasamento, $idUtilizador, $subscrito)";
		return mysql_query($insert);
	}
	
	/**
	 * Permite criar a ligacao entre um 'convidado' e os produtos que o mesmo ofereceu.
	 */
	function oferecerProduto($idLinhaCasamento, $idCasamento, $idUtilizador, $quantidade, $valor) {
		$insert = "INSERT INTO tbl_oferecer(id_utilizador, id_casamento, id_linha_casamento, quantidade, valor) VALUES($idUtilizador, $idCasamento, $idLinhaCasamento, $quantidade, $valor)";
		return mysql_query($insert);
	}
	
	/**
	 * insercao de novos produtos.
	 */
	function adicionarProduto($nome, $descricao, $preco, $categoria) {
		$insert = "INSERT INTO tbl_produto(nome, descricao, preco, id_categoria) VALUES('{$nome}', '{$descricao}', $preco, $categoria)";
		return mysql_query($insert);
	}
	
	/**
	 * Permite adicionar 'a relacao entre o 'utilizador' e o 'casamento' a opcao de notificacao.
	 */
	function adicionarNotificacoes($idCasamento, $idUtilizador) {
		$update = "UPDATE tbl_assistir SET subscrito = 1 WHERE id_casamento = $idCasamento AND id_utilizador = $idUtilizador";
		return mysql_query($update);
	}
	
	/**
	 * Desativa a notificacao de alteracoes para determinado casamento.
	 */
	function desativarNotificacoes($idCasamento, $idUtilizador) {
		$update = "UPDATE tbl_assistir SET subscrito = 0 WHERE id_casamento = $idCasamento AND id_utilizador = $idUtilizador";
		return mysql_query($update);
	}
	
	/**
	 *
	 */
	function obterSuperCategorias() {
		return pesquisaComoVector("SELECT id, nome FROM tbl_categoria WHERE id IN (SELECT id_categoria from tbl_categoria WHERE id_categoria IS NOT NULL) AND id_categoria IS NULL ORDER BY nome;");

	}
	/**
	 *
	 */
	function obterSubCategorias($superCategoria) {
		return pesquisaComoVector("SELECT id, nome FROM tbl_categoria WHERE id_categoria = {$superCategoria} ORDER BY nome");
	}

	/**
	 *
	 */
	function pesquisaComoVector($query) {
		$result = mysql_query($query);
		
		if($result) {
			if(mysql_num_rows($result)) {
				while($row = mysql_fetch_array($result, MYSQL_NUM)) {
					$array[] = $row;
				}
			}
		}
	
		return $array;
	}
	
	/**
	 *
	 */
	function listarProdutos($categoria, $startLimit, $offset) {
		$query = "SELECT * FROM tbl_produto WHERE id_categoria = $categoria LIMIT $startLimit, $offset;";
		return pesquisaComoVector($query);
	}

	function getUtilizador($id){
		$query = "SELECT * FROM tbl_utilizador WHERE id = $id;";
		return pesquisaComoVector($query);
	}
	
	function getAdminPass($id) {
		$query = "SELECT * FROM tbl_admin WHERE id = $id;";
		return pesquisaComoVector($query);
	} 

	function updateUtilizador($id, $nome, $apelido, $endereco, $cod_postal, $localidade, $contribuinte, $sexo, $email) {
		$update = "UPDATE tbl_utilizador SET nome = '{$nome}', apelido = '{$apelido}', endereco = '{$endereco}', cod_postal = '{$cod_postal}', localidade = '{$localidade}', contribuinte = '{$contribuinte}', sexo = '{$sexo}', email = '{$email}' WHERE id = $id";
		return mysql_query($update);
	}
	
	function updatePasswordUtilizador($id, $oldpass, $newpass){
		global $salt;
		$dados=getUtilizador($id);
		$realpass = md5($salt."".$oldpass."".$dados[0][6]."".$salt);

		if($realpass != $dados[0][7])
			return -1;
		else{
			$realnewpass = md5($salt."".$newpass."".$dados[0][6]."".$salt);
			$update = "UPDATE tbl_utilizador SET chave = '{$realnewpass}' WHERE id = $id;";
			mysql_query($update);
		}
		return 0;
	}
	
		function updatePasswordAdmin($id, $oldpass, $newpass){
		global $salt;
		$dados = getAdminPass($id);
		
		$realpass = md5($salt."".$oldpass."".$dados[0][1]."".$salt);

		if($realpass != $dados[0][2])
			return -1;
		else{
			$realnewpass = md5($salt."".$newpass."".$dados[0][1]."".$salt);
			$update = "UPDATE tbl_admin SET chave = '{$realnewpass}' WHERE id = $id;";
			mysql_query($update);
		}
		return 0;
	}
	
	function getSolteiroBySexo($sexo){ 
		$query = "select * from tbl_utilizador where sexo LIKE '{$sexo}' AND tbl_utilizador.id NOT IN (SELECT " . ($sexo == "M" ? "id_noivo" : "id_noiva") . " FROM tbl_lista_casamento WHERE activa = 1) ORDER BY nome";
		return pesquisaComoVector($query);
	}
	
	function obterTodasSuperCategorias() {
		return pesquisaComoVector("SELECT id, nome FROM tbl_categoria WHERE id_categoria IS NULL ORDER BY nome;");
	}
	
	function getListasCasamentoNoivo($id){
		$query = "select * from tbl_lista_casamento where id_noiva = ".$_SESSION["id"]." or id_noivo = ".$_SESSION["id"]." order by data_casamento";
		return pesquisaComoVector($query);
	}

	function removerListaCasamento($id){
		$query = "delete from tbl_lista_casamento where id = $id";
		return mysql_query($query);
	}
	
	function getListaAdministradores() {
		$query = "SELECT * FROM tbl_admin WHERE username NOT LIKE 'admin';";
		return pesquisaComoVector($query);
	}
	
	function getListaUtilizadores() {
		$query = "SELECT * FROM tbl_utilizador;";
		return pesquisaComoVector($query);
	}
	
	function getListaUtilizadoresComLimite($start, $offset) {
		$query = "SELECT * FROM tbl_utilizador LIMIT {$start}, $offset;";
		return pesquisaComoVector($query);
	}
	
	function removerAdmin($id) {
		$query = "DELETE FROM tbl_admin WHERE id = $id;";
		return mysql_query($query);
	}
	
	function removerUtilizador($id) {
		$query = "DELETE FROM tbl_utilizador WHERE id = $id;";
		return mysql_query($query);
	}

	function getListaActiva($id){
		$query = "select * from tbl_lista_casamento where id = $id or id_noiva = $id";
		return pesquisaComoVector($query);
	}
/*	function getListaActiva($id){
		$query = "select * from tbl_lista_casamento where (id_noivo = $id or id_noiva = $id ) and activa = 1";
		return pesquisaComoVector($query);
	}
*/	
	/**
	 *	Mostra as listas a que o utilizador pode aderir, ou seja, listas activas que não tenham sido criadas pelo utilizador, e nas quais este ainda não tenha aderido
	 */
	function getListasAderiveis($id){
		$query = "SELECT * FROM tbl_lista_casamento WHERE activa = 1 AND tbl_lista_casamento.id NOT IN (SELECT id_casamento FROM tbl_assistir WHERE id_utilizador = {$id} ) AND tbl_lista_casamento.id_noivo <> {$id} AND tbl_lista_casamento.id_noiva <> {$id} ORDER BY data_casamento";
		return pesquisaComoVector($query);
	}

	function aderirListaCasamento($id){
		$query = "INSERT INTO tbl_assistir (id_casamento, id_utilizador, subscrito) VALUES ({$id}, ". $_SESSION["id"] .", '0')";
		return mysql_query($query);
	}

	function getListasAderidas($id){
		$query = "SELECT * FROM tbl_lista_casamento, tbl_assistir WHERE tbl_lista_casamento.id = tbl_assistir.id_casamento AND id_utilizador = {$id} ORDER BY data_casamento";
		return pesquisaComoVector($query);
	}
	
	function cancelarAderir($id){
		$query = "delete from tbl_assistir where id_casamento = $id AND id_utilizador = ". $_SESSION["id"];
		return mysql_query($query);
	}

	function activarLista($id){
		$query = "UPDATE tbl_lista_casamento SET activa = 1 WHERE id = $id";
		mysql_query($query);
	}

	function adicionarProdutoLista($id_produto, $id_lista, $quantidade){
		$insert = "INSERT INTO tbl_linha_casamento(id_lista_casamento, id_produto, quantidade, sub_total) VALUES($id_lista, $id_produto, $quantidade, 0)";
		mysql_query($insert);
	}

	function listarProdutosLista($id_lista){
		$query = "SELECT * from tbl_produto, tbl_linha_casamento WHERE tbl_produto.id = tbl_linha_casamento.id_produto AND tbl_linha_casamento.id_lista_casamento = $id_lista";
		return pesquisaComoVector($query);
	}
	
	function removerProdutoLista($id_lista, $id_produto){
		$query = "delete from tbl_linha_casamento WHERE id_produto = $id_produto AND id_lista_casamento = $id_lista";
		mysql_query($query);
	}
	
	
	function mostrarTodasListas() {
		$query = "SELECT * FROM tbl_lista_casamento ORDER BY data_casamento;";
		return pesquisaComoVector($query);
	}
	
	function mostrarTodasListasComLimite($start, $offset) {
		$query = "SELECT * FROM tbl_lista_casamento ORDER BY data_casamento LIMIT {$start}, $offset;";
		return pesquisaComoVector($query);	
	}
	
	function introduzirNovoProduto($nome, $descricao, $preco, $desconto, $pvp_recomendado, $entrega_imediata, $foto, $id_categoria) {
		$insert = "INSERT INTO tbl_produto(nome, descricao, preco, desconto, pvp_recomendado, entrega_imediata, foto, id_categoria) VALUES('{$nome}', '{$descricao}', $preco, $desconto, $pvp_recomendado, $entrega_imediata, '{$foto}', $id_categoria)";
		return mysql_query($insert);
	}
	
	function getListasNoivoNoiva($noivo, $noiva){
		if($noivo == "")
			$noivo = " ";
		if($noiva == "")
			$noiva = " ";
		$query = "SELECT * from tbl_lista_casamento, tbl_utilizador WHERE (tbl_utilizador.id = tbl_lista_casamento.id_noivo OR tbl_utilizador.id = tbl_lista_casamento.id_noiva) AND (tbl_utilizador.nome LIKE '%{$noivo}%' OR tbl_utilizador.nome LIKE '%{$noiva}%')";		
		return pesquisaComoVector($query);	
	}
?>
