<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Line Charts | Kiaalap - Kiaalap Admin Template</title>
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
										<li><a
											href="${pageContext.request.contextPath}/loginCheck/index">Home</a>
											<span class="bread-slash">/</span></li>
										<li><a href="#">강의관리</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">성적관리</span></li>
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
						<h4>성적관리</h4>
						<hr>
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
										<div class="all-form-element-inner">
											<!-- 해당 lecture 조회 -->
											<form
												action="${pageContext.request.contextPath}/loginCheck/lectureSubjectList"
												method="post">
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-2 col-md-2 col-sm-2 col-xs-1">
															<label class="login2 pull-right pull-right-pro">Lecture</label>
														</div>
														<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
															<div class="form-select-list">
																<select class="form-control custom-select-value"
																	name="lectureName" id="lectureName" required="required">
																	<option value="defalut">-------------------------------------------강좌선택------------------------------------------</option>
																	<c:forEach var="l" items="${lectureListByTeacher}">
																		<option value="${l.lectureName }">${l.lectureName }</option>
																	</c:forEach>
																</select>
															</div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<button type="submit"
																class="btn btn-success">강좌선택</button>
														</div>
													</div>
												</div>
											</form>
											<!-- /해당 lecture 조회 -->
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
										<div class="all-form-element-inner">
											<!-- 해당 subject 조회 -->
											<form
												action="${pageContext.request.contextPath}/loginCheck/lectureSubjectList"
												method="post">
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-2 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">subject</label>
														</div>
														<div class="col-lg-7 col-md-5 col-sm-5 col-xs-12">
															<div class="form-select-list">
																<select class="form-control custom-select-value"
																	name="lectureName" id="lectureName" required="required">
																	<option value="defalut">-------------------------------------------강의선택------------------------------------------</option>
																	<c:forEach var="l" items="${lectureListByTeacher}">
																		<option value="${l.lectureName }">${l.lectureName }</option>
																	</c:forEach>
																</select>
															</div>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<button type="submit"
																class="btn btn-success">강의선택</button>
														</div>
													</div>
											</form>
											<!-- /해당 subject 조회 -->
										</div>
									</div>
								</div><!-- /row  -->
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
						<!-- Static Table Start -->
						<div class="sparkline13-graph">
							<div class="datatable-dashv1-list custom-datatable-overright">
								<table id="table" data-toggle="table" data-pagination="true"
									data-search="true" data-show-columns="true"
									data-show-pagination-switch="true" data-show-refresh="true"
									data-key-events="true" data-show-toggle="true"
									data-resizable="true" data-cookie="true"
									data-cookie-id-table="saveId" data-show-export="true"
									data-click-to-select="true" data-toolbar="#toolbar">
									<thead>
										<tr>
											<th data-field="state" data-checkbox="true"></th>
											<th data-field="lectureName" data-editable="true">lectureName</th>
											<th data-field="subjectName" data-editable="true">subjectName</th>
											<th data-field="accountId" data-editable="true">accountId</th>
											<th data-field="studentName" data-editable="true">studentName</th>
											<th data-field="MidtermReportScore" data-editable="true">MidtermReportScore</th>
											<th data-field="reportScore" data-editable="true">FinalReportScore</th>
											<th data-field="MidtermExamScore" data-editable="true">MidtermExamScore</th>
											<th data-field="FinalExamScore" data-editable="true">FinalExamScore</th>
											<th data-field="totalGrade" data-editable="true">totalGrade</th>
									</thead>
									<tbody>
											<c:forEach var="grade" items="${studentList}">
										<tr>
											<td></td>
											<td>${grade.lectureName}</td>
											<td>${grade.subjectName}</td>
											<td>${grade.accountId}</td>
											<td>${grade.studentName}</td>
											<td>${grade.MidtermReportScore}</td>
											<td>${grade.FinalReportScore}</td>
											<td>${grade.MidtermExamScore}</td>
											<td>${grade.FinalExamScore}</td>
											<td>${grade.totalGrade}</td>
										</tr>
										</c:forEach>
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