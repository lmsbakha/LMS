<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
										<li><a
											href="${pageContext.request.contextPath}/loginCheck/reportSubmitList">과제</a>
											<span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">제출</span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="myTabContent" class="tab-content custom-product-edit">
		<div class="product-tab-list tab-pane fade active in" id="description">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="review-content-section">
						<div id="dropzone1" class="pro-ad">
							<form
								action="${pageContext.request.contextPath}/loginCheck/addReportSubmit"
								class="dropzone dropzone-custom needsclick add-professors"
								id="addFileForm">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
										style="padding: 2%;">
										<h4>Report Submit</h4>
										<hr>
										<div class="form-group">
											<label for="subjectName">subjectName</label> <input
												name="subjectName" id="subjectName" type="text"
												class="form-control" value="${reportOne.subjectName}"
												readonly> <input type="hidden" name="reportNo"
												value="${reportOne.reportNo}">
											<!-- 
											<input type="hidden" name="educationNo">
											<input type="hidden" name="accountId">
											<input type="hidden" name="reportSubmitScore">
									 -->
										</div>
										<div class="form-group">
											<label for="reportSubmitTitle">reportSubmitTitle</label> <input
												type="text" class="form-control" id="reportSubmitTitle"
												name="reportSubmitTitle">
										</div>
										<div class="form-group edit-ta-resize res-mg-t-15">
											<label for="reportSubmitContent">reportSubmitContent</label>
											<textarea name="reportSubmitContent" id="reportSubmitContent"
												name="reportSubmitContent"></textarea>
										</div>
										<div style="width: 50px;">
										<label for="file"><b>ImgFile</b></label>
										<input type="file" name="file" id="file"
											class="form-control">
											</div>
										<div class="form-group alert-up-pd">
											<div class="dz-message needsclick download-custom">
												<i class="fa fa-download edudropnone" aria-hidden="true"></i>
												<h2 class="edudropnone">Drop file here or click to
													upload.</h2>
												<input name="file" id="file" class="hd-pro-img" type="file" />
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<div class="payment-adress">
											<!-- name="multiple" -> mutiple 여러개의 파일을 선택할 수 있다. -->
											<!-- button을 누르면 파일 입력창이 열려 파일을 선택할 수 있도록 -->
											<button type="button" id="addFile">Add</button>
											<!--  input type="file" -->
											<button type="button" id="removeFile">Delete</button>
											<div id="fileSection"></div>
											<button type="button" id="addBtn"
												style="float: right; margin-top: 3%; margin-left: 2%;"
												class="btn btn-primary waves-effect waves-light">Submit</button>
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
	<!-- dropzone JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/dropzone/dropzone.js"></script>
	<!-- tab JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/tab.js"></script>
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
<script>
	// $(function(){
	$(document)
			.ready(
					function() {
						$('#removeFile').click(function() {
							$('#fileSection').empty();
						});
						$('#addFile')
								.click(
										function() {
											// 공백을 알아보기 위한 변수 
											let isFileEmpty = false;

											let html = '<div><input type="file" name="multiList" class="multiList"></div>';
											$('.multiList')
													.each(
															function(index,
																	item) {
																// $(this) --> item
																if ($(item)
																		.val() == '') {
																	isFileEmpty = true;
																}
															});

											if (isFileEmpty == false) {
												$('#fileSection').append(html);
											}
										});

						$('#addBtn').click(function() {
							// 공백을 알아보기 위한 변수 
							let isFileEmpty = false;
							// ReportSubmit 유효성 검사 후

							$('.multiList').each(function(index, item) {
								// $(this) --> item
								if ($(item).val() == '') {
									isFileEmpty = true;
								}
							});
							if ($('#reportSubmitTitle').val() == '') {
								alert('reportSubmitTitle를 입력하세요');
							} else if (isFileEmpty == true) {
								alert('reportSubmitTitle를 입력하세요');
							} else if ($('#reportSubmitContent').val() == '') {
								alert('reportSubmitContent를 입력하세요');
							} else if (isFileEmpty == true) {
								alert('reportSubmitContent를 입력하세요');
							} else {
								$('#addFileForm').submit();
							}
						});
					});
</script>
</html>