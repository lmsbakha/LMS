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
										<li><a href="#">강의</a> <span class="bread-slash">/</span></li>
										<li><a href="${pageContext.request.contextPath}/loginCheck/exam">시험</a> <span class="bread-slash">/</span></li>
										<li><a href="#">
												<span class="bread-blod" style="font-weight: bold;">시험 상세보기</span>
											</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Basic Form Start -->
	<div class="basic-form-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="sparkline12-list">
						<div class="sparkline12-hd">
							<div class="main-sparkline12-hd">
								<h1>시험 응시</h1>
								<hr>
								이름 : <input type="text" value="${studentInfo.studentName }" readonly="readonly">
								educationNo : <input type="text" value="${studentInfo.educationNo}" readonly="readonly" />
								examNo : <input type="text" value="${param.examNo}" readonly="readonly" />
								<hr>
							</div>
						</div>
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="all-form-element-inner">
											<!-- 시험 전송 -->
											<form action="${pageContext.request.contextPath}/loginCheck/submitExam" method="post">
											<input type="hidden" value="${param.examNo}" id="examNo" name="examNo" readonly="readonly" />
											<input type="hidden" class="form-control" value="${studentInfo.educationNo}" id="educationNo" name="educationNo" readonly="readonly" />
												<c:forEach var="one" items="${examOne}">
													<!-- 객관식 유형일 경우 -->
													<c:if test="${one.questionType eq '객관식'}">
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">문제${one.examQuestionNo}.</label>
																	<label class="login2 pull-right pull-right-pro">${one.examQuestionIndex} <-- index</label>
																	<input type="hidden" value="${one.examQuestionIndex}" id="examQuestionIndex" name="examQuestionIndex">
																	<input type="hidden" value="객관식" id="questionType" name="questionType">
																</div>
																<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
																	<input type="text" class="form-control" value="${one.questionTitle}" readonly="readonly" />
																</div>
															</div>
															<!-- 객관식 보기 -->
															<c:forEach var="example" items="${one.multiplechoiceExampleList}">
																<div class="row">
																	<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
																		<div class="i-checks pull-right">
																			<label style="margin-top: 5px">
																			<input type="radio" value="${example.multiplechoiceExampleId}" id="examAnswerContent${one.examQuestionIndex}" name="examAnswerContent${one.examQuestionIndex}"> <i></i> (${example.multiplechoiceExampleId})
																			</label>
																		</div>
																	</div>
																	<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
																		<div class="bt-df-checkbox pull-left">
																			<div class="row">
																				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
																					<div class="i-checks pull-left">
																						<label> <i></i> ${example.multiplechoiceExampleContent}
																						</label>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</c:forEach>
														</div>
													</c:if>

													<!-- 문제 유형이 단답형일 경우 -->
													<c:if test="${one.questionType eq '단답형'}">
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">문제${one.examQuestionNo}.</label>
																	<label class="login2 pull-right pull-right-pro">${one.examQuestionIndex} <-- index</label>
																	<input type="hidden" value="${one.examQuestionIndex}" id="examQuestionIndex" name="examQuestionIndex">
																	<input type="hidden" value="단답형" id="questionType" name="questionType">
																</div>
																<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
																	<input type="text" class="form-control" value="${one.questionTitle}" readonly="readonly" />
																</div>
															</div>
															<div class="row">
																<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">정답 :</label>
																</div>
																<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
																	<input type="text" class="form-control" id="examAnswerContent${one.examQuestionIndex}" name="examAnswerContent${one.examQuestionIndex}" placeholder="정답을 입력해주세요" />
																</div>
															</div>
														</div>
													</c:if>
												</c:forEach>
												<div class="form-group-inner">
													<div class="login-btn-inner">
														<div class="row">
															<div class="col-lg-12">
																<div class="login-horizental cancel-wp pull-right form-bc-ele">
																	<button class="btn btn-white" type="reset">취소</button>
																	<button class="btn btn-sm btn-primary login-submit-cs" type="submit">시험종료</button>
																</div>
															</div>
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


	<!-- Start footer -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- End footer -->


	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- jquery ============================================ -->
	<script src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS ============================================ -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- wow JS ============================================ -->
	<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
	<!-- price-slider JS ============================================ -->
	<script src="${pageContext.request.contextPath}/js/jquery-price-slider.js"></script>
	<!-- meanmenu JS ============================================ -->
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