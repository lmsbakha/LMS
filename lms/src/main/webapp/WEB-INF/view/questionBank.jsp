<!-- 문제은행 페이지 -->
<!-- 문제은행 페이지 -->
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
										<li><a href="${pageContext.request.contextPath}/exam">시험</a> <span class="bread-slash">/</span></li>
										<li><a href="${pageContext.request.contextPath}/questionBank">
												<span class="bread-blod" style="font-weight: bold;">문제은행</span>
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
	<div class="product-status mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-status-wrap drp-lst">
						<ul id="myTabedu1" class="tab-review-design">
							<li class="active"><a href="#multiplechoice">객관식 문제은행</a></li>
							<li><a href="#shortAnswer">단답형 문제은행</a></li>
						</ul>
						<div class="add-product">
							<a href="${pageContext.request.contextPath}/addQuestionInBank">문제추가</a>
						</div>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in" id="multiplechoice">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="asset-inner">
														<table class="table table-hover">
															<tr>
																<th>questionNo</th>
																<th>questionTitle</th>
																<th>subjectName</th>
																<th>updateDate</th>
																<th>createDate</th>
																<th>Setting</th>
															</tr>
															<c:forEach var="map" items="${multiplechoiceList}">
																<tr>
																	<td>${map.questionNo}</td>
																	<td>${map.questionTitle}</td>
																	<td>${map.subjectName}</td>
																	<td>${map.updateDate}</td>
																	<td>${map.createDate}</td>
																	<td><a href="${pageContext.request.contextPath}/multiplechoiceOne?questionNo=${map.questionNo}">
																			<button data-toggle="tooltip" title="상세보기" class="pd-setting-ed">
																				<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																			</button>
																		</a>
																		<button data-toggle="tooltip" title="삭제하기" class="pd-setting-ed" onclick="location.href='${pageContext.request.contextPath}/removeMultiplechoiceOne?questionNo=${map.questionNo}' ">
																			<i class="fa fa-trash-o" aria-hidden="true"></i>
																		</button></td>
																</tr>
															</c:forEach>
														</table>
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
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="asset-inner">
														<table class="table table-hover">
															<tr>
																<th>questionNo</th>
																<th>questionTitle</th>
																<th>subjectName</th>
																<th>updateDate</th>
																<th>createDate</th>
																<th>Setting</th>
															</tr>
															<c:forEach var="map" items="${examList}">
																<tr>
																	<td>${map.questionNo}</td>
																	<td>${map.questionTitle}</td>
																	<td>${map.subjectName}</td>
																	<td>${map.updateDate}</td>
																	<td>${map.createDate}</td>
																	<td>
																		<button data-toggle="tooltip" title="Edit" class="pd-setting-ed" onclick="location.href='${pageContext.request.contextPath}/editQuestion?questionNo=${map.questionNo}' ">
																			<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																		</button>
																		<button data-toggle="tooltip" title="Trash" class="pd-setting-ed" onclick="location.href='${pageContext.request.contextPath}/trashQuestion?questionNo=${map.questionNo}' ">
																			<i class="fa fa-trash-o" aria-hidden="true"></i>
																		</button>
																	</td>
																</tr>
															</c:forEach>
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