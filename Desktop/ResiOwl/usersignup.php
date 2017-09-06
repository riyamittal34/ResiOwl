<?php
	session_start();
	
	$con=mysqli_connect('localhost','root','','resiowl');
	
    $name 		=	$_POST['Name'];
	$lname		=	$_POST['LastName'];
	$phn1		=	$_POST['phoneno'];
	$phn2		=	$_POST['al-phn'];
	$username	=	$_POST['username'];
    $email 		=	$_POST['email'];
    $usertype 	=	$_POST['usertype'];
    $gender		=	$_POST['gender'];
    $pass 		=	$_POST['password'];
	$repass		=	$_POST['repass'];
    $curdate	=	date('Y-m-d H:i:s');
	
	#echo $curdate;
	if($pass == $repass)
	{
		
		$sql = "INSERT INTO `users` (name,username,email,password,phone1,phone2,usertype,gender,created,modified) values 
		('".$name." ".$lname."','".$username."','".$email."','".$pass."','".$phn1."','".$phn2."',
		'".$usertype."','".$gender."','".$curdate."','".$curdate."')";
    }
	else
	{
		$_SESSION['signup-error']="Password and Re-Password is not same";
		header("location:login.php");
	}
    if (mysqli_query($con, $sql)) {
        echo "New record created successfully";
		$_SESSION['login_status']=1;
		header("location:index.php");
    } 
	else 
	{
        echo "Error: " . $sql . "<br>" . mysqli_error($con);
    }
	
?>