<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Data Table | Kiaalap - Kiaalap Admin Template</title>
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

	<!-- Start sidebar -->
	<jsp:include page="../inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="../inc/topbar.jsp" />
	<!-- End tobbar -->
	<div class="header-advance-area">
		<div class="breadcome-area">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="breadcome-list single-page-breadcome">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<ul class="breadcome-menu" style="float: left;">
										<li><a href="${pageContext.request.contextPath}/loginCheck/index">Home</a> <span class="bread-slash">/</span></li>
										<li><a href="#">강의관리</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">교재관리</span></li>
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
					<div class="product-status-wrap">
						<h4>교재관리</h4>
						<div class="add-product">
							<a href="#">교재추가</a>
						</div>
						<div class="asset-inner">
							<table>
								<tr>
									<th>No</th>
									<th>Image</th>
									<th>Name of Asset</th>
									<th>Status</th>
									<th>Subject</th>
									<th>Department</th>
									<th>Type</th>
									<th>Price</th>
									<th>Setting</th>
								</tr>
								<tr>
									<td>1</td>
									<td><img src="img/product/book-1.jpg" alt="" /></td>
									<td>Web Development Book</td>
									<td>
										<button class="pd-setting">Active</button>
									</td>
									<td>Html, Css</td>
									<td>CSE</td>
									<td>Book</td>
									<td>$1500</td>
									<td>
										<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
										<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td><img src="img/product/book-2.jpg" alt="" /></td>
									<td>Quality Bol pen</td>
									<td>
										<button class="ps-setting">Paused</button>
									</td>
									<td>PHP</td>
									<td>CSE</td>
									<td>CD</td>
									<td>$1700</td>
									<td>
										<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
										<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
								<tr>
									<td>3</td>
									<td><img src="img/product/book-3.jpg" alt="" /></td>
									<td>Box of pendrive</td>
									<td>
										<button class="ds-setting">Disabled</button>
									</td>
									<td>Java</td>
									<td>CSE</td>
									<td>Book</td>
									<td>$1500</td>
									<td>
										<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
										<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
								<tr>
									<td>4</td>
									<td><img src="img/product/book-4.jpg" alt="" /></td>
									<td>Quality Bol pen</td>
									<td>
										<button class="pd-setting">Active</button>
									</td>
									<td>PHP</td>
									<td>CSE</td>
									<td>CD</td>
									<td>$1200</td>
									<td>
										<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
										<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
								<tr>
									<td>5</td>
									<td><img src="img/product/book-1.jpg" alt="" /></td>
									<td>Web Development Book</td>
									<td>
										<button class="pd-setting">Active</button>
									</td>
									<td>Wordpress</td>
									<td>CSE</td>
									<td>Book</td>
									<td>$1800</td>
									<td>
										<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
										<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
								<tr>
									<td>6</td>
									<td><img src="img/product/book-2.jpg" alt="" /></td>
									<td>Quality Bol pen</td>
									<td>
										<button class="ps-setting">Paused</button>
									</td>
									<td>Java</td>
									<td>CSE</td>
									<td>CD</td>
									<td>$1000</td>
									<td>
										<button data-toggle="tooltip" title="Edit" class="pd-setting-ed">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
										</button>
										<button data-toggle="tooltip" title="Trash" class="pd-setting-ed">
											<i class="fa fa-trash-o" aria-hidden="true"></i>
										</button>
									</td>
								</tr>
							</table>
						</div>
						<div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-copyright-area">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<div class="footer-copy-right">
						<p>
							Copyright © 2018. All rights reserved. Template by
							<a href="https://colorlib.com/wp/templates/">Colorlib</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

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
	<script src="${pageContext.request.contextPath}/js/sparkline/jquery.sparkline.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/sparkline/jquery.charts-sparkline.js"></script>
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