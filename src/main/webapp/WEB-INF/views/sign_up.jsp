<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<link rel="StyleSheet" href="css/sign_up.css" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">

</head>
<body class="body_container">
	<header class="section">
		<a href="/"><img src="img/logo.png"></a>
		<div class="header_menu">
		</div>
	</header>
	
	
<div class="container right-panel-active">
  <!-- Sign Up -->
  <div class="container__form container--signup">
    <form action="/sign_up_form" class="form" id="form1" method="post">
      <h2 class="form__title">Sign Up</h2>
      <input name="user_Id" type="text" placeholder="Id" class="input" />
      <input name="user_Em" type="email" placeholder="Email" class="input" />
      <input name="user_Pw" type="password" placeholder="Password" class="input" />
      <button type="submit"class="btn">Sign Up</button>
    </form>
  </div>

  <!-- Sign In -->
  <div class="container__form container--signin">
    <form action="login_form" class="form" id="form2" method="post">
      <h2 class="form__title">Sign In</h2>
      <input name="user_Em" type="email" placeholder="Email" class="input" />
      <input name="user_Pw" type="password" placeholder="Password" class="input" />
      <a href="#" class="link">Forgot your password?</a>
      <button class="btn">Sign In</button>
    </form>
  </div>

  <!-- Overlay -->
  <div class="container__overlay">
    <div class="overlay">
      <div class="overlay__panel overlay--left">
        <button class="btn" id="signIn">Sign In</button>
      </div>
      <div class="overlay__panel overlay--right">
        <button class="btn" id="signUp">Sign Up</button>
      </div>
    </div>
  </div>
  
</div>
<script src='js/sign_up.js'></script>
</body>
</html>