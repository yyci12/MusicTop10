<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<link rel="StyleSheet" href="css/chatt.css" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">

</head>
<body>
	<header class="section">
		<a href="/"><img src="img/logo.png"></a>
		<div class="header_menu">
			<c:if test="${session == 0}">
				<button onclick="location.href='/chat'">Chatting</button>
				<button onclick="location.href='/sign_up'">Sign In / Sign Up</button>
			</c:if>
			<c:if test="${session == 1}">
				<button onclick="location.href='/chat'">Chatting</button>
				<button onclick="location.href='/mypage'">Mypage</button>
				<button onclick = "location.href='/logout'">logout</button>
			</c:if>
		</div>
	</header>
	<div id='chatt'>
		<c:choose>
			<c:when test="${empty roomlist }">
				<tr>
					<td colspan="4">----작성된 글이 존재하지 않습니다----</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${roomlist }" var="dto">
					<h1>${dto.artist_Name }</h1>
					<input class="myid" type='hidden' id='mid' value="${myid}">
					<br />
					<div id='talk'></div>
					<div id='sendZone'>
						<textarea id='msg' value='hi...'></textarea>
						<input type='button' value='전송' id='btnSend'>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</div>
	<script src='js/chatt.js'></script>
</body>
</html>