<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Dashboard V.1 | Kiaalap - Kiaalap Admin Template</title>
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
	<jsp:include page="inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start topbar -->
	<jsp:include page="inc/topbar.jsp" />
	<!-- End topbar -->

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
										<li><span class="bread-blod" style="font-weight: bold;">시험 출제</span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Single pro tab review Start-->
	<div class="single-pro-review-area mt-t-30 mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-payment-inner-st">
						<ul id="myTabedu1" class="tab-review-design">
							<li class="active"><a href="#multiplechoice">객관식 문제</a></li>
							<li><a href="#shortAnswer">단답형 문제</a></li>
						</ul>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in" id="multiplechoice">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="devit-card-custom">
														<!-- 과목선택 -->
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">시험을 출제할 과목을 선택하세요</label>
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<div class="form-select-list">
																		<select class="form-control custom-select-value" name="subjectName" id="subjectName">
																			<option value="defalut">-----과목선택-----</option>
																			<option value="saab">Saab</option>
																			<option value="opel">Opel</option>
																			<option value="audi">Audi</option>
																		</select>
																	</div>
																</div>
															</div>
														</div>
														<!-- 문제 지문 -->
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">문제를 입력하세요</label>
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<input type="text" class="form-control" id="multiplechoiceQuestion" name="multiplechoiceQuestion" placeholder="문제 지문" />
																</div>
															</div>
														</div>
														<!-- 보기 -->
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">보기 지문을 입력 후 정답에 체크해주세요</label>
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<div class="input-group">
																		<span class="input-group-addon">1번</span> 
																		<input type="text" class="form-control"> 
																		<span class="input-group-addon"> <input type="checkbox"> </span>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<div class="input-group">
																		<span class="input-group-addon">2번</span> 
																		<input type="text" class="form-control"> 
																		<span class="input-group-addon"> <input type="checkbox"> </span>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<div class="input-group">
																		<span class="input-group-addon">3번</span> 
																		<input type="text" class="form-control"> 
																		<span class="input-group-addon"> <input type="checkbox"> </span>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<div class="input-group">
																		<span class="input-group-addon">4번</span> 
																		<input type="text" class="form-control"> 
																		<span class="input-group-addon"> <input type="checkbox"> </span>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																</div>
																<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
																	<div class="input-group">
																		<span class="input-group-addon">5번</span> 
																		<input type="text" class="form-control"> 
																		<span class="input-group-addon"> <input type="checkbox"> </span>
																	</div>
																</div>
															</div>
														</div>
														<br>
														<!-- multiplechoice_question -->
														문제를 입력하세요.
														<div class="form-group">
															<input type="number" class="form-control" id="multiplechoice_question" name="multiplechoice_question" placeholder="문제를 입력하세요">
														</div>
														<!-- 보기 -->
														문제의 보기를 입력하세요.
														<div class="form-group">
															<input type="password" class="form-control" required="required" placeholder="1번 보기">
														</div>
														<div class="form-group">
															<input type="password" class="form-control" required="required" placeholder="2번 보기">
														</div>
														<div class="form-group">
															<input type="password" class="form-control" required="required" placeholder="3번 보기">
														</div>
														<div class="form-group">
															<input type="password" class="form-control" required="required" placeholder="4번 보기">
														</div>
														<div class="form-group">
															<input type="password" class="form-control" required="required" placeholder="5번 보기">
														</div>
														<!--/보기  -->
														<div class="form-group">
															<input type="password" class="form-control" placeholder="Password">
														</div>
														<div class="form-group">
															<input type="password" class="form-control" placeholder="Confirm Password">
														</div>
														<a href="#!" class="btn btn-primary waves-effect waves-light">Submit</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="product-tab-list tab-pane fade" id="shortAnswer">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div class="row">
												<div class="col-lg-12">
													<div class="devit-card-custom">
														<div class="form-group">
															<input type="url" class="form-control" placeholder="Facebook URL">
														</div>
														<div class="form-group">
															<input type="url" class="form-control" placeholder="Twitter URL">
														</div>
														<div class="form-group">
															<input type="url" class="form-control" placeholder="Google Plus">
														</div>
														<div class="form-group">
															<input type="url" class="form-control" placeholder="Linkedin URL">
														</div>
														<button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
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
		</div>
	</div>
	<!-- /Main Contents -->

	<!-- Start footer -->
	<jsp:include page="inc/footer.jsp" />
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