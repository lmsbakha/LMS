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
										<li><a
											href="${pageContext.request.contextPath}/loginCheck/index">Home</a>
											<span class="bread-slash">/</span></li>
										<li><a href="#">강의</a> <span class="bread-slash">/</span></li>
										<li><a
											href="${pageContext.request.contextPath}/loginCheck/exam">시험</a>
											<span class="bread-slash">/</span></li>
										<li><a
											href="${pageContext.request.contextPath}/loginCheck/questionBank">
												<span class="bread-blod" style="font-weight: bold;">문제은행</span>
										</a></li>
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

						<ul id="myTabedu1" class="tab-review-design">
							<li class="active"><a href="#multiplechoice">객관식 문제은행</a></li>
							<li><a href="#shortAnswer">단답형 문제은행</a></li>
						</ul>
						<div class="add-product">
							<a
								href="${pageContext.request.contextPath}/loginCheck/addQuestionInBank">문제추가</a>
						</div>
						<!-- 문제은행에서 문제 삭제에 성공했을 때 -->
						<c:if test="${alertMsg eq 'Success'}">
							<div class="alert alert-success alert-success-style1">
								<button type="button" class="close sucess-op"
									data-dismiss="alert" aria-label="Close">
									<span class="icon-sc-cl" aria-hidden="true">&times;</span>
								</button>
								<i class="fa fa-check edu-checked-pro admin-check-pro"
									aria-hidden="true"></i>
								<p>
									<strong>Success!</strong> 문제 삭제에 성공하였습니다.
								</p>
							</div>
						</c:if>
						<!-- 문제은행에서 문제 삭제에 실패했을 때 -->
						<c:if test="${alertMsg eq 'Fail'}">
							<div class="alert alert-danger alert-mg-b alert-success-style4">
								<button type="button" class="close sucess-op"
									data-dismiss="alert" aria-label="Close">
									<span class="icon-sc-cl" aria-hidden="true">&times;</span>
								</button>
								<i class="fa fa-times edu-danger-error admin-check-pro"
									aria-hidden="true"></i>
								<p>
									<strong>Fail!</strong> 문제 삭제에 실패하였습니다.
								</p>
							</div>
						</c:if>
						<!-- FK 때문에 삭제가 안되는 경우 -->
						<c:if test="${alertMsg eq 'Error'}">
							<div class="alert alert-danger alert-mg-b alert-success-style4">
								<button type="button" class="close sucess-op"
									data-dismiss="alert" aria-label="Close">
									<span class="icon-sc-cl" aria-hidden="true">&times;</span>
								</button>
								<i class="fa fa-times edu-danger-error admin-check-pro"
									aria-hidden="true"></i>
								<p>
									<strong>Fail!</strong> 문제 삭제가 불가능합니다. 삭제를 원하시면 exam에서 먼저 삭제해주세요
								</p>
							</div>
						</c:if>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="multiplechoice">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="sparkline13-list">
											<div class="sparkline13-graph">
												<div
													class="datatable-dashv1-list custom-datatable-overright">
													<table id="table" data-toggle="table"
														data-pagination="true" data-search="true"
														data-show-pagination-switch="true"
														data-show-refresh="true" data-key-events="true"
														data-resizable="true" data-cookie="true"
														data-cookie-id-table="saveId" data-click-to-select="true"
														data-toolbar="#toolbar">
														<thead>
															<tr>
																<th>questionNo</th>
																<th>questionTitle</th>
																<th>subjectName</th>
																<th>updateDate</th>
																<th>createDate</th>
																<th style="width: 150px">Setting</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="map" items="${multiplechoiceList}">
																<tr>
																	<td>${map.questionNo}</td>
																	<td>${map.questionTitle}</td>
																	<td>${map.subjectName}</td>
																	<td>${map.updateDate}</td>
																	<td>${map.createDate}</td>
																	<td><a
																		href="${pageContext.request.contextPath}/loginCheck/multiplechoiceOne?questionNo=${map.questionNo}">
																			<button class="btn btn-sm btn-custon-rounded-three btn-primary">
																				<i class="fa fa-pencil-square-o" aria-hidden="true"></i>상세보기
																			</button>
																	</a> <a
																		href="${pageContext.request.contextPath}/loginCheck/removeMultiplechoiceOne?questionNo=${map.questionNo}&page=questionBank"
																		onclick="return confirm('[객관식] ${map.questionNo}번째 문제를 삭제하시겠습니까?');">
																			<button class="btn btn-sm btn-custon-rounded-three btn-danger">
																				<i class="fa fa-trash-o" aria-hidden="true"></i>삭제하기
																			</button>
																	</a></td>
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
							<div class="product-tab-list tab-pane fade" id="shortAnswer">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="sparkline13-list">
											<div class="sparkline13-graph">
												<div
													class="datatable-dashv1-list custom-datatable-overright">
													<table id="table" data-toggle="table"
														data-pagination="true" data-search="true"
														data-show-pagination-switch="true"
														data-show-refresh="true" data-key-events="true"
														data-resizable="true" data-cookie="true"
														data-cookie-id-table="saveId" data-click-to-select="true"
														data-toolbar="#toolbar">
														<thead>
															<tr>
																<th>questionNo</th>
																<th>questionTitle</th>
																<th>subjectName</th>
																<th>updateDate</th>
																<th>createDate</th>
																<th style="width: 150px">Setting</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach var="map" items="${shortAnswerQuestionList}">
																<tr>
																	<td>${map.questionNo}</td>
																	<td>${map.questionTitle}</td>
																	<td>${map.subjectName}</td>
																	<td>${map.updateDate}</td>
																	<td>${map.createDate}</td>
																	<td>
																		<a href="${pageContext.request.contextPath}/loginCheck/shortAnswerQuestionOne?questionNo=${map.questionNo}"> 
																			<button class="btn btn-sm btn-custon-rounded-three btn-primary">
																				<i class="fa fa-pencil-square-o" aria-hidden="true"></i>수정하기
																			</button>
																		</a> 
																		<a href="${pageContext.request.contextPath}/loginCheck/removeShortAnswerQuestion?questionNo=${map.questionNo}&page=questionBank" onclick="return confirm('[단답형] ${map.questionNo}번째 문제를 삭제하시겠습니까?');">
																			<button class="btn btn-sm btn-custon-rounded-three btn-danger">
																				<i class="fa fa-trash-o" aria-hidden="true"></i>삭제하기
																			</button>
																		</a>
																	</td>
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
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Start footer -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- End footer -->


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
</html>