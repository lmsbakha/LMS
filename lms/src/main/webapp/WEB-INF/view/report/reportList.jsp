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
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
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
<link rel="stylesheet"
	href="css/scrollbar/jquery.mCustomScrollbar.min.css">
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
	<jsp:include page="${pageContext.request.contextPath}/inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="${pageContext.request.contextPath}/inc/topbar.jsp" />
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
			<form action="${pageContext.request.contextPath}/loginCheck/reportList"
				id="reportListForm" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="product-status-wrap drp-lst">
							<h4>Report List</h4>
							<hr>
							<div class="add-product">
								<a href="${pageContext.request.contextPath}/loginCheck/addReport">과제 추가</a>
							</div>
							<div class="asset-inner">
								<table>
									<tr>
										<th>reportNo</th>
										<th>subjectName</th>
										<th>reportTitle</th>
										<th>createDate</th>
										<th>Setting</th>
									</tr>

									<c:forEach var="report" items="${reportList}">
										<tr>
											<td>${report.reportNo}</td>
											<td>${report.subjectName}</td>
											<td>
												<div class="menu">
													<a>${report.reportTitle}</a>
													<div>
														<textarea name="reportContent" id="reportContent"
															style="width: 300px; border-color: white;" readonly>
															 ${report.reportContent}</textarea>
													</div>
												</div>
											</td>
											<td>${report.createDate}</td>
											<td><a
												href="${pageContext.request.contextPath}/loginCheck/modifyReport?reportNo=${report.reportNo}">
													<button data-toggle="tooltip" title="Edit"
														class="pd-setting-ed" type="button">
														<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													</button>
											</a> <a
												href="${pageContext.request.contextPath}/loginCheck/removeReport?reportNo=${report.reportNo}">
													<button data-toggle="tooltip" title="Trash"
														class="pd-setting-ed" type="button">
														<i class="fa fa-trash-o" aria-hidden="true"></i>
													</button>
											</a></td>
										</tr>
									</c:forEach>
								</table>
							</div>
							<div>
								<c:if test="${currentPage > 1}">
									<a
										href="${pageContext.request.contextPath}/loginCheck/reportList?currentPage=${currentPage-1}">이전</a>
								</c:if>
								<c:if test="${currentPage < lastPage}">
									<a
										href="${pageContext.request.contextPath}/loginCheck/reportList?currentPage=${currentPage+1}">다음</a>
								</c:if>
							</div>
							<div class="custom-pagination">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item"><a class="page-link" href="">Previous</a></li>
										<!-- <li class="page-item"><a class="page-link" href="#">3</a></li> -->

										<li class="page-item"><a class="page-link" href="">Next</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</form>
			<!-- </form> -->
		</div>
	</div>
	<!-- Start footer -->
	<jsp:include page="${pageContext.request.contextPath}/inc/footer.jsp" />
	<!-- End footer -->

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
<script>
	    // html dom 이 다 로딩된 후 실행된다.    
	$(document).ready(function() {
		// menu 클래스 바로 하위에 있는 a 태그를 클릭했을때       
		$(".menu>a").click(function() {
			var submenu = $(this).next("div");
			// submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기           
			if (submenu.is(":visible")) {
				submenu.slideUp();
			} else {
				submenu.slideDown();
			}
		});
	});
</script>
</html>