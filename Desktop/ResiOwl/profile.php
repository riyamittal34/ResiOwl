<?php
	session_start();
	$_SESSION['page-name'] = "profile.php"
?>


<!DOCTYPE html>
<html ng-app="Resiowl">
    <head>
    
            <meta charset="UTF-8">
         
            <link href="netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
             <link href="component/bootstrap.css" type="text/css" rel="stylesheet">
		    <link rel="stylesheet" href="style1.css">
            <style>
                li:hover { 
                            background-color: orange;
                        }
                </style>
             </head>
        <body>
        
            <!-- --------------------------------- top bar   ------------------------------- -->
                                      <?php include('includes/header.php'); ?>

        <!-- --------------------------------------profile------------------- -->
        
        
        
        <!-- ---------------------------------------footer----------------------------- -->
                                     <?php include('includes/footer.php'); ?>