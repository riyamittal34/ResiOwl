<?php
	session_start();
	$_SESSION['page-name']="index.php";
	
	
	$con=mysqli_connect('localhost','root','','resiowl');
	$query="select * from `home_form`";
	$dat=mysqli_query($con,$query);
	$data	=	mysqli_fetch_array($dat);
?>



<!DOCTYPE html>
<html ng-app="Resiowl">
    <head>
    
            <meta charset="UTF-8">
			<link rel="stylesheet" href="component/style1.css">
            <link href="netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
            
            <link rel="stylesheet" href="component/demo.css">
            <link href="component/bootstrap.css" type="text/css" rel="stylesheet">
		    
            <style>
                li:hover { 
                            background-color: orange;
                        }
                </style>
            
            
            <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- <script src="bootstrap.min.js"></script>-->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <script>
        $(document).ready(function(){
        // Add smooth scrolling to all links
        $("a").on('click', function(event) {

            // Make sure this.hash has a value before overriding default behavior
            if (this.hash !== "") {
            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash
            var hash = this.hash;

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 1000, function(){
        
                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
            } // End if
        });
        });
    </script>  
		        
    </head>
        <body>
        
            <!-- --------------------------------- top bar   ------------------------------- -->
                            <?php include('includes/header.php'); ?>

                             <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="bootstrap.min.js"></script>
             <!-- --------------------------------- video logo div  ------------------------------- -->
            
            <div  class="banner row border" style="margin:0;border-top:0;">
                <div class="col-xs-12 col-sm-3 stars"></div>
                <div class="col-xs-12 col-sm-6 slider">
                    <video  width=100% control="false"  autoplay>
                        <source src="video.mp4" type="video/mp4">
                        Your browser does not support the video tag.
                    </video>
               
                    <center><h1 class="text-primary">Helping Owls Fetch Nests</h1>
                    <br>
					
                    <a href="OurTeam.php"><button class="btn-primary">Know Us</button></a></center>
                    <br>
          </div>

               <div class="col-xs-0 col-sm-3 stars"></div>

               
                </div>

            <!-- --------------------------------- search div  ------------------------------- -->
 

        <div class="paralla" id="find">
            <div class="row">
                <div class="col-xs-1 col-sm-3"></div>
                <div class="col-xs-10 col-sm-6 pichead"><h1>Start Fetching</h1></div>
                <div class="col-xs-1 col-sm-3"></div>
            </div>
            <br><br>
            <div class="row">
                <div class="col-xs-0 col-sm-2"></div>
                <div class="col-xs-8 col-sm-6">
                    <input type="text" class="form-control" placeholder="Search Landmarks and Pincodes">
                </div>
                <div class="col-xs-4 col-sm-2">
					<?php $_SESSION['page-name'] = "search.php" ?>
                    <button class="btn btn-primary btn-block" onClick="document.location.href='search.php'">Search</button>
                </div>
                <div class="col-xs-0 col-sm-2"></div>
            </div>
            
                
            
        </div> 
 
             <!-- --------------------------------- Amenities ------------------------------- -->
 
 
            <div  class="banner border" id="amenities" style="text-align:center;">
                <h1 class="main">†   AMENITIES   †<br></h1><hr><br><br>
                <div class="row">
                    <div class="col-xs-12 col-sm-4">
                        <img class="imgs" src="images/single.jpg" alt="">
                        <h3 class="ame_head">Single Room</h3>
                    </div>
                    <div class="col-xs-12 col-sm-4">
                        <img class="imgs" src="images/twin.png" alt="">
                        <h3 class="ame_head">Twin Share</h3>
                    </div>
                    <div class="col-xs-12 col-sm-4">
                        <img class="imgs" src="images/flat.png" alt="">
                        <h3 class="ame_head">Flat</h3>
                    </div>
                </div>
                
            </div>
            <!------------------------------------ blank---------------------------------------------->
        <div class="parallax">
            
                    <center>
                        <img class="img-responsive" src="images/banner.png" alt="#">
                    </center>
             
        </div>  


         <!-- --------------------------------- simplified div ------------------------------- -->
 
 
            <div  class="banner border pad" style="text-align:center;">
               
      <h1 class="main">†   FINDING NEST SIMPLIFIED   †<br></h1><br><br>
      <div class="row">
        
        <div class="col-xs-6 col-sm-3">
                <img alt="how work widget section: first search icon for search house" src="https://d1i673fcimy4cb.cloudfront.net/v3/search-icn1.png">
                <h3 class="main_head">Search</h3>
                <p>Find a place that fits all <br> your preferences.</p>
        </div>
        <div class="col-xs-6 col-sm-3">   
                <img alt="how work widget section: then visit icon for schedule a visit for that house" src="https://d1i673fcimy4cb.cloudfront.net/v3/visit-icn1.png">
                <h3 class="main_head">Visit</h3>
                <p>Finalise a time and date to <br> visit the homes you like.</p>
        </div>
        <div class="col-xs-6 col-sm-3">     
                <img alt="how work widget section: then book icon for secure payment on booking bed or room or house" src="https://d1i673fcimy4cb.cloudfront.net/v3/book-icn1.png">
                <h3 class="main_head">Book</h3>
                <p>Pay a token amount online to <br> lock the bed / room / house.</p>
        </div>
        <div class="col-xs-6 col-sm-3">      
                <img alt="how work widget section: move-in icon for ready to move-in house" src="https://d1i673fcimy4cb.cloudfront.net/v3/move-icn1.png">
                <h3 class="main_head">Move-In</h3>
                <p>Choose a move-in date <br> and just show up!</p>
        </div>
        
        <div class="clr" id="Contact_us"></div>
      </div>
    </div>
               
            
            
        <!-- --------------------------------------contact form -------------------------------- -->
    <div  >
                 <ul class="nav nav-tabs">
		
		<div class="a row">
		    <div class="aa col-xs-12 col-md-5 col-sm-5">
                <h1 style="color: red">Contact Us </h1>
                <p >Name*</p>
                <input type="text" id="text" name="text_name" class="mytext" >
                <p>Email*</p>
                <input type="text" id="text" name="text_email" class="mytext" >
                <p>Message</p>
                <input type="text" id="text1" name="text_msg" class="mytext1" ><br />
                <button class="button1">SUBMIT</button>
                <br />   
			</div>
			<div class="col-xs-0 col-sm-1"></div>
			<div class="bb col-xs-12 col-md-6 col-sm-5">
                <h1 style="color: red;">Get in touch with us</h1>
                <br />
                <p>We will be very happy to help you and assist you in your search. Feel free to call us ,<br />
                mail us or simply complete the contact form</p><br />
                <p><?php echo $data['contact_info']; ?></p><br />
                <p><?php echo $data['timing']; ?></p><br />
                <p><?php echo $data['email']; ?></p>
			</div>

		</div>             
     </div>
        <!-- ------------------------------------------top button--------------------------------- -->
                                 
                                 <?php include('includes/topbtn.php'); ?>

         <!-- -------------------------------------footer -------------------------------- -->

                  <?php include('includes/footer.php'); ?>
        <!-- --------------------------------------------------------------------------------- -->
          
         </body>
</html>