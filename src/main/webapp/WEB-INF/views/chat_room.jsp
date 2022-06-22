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

</head>
<body>
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
					<input type='text' id='mid' value='홍길동'>
					<input type='button' value='로그인' id='btnLogin'>
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