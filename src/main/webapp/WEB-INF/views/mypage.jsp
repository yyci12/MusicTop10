<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">


</head>
<body>
<header class="section">
			<a href="/"><img src="img/logo.png"></a>
			<div class="header_menu">
			<c:if test = "${session == 0}">
			<button onclick = "location.href='/chat'">Chatting</button>
			<button onclick = "location.href='/sign_up'">Sign In / Sign Up</button>
			</c:if>
			<c:if test = "${session == 1}">
			<button onclick = "location.href='/chat'">Chatting</button>
			<button onclick = "location.href='/mypage'">Mypage</button>
			</c:if>
			</div>
		</header>
		<div>${myid}님 어서오세요</div>
		
		
</body>
</html>