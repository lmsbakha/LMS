<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Departments | Kiaalap - Kiaalap Admin Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon
      ============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
      ============================================ -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
<!-- Bootstrap CSS
      ============================================ -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap CSS
      ============================================ -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- owl.carousel CSS
      ============================================ -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.transitions.css">
<!-- animate CSS
      ============================================ -->
<link rel="stylesheet" href="css/animate.css">
<!-- normalize CSS
      ============================================ -->
<link rel="stylesheet" href="css/normalize.css">
<!-- meanmenu icon CSS
      ============================================ -->
<link rel="stylesheet" href="css/meanmenu.min.css">
<!-- main CSS
      ============================================ -->
<link rel="stylesheet" href="css/main.css">
<!-- educate icon CSS
      ============================================ -->
<link rel="stylesheet" href="css/educate-custon-icon.css">
<!-- morrisjs CSS
      ============================================ -->
<link rel="stylesheet" href="css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
      ============================================ -->
<link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
      ============================================ -->
<link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
<link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
<!-- calendar CSS
      ============================================ -->
<link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
<link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
<!-- style CSS
      ============================================ -->
<link rel="stylesheet" href="style.css">
<!-- responsive CSS
      ============================================ -->
<link rel="stylesheet" href="css/responsive.css">
<!-- modernizr JS
      ============================================ -->
<script src="js/vendor/modernizr-2.8.3.min.js"></script>

</head>
<body>
	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

	<!-- Start sidebar -->
	<jsp:include page="inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="inc/topbar.jsp" />
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
										<li><a href="#">강의</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">시험</span></li>
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
					<div class="sparkline12-list">
						<div class="sparkline12-hd">
							<div class="main-sparkline12-hd">
								<h1>시험 출제하기</h1><hr>
							</div>
						</div>
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="all-form-element-inner">
											<form action="${pageContext.request.contextPath}/addExam">
											<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">강사명</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" value="${sessionId }" readonly="readonly" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험을 출제할 강의를 선택하세요</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<div class="form-select-list">
																<select class="form-control custom-select-value" name="lectureListByTeacher" id="lectureListByTeacher" required="required">
																	<option value="defalut">-----강의선택-----</option>
																	<c:forEach var="l" items="${lectureListByTeacher}">
																		<option value="${l.lectureName }">${l.lectureName }</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험명을 작성하세요 (예시: 중간고사, 월말평가...)</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" name="examTitle" id="examTitle" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험명을 작성하세요 (예시: 중간고사, 월말평가...)</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" name="examTitle" id="examTitle" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">해당 시험에 대한 설명을 입력해주세요</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" name="examContent" id="examContent" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">해당 시험의 총 문제 수를 선택하세요</label>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="number" class="form-control" name="examTotalCnt" id="examTotalCnt" min="1" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험 응시 시작일</label>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="date"  class="form-control" name="examStartDate" ID="examStartDate" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험 응시 마감일</label>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="date" class="form-control" id="examEndDate" name="examEndDate"  required="required" />
														</div>
													</div>
												</div>

											</form>
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
	<!-- Start tobbar -->
	<jsp:include page="inc/footer.jsp" />
	<!-- End tobbar -->

	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

	<!-- jquery
      ============================================ -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
      ============================================ -->
	<script src="js/bootstrap.min.js"></script>
	<!-- wow JS
      ============================================ -->
	<script src="js/wow.min.js"></script>
	<!-- price-slider JS
      ============================================ -->
	<script src="js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
      ============================================ -->
	<script src="js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
      ============================================ -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- sticky JS
      ============================================ -->
	<script src="js/jquery.sticky.js"></script>
	<!-- scrollUp JS
      ============================================ -->
	<script src="js/jquery.scrollUp.min.js"></script>
	<!-- mCustomScrollbar JS
      ============================================ -->
	<script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
      ============================================ -->
	<script src="js/metisMenu/metisMenu.min.js"></script>
	<script src="js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
      ============================================ -->
	<script src="js/sparkline/jquery.sparkline.min.js"></script>
	<script src="js/sparkline/jquery.charts-sparkline.js"></script>
	<!-- calendar JS
      ============================================ -->
	<script src="js/calendar/moment.min.js"></script>
	<script src="js/calendar/fullcalendar.min.js"></script>
	<script src="js/calendar/fullcalendar-active.js"></script>
	<!-- plugins JS
      ============================================ -->
	<script src="js/plugins.js"></script>
	<!-- main JS
      ============================================ -->
	<script src="js/main.js"></script>
	<!-- tawk chat JS
      ============================================ -->
	<script src="js/tawk-chat.js"></script>
</body>
</html>