<?php

//Server of the Chatting Application
$dbHost = "";
$dbUsername = "";
$dbPassword = "";
$dbName = "";

$db = new MySQL($dbHost, $dbUsername, $dbPassword, $dbName);

$username = isset(($_REQUEST['username']) && ($_REQUEST['username']) >= 0 ) ? $_REQUEST['username'] : NULL;
$password = isset($_REQUEST['password']) ? md5($_REQUEST['password']) : NULL;
$port = isset($_REQUEST['port']) ? md5($_REQUEST['port']) : NULL;

$action = isset($_REQUEST['action']) ? $_REQUEST['action'] : NULL;

if($action == "testWebAPI"){
	if($db->testConnection()){
		echo "Successful";
		exit();
	}else{
		echo "Failed";
		exit();
	}
}	

?>