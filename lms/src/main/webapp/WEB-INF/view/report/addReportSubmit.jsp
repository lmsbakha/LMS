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
										<li><a href="$#">과제</a> <span class="bread-slash">/</span></li>
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
							<form method="post" enctype="multipart/form-data"
								action="${pageContext.request.contextPath}/loginCheck/addReportSubmit"
								id="addreportSubmitForm">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
										style="padding: 2%;">
										<h4>Add ReportSubmit</h4>
										<hr>
										<div class="form-group">
											<label for="subjectName">subjectName</label> <input
												name="subjectName" id="subjectName" type="text"
												class="form-control" value="${subjectName}" readonly>
											<input type="hidden" name="reportNo" value="${reportNo}">
											<input type="hidden" name="educationNo"
												value="${educationInfoById.educationNo}"> <input
												type="hidden" name="accountId"
												value="${educationInfoById.accountId}">

										</div>
										<div class="form-group">
											<label for="reportSubmitTitle">reportSubmitTitle</label> <input
												type="text" class="form-control" required="required"
												id="reportSubmitTitle" name="reportSubmitTitle">
										</div>
										<div class="form-group edit-ta-resize res-mg-t-15">
											<label for="reportSubmitContent">reportSubmitContent</label>
											<textarea name="reportSubmitContent" required="required"
												id="reportSubmitContent" name="reportSubmitContent"></textarea>
										</div>
										<div class="form-group alert-up-pd">
											<div class="dz-message needsclick download-custom">
												<i class="fa fa-download edudropnone" aria-hidden="true"></i>
												<input name="reportSubmitFile" id="filename"
													class="form-control" type="file" multiple="multiple"
													required="required" accept=".txt,.zip"> <span>*
													zip 파일만 업로드 해주세요.</span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<div class="payment-adress">
											<button type="button" id="addReportSubmitBtn"
												class="btn btn-success"
												style="float: right; margin-top: 3%; margin-right: 3%;">Submit</button>
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

	<!-- Start script -->
	<jsp:include page="../js/alljs.jsp" />
	<!-- End script -->
</body>
<script>
	$('#addReportSubmitBtn').click(function() {
		if ($('#reportSubmitTitle').val() == '') {
			alert('reportSubmitTitle를 입력해주세요.');
			$('#reportTitle').focus();
		} else if ($('#reportContent').val() == '') {
			alert('reportSubmitContent를 입력해주세요.');
			$('#reportSubmitContent').focus();
		} else if ($('#filename').val() == '') {
			alert('파일을 업로드해주세요.');
			$('#filename').focus();
		} else if ($('#filename').val() == '') {
			alert('파일을 업로드해주세요.');
			$('#filename').focus();
		} else {
			alert('과제를 제출하시겠습니까?');
			$('#addreportSubmitForm').submit();
		}
	});
</script>
</html>