<?php
	session_start();
	if(isset($_SESSION['login_error'])){
		echo $_SESSION['login_error'];
		unset($_SESSION['login_error']);
	}
?>


<link rel="stylesheet" href="component/admin_login.css">
    <script>
    $('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
    </script>   


<div class="login-page">
  <div class="form">
    <form class="register-form">
      <input type="text" placeholder="name"/>
      <input type="password" placeholder="password"/>
      <input type="text" placeholder="email address"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
	
    <form class="login-form" action="formsign.php" method="POST" enctype="multipart/form-data">
    <input type="text" name="username" id="username" placeholder="name"/>
    <input type="password" type="password" name="password" id="password" placeholder="password"/>
    <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>

            