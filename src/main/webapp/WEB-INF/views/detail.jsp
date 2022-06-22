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
<link rel="StyleSheet" href="css/detail.css" type="text/css">
<link rel="StyleSheet" href="css/header_footer.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('.melon_tr img').attr('style', "display:none;");
		$('.melon_tr').hover(function() {
			$(this).find('img').attr('style', "display:;");
		}, function() {
			$(this).find('img').attr('style', "display:none;");
		});
	});//ready
</script>
</head>
<body class="body_container">
	<div class="page">
		<header class="section">
			<a href="/"><img src="img/logo.png"></a>
			<div class="header_menu">
				<c:if test="${session == 0}">
					<button onclick="location.href='/chat'">Chatting</button>
					<button onclick="location.href='/sign_up'">Sign In / Sign
						Up</button>
				</c:if>
				<c:if test="${session == 1}">
					<button onclick="location.href='/chat'">Chatting</button>
					<button onclick="location.href='/mypage'">Mypage</button>
					<button onclick="location.href='/logout'">logout</button>
				</c:if>
			</div>
		</header>
		<div class="chart_Bottom">
			<div class="chart">
				<div class="chart_bottom_left">
					<br>
					<div class="sectionTitle">
						<div class="info">
							<h1>차트 모아보기</h1>
							<div class="musiccom"></div>
							<script>
								const date = new Date();
								document.write(date.toLocaleString('ko-kr'));
							</script>
							<div class="jstl_chart">
								<div class="melon">
									<table class="chart_Table_melon">
										<caption>
											<b>Melon</b>
										</caption>
										<col width="100">
										<col width="300">
										<col width="300">
										<col width="350">
										<col width="150">
										<c:choose>
											<c:when test="${empty list }">
												<tr>
													<td colspan="5">----차트 불러오기 실패----</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach items="${list }" var="dto">
													<tr class="melon_tr">
														<td>${dto.rank }</td>
														<td><div class="img_tag">
																<a
																	href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
																	<img src="${dto.img }">
																</a>
															</div>${dto.title }</td>
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
								<div class="bugs">
									<table class="chart_Table_bugs">
										<caption>
											<b>벅스</b>
										</caption>
										<col width="100">
										<col width="300">
										<col width="300">
										<col width="350">
										<col width="150">
										<c:choose>
											<c:when test="${empty bugs }">
												<tr>
													<td colspan="5">----차트 불러오기 실패----</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach begin="0" end="50" items="${bugs }" var="dto">
													<tr class="melon_tr">
														<td>${dto.rank }</td>
														<td><div class="img_tag">
																<a
																	href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
																	<img src="${dto.img }">
																</a>
															</div>${dto.title }</td>
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
								<div class="genie">
									<table class="chart_Table_genie">
										<caption>
											<b>지니</b>
										</caption>
										<col width="100">
										<col width="300">
										<col width="300">
										<col width="350">
										<col width="150">
										<c:choose>
											<c:when test="${empty genie }">
												<tr>
													<td colspan="5">----차트 불러오기 실패----</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach begin="0" end="50" items="${genie }" var="dto">
													<tr class="melon_tr">
														<td>${dto.rank }</td>
														<td><div class="img_tag">
																<a
																	href="https://search.naver.com/search.naver? where=nexearch&sm=top_hty&fbm=0&ie=utf8&query= ${dto.artist }+${dto.title }">
																	<img src="${dto.img }">
																</a>
															</div>${dto.title }</td>
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
					</div>
				</div>
			</div>
			<footer class="section"> </footer>
		</div>
</body>
</html>