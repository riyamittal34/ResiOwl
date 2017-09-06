<?php
	session_start();
	$con = mysqli_connect('localhost','root','','resiowl');
	$hname=$_POST['name'];
    $phone=$_POST['phone'];
    $plot=$_POST['plot'];
    $colony=$_POST['colony'];
    $street=$_POST['street'];
    $landmark=$_POST['landmark'];
    $city=$_POST['city'];
    $state=$_POST['state'];
    $zip=$_POST['zip'];
    $type=$_POST['type'];
    $gender=$_POST['gender'];
    $rent=$_POST['rent'];
    $security=$_POST['deposit'];
    $des=$_POST['description'];
    $hospital=$_POST['hospital'];
    $mall=$_POST['mall'];
    $grocery_store=$_POST['grocery_store'];
    $restaurant=$_POST['restaurant'];
    $trans=$_POST['trans'];
    $curdate=date('Y-m-d H:i:s');


	$query="INSERT INTO `flat` (`name`,`phone`,`plot`,`colony`,`street`,`landmark`,`city`,`state`,`zipcode`,`type`,`gender`
    ,`rent`,`security_deposit`,`description`,`hospital`,`mall`,`grocery_store`,`tranport`,`restaurant`,`created`)
     VALUES ('".$hname."','".$phone."','".$plot."','".$colony."','".$street."','".$landmark."','".$city."','".$state."','".$zip."',
     '".$type."','".$gender."','".$rent."','".$security."','".$des."','".$hospital."','".$mall."','".$grocery_store."', '".$trans."','".$restaurant."','".$curdate."'
)";
            if(mysqli_query($con,$query))
            {
                echo"new record entered successfully";
                header("location:index.php");
            }
		else {
            echo "no entry" .$sql. mysqli_error($con);
        }
	

?>