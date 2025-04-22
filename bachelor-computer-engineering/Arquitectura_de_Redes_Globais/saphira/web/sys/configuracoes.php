<?php
/**
* config.php
* Congiguracoes do sistema.
* 
* @authors: Nelson Rodrigues, Sergio Lopes
*/

/*Dados de ligacao a' base de dados */
	$host = 'localhost';
	$dbuser = 'saphira';
	$dbpass = 'saphira';	
	$dbname = 'arg';
	$noivo = 1;
	$admin = 2;
	$dbAdminUser = 'root';
	$dbAdminPass = 'root';	
	
	
	function getDatabaseAdminUser() {
		global $dbAdminUser;
		return $dbAdminUser;
	}
	
	function getDatabaseAdminPass() {
		global $dbAdminPass;
		return $dbAdminPass;
	}

	
	function getIDNoivo() {
		global $noivo;
		return $noivo;
	}
	
	function getIDAdministrador() {
		global $admin;
		return $admin;
	}
	
	function getDatabaseHost() {
		global $host;
		return $host;
	}
	
	function getDataBaseUser() {
		global $dbuser;
		return $dbuser;
	}
	
	function getDatabasePassword() {
		global $dbpass;
		return $dbpass;
	}
	
	function getDatabaseName() {
		global $dbname;
		return $dbname;
	}	
?>
