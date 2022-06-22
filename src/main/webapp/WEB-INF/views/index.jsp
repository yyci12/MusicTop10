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
			<div class="header_menu">
			<button onclick = "location.href='/chat'">Chatting</button>
			<button onclick = "location.href='/mypage'">Mypage</button>
			<button onclick = "location.href='/login'">Login</button>
			<button onclick = "location.href='/sign_up'">Sign Up</button>
			</div>
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
										<td><a
											href="https://www.melon.com/search/total/index.htm?q=${dto.title }"><img
												src="${dto.img }"><br> ${fn: substring(dto.title, 0 ,15) }<br>
												<b>${dto.artist }</b></a><br></td>
										<tr></tr>
									</c:when>
									<c:otherwise>
										<td><a
											href="https://www.melon.com/search/total/index.htm?q=${dto.title }"><img
												src="${dto.img }"><br> ${fn: substring(dto.title, 0 ,15) }<br>
												<b>${dto.artist }</b><br></a></td>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>

			</div>

			<div class="chart_Bottom">
				<div class="chart_bottom_left">
					<br>

					<div class="sectionTitle">
						<div class="info">
							<h1>곡 차트</h1>
							<div class="musiccom">
								<button id="melon">melon</button>
								<button id="bugs">bugs</button>
								<button id="genie">genie</button>
							</div>
							<br> <strong>실시간</strong> <br> <br>
							<script>
								const date = new Date();
								document.write(date.toLocaleString('ko-kr'));
							</script>
							<table class="chart_Table_melon">
								<col width="100">
								<col width="250">
								<col width="250">
								<col width="350">
								<col width="150">
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
												<td><a
													href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
														<img src="${dto.img }">
												</a><br> ${dto.title }</td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }">${dto.artist }</a></td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.album}">${dto.album }</a></td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">&#128441;</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>

							<table class="chart_Table_bugs">
								<col width="100">
								<col width="250">
								<col width="250">
								<col width="350">
								<col width="150">
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
												<td><a
													href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
														<img src="${dto.img }">
												</a><br> ${dto.title }</td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }">${dto.artist }</a></td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.album}">${dto.album }</a></td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">&#128441;</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>

							<table class="chart_Table_genie">
								<col width="100">
								<col width="250">
								<col width="250">
								<col width="350">
								<col width="150">
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
												<td><a
													href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
														<img src="${dto.img }">
												</a><br> ${dto.title }</td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }">${dto.artist }</a></td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.album}">${dto.album }</a></td>
												<td><a
													href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=${dto.artist }+${dto.title }">&#128441;</a></td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
						</div>
					</div>
				</div>
				<div class="chart_bottom_right">
					<div class="temp">
						<img src="img/iu_event.jpg">
					</div>
					<div class="temp">
						<img src="img/event.jpg">
					</div>
					<div class="temp">
						<img src="img/im_event.jpg">
					</div>
				</div>
			</div>
		</div>
		<footer class="section"> </footer>
	</div>
</body>
</html>