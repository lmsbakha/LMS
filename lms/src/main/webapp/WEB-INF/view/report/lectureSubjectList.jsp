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
										<li><span class="bread-blod" style="font-weight: bold;">강의리스트</span></li>
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
						<h4>강의조회</h4>
						<hr>
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="all-form-element-inner">
											<!-- 강사용 lecture 조회 -->
											<c:choose>
												<c:when test="${sessionLevel == 2}">
													<form
														action="${pageContext.request.contextPath}/loginCheck/lectureSubjectList"
														method="post">
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">Lecture
																		조회</label>
																</div>
																<div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
																	<div class="form-select-list">
																		<select class="form-control custom-select-value"
																			name="lectureName" id="lectureName"
																			required="required">
																			<option value="defalut">------------------------강좌선택-----------------------</option>
																			<c:forEach var="l" items="${lectureListByTeacher}">
																				<option value="${l.lectureName }">${l.lectureName }</option>
																			</c:forEach>
																		</select>
																	</div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<button type="submit" class="btn btn-success">강좌선택</button>
																</div>
															</div>
														</div>
													</form>
												</c:when>
												<c:when test="${sessionLevel >= 3}">
													<form
														action="${pageContext.request.contextPath}/loginCheck/lectureSubjectList"
														method="post">
														<div class="form-group-inner">
															<div class="row">
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<label class="login2 pull-right pull-right-pro">Lecture
																		조회</label>
																</div>
																<div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
																	<div class="form-select-list">
																		<select class="form-control custom-select-value"
																			name="lectureName" id="lectureName"
																			required="required">
																			<option value="defalut">------------------------강좌선택-----------------------</option>
																			<c:forEach var="l" items="${lectureListByAdmin}">
																				<option value="${l.lectureName }">${l.lectureName }</option>
																			</c:forEach>
																		</select>
																	</div>
																</div>
																<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
																	<button type="submit" class="btn btn-success">강좌선택</button>
																</div>
															</div>
														</div>
													</form>
												</c:when>
											</c:choose>
											<!-- / 행정용 lecture 조회 -->
										</div>
									</div>

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
						<h4>강의리스트</h4>
						<div class="asset-inner">
							<table>
								<tr>
									<th>lectureSubjectNo</th>
									<th>lectureName</th>
									<th>subjectName</th>
									<th style="width: 150px">report</th>
								</tr>
								<c:if test="${empty lectureSubjectList}">
									<tr>
										<td colspan="7" style="text-align: center;">lecture를 먼저
											선택해주세요</td>
									</tr>
								</c:if>
								<c:if test="${not empty lectureSubjectList}">
									<c:forEach var="lectureSubjectList"
										items="${lectureSubjectList}">
										<tr>
											<td>${lectureSubjectList.lectureSubjectNo}</td>
											<td>${lectureSubjectList.lectureName}</td>
											<td>${lectureSubjectList.subjectName}</td>
											<td><a
												href="${pageContext.request.contextPath}/loginCheck/addReport?subjectName=${lectureSubjectList.subjectName}">
													<button data-toggle="tooltip" title="addReport"
														class="pd-setting-ed" type="button">
														<i class="fa fa-pencil-square-o" aria-hidden="true">과제
															추가</i>
													</button>
											</a><a
												href="${pageContext.request.contextPath}/loginCheck/reportList?subjectName=${lectureSubjectList.subjectName}">
													<button data-toggle="tooltip" title="reportList"
														class="pd-setting-ed" type="button">
														<i class="fa fa-pencil-square-o" aria-hidden="true">과제
															리스트</i>
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