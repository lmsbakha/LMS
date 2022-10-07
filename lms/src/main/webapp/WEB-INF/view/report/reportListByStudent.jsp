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
										<li><span class="bread-blod" style="font-weight: bold;">과제</span></li>
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
				action="${pageContext.request.contextPath}/loginCheck/reportList"
				id="reportListForm" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"
						style="padding: 1%;">
						<div class="product-status-wrap drp-lst" style="padding: 2%;">
							<h4>ReportList</h4>
							<hr>
							<div class="asset-inner">
								<table>
									<tr>
										<th>reportNo</th>
										<th>subjectName</th>
										<th>reportTitle</th>
										<th>reportStartDate</th>
										<th>reportEndDate</th>
										<th style="width: 150px">report</th>
									</tr>
									<c:if test="${empty reportListByStudent}">
										<tr>
											<td colspan="7" style="text-align: center;">과제가
												없습니다.</td>
										</tr>
									</c:if>
									<c:if test="${not empty reportListByStudent}">
										<c:forEach var="reportList" items="${reportListByStudent}">
											<tr>
												<td>${reportList.reportNo}</td>
												<td>${reportList.subjectName}</td>
												<td style="width: 350px;">
													<div class="menu">
														<a>${reportList.reportTitle}</a>
														<div>
															<textarea name="reportContent" id="reportContent"
																style="width: 300px; height: 100px; border-color: white;"
																readonly>
															 ${reportList.reportContent}</textarea>
														</div>
													</div>
												</td>
												<td>${reportList.reportStartDate}</td>
												<td>${reportList.reportEndDate}</td>
												<c:if test="${reportList.state eq 0 }">
													<td><a
														href="${pageContext.request.contextPath}/loginCheck/addReportSubmit?reportNo=${reportList.reportNo}&subjectName=${reportList.subjectName}">
															<button data-toggle="tooltip" title="submit"
																class="pd-setting-ed" type="button">
																<i class="fa fa-pencil-square-o" aria-hidden="true">과제제출</i>
															</button>
													</a></td>
												</c:if>
												<c:if test="${reportList.state eq 1 }">
													<td><button data-toggle="tooltip" title="complete"
															class="pd-setting-ed" type="button">제출완료</button></td>
												</c:if>

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
<script>
	    // html dom 이 다 로딩된 후 실행된다.    
	$(document).ready(function() {
		// menu 클래스 바로 하위에 있는 a 태그를 클릭했을때       
		$(".menu>a").click(function() {
			var submenu = $(this).next("div");
			// submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 부드럽게 펼치기           
			if (submenu.is(":visible")) {
				submenu.slideUp();
			} else {
				submenu.slideDown();
			}
		});
	});
</script>
</html>