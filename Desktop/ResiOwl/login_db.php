<?php
	session_start();
	$con = mysqli_connect('localhost','root','','resiowl');
	$email=$_POST['email'];
	$password=$_POST['password'];
	$query="Select * from `login` where `email`='".$email."' AND `password`='".$password."'";
	$data	=	mysqli_query($con,$query);

	$count	=	mysqli_num_rows($data);
	echo $email;
	echo $password;

	if($count > 0 ){
		$_SESSION['login_status']	=	1;
		header('location:index.php');
	}else{
		$_SESSION['login_error']	=	"Invalid details";
		header('location:login.php');
	}
	
?>