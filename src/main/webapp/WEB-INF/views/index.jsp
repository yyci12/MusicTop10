<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="StyleSheet" href="css/StyleSheet.css" type="text/css">
<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('.chart_Table_bugs').attr('style', "display:none;");
		$('.chart_Table_genie').attr('style', "display:none;");
		
		$('#melon').click(function() {
			$('.chart_Table_melon').show();
			$('.chart_Table_bugs').hide();
			$('.chart_Table_genie').hide();
		});//click

		$('#bugs').click(function() {
			$('.chart_Table_melon').hide();
			$('.chart_Table_bugs').show();
			$('.chart_Table_genie').hide();
		});
		
		$('#genie').click(function() {
			$('.chart_Table_melon').hide();
			$('.chart_Table_bugs').hide();
			$('.chart_Table_genie').show();
		});
	});//ready
</script>
</head>
<body class="body_container">
	<div class="page">
		<header class="section">
				<a href="/"><img src="img/logo.png"></a>
		</header>

		<div class="chart">
			<div class="chart TOP">
				<table class="TOP_Table">
					<col width="200">
					<col width="200">
					<col width="200">
					<col width="200">
					<col width="200">
					<col width="200">
					<c:choose>
						<c:when test="${empty banner }">
							<tr>
								<td colspan="5">----차트 불러오기 실패----</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach begin="0" end="11" items="${banner }" var="dto"
								varStatus="status">
								<fmt:formatNumber value="${status.index }" var="index" />

								<c:choose>
									<c:when test="${index == 5}">
										<td><img src="${dto.img }"><br> ${fn: substring(dto.title, 0 ,15) }<br>
											<b>${dto.artist }</b><br></td>
										<tr></tr>
									</c:when>
									<c:otherwise>
										<td><img src="${dto.img }"><br> ${fn: substring(dto.title, 0 ,15) }<br>
											<b>${dto.artist }</b><br></td>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>

			</div>

			<div class="chart Bottom">
				<br>
				<button id="melon">melon</button>
				<button id="bugs">bugs</button>
				<button id="genie">genie</button>
				<header class="sectionTitle">
					<div class="info">
						<h1>곡 차트</h1>
						<strong>실시간</strong>
						<time datetime="2022.06.21 09:00">
							2022.06.21&nbsp;&nbsp;<span>09:00</span>
						</time>
						<table class="chart_Table_melon">
							<col width="50">
							<col width="200">
							<col width="200">
							<col width="300">
							<col width="100">
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
											<td>
											<a href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
											<img src="${dto.img }"></a><br> ${dto.title }</td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }">${dto.artist }</a></td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.album}">${dto.album }</a></td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">&#128441;</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						
						<table class="chart_Table_bugs">
							<col width="50">
							<col width="200">
							<col width="200">
							<col width="300">
							<col width="100">
							<c:choose>
								<c:when test="${empty bugs }">
									<tr>
										<td colspan="5">----차트 불러오기 실패----</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach begin="0" end="9" items="${bugs }" var="dto">
										<tr>
											<td>${dto.rank }</td>
											<td>
											<a href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
											<img src="${dto.img }"></a><br> ${dto.title }</td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }">${dto.artist }</a></td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.album}">${dto.album }</a></td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">&#128441;</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						
						<table class="chart_Table_genie">
							<col width="50">
							<col width="200">
							<col width="200">
							<col width="300">
							<col width="100">
							<c:choose>
								<c:when test="${empty genie }">
									<tr>
										<td colspan="5">----차트 불러오기 실패----</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach begin="0" end="9" items="${genie }" var="dto">
										<tr>
											<td>${dto.rank }</td>
											<td>
											<a href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
											<img src="${dto.img }"></a><br> ${dto.title }</td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }">${dto.artist }</a></td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.album}">${dto.album }</a></td>
											<td><a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">&#128441;</a></td>
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