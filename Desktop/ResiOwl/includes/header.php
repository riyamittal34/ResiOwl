<?php 
	if(!isset($_SESSION['login_status']))
	{
		$_SESSION['login_status']=0;
	}
	
	
	
?>

<style>
	.logoimg {
    top:-2px;
    position: absolute;
    height: 50px;
    width: 120px;
	} 
</style>	

	<?php if($_SESSION['login_status'] == 1)
		{ 
	?>
			<nav class="nb navbar navbar-inverse" style="margin:0px;background-color:teal;border-color:teal;position:fixed;width:100%;z-index:1000;">
                <div class="container-fluid">
                    <div class="navbar-header">
	                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
	                        <span class="sr-only">Toggle navigation</span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                    </button>
						<a class="navbar-brand" href="index.php"><img class="logoimg" src="images/logowhite.png" alt=""></a>
                    </div>

                    <div class="collapse navbar-collapse"  id="bs-example-navbar-collapse-2">
						<ul class="nav navbar-nav navbar-right">
							
					<?php if($_SESSION['page-name']=="search.php" || $_SESSION['page-name']=="OurTeam.php" || $_SESSION['page-name']=="form.php") { ?>
							<li><a style="color:white" href="index.php">Home</a></li>	
					<?php } if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']=="form.php") { ?>
							<li><a style="color:white" href="#find">Fetch a Nest</a></li>
					<?php } if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']=="form.php") { ?>
							<li><a style="color:white" href="#amenities">Amenities</a></li>
	                <?php }	if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']=="search.php" || $_SESSION['page-name']=="form.php") { ?>
							<li><a style="color:white" href="#Contact_us">Contact Us</a></li>
					<?php }	if($_SESSION['page-name']=="OurTeam.php" ) {?>
                            <li><a style="color:white" href="#">Tenant Policies</a></li>
					<?php } if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']=="search.php" || $_SESSION['page-name']=="OurTeam.php") { ?>
	                        <li><a style="color:white" href="form.php">List your property</a></li>
					<?php } ?>
                            <li><a style="color:white" href="logout.php">Logout</a></li>
						</ul>
                    </div>  
                </div>
            </nav>
		<?php
			}
			else if($_SESSION['login_status'] == 0)
			{
		?>
			<nav class="nb navbar navbar-inverse" style="margin:0px;background-color:teal;border-color:teal;position:fixed;width:100%;z-index:1000;">
                <div class="container-fluid">
                    <div class="navbar-header">
	                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
	                        <span class="sr-only">Toggle navigation</span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                    </button>
						<a class="navbar-brand" href="index.php"><img class="logoimg" src="images/logowhite.png" alt=""></a>
                    </div>

                    <div class="collapse navbar-collapse"  id="bs-example-navbar-collapse-2">
						<ul class="nav navbar-nav navbar-right">
						
					<?php if($_SESSION['page-name']=="search.php" || $_SESSION['page-name']=="OurTeam.php" || $_SESSION['page-name']=="login.php") { ?>
							<li><a style="color:white" href="index.php">Home</a></li> 
					<?php } if($_SESSION['page-name']=="index.php") { ?>
							<li><a style="color:white" href="#find">Fetch a Nest</a></li>
					<?php } if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']==".php") { ?>
							<li><a style="color:white" href="#amenities">Amenities</a></li>
					<?php }	if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']=="search.php" || $_SESSION['page-name']=="login.php") { ?>
							<li><a style="color:white" href="#Contact_us">Contact Us</a></li>
					<?php }	if($_SESSION['page-name']=="OurTeam.php" || $_SESSION['page-name']=="login.php") { ?>
                            <li><a style="color:white" href="#">Tenant Policies</a></li>
					<?php }	if($_SESSION['page-name']=="index.php" || $_SESSION['page-name']=="search.php" || $_SESSION['page-name']=="OurTeam.php") { ?>
                            <li><a style="color:white" href="login.php">Login | Register</a></li>
					<?php } if($_SESSION['page-name']=="login.php") { ?>
							<li><a style="color:white" href="signup.php">SignUp</a></li>
					<?php } ?>
						</ul>
                    </div>  
                </div>
			</nav>
		<?php
			}
		?>

		
           
            