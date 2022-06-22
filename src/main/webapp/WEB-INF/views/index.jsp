<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="css/StyleSheet.css" type="text/css">
<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
</head>
<body class="body_container">
	<div class="page">
		<header class="section">
			<h1>
				<a href="/">메인</a>
			</h1>
		</header>

				<div class="chart">
			<div class="chart TOP">
				<table border="0">
					<c:choose>
						<c:when test="${empty banner }">
							<tr>
								<td colspan="5">----차트 불러오기 실패----</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach begin="0" end="11" items="${banner }" var="dto" varStatus="status">
							<fmt:formatNumber value="${status.index }" var="index"/>
							<c:choose>
								<c:when test="${index == 5}">
								<td><img src="${dto.img }"><br>
											${dto.title }<br> ${dto.artist } ${status.index} <br></td>
									<tr></tr>
								</c:when>
								<c:otherwise>
										<td><img src="${dto.img }"><br>
											${dto.title }<br> ${dto.artist } ${status.index} <br></td>
								</c:otherwise>
							</c:choose>	
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>

			</div>

			<div class="chart Bottom">
				<br>
				<button>bugs</button>
				<button>melon</button>
				<button>youtube</button>
				<header class="sectionTitle">
					<div class="info">
						<h1>곡 차트</h1>
						<strong>실시간</strong>
						<time datetime="2022.06.21 09:00">
							2022.06.21&nbsp;&nbsp;<span>09:00</span>
						</time>
						<table border="1">
							<col width="50">
							<col width="100">
							<col width="200">
							<col width="100">
							<col width="100">
							<tr>
								<th>RANK</th>
								<th>TITLE</th>
								<th>ARTIST</th>
								<th>ALBUM</th>
								<th>DETAIL</th>
							</tr>
							<c:choose>
								<c:when test="${empty list }">
									<tr>
										<td colspan="5">----차트 불러오기 실패----</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach begin="0" end="9" items="${list }" var="dto">
										<tr>
											<td>${dto.rank }</td>
											<td><img src="${dto.img }"> ${dto.title }</td>
											<td>${dto.artist }</td>
											<td>${dto.album }</td>
											<td><a
												href="https://search.naver.com/search.naver?
											where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">
													&#128441;</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</header>
			</div>
		</div>
		<div class="temp">
			<li><a href="/mypage">마이페이지</a></li>
			<li><a href="/chat">채팅방</a></li>
			<li><a href="/login">로그인</a></li>
			<li><a href="/sign_up">회원가입</a></li>
		</div>



		<footer class="section"> </footer>
	</div>
</body>
</html>