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
<style>
.myth {
	width: 250px;
	text-align: right;
}
</style>
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
										<li><a href="${pageContext.request.contextPath}/loginCheck/index">Home</a> <span class="bread-slash">/</span></li>
										<li><a href="#">??????</a> <span class="bread-slash">/</span></li>
										<li><a href="${pageContext.request.contextPath}/loginCheck/exam">??????</a> <span class="bread-slash">/</span></li>
										<li><a href="${pageContext.request.contextPath}/loginCheck/questionBank">????????????</a> <span class="bread-slash">/</span></li>
										<li><a href="#">????????????</a> <span class="bread-slash">/</span></li>
										<li><a href="#">
												<span class="bread-blod" style="font-weight: bold;">????????? ?????? ??????</span>
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
						<!-- ?????? ????????? ??????????????? ???????????? ??? -->
						<c:if test="${alertMsg eq 'Success'}">
							<div class="alert alert-success alert-success-style1">
								<button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
									<span class="icon-sc-cl" aria-hidden="true">&times;</span>
								</button>
								<i class="fa fa-check edu-checked-pro admin-check-pro" aria-hidden="true"></i>
								<p>
									<strong>Success!</strong> ?????? ????????? ?????????????????????.
								</p>
							</div>
						</c:if>
						<!-- ?????? ????????? ???????????? ??? -->
						<c:if test="${alertMsg eq 'Fail'}">
							<div class="alert alert-danger alert-mg-b alert-success-style4">
								<button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
									<span class="icon-sc-cl" aria-hidden="true">&times;</span>
								</button>
								<i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
								<p>
									<strong>Fail!</strong> ?????? ????????? ?????????????????????.
								</p>
							</div>
						</c:if>
						<h4>????????? ?????? ????????????</h4>
						<!-- ?????? ?????? ?????? -->
						<div class="asset-inner">
							<form method="post" action="${pageContext.request.contextPath}/loginCheck/modifyShortAnswerQuestion">
								<table>
									<tr>
										<th style="width: 250px; text-align: right;">questionNo&nbsp;&nbsp;&nbsp;</th>
										<td>${shortAnswerQuestion.questionNo}</td>
									</tr>
									<tr>
										<th style="width: 250px; text-align: right;">subjectName&nbsp;&nbsp;&nbsp;</th>
										<td>${shortAnswerQuestion.subjectName}</td>
									</tr>
									<tr>
										<th style="width: 250px; text-align: right;">questionTitle&nbsp;&nbsp;&nbsp;</th>
										<td>
											<input type="hidden" class="form-control" id="questionNo" name="questionNo" value="${shortAnswerQuestion.questionNo}"> 
											<input type="text" class="form-control" id="questionTitle" name="questionTitle" value="${shortAnswerQuestion.questionTitle}">
										</td>
									</tr>
									<tr>
										<th style="width: 250px; text-align: right;">questionAnswer&nbsp;&nbsp;&nbsp;</th>
										<td><input type="text" class="form-control" id="questionAnswer" name="questionAnswer" value="${shortAnswerQuestion.questionAnswer}"></td>
									</tr>
									<tr>
										<th style="width: 250px; text-align: right;">updateDate&nbsp;&nbsp;&nbsp;</th>
										<td>${shortAnswerQuestion.updateDate}</td>
									</tr>
									<tr>
										<th style="width: 250px; text-align: right;">createDate&nbsp;&nbsp;&nbsp;</th>
										<td>${shortAnswerQuestion.createDate}</td>
									</tr>
									<tr>
										<th style="width: 250px; text-align: right;">Setting&nbsp;&nbsp;&nbsp;</th>
										<th>
											<button class="btn btn-custon-rounded-three btn-success" type="submit">
												<i class="fa fa-pencil-square-o" aria-hidden="true"></i>????????????
											</button> 
											<a href="${pageContext.request.contextPath}/loginCheck/removeShortAnswerQuestion?questionNo=${shortAnswerQuestion.questionNo}" onclick="return confirm('????????? ?????????????????????????');">
												<button class="btn btn-custon-rounded-three btn-danger">
													<i class="fa fa-trash-o" aria-hidden="true"></i>????????????
												</button>
											</a>
										</th>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ????????? ?????? ?????? ??? -->
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