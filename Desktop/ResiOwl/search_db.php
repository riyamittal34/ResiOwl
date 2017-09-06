<?php
	session_start();
	
	$_SESSION['sort']		=	$_POST['sort'];
	$_SESSION['type']		=	$_POST['type'];
	$_SESSION['gender']		=	$_POST['gender'];
	$_SESSION['minprice']	=	$_POST['minprice'];
	$_SESSION['maxprice']	=	$_POST['maxprice'];
	$_SESSION['city']		=	$_POST['city'];
	$_SESSION['locality']	=	$_POST['locality'];
	#$hospital				=	$_POST['hospital'];
	#echo $hospital;
	$con		=	mysqli_connect('localhost','root','','resiowl');
	if($_SESSION['gender']!=" " && $_SESSION['minprice']!=" " && $_SESSION['maxprice']!=" " && 
	$_SESSION['city']!=" " && $_SESSION['type']!=" " && $_SESSION['locality']!=" ")
	{
		$query		= 	"SELECT * FROM `flat` where `type`='".$_SESSION['type']."' AND 
		`gender`='".$_SESSION['gender']."' AND(`rent` BETWEEN ".$_SESSION['minprice']." AND 
		".$_SESSION['maxprice'].") AND `city`='".$_SESSION['city']."' AND 
		`colony`='".$_SESSION['locality']."' ";
		#$query		=	"SELECT * FROM `flat`";
		$data 		=	mysqli_query($con,$query);
		#$array		=	mysqli_fetch_array($data);
		#echo mysqli_num_rows($data);
		$_SESSION['rows']	=	mysqli_num_rows($data);
		$i=0;
		while($row = mysqli_fetch_row($data))
		{
			$_SESSION['dat'][$i]=$row;
			for($j=0;$j<mysqli_num_fields($data);$j++)
			{
				#echo $row[$j]." ";
			}
			echo "<br /><br />";
			$i++;
		}
		if(mysqli_num_rows($data)>0)
		{
			header("location:search.php");
		}
		else
		{
			$_SESSION['no-result']="No Data Found";
			header("location:search.php");		
		}
	}
	else
	{
		$_SESSION['no-result']="No Data Found";
		header("location:search.php");
	}
	
	
	#print_r($_SESSION['dat']);
	/*
	print_r($_SESSION['dat'][0]);
	echo "<br />";
	print_r($_SESSION['dat'][1]);
	echo "<br />";
	print_r($_SESSION['dat'][2]);
	echo "<br />";
	
	echo $sort."<br />";
	echo $_SESSION['type']."<br />";
	echo $gender."<br />";
	echo $minprice."<br />";
	echo $maxprice."<br />";
	echo $city."<br />";
	*/
?>