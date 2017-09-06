<?php
	session_start();
	$con=mysqli_connect('localhost','root','','resiowl');
	
	if(!isset($_SESSION['login'])){
		$_SESSION['login_error']	=	"Please login to continue";
		header('location:admin_login.php');
	}
	
	$query="select * from `home_form`";
	$dat=mysqli_query($con,$query);
	$data	=	mysqli_fetch_array($dat);
?>

<html ng-app="adminpanel"> 
    <head> <title>Admin Panel</title> 
        <script src="component/angular.js"></script>
        <script src="component/adminpanel.js"></script>
        <link rel="stylesheet" href="component/adminpanel.css">
        <link rel="stylesheet" href="component/bootstrap.css">
    </head> 
    <body>
        <div class="content" ng-controller="adminctrl as adm">
            <div class="side">
                <ul class=list-group style="margin-top:50px">
                    <li class="list-group-item btn" ng-click="adm.homeselect()">Home</li><br>
                    <li class="list-group-item btn" ng-click="adm.resultselect()">Results</li><br>
                    <li class="list-group-item btn" ng-click=adm.aboutselect()>About Us</li><br>
                </ul>
            </div>
            <div class="admform" ng-if="adm.home">
                <form class=form-group action="modify.php" method="post">
                    <fieldset>
                        <legend>Home Form</legend>
                        <label for="contact no" class="control-label">Contact No</label><input type="text" class=form-control value="<?php echo $data['contact_info']; ?>" name="contact"><br>
                        <label for="contact no" class="control-label">Email Address</label><input type="text" class=form-control value="<?php echo $data['email']; ?>" name="email" ><br>
                        <label for="contact no" class="control-label">About</label><input type="text" class=form-control value="<?php echo $data['about']; ?>" name="about"><br>
                        <label for="contact no" class="control-label">Timings</label><input type="text" class=form-control value="<?php echo $data['timing']; ?>" name="timing" ><br>
                        <label for="contact no" class="control-label">Address</label><input type="text" class=form-control value="<?php echo $data['address']; ?>"  name="address"><br>
                        <br><center><button class="btn btn-primary">Update</button></center>
                    </fieldset>
                </form>
            </div>
            <div class="admform" ng-if="adm.result">
                <form class=form-group>
                    <fieldset>
                        <legend>Result Form</legend>
                        <label for="contact no" class="control-label">Contact No</label><input type="text" class=form-control><br>
                        <label for="contact no" class="control-label">Email Address</label><input type="text" class=form-control><br>
                        <label for="contact no" class="control-label">About</label><input type="text" class=form-control><br>
                        <label for="contact no" class="control-label">Timings</label><input type="text" class=form-control><br>
                        <label for="contact no" class="control-label">Address</label><input type="text" class=form-control><br>
                        <br><center><button class="btn btn-primary">Update</button></center>
                    </fieldset>
                </form>
            </div>
            <div class="admform" ng-if="adm.about">
                <form class=form-group>
                    <fieldset>
                        <legend>About Form</legend>
                        
                        <label for="contact no" class="control-label">About</label><input type="text" class=form-control>
                        <br><center><button class="btn btn-primary">Update</button></center>
                    </fieldset>
                </form>
            </div>
        </div>

    </body>
</html>