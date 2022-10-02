v<%@ page language="java" contentType="text/html; charset=UTF-8"
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
											href="#">과제</a>
											<span class="bread-slash">/</span></li>
										<li><a
											href="#">제출</a>
											<span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">수정하기</span></li>
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
			<form
				action="${pageContext.request.contextPath}/loginCheck/modifyReportSubmit"
				id="modifyReportSubmitForm" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-status-wrap drp-lst" style="padding: 2%;">
							<h4>Modify ReportSubmit</h4>
							<hr>
							<div class="form-group">
								<label for="reportSubmitNo">reportSubmitNo</label> <input
									name="reportSubmitNo" class="form-control" type="text"
									value="${reportSubmitOne.reportSubmitNo}" readonly>
							</div>
							<div class="form-group">
								<label for="reportNo">reportNo</label> <input name="reportNo"
									id="reportNo" type="text" class="form-control"
									value="${reportSubmitOne.reportNo}" readonly>
							</div>
							<div class="form-group">
								<label for="reportSubmitTitle">reportSubmitTitle</label> <input
									name="reportSubmitTitle" id="reportSubmitTitle" type="text"
									class="form-control" 
									value="${reportSubmitOne.reportSubmitTitle}" required="required">
							</div>
							<div class="form-group edit-ta-resize res-mg-t-15">
								<label for="reportSubmitContent">reportSubmitContent</label>
								<textarea name="reportSubmitContent" id="reportSubmitContent" required="required">${reportSubmitOne.reportSubmitContent}</textarea>
							</div>
							<div class="form-group alert-up-pd">
								<div class="dz-message needsclick download-custom">
									<i class="fa fa-download edudropnone" aria-hidden="true"></i> <input
										name="reportSubmitFilename" id="filename" class="form-control"
										type="file" multiple="multiple" accept=".zip">
										<span>* zip 파일만 업로드 해주세요.</span>
										<input
									name="reportSubmitNo" id="reportSubmitNo" type="hidden"
									class="form-control" 
									value="${reportSubmitOne.reportSubmitNo}">
									<input
									name="reportSubmitOriginName" id="reportSubmitOriginName" type="hidden"
									class="form-control" 
									value="${reportSubmitOne.reportSubmitFilename}">
								</div>
							</div>
						</div>
						<div class="payment-adress">
							<button type="button" id="modifyReportSubmitBtn"
								class="btn btn-success"
								style="float: right; margin-top: 3%; margin-right: 3%;">submit</button>
						</div>
					</div>

				</div>
			</form>
			<!-- </form> -->
		</div>
	</div>
	<!-- Start footer -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- End footer -->

	<!-- Start script -->
	<jsp:include page="../js/alljs.jsp" />
	<!-- End script -->
</body>
<script>
	$('#modifyReportSubmitBtn').click(function() {
		if ($('#reportSubmitTitle').val() == '') {
			alert('reportSubmitTitle를 입력해주세요.');
			$('#reporSubmittTitle').focus();
		} else if ($('#reportSubmitContent').val() == '') {
			alert('reportSubmitContent를 입력해주세요.');
			$('#reportContent').focus();
		}else if ($('#filename').val() == '') {
			alert('파일을 업로드해주세요.');
			$('#filename').focus();
		} else {
			alert('과제를 수정하시겠습니까?');
			$('#modifyReportSubmitForm').submit();
		}
	});
</script>
</html>