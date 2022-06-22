<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>채팅방</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<link rel="StyleSheet" href="css/chat_room.css" type="text/css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&display=swap" rel="stylesheet">
</head>


<body class="body_container">
	<header class="section">
		<a href="/"><img src="img/logo.png"></a>
		<div class="header_menu">
			<button onclick="location.href='/chat'">Chatting</button>
			<button onclick="location.href='/mypage'">Mypage</button>
			<button onclick="location.href='/login'">Login</button>
			<button onclick="location.href='/sign_up'">Sign Up</button>
		</div>
	</header>
	<div class="chatroompage">



		<div class="myfavoriteArtist_container">
			<div class="myfavoriteArtist_button_con">채팅방에 오신걸 환영합니다.</div>
		</div>
		<div class="chat_room_container">
			<table>
				<col width="100">
				<col width="200">
				<col width="400">
				<col width="300">
				<tr>
					<th>번호</th>
					<th>채팅방 입장</th>
					<th>아티스트 이름</th>
					<th>방 설명</th>
				</tr>
				<c:choose>
					<c:when test="${empty list_1 }">
						<tr>
							<td colspan="4">----작성된 글이 존재하지 않습니다----</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${list_1 }" var="dto">
							<tr>
								<td>${dto.cRoom_No }</td>
								<!-- =${dto.cRoom_No } -->
								<td><button
										onclick="location.href='go_to_chat_room?room_no=${dto.cRoom_No}'">입장</button></td>
								<td>${dto.artist_Name }</td>
								<td>${dto.r_Contents }</td>

							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<tr>
					<td class="chat_m_btn" colspan="4"><input type="button" value="채팅방만들기"
						onclick="location.href='chat_room_open'"></td>
				</tr>
			</table>
		</div>


		<footer class="section"> </footer>
	</div>
</body>
</html>