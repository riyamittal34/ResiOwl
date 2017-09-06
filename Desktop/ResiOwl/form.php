<?php
	session_start();
	$_SESSION['page-name']="form.php";
?>

<!DOCTYPE html>
<html>
    <head>
    
            <meta charset="UTF-8">
            <link rel="stylesheet" href="component/form.css">
            <link rel="stylesheet" href="component/bootstrap.css">
            <script src="component/form.js"></script>
            <script src='https://code.jquery.com/jquery-3.1.0.min.js'></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="component/bootstrap.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
#success_message{ display: none;}
</style>
    </head>
        <body>
			<?php include('includes/header.php'); ?>
			<br><br><br><br><br>
            <div id="tophead">
                <center><span id="heading">Property Details</span></center>

            </div><br><br><br><br>

            <div class="form">
                <div class="tab">
                    <button class="tablinks active" aria-expanded="true"  onclick="openCity(event, 'hostel')">HOSTEL/PG</button>
                    <button class="tablinks" onclick="openCity(event, 'flat')">FLAT</button>
                    
                    </div>

                    <div id="hostel" class="tabcontent active ">

<!-- -------------ernter here---------------------------- -->
                     <?php include('includes/hostelform.php'); ?>
                    </div>

                    <div id="flat" class="tabcontent">
                    <?php include('includes/flatform.php'); ?>
                    </div>


                    <script>
                    function openCity(evt, cityName) {
                        var i, tabcontent, tablinks;
                        tabcontent = document.getElementsByClassName("tabcontent");
                        for (i = 0; i < tabcontent.length; i++) {
                            tabcontent[i].style.display = "none";
                        }
                        tablinks = document.getElementsByClassName("tablinks");
                        for (i = 0; i < tablinks.length; i++) {
                            tablinks[i].className = tablinks[i].className.replace(" active", "");
                        }
                        document.getElementById(cityName).style.display = "block";
                        evt.currentTarget.className += " active";
                    }
                    </script>
            </div>
         </body>
</html>