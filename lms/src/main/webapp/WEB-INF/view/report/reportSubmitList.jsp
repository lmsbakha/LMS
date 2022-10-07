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
				action="${pageContext.request.contextPath}/loginCheck/reportSubmitList"
				id="reportListForm" method="post">
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
										<th>delete</th>
									</tr>
									<c:if test="${empty reportSubmitList}">
										<tr>
											<td colspan="7" style="text-align: center;">제출한 과제가
												없습니다.</td>
										</tr>
									</c:if>
									<c:if test="${not empty reportSubmitList}">
										<c:forEach var="reportSubmitList" items="${reportSubmitList}">
											<tr style="text-align: center;">
												<td>${reportSubmitList.reportSubmitNo}</td>
												<td>${reportSubmitList.subjectName}</td>
												<td><a
													href="${pageContext.request.contextPath}/loginCheck/reportSubmitOne?reportSubmitNo=${reportSubmitList.reportSubmitNo}">
														${reportSubmitList.reportSubmitTitle} </a></td>
												<td>${reportSubmitList.createDate}</td>
												<td>${reportSubmitList.accountId}</td>
												<td>${reportSubmitList.reportSubmitScore}</td>
												<td><a
													href="${pageContext.request.contextPath}/loginCheck/modifyReportScore?reportSubmitNo=${reportSubmitList.reportSubmitNo}&reportNo=${reportSubmitList.reportNo}">
														<button data-toggle="tooltip" title="Edit"
															class="pd-setting-ed" type="button">
															<i class="fa fa-pencil-square-o" aria-hidden="true">점수
																수정하기</i>
														</button>
												</a></td>
												<td><a
													href="${pageContext.request.contextPath}/loginCheck/removeReportSubmit?reportSubmitNo=${reportSubmitList.reportSubmitNo}">
														<button data-toggle="tooltip" title="Trash"
															class="pd-setting-ed" type="button"
															id="deleteSubmitReportBtn">
															<i class="fa fa-trash-o" aria-hidden="true">삭제하기</i>
														</button>
												</a></td>
											</tr>
										</c:forEach>
									</c:if>
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

	<!-- Start script -->
	<jsp:include page="../js/alljs.jsp" />
	<!-- End script -->
</body>
</html>