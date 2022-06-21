<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<link rel="StyleSheet" href="css/chat_room_open.css" type="text/css">

</head>

<body class="body_container">
	<div class="chatopenpage">
		<header class="section">
			<div class="header_section">
				<a href="/">메인</a>
				<div>채팅방 만들기</div>
				<div>
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