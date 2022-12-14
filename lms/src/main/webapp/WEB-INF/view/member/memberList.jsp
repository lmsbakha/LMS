<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

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
<!-- x-editor CSS
		============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/select2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/datetimepicker.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/bootstrap-editable.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/x-editor-style.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/data-table/bootstrap-table.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/data-table/bootstrap-editable.css">
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
	<!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->

	<!-- Start sidebar -->
	<jsp:include page="../inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="../inc/topbar.jsp" />
	<!-- End tobbar -->
	<br>
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
										<li><a href="${pageContext.request.contextPath}/loginCheck/index">HOME</a> <span class="bread-slash">/</span></li>
										<li><a href="#">????????????</a> <span class="bread-slash">/</span></li>
										<c:if test="${memberCheck eq 'student'}">
											<li><span class="bread-blod" style="font-weight: bold;">????????????</span></li>
										</c:if>
										<c:if test="${memberCheck eq 'teacher'}">
											<li><span class="bread-blod" style="font-weight: bold;">????????????</span></li>
										</c:if>
										<c:if test="${memberCheck eq 'manager'}">
											<li><span class="bread-blod" style="font-weight: bold;">????????????</span></li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Static Table Start -->
	<div class="data-table-area mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="sparkline13-list">
						<div class="sparkline13-hd">
							<div class="main-sparkline13-hd">
								<c:if test="${memberCheck eq 'student'}">
									<h1>????????????</h1>
									<hr>
								</c:if>
								<c:if test="${memberCheck eq 'teacher'}">
									<h1>????????????</h1>
									<hr>
								</c:if>
								<c:if test="${memberCheck eq 'manager'}">
									<h1>????????????</h1>
									<hr>
								</c:if>
							</div>
						</div>
						<div class="sparkline13-graph">
							<div class="datatable-dashv1-list custom-datatable-overright">
								<table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true" data-cookie-id-table="saveId" data-click-to-select="true" data-toolbar="#toolbar">
									<thead>
										<tr>
											<th>?????????</th>
											<th>??????</th>
											<th>??????</th>
											<th>????????????</th>
											<th>????????????</th>
											<th>Setting</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${memberCheck eq 'student'}">
											<c:forEach var="s" items="${studentList}">
												<tr>
													<td>${s.accountId}</td>
													<td>${s.studentName}</td>
													<td>${s.studentGender}</td>
													<td>${s.studentBirth}</td>
													<td>${s.createDate}</td>
													<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${s.accountId}">
														<button class="btn btn-sm btn-custon-rounded-foue btn-primary">
															<i class="fa fa-info-circle edu-informatio" aria-hidden="true"></i> ????????????
														</button>
													</a></td>
													
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${memberCheck eq 'teacher'}">
											<c:forEach var="t" items="${teacherList}">
												<tr>
													<td>${t.accountId}</td>
													<td>${t.teacherName}</td>
													<td>${t.teacherGender}</td>
													<td>${t.teacherBirth}</td>
													<td>${t.createDate}</td>
													<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${t.accountId}">
														<button class="btn btn-sm btn-custon-rounded-foue btn-primary">
															<i class="fa fa-info-circle edu-informatio" aria-hidden="true"></i> ????????????
														</button>
													</a></td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${memberCheck eq 'manager'}">
											<c:forEach var="m" items="${managerList}">
												<tr>
													<td>${m.accountId}</td>
													<td>${m.managerName}</td>
													<td>${m.managerGender}</td>
													<td>${m.managerBirth}</td>
													<td>${m.createDate}</td>
													<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${m.accountId}">
														<button class="btn btn-sm btn-custon-rounded-foue btn-primary">
															<i class="fa fa-info-circle edu-informatio" aria-hidden="true"></i> ????????????
														</button>
													</a></td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>
							</div>
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

</html>