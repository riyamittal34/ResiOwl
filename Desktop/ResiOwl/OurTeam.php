<?php
	session_start();
	$_SESSION['page-name'] = "OurTeam.php";
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Our Team</title>
		<link href="component/ourteam.css" type="text/css" rel="stylesheet">
		<link href="component/bootstrap.css" type="text/css" rel="stylesheet">
		 
		
	</head>
	<body>
	
		<?php include("includes/header.php"); ?>
		<br />
		<br />
		<br />
		<br /><br /><br />
		<div class="team row" style="margin:auto;padding-top:3%;width:70%;">
			<div class="text">
				<p>About Us</p>
			</div>
			<div class="about-us">
				<p>
					
				</p>
			</div>
			
		</div>
			<br />
			<br />
		<div class="team row" style="margin:auto;padding-top:3%;">
			<div class="text">
				<p>Our Team</p>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="img1">
					<center><img  class="image img-responsive" src="images/Capture.PNG" width="350px" height="350px" ></center>
				</div>
				<br />
				<div class="message">
				<br /><p>Arpit Garg</p>
				<a href=""><img src="images/facebook-logo-png-white-i6.png" width="30px"></a>
				<a href=""><img src="images/twitter.png" width="50px"></a>
				<a href=""><img src="images/gitHub.png" width="30px"></a>
				<a href=""><img src="images/instagram-icon.png" width="60px"></a>
				<a href=""><img src="images/linkedin.png" width="30px" style="border:1px solid white;"></a>
				<br/><br/><br/><br/>
				</div>	
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="img1">
					<center><img  class="image img-responsive" src="images/11.png" width="350px" height="350px"></center>
				</div>
				<br />
				<div class="message">
				<br /><p>Nitin Rohra</p>
				<a href=""><img src="images/facebook-logo-png-white-i6.png" width="30px"></a>
				<a href=""><img src="images/twitter.png" width="50px"></a>
				<a href=""><img src="images/gitHub.png" width="30px"></a>
				<a href=""><img src="images/instagram-icon.png" width="60px"></a>
				<a href=""><img src="images/linkedin.png" width="30px" style="border:1px solid white;"></a>
				<br /><br /><br /><br />
				</div>	
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="img1">
					<center><img  class="image img-responsive" src="images/IMG_20160313_113446.jpg" width="350px" height="350px"></center>
				</div>
				<br />
				<div class="message">
				<br /><p>Riya Mittal</p>
				<a href=""><img src="images/facebook-logo-png-white-i6.png" width="30px"></a>
				<a href=""><img src="images/twitter.png" width="50px"></a>
				<a href=""><img src="images/gitHub.png" width="30px"></a>
				<a href=""><img src="images/instagram-icon.png" width="60px"></a>
				<a href=""><img src="images/linkedin.png" width="30px" style="border:1px solid white;"></a>
				<br /><br /><br /><br />
				</div>	
			</div>

			
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="img1">
					<center><img  class="image img-responsive" src="images/15.jpg" width="350px" height="350px"></center>
				</div>
				<br />
				<div class="message">
				<br /><p>Tulika Singh</p>
				<a href=""><img src="images/facebook-logo-png-white-i6.png" width="30px"></a>
				<a href=""><img src="images/twitter.png" width="50px"></a>
				<a href=""><img src="images/gitHub.png" width="30px"></a>
				<a href=""><img src="images/instagram-icon.png" width="60px"></a>
				<a href=""><img src="images/linkedin.png" width="30px" style="border:1px solid white;"></a>
				<br /><br /><br /><br />
				</div>	
			</div>
		</div>
		<br />
		<br />
		
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="component/bootstrap.min.js"></script>

		 <!-- ---------------------------------------footer----------------------------- -->
        <?php include('includes/footer.php'); ?>
		 <!-- ---------------------------------------footer----------------------------- -->
        
	</body>
</html>