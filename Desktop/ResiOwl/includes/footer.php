<?php
	$con=mysqli_connect('localhost','root','','resiowl');
	$query="select * from `home_form`";
	$dat = mysqli_query($con,$query);
	$data= mysqli_fetch_array($dat);


?>


<link rel="stylesheet" href="component/footer.css">
             <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
           
            
 
 
 <footer class="footer-distributed foot" id="know" style="margin:0;">

			<div class="footer-left">

				<span>
                    <a class="navbar-brand" href="index.php"><img src="images/logowhite.png" alt="" width="250px" height="100px">
                    </a>
                    </span>
                    <br>

				<p class="footer-links">
                    
					<a href="index.php">Home</a>
					·
					<a href="OurTeam.php">About Us</a>
					·
					<a href="#contact_us">Contact</a>
				</p>

				<p class="footer-company-name">Resiowl &copy; 2017</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span><?php echo $data['address']; ?></p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p><?php echo $data['contact_info']; ?></p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com"><?php echo $data['email']; ?></a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the company</span>
					<?php echo $data['about']; ?>
				</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>
