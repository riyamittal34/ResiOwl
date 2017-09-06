<?php
	session_start();
	$_SESSION['page-name']="search.php";
?>

	


<!DOCTYPE html>
<html lang="en">

  <head>
    <title>Search</title>
    <meta charset="utf-8"></meta>
    <link rel="stylesheet" href="component/jquery.rateyo.min.css"/>
	<link href="component/search.css" type="text/css" rel="stylesheet">
		<link href="component/bootstrap.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" href="component/jquery.rateyo.min.css">
		<script type="text/javascript" src="component/jquery.min.js"></script>
		<script type="text/javascript" src="component/jquery.rateyo.js"></script>
		<script src="component/bootstrap.min.js"></script>
		<script src="component/main.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="component/jquery.bxslider.min.js"></script>
		<link href="component/jquery.bxslider.css" rel="stylesheet" />
	</head>
	<body class="body" style="overflow-x:hidden;">
			<?php include('includes/header.php'); ?>
	      	<script src="component/bootstrap.min.js"></script>
		<script type="text/javascript" src="component/jquery.rateyo.js"></script>
			<br /><br />
			<div class="filter">
				<nav class="navbar navbar-default" style="z-index:800;width:100%;margin-top:10px;">
					<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">Filters</a>
					    </div>
					
					    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<div>
							<ul class="nav navbar-nav" style="padding-left:150px;"  >
							
						        <!--<li class="dropdown">
						          <a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button"   aria-expanded="false">Sort By <span class="caret"></span></a>
						          <ul class="dropdown-menu" role="menu" >
						            <li><option href="#">Low to High</option></li>
						            <li><option href="#">High to Low</option></li>
						          </ul>
						        </li>
								<li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Category<span class="caret"></span></a>
						          <ul class="dropdown-menu" role="menu">
						            <li><a href="#">Single Room</a></li>
						            <li><a href="#">Double Room</a></li>
						            <li><a href="#">Flat</a></li>
						          </ul>
						        </li>
								<li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Gender <span class="caret"></span></a>
						          <ul class="dropdown-menu" role="menu">
						            <li><a href="#">Male</a></li>
						            <li><a href="#">Female</a></li>
						          </ul>
						        </li>
						
								<li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Min Price <span class="caret"></span></a>
						          <ul class="dropdown-menu" role="menu">
						            <li><a href="#">Min</a></li>
						            <li><a href="#">1000</a></li>
						            <li><a href="#">2000</a></li>
						            <li><a href="#">5000</a></li>
						            <li><a href="#">7000</a></li>
						            <li><a href="#">10000</a></li>
						            <li><a href="#">15000</a></li>
						          </ul>
						        </li>
								<li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Max Price <span class="caret"></span></a>
						          <ul class="dropdown-menu" role="menu">
						            <li><a href="#">5000</a></li>
						            <li><a href="#">7000</a></li>
						            <li><a href="#">10000</a></li>
						            <li><a href="#">15000</a></li>
						            <li><a href="#">20000</a></li>
						            <li><a href="#">25000</a></li>
						            <li><a href="#">Max</a></li>
						          </ul>
						        </li>
								-->
							</ul>
							<form action="search_db.php" method="post" class="navbar-form navbar-left" role="search">
								<select name="sort">
								<option value=" ">Sort By-</option>
								<option value="lth">Low to High</option>
						        <option value="htl">High to Low</option>
							</select>
							
							<select name="type">
								<option value=" ">Type</option>
								<option value="0">Single Room</option>
						        <option value="1">Double Room</option>
								<option value="2">Both</option>
							</select>
							
							<select name="gender">
								<option value=" ">Gender</option>
								<option value="0">Male</option>
						        <option value="1">Female</option>
						        <option value="2">Both</option>
							</select>
							
							<select name="minprice">
								<option value=" ">Min Price</option>
						        <option value="5000">5000</option>
						        <option value="7000">7000</option>
						        <option value="9000">9000</option>
						        <option value="10000">10000</option>
							</select>
							
							<select name="maxprice">
								<option value=" ">Max Price</option>
						        <option value="10000">10000</option>
						        <option value="15000">15000</option>
						        <option value="20000">20000</option>
						        <option value="25000">25000</option>
							</select>
							   <div class="form-group">
									<input type="text" name="city" class="form-control" placeholder="City">
						        </div>
								<div class="form-group">
									<input type="text" name="locality" class="form-control" placeholder="Locality">
						        </div>
						        <button type="submit" class="btn btn-default">Search</button>
						    
						</div>
						<div style="float:left;width:100%" class="row">
							<div class="col-xs-12 col-md-1" style="font-size:16px;margin:10px;">Distance  -</div>
							
							<div class="checkbox col-xs-12 col-md-2" style="display:inline;margin:10px;">
						      <label><input type="checkbox" name="hospital" value="">Near Hospital</label>
						    </div>
							<div class="checkbox col-xs-12 col-md-2" style="display:inline;margin:10px;">
						      <label><input type="checkbox" value="">Near Grocery Store</label>
						    </div>
							<div class="checkbox col-xs-12 col-md-2" style="display:inline;margin:10px;">
						      <label><input type="checkbox" value="">Near Mall</label>
						    </div>
							<div class="checkbox col-xs-12 col-md-2" style="display:inline;margin:10px;">
						      <label><input type="checkbox" value="">Near Transportation</label>
						    </div>
							<div class="checkbox col-xs-12 col-md-2" style="display:inline;margin:10px;">
						      <label><input type="checkbox" value="">Near Restaurant</label>
						    </div>
					    </div>
					    </div>
				  </div>
				  
				  
				</nav>
			</div>
			
		<?php	if(isset($_SESSION['dat']))
		{
			for($i=0;$i<$_SESSION['rows'];$i++)
			{
			
				if($_SESSION['dat'][$i][1]==0)
				{
		?>
			
			<div class="row">
				<div class="data" style="z-index:100;background-color:rgba(49,79,79,0.7);color:white;">
					<p>Hostel / pg</p>
					<div class="image col-xs-12 col-sm-6 col-md-4">
						<ul class="bxslider slider">
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
						</ul>
					</div>
					<div  class="content col-xs-12 col-sm-6 col-md-8 row">
						<div class="box"><?php echo $_SESSION['dat'][$i][15]; ?></div> 
						<div class="glyphicon glyphicon-map-marker des"> <?php echo $_SESSION['dat'][$i][4]; ?></div>
						<div class="glyphicon glyphicon-user des"> 
						<?php
							if($_SESSION['dat'][$i][11]==0)
							{
								echo "Boys";
							}
							else if($_SESSION['dat'][$i][11]==1)
							{
								echo "Girls";
							}
							else
							{
								echo "Girls and Boys";
							}
						
						?>
						</div>
						<div class="glyphicon glyphicon-user des">
						<?php
							if($_SESSION['dat'][$i][10]==0)
							{
								echo "Single Room";
							}
							else if($_SESSION['dat'][$i][10]==1)
							{
								echo "Double Room";
							}
							else
							{
								echo "Single and Double";
							}
						?>
						</div>
						
						<br /><br />
						<div class="list-group" style="margin:0 0 0 2%;">
						    <div href="#" class="list-group-item" style="background-color:white;color:black;border:none;">
						      <h4 class="list-group-item-heading" style="color:red;">Facilities</h4><br />
						      <p class="list-group-item-text">
								<ul>
									<li class="list">AC Room</li>
									<li class="list">Laundary</li>
									<li class="list">Food</li>
									<li class="list">Timing</li>
								</ul>
							  </p>
						    </div>
						</div>
						<br />
						<br />
						<div class="col-md-6"><h4>Rent -</h4><h3 style="color:black;">&#8377  
							<?php echo $_SESSION['dat'][$i][13]; ?>
						</h3></div>
						<div class="col-md-6"><h4>Security Deposit -</h4><h3 style="color:black;">&#8377 
							<?php echo $_SESSION['dat'][$i][14]; ?>
						</h3></div>
						
						<div class="col-xs-12 row" style="padding:2%;">
							<div class="col-xs-12" style="font-size:18px;color:black">Distance From (Kms) :-</div>
							<div class="col-xs-6 col-md-3">Hospital - <?php echo $_SESSION['dat'][$i][16]; ?></div>
							<div class="col-xs-6 col-md-3">Grocery Store - <?php echo $_SESSION['dat'][$i][18]; ?></div>
							<div class="col-xs-6 col-md-3">Mall - <?php echo $_SESSION['dat'][$i][17]; ?></div>
							<div class="col-xs-6 col-md-3">Transportation - <?php echo $_SESSION['dat'][$i][19]; ?></div>
							<div class="col-xs-6 col-md-3">Restaurant - <?php echo $_SESSION['dat'][$i][20]; ?></div>
						</div>
						
						<br /><br /><br />
						<div class="row" style="margin-left:3%;">
							<div class="form-group col-xs-9 col-md-5" style="padding:0;">
								<textarea class="form-control" id="usr" style="float:left;"></textarea>
							</div>
							<div class="col-xs-3" style="padding:0;">
								<button type="button" class="btn btn-success" style="float:left;margin-left:2px;">Comment</button>
							</div>
							<div class="col-xs-6 col-md-1" style="margin:0;padding:0;">
								<h3>Rating</h3>
							</div>
							<div style="float:right;font-size:20px;margin:0;padding:0" class="rateyo col-xs-6 col-md-4"></div>
						</div>	
						<div class="book">
							<button type="button" class="btn btn-warning btn-block"><div style="font-size:20px;">Book Now</div></button>
						</div>
					</div>
				</div>
			</div>
			<?php
				}
				else if($_SESSION['dat'][$i][1]==1)
				{
			?>
			
			<div class="row" >
				<div class="data" style="z-index:100;background-color:rgba(160,82,42,0.7);color:white;">
				<p>Flat</p>
					<div class="image col-xs-12 col-sm-6 col-md-4">
						<ul class="bxslider slider">
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
							<li><img class="s-img" src="images/cad-square-500x500.jpg" /></li>
						</ul>
					</div>
					<div class="content col-xs-12 col-sm-6 col-md-8 row">
						
						<div class="box"><?php echo $_SESSION['dat'][$i][15]; ?></div>
						<div class="glyphicon glyphicon-map-marker des"> <?php echo $_SESSION['dat'][$i][4]; ?></div>
						<div class="glyphicon glyphicon-user des">
						<?php
							if($_SESSION['dat'][$i][11]==0)
							{
								echo "Boys";
							}
							else if($_SESSION['dat'][$i][11]==1)
							{
								echo "Girls";
							}
							else
							{
								echo "Girls and Boys";
							}
						
						?>
						</div>
						<br /><br />
						<div class="list-group" style="margin:0 0 0 2%;">
						    <div href="#" class="list-group-item" style="background-color:white;color:black;border:none;">
						      <h4 class="list-group-item-heading" style="color:red;">Facilities</h4><br />
						      <p class="list-group-item-text">
								<ul>
									<li class="list">AC Room</li>
									<li class="list">Laundary</li>
									<li class="list">Food</li>
									<li class="list">Timing</li>
								</ul>
							  </p>
						    </div>
						</div>
						<br />
						
						<div class="col-md-6"><h4>Rent -</h4><h3 style="color:black;">&#8377 
							<?php echo $_SESSION['dat'][$i][13]; ?>
						</h3></div>
						<div class="col-md-6"><h4>Security Deposit -</h4><h3 style="color:black;">&#8377 
							<?php echo $_SESSION['dat'][$i][14]; ?>
						</h3></div>
						
						<div class="col-xs-12 row" style="padding:2%;">
							<div class="col-xs-12" style="font-size:18px;color:black">Distance From (Kms) :-</div>
							<div class="col-xs-6 col-md-3">Hospital - <?php echo $_SESSION['dat'][$i][16]; ?></div>
							<div class="col-xs-6 col-md-3">Grocery Store - <?php echo $_SESSION['dat'][$i][18]; ?></div>
							<div class="col-xs-6 col-md-3">Mall - <?php echo $_SESSION['dat'][$i][17]; ?></div>
							<div class="col-xs-6 col-md-3">Transportation - <?php echo $_SESSION['dat'][$i][19]; ?></div>
							<div class="col-xs-6 col-md-3">Restaurant - <?php echo $_SESSION['dat'][$i][20]; ?></div>
						</div>
						
						<br /><br /><br />
						<div class="row" style="margin-left:3%;">
							<div class="form-group col-xs-9 col-md-5" style="padding:0;">
								<textarea class="form-control" id="usr" style="float:left;"></textarea>
							</div>
							<div class="col-xs-3" style="padding:0;">
								<button type="button" class="btn btn-success " style="float:left;margin-left:2px;">Comment</button>
							</div>
							<div class="col-xs-6 col-md-1" style="margin:0;padding:0;">
								<h3>Rating</h3>
							</div>
							<div style="float:right;font-size:20px;margin:0;padding:0;color:red;" class="rateyo col-xs-6 col-md-4"></div>
						</div>
						<div class="book">
							<button type="button" class="btn btn-primary btn-block"><div style="font-size:20px;">Book Now</div></button>
						</div>
						
					</div>
					
										
				</div>
			</div>
		<?php
				}
			}
			#unset($_SESSION['dat']);
		}
		if(isset($_SESSION['no-result']))
		{
			?>
				<div style="width: 50%;margin: 10% auto;height:20%;background-color:rgba(0,0,0,0.5);border-radius:20px;border: 2px solid white;font-family:monotype corsiva;">
					<font color="white"><p style="font-weight:700;text-align:center;padding:15%;font-size:40px;">NO Data FOUND!!!</p></font>
				</div>
			<?php
			unset($_SESSION['no-result']);
		}
			
		?>
		
    <script>

      $(function () {

        var rating = 1.6;

        $(".counter").text(rating);

        $("#rateYo1").on("rateyo.init", function () { console.log("rateyo.init"); });

        $("#rateYo1").rateYo({
          rating: rating,
          numStars: 5,
          precision: 2,
          starWidth: "64px",
          spacing: "5px",
	  rtl: true,
          multiColor: {

            startColor: "#000000",
            endColor  : "#ffffff"
          },
          onInit: function () {

            console.log("On Init");
          },
          onSet: function () {

            console.log("On Set");
          }
        }).on("rateyo.set", function () { console.log("rateyo.set"); })
          .on("rateyo.change", function () { console.log("rateyo.change"); });

        $(".rateyo").rateYo();

        $(".rateyo-readonly-widg").rateYo({

          rating: rating,
          numStars: 5,
          precision: 2,
          minValue: 1,
          maxValue: 5
        }).on("rateyo.change", function (e, data) {
        
          console.log(data.rating);
        });
      });
	  
    </script>
	
  </body>
</html>
