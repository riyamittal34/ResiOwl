<?php
	session_start();
	$_SESSION['page-name'] = "login.php";

	if(isset($_SESSION['login_error']))
	{
		echo $_SESSION['login_error'];
		unset($_SESSION['login_error']);
	}
?>



<html ng-app="Resiowl">
  <head>
  	<title>Sign-Up</title>
		<script src=component/angular.js></script>
		<script src="component/app.js"></script>
		 <link rel="stylesheet" href="component/footer.css">
		<link rel="stylesheet" type="text/css" href="component/login.css">
	 	<link href="component/bootstrap.css" type="text/css" rel="stylesheet">
		 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	</head>
  <body>

	  
            <!-- --------------------------------- top bar   ------------------------------- -->
                            <?php include('includes/header.php'); ?>

           
		<div id="fb-root" ></div>
		<div  ng-controller="formctrl as ctrl">
		<div class="bg row" >
			<div class=" hidden-xs col-sm-4"></div>
	    <div class="login col-xs-12 col-sm-4" ng-if="ctrl.logstatus">
	  		<h1>Login</h1><hr><br/>
				<button class="loginBtn loginBtn--facebook btn-block">
					<center>Login with Facebook</center>
				</button>
				<button class="loginBtn loginBtn--google btn-block">
		  		<center>Login with Google</center>
				</button>
				<form name="loginform" action="login_db.php" method="POST" novalidate>
					<center><h3>or</h3></center>
		  		<div class="form-group" ng-submit="">
						<label for="formGroupExampleInput"></label>
						<input type="email" class="form-control" name="email" id="formGroupExampleInput" placeholder="Enter Email Or Username" ng-model="email" required>
						<span ng-if="loginform.email.$error.required && loginform.$submitted">Email is Required</span>
						<span ng-if="loginform.email.$error.email && loginform.$submitted">Email format is incorrect</span>
						<label for="formGroupExampleInput2"></label>
						<input type="password" class="form-control" name="password" id="formGroupExampleInput2" placeholder="Enter Password" ng-model="password" required>
						<span ng-if="loginform.password.$invalid && loginform.$submitted">Password Required<br></span>
						<a href="#" class="forgot">forgot password</a><br><br>
						<button type="submit" class="btn btn-warning btn-block">Login</button>
						
					</div>
				</form>
				<center><font style="color:white"> New User?  </font><a href="" class="create" ng-click="ctrl.statuschange()">Create an Account</a></center>
				<br/>
			</div> 
		</div>








		<div class="bg row">
			<div class=" hidden-xs col-sm-2"></div>
			<div class="signup col-xs-12 col-sm-8" ng-if="!ctrl.logstatus" >
				<form name="sform" action="usersignup.php" method="post" ng-submit="ctrl.submit(sform)" novalidate>
						<h1>Sign Up</h1>
						<hr>
						<div class="row">
						<div class="col-xs-12 col-sm-6">
						<center><h4 style="color:lightgreen">Already a Member?</h4></div>
						<div class="col-xs-12 col-sm-6"><button class="btn-info btn btn-block" ng-click="ctrl.statuschange()">Login</button></center></div>
						<br><br><hr>
						
							<div class="col-xs-12 col-sm-6">
						<p>First Name<font>*</font></p>
            <input type="text" name="Name" class="form-control" ng-model="ctrl.fname" required>
						<span ng-if="sform.Name.$invalid && sform.$submitted">Field Required<br></span><br>
							</div>
							<div class="col-xs-12 col-sm-6">
								<p>Last Name</p>
								<input type="text" name="LastName" class="form-control" ng-model="ctrl.lname" >
								<br>
							</div>
							<div class="col-xs-12 col-sm-6">
						<p>Phone no.<font>*</font></p>
            <input type="text" name="phoneno" class="form-control" ng-model="ctrl.phn" required>
						<span ng-if="sform.Name.$invalid && sform.$submitted">Field Required<br></span><br>
							</div>
							<div class="col-xs-12 col-sm-6">
							<p>Alternative Phone No.<font>*</font></p>
							<input type="text" name="al-phn" class="form-control" ng-model="ctrl.idno" required>
							<span ng-if="sform.Name.$invalid && sform.$submitted">Field Required<br></span><br>
							</div>
						
							<div class="col-xs-12 col-sm-6">
						<p> UserName<font>*</font></p>
		        <input type="text" name="username" class="form-control" ng-model="ctrl.uname" required>
						<span ng-if="sform.uname.$invalid && sform.$submitted">Field Required<br></span><br>
									</div>
							<div class="col-xs-12 col-sm-6">
						<p>Email<font>*</font></p>
		       	<input type="email" name="email" class="form-control" ng-model="ctrl.email" required></textarea>
						<span ng-if="sform.email.$error.required && sform.$submitted">Email is Required</span>
						<span ng-if="sform.email.$error.email && sform.$submitted">Email format is incorrect</span> 
						<br />
							</div>
							<div class="col-xs-12 col-sm-6">
						<p>Password<font>*</font></p>
		       	<input type="password" name="password" class="form-control" ng-model="ctrl.pass" data-toggle="password" required>
						<span ng-if="sform.password.$invalid && sform.$submitted">Password Required<br></span><br>
							</div>
							<div class="col-xs-12 col-sm-6">
						<p>Re-enter Password<font>*</font></p>
		       	<input type="password" name="repass" class="form-control" ng-model="ctrl.renter" data-toggle="password" required>
						<span ng-if="sform.reenter.$invalid && sform.$submitted">Field Required<br></span><br>
							</div>
							<div class="col-xs-12 col-sm-6">
						<p>Login as:</p>
			 			<label class="radio-inline rad">
              <input type="radio" name="usertype" value="0" ng-model="ctrl.auth" >Tenant
						</label>
	          <label class="radio-inline rad">
	            <input type="radio" name="usertype" value="1" ng-model="ctrl.auth">Land Lord
						</label>
						<span ng-if="sform.auth.$invalid && sform.$submitted">Auth Type Required<br></span><br><br/>
							</div>
							<div class="col-xs-12 col-sm-6">
						<p>You are:</p> 
			  		<label class="radio-inline rad">
              <input type="radio" name="gender" value="f" ng-model="ctrl.gender">Female
            </label>
            <label class="radio-inline rad">
             	<input type="radio" name="gender" value="m" >Male
            </label>
						<span ng-if="sform.gender.$invalid && sform.$submitted">Gender Required<br></span><br><br/>
							</div>
							<div class="col-xs-6"><span style="background-color:grey; border:2px solid teal;"  class="form-control captchadiv">{{ctrl.captcha}}</span></div>
							<div class="col-xs-6"><input class="form-control" ng-model="ctrl.takecaptcha"></input></div><br>
							<br><br><br>
							<div class=" hidden-xs col-sm-3"></div><br><br><br>
							<div class="col-xs-12 col-sm-6">
						 <button style="margin-top:5%" ng-click="ctrl.check()" type="submit" class="btn btn-danger btn-block">Create An Account</button>
							</div>
						</div>
				</form>	
      </div>
		</div>
	</div>
	 <!-- ---------------------------------------footer----------------------------- -->
        <?php include('includes/footer.php'); ?>
		 <!-- ---------------------------------------footer----------------------------- -->
        
  </body>
</html>		