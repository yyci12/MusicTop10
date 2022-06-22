<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방만들기</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<link rel="StyleSheet" href="css/chat_room_open.css" type="text/css">

</head>

<body class="body_container">
	<div class="chatopenpage">
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



		<div class="chat_room_open_container">
			<form action="chat_room_make" method="get">
				<table border="1">
					<tr>
						<th>아티스트 이름</th>
						<td><input type="text" name="artist_Name"></td>
					</tr>
					<tr>
						<th>방 설명</th>
						<td><input type="text" name="r_Contents"></td>
					</tr>
					<tr>
						<td><input type="submit" value="완료"> 
						</td>

					</tr>
				</table>
			</form>
		</div>


		<footer class="section"> </footer>
	</div>
</body>
</html>