<?php 
	session_start();
	$_SESSION['login_status']=0;
	header("location:index.php");
?>