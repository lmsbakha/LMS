<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>BAKHA LMS</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon
      ============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<!-- Google Fonts
      ============================================ -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
<!-- Bootstrap CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- Bootstrap CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<!-- owl.carousel CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.transitions.css">
<!-- animate CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
<!-- normalize CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
<!-- meanmenu icon CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/meanmenu.min.css">
<!-- main CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<!-- educate icon CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/educate-custon-icon.css">
<!-- morrisjs CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/metisMenu/metisMenu.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/metisMenu/metisMenu-vertical.css">
<!-- calendar CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar/fullcalendar.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar/fullcalendar.print.min.css">
<!-- style CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
<!-- responsive CSS
      ============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
<!-- modernizr JS
      ============================================ -->
<script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

	<!-- Start sidebar -->
	<jsp:include page="../inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="../inc/topbar.jsp" />
	<!-- End tobbar -->

	<!-- Main Contents -->
	<div class="header-advance-area">
		<!-- Mobile Menu end -->
		<div class="breadcome-area">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="breadcome-list single-page-breadcome">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<ul class="breadcome-menu" style="float: left;">
										<li><a href="#">Home</a> <span class="bread-slash">/</span></li>
										<li><a href="#">????????????</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">???????????????</span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="product-status mg-b-15">
			<div class="container-fluid">
				<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
					<div class="product-status-wrap drp-lst">
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="product-status-wrap drp-lst">
											<h4>Lecture ??????</h4>
											<hr>
											<!-- ?????? ?????? ?????? -->
											<div class="all-form-element-inner">
												<!-- ?????? lecture ?????? -->
												<form action="${pageContext.request.contextPath}/loginCheck/lectureListByTeacherForAttendance" method="post">
													<div class="form-group-inner">
														<div class="row">
															<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																<div class="form-select-list">
																	<select class="form-control custom-select-value" name="lectureName" id="lectureName" required="required">
																		<option value="defalut">------ Lecture ?????? ------</option>
																		<c:forEach var="l" items="${lectureListByTeacher}">
																			<option value="${l.lectureName }">${l.lectureName }</option>
																		</c:forEach>
																	</select>
																</div>
															</div>
															<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																<button type="submit" class="btn btn-custon-rounded-two" style="background-color: #4e5256; color: white;">????????????</button>
															</div>
														</div>
													</div>
												</form>
												<!-- /?????? lecture ?????? -->
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
					<div class="product-status-wrap drp-lst">
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="product-status-wrap drp-lst">
											<h4>????????? ??????</h4>
											<!-- ?????? ?????? ?????? -->
											<div class="asset-inner">
												<table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-resizable="true" data-cookie="true" data-cookie-id-table="saveId" data-click-to-select="true" data-toolbar="#toolbar">
													<thead>
														<tr>
															<th>studentName(????????????)</th>
															<th>studentId(??????ID)</th>
															<th>lectureName(??????)</th>
															<th>teacherName(??????)</th>
															<th style="width: 150px">Setting</th>
														</tr>
													</thead>
													<tbody>
														<c:if test="${empty attendanceList }">
															<tr>
																<td colspan="7" style="text-align: center;">--- lecture??? ?????? ?????????????????? ---</td>
															</tr>
														</c:if>
														<c:if test="${not empty attendanceList }">
															<c:forEach var="map" items="${attendanceList}">
																<tr>
																	<td>${map.studentName}</td>
																	<td>${map.studentId}</td>
																	<td>${map.lectureName}</td>
																	<td>${map.teacherName}</td>
																	<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${map.studentId}">
																			<button type="button" class="btn btn-sm btn-custon-rounded-two btn-primary">
																				<i class="fa fa-info-circle edu-informatio" aria-hidden="true"></i> ????????????
																			</button>
																		</a></td>
																</tr>
															</c:forEach>
														</c:if>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Start footer -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- End footer -->


	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- jquery
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<!-- counterup JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/counterup/jquery.counterup.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/counterup/waypoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/counterup/counterup-active.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/metisMenu/metisMenu.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/morrisjs/raphael-min.js"></script>
	<script src="${pageContext.request.contextPath}/js/morrisjs/morris.js"></script>
	<script src="${pageContext.request.contextPath}/js/morrisjs/morris-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/sparkline/jquery.sparkline.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/sparkline/jquery.charts-sparkline.js"></script>
	<script src="${pageContext.request.contextPath}/js/sparkline/sparkline-active.js"></script>
	<!-- calendar JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/calendar/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/calendar/fullcalendar.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/calendar/fullcalendar-active.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/tawk-chat.js"></script>
</body>
</html>