<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<link rel="StyleSheet" href="css/mypage.css" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">

</head>
<body>
<header class="section">
			<a href="/"><img src="img/logo.png"></a>
			<div class="header_menu">
			<c:if test = "${session == 1}">
			<button onclick = "location.href='/chat'">Chatting</button>
			</c:if>
			</div>
		</header>
		<div class="page">
		<div class ="mypage_id">${myid}님 어서오세요</div>
		<button onclick = "location.href='/Withdrawal'">회원탈퇴</button>
		</div>
		
		
		
</body>
</html>