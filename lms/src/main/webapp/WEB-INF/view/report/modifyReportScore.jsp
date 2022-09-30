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
										<li><a href="#">과제</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">제출리스트</span></li>
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
				action="${pageContext.request.contextPath}/loginCheck/modifyReportScore"
				id="modifyReportScoreForm" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-status-wrap drp-lst" style="padding: 2%;">
							<h4>Report SubmitList</h4>
							<hr>
							<div class="asset-inner">
								<table>
									<tr style="text-align: center;">
										<th>reportSubmitNo</th>
										<th>subjectName</th>
										<th>reportTitle</th>
										<th>createDate</th>
										<th>accuontId</th>
										<th>reportSubmitScore</th>
										<th>modify</th>
									</tr>
									<form
										action="${pageContext.request.contextPath}/loginCheck/modifyReportScore?
											reportSubmitNo=${modifyScoreForm.reportSubmitNo}&reportSubmitScore=${modifyScoreForm.reportSubmitScore}"
										method="post">
										<tr style="text-align: center;">
											<td><input type="text" style="border: none;"  name="reportSubmitNo"
												value="${modifyScoreForm.reportSubmitNo}">
												<input type="hidden" style="border: none;"  name="reportNo"
												value="${modifyScoreForm.reportNo}">
												</td>
											<td>${modifyScoreForm.subjectName}</td>
											<td><a
												href="${pageContext.request.contextPath}/loginCheck/reportSubmitOne?reportSubmitNo=${modifyScoreForm.reportSubmitNo}">
													${modifyScoreForm.reportSubmitTitle} </a></td>
											<td>${modifyScoreForm.createDate}</td>
											<td>${modifyScoreForm.accountId}</td>
											<td><select style="width: 200px;"
												class="form-control custom-select-value"
												name="reportSubmitScore" id="reportSubmitScore"
												required="required">
													<option value="defalut">::::점수::::</option>
													<option value="A">A</option>
													<option value="B">B</option>
													<option value="C">C</option>
													<option value="D">D</option>
													<option value="F">F</option>
											</select></td>
											<td>
												<button data-toggle="tooltip" title="Edit"
													class="pd-setting-ed" type="button" id="modifyScoreBtn">
													<i class="fa fa-pencil-square-o" aria-hidden="true">점수
														수정</i>
												</button>
											</td>
										</tr>
									</form>
								</table>
							</div>
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

	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

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
	<!-- data table JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/data-table/bootstrap-table.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/tableExport.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/data-table-active.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/bootstrap-table-editable.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/bootstrap-editable.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/bootstrap-table-resizable.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/colResizable-1.5.source.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/data-table/bootstrap-table-export.js"></script>
	<!--  editable JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/editable/jquery.mockjax.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/editable/mock-active.js"></script>
	<script src="${pageContext.request.contextPath}/js/editable/select2.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/editable/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/editable/bootstrap-datetimepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/editable/bootstrap-editable.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/editable/xediable-active.js"></script>
	<!-- Chart JS
		============================================ -->
	<script
		src="${pageContext.request.contextPath}/js/chart/jquery.peity.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/peity/peity-active.js"></script>
	<!-- tab JS
		============================================ -->
	<script src="${pageContext.request.contextPath}/js/tab.js"></script>
</body>
<script>
	$('#modifyScoreBtn').click(function() {
		if ($('#reportSubmitScore').val() == 'defalut') {
			alert('reportSubmitScore를 입력해주세요.');
			$('#reportSubmitScore').focus();
		} else {
			alert('점수를 수정하시겠습니까?');
			$('#modifyReportScoreForm').submit();
		}
	});
</script>
</html>