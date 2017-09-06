<?php
	$contact = $_POST['contact'];
	$email = $_POST['email'];
	$about = $_POST['about'];
	$timing = $_POST['timing'];
	$address = $_POST['address'];
	
	$con = mysqli_connect('localhost','root','','resiowl');
	$query="UPDATE `home_form` set `contact_info`='".$contact."',
								`email`='".$email."',
								`about`='".$about."',
								`timing`='".$timing."',
								`address`='".$address."' ";
	$data=mysqli_query($con,$query);
	header("location:adminpanel.php");
?>