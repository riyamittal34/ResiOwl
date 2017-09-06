<?php
	session_start();
	
	$con=mysqli_connect('localhost','root','','resiowl');
	
	$name 		=	$_POST['username'];
	$pass 		=	$_POST['password'];
	$querry = "SELECT * FROM `users` where `username`='".$name."' OR `email`='".$name."' AND `password`='".$pass."'";
	$data	=	mysqli_query($con,$querry);
	$count	=	mysqli_num_rows($data);
	
	if($count > 0 ){
		$_SESSION['login']	=	1;
		header('location:index.php');
	}else{
		$_SESSION['login_error']	=	"Invalid details";
		header('location:profile.php');
	}
?>