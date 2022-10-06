<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>BAKHA LMS</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://kit.fontawesome.com/def66b134a.js"
	crossorigin="anonymous"></script>
<!-- favicon
      ============================================ -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<!-- Google Fonts
      ============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
<!-- Bootstrap CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<!-- Bootstrap CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<!-- owl.carousel CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/owl.transitions.css">
<!-- animate CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/animate.css">
<!-- normalize CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/normalize.css">
<!-- meanmenu icon CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/meanmenu.min.css">
<!-- main CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<!-- educate icon CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/educate-custon-icon.css">
<!-- morrisjs CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/metisMenu/metisMenu.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/metisMenu/metisMenu-vertical.css">
<!-- calendar CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/calendar/fullcalendar.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/calendar/fullcalendar.print.min.css">
<!-- style CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style.css">
<!-- responsive CSS
      ============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/responsive.css">
<!-- modernizr JS
      ============================================ -->
<script
	src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3.min.js"></script>
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
		<div class="breadcome-area">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="breadcome-list single-page-breadcome">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<ul class="breadcome-menu" style="float: left;">
										<li><a
											href="${pageContext.request.contextPath}/loginCheck/index">Home</a>
											<span class="bread-slash">/</span></li>
										<li><a href="#">강의관리</a> <span class="bread-slash">/</span></li>
										<li><a href="#">강좌관리</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">강좌수정</span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="product-status mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-status-wrap drp-lst">
						<c:if test="${not empty alertMsg}">
							<div class="alert alert-success alert-success-style1">
								<button type="button" class="close sucess-op"
									data-dismiss="alert" aria-label="Close">
									<span class="icon-sc-cl" aria-hidden="true">&times;</span>
								</button>
								<i class="fa fa-check edu-checked-pro admin-check-pro"
									aria-hidden="true"></i>
								<p>
									<strong>${alertMsg}</strong>
								</p>
							</div>
						</c:if>
						<h4>강좌수정</h4>
						<div class="asset-inner">
							<form
								action="${pageContext.request.contextPath}/loginCheck/modifyLecture"
								method="post">
								<table>
									<tr class="table-info">
										<th>강좌명</th>
										<td><input type="text" class="form-control"
											id="lectureName" name="lectureName"
											value="${lectureOne.lectureName}" readonly="readonly"></td>
									</tr>
									<tr class="table-info">
										<th>담당 강사</th>
										<td><input type="text" class="form-control"
											id="teacherName" name="teacherName"
											value="${lectureOne.teacherName}"></td>
									</tr>
									<tr class="table-info">
										<th>담당 매니저</th>
										<td><input type="text" class="form-control"
											id="managerName" name="managerName"
											value="${lectureOne.managerName}"></td>
									</tr>
									<tr class="table-info">
										<th>강의실</th>
										<td><input type="text" class="form-control"
											id="lectureRoomName" name="lectureRoomName"
											value="${lectureOne.lectureRoomName}"></td>
									</tr>
									<tr class="table-info">
										<th>최대수강생 수</th>
										<td><input type="text" class="form-control"
											id="lectureMaxStudent" name="lectureMaxStudent"
											value="${lectureOne.lectureMaxStudent}"></td>
									</tr>
									<tr class="table-info">
										<th>개강일</th>
										<td><input type="date" class="form-control"
											id="lectureStartDate" name="lectureStartDate"
											value="${lectureOne.lectureStartDate}"></td>
									</tr>
									<tr class="table-info">
										<th>종강일</th>
										<td><input type="date" class="form-control"
											id="lectureEndDate" name="lectureEndDate"
											value="${lectureOne.lectureEndDate}"></td>
									</tr>
									<tr class="table-info">
										<th>lectureActive</th>
										<td><select id="lectureActive" name="lectureActive"
											class="form-control">
												<option value='${lectureOne.lectureActive}' selected>${lectureOne.lectureActive}</option>
												<c:if test="${lectureOne.lectureActive ne '개설대기'}">
													<option value='개설대기'>개설대기</option>
												</c:if>
												<c:if test="${lectureOne.lectureActive ne '개설승인'}">
													<option value='개설승인'>개설승인</option>
												</c:if>
										</select></td>
									</tr>
									<tr class="table-info">
										<th>lectureState</th>
										<td><select id="lectureState" name="lectureState"
											class="form-control">
												<option value='${lectureOne.lectureState}' selected>${lectureOne.lectureState}</option>
												<c:if test="${lectureOne.lectureState ne '대기'}">
													<option value='대기'>대기</option>
												</c:if>
												<c:if test="${lectureOne.lectureState ne '수강'}">
													<option value='수강'>수강</option>
												</c:if>
												<c:if test="${lectureOne.lectureState ne '수료'}">
													<option value='수료'>수료</option>
												</c:if>
										</select></td>
									</tr>
									<tr class="table-info">
										<th>updateDate</th>
										<td>${lectureOne.updateDate}</td>
									</tr>
									<tr class="table-info">
										<th>createDate</th>
										<th style="font-weight: normal;">${lectureOne.createDate}</th>
									</tr>
								</table>
								<div class="btn-custom-groups-one btn-mg-b-10"
									style="float: right; margin: 10px 10px 10px 0">
									<button type="button" onclick="location.href='${pageContext.request.contextPath}/loginCheck/lecture'" class="btn btn-custon-rounded-four btn-primary">목록</button>
									<button type="submit" class="btn btn-custon-rounded-four btn-danger">수정하기</button>
								</div>
							</form>
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
	<script
		src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/jquery-price-slider.js"></script>
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
	<script
		src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
	<!-- counterup JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/counterup/jquery.counterup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/counterup/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/counterup/counterup-active.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/metisMenu/metisMenu.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/morrisjs/raphael-min.js"></script>
	<script src="${pageContext.request.contextPath}/js/morrisjs/morris.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/morrisjs/morris-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/sparkline/jquery.charts-sparkline.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/sparkline/sparkline-active.js"></script>
	<!-- calendar JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/calendar/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/calendar/fullcalendar.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/calendar/fullcalendar-active.js"></script>
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