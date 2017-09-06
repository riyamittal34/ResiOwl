<?php
	session_start();
	
	$con=mysqli_connect('localhost','root','','resiowl');
	
	$name 		=	$_POST['username'];
	$pass 		=	$_POST['password'];
	$querry = "SELECT * FROM `admin` where `username`='".$name."' AND `password`='".$pass."'";
	$data	=	mysqli_query($con,$querry);
	$count	=	mysqli_num_rows($data);
	
	if($count > 0 ){
		$_SESSION['login']	=	1;
		header('location:adminpanel.php');
	}else{
		$_SESSION['login_error']	=	"Invalid details";
		header('location:admin_login.php');
	}
?>