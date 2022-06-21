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
</head>


<body class="body_container">
	<div class="chatroompage">
		<header class="section">
			<div class="header_section">
				<a href="/">메인</a>
				<div href="/">채팅방</div>
				<div>
		</header>


		<div class="myfavoriteArtist_container">
			<div class="myfavoriteArtist_button_con">hi</div>
		</div>
		<div class="chat_room_container">
			<table border="1">
				<col width="50">
				<col width="100">
				<col width="200">
				<col width="100">
				<tr>
					<th>croom_no</th>
					<th>artistname</th>
					<th>contents</th>
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
								<td>${dto.artist_Name }</td>
								<td>${dto.r_Contents }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="4"><input type="button" value="글작성"
						onclick="location.href='./insertform'"></td>
				</tr>
			</table>
		</div>


		<footer class="section"> </footer>
	</div>
</body>
</html>