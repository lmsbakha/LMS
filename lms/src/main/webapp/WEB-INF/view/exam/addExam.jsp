<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
										<li><a href="${pageContext.request.contextPath}/loginCheck/index">Home</a> <span class="bread-slash">/</span></li>
										<li><a href="#">강의</a> <span class="bread-slash">/</span></li>
										<li><a href="${pageContext.request.contextPath}/loginCheck/exam">시험</a> <span class="bread-slash">/</span></li>
										<li><span class="bread-blod" style="font-weight: bold;">시험출제</span></li>
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
					<div class="sparkline12-list">
						<div class="sparkline12-hd">
							<div class="main-sparkline12-hd">
								<!-- 시험 출제가 정상적으로 작동했을 때 -->
								<c:if test="${alertMsg eq 'Success'}">
									<div class="alert alert-success alert-success-style1">
										<button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
											<span class="icon-sc-cl" aria-hidden="true">&times;</span>
										</button>
										<i class="fa fa-check edu-checked-pro admin-check-pro" aria-hidden="true"></i>
										<p>
											<strong>Success!</strong> 시험 출제에 성공하였습니다.
										</p>
									</div>
								</c:if>
								<!-- 시험 출제가 실패했을 때 -->
								<c:if test="${alertMsg eq 'Fail'}">
									<div class="alert alert-danger alert-mg-b alert-success-style4">
										<button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
											<span class="icon-sc-cl" aria-hidden="true">&times;</span>
										</button>
										<i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
										<p>
											<strong>Fail!</strong> 시험 출제에 실패하였습니다.
										</p>
									</div>
								</c:if>
								<h1>시험 출제하기</h1>
								<hr>
							</div>
						</div>
						<div class="sparkline12-graph">
							<div class="basic-login-form-ad">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="all-form-element-inner">
											<form action="${pageContext.request.contextPath}/loginCheck/addExam" method="post" id="addExamForm">
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">강사명</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" value="${infoAboutTeacher.teacherName }" readonly="readonly" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">lectureName(강의명)</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" value="${infoAboutTeacher.lectureName }" readonly="readonly" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험을 출제할 과목(subject)를 선택하세요</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<div class="form-select-list">
																<select class="form-control custom-select-value" name="subjectName" id="subjectName" required="required">
																	<option value="defalut">-----과목선택-----</option>
																	<c:forEach var="l" items="${lectureSubjectList}">
																		<option value="${l.subjectName }">${l.subjectName }</option>
																	</c:forEach>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험명을 작성하세요</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" name="examTitle" id="examTitle" placeholder="중간고사, 월말평가...." required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">해당 시험에 대한 설명을 입력해주세요</label>
														</div>
														<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
															<input type="text" class="form-control" name="examContent" id="examContent" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">해당 시험의 총 문제 수를 선택하세요</label>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="number" class="form-control" placeholder="객관식" name="multipleCnt" id="multipleCnt" min="0" required="required" />
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="number" class="form-control" placeholder="단답형" name="shortAnswerCnt" id="shortAnswerCnt" min="0" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험 시작일</label>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="date" class="form-control" name="examStartDate" ID="examStartDate" min="${infoAboutTeacher.lectureStartDate }" max="${infoAboutTeacher.lectureEndDate }" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="row">
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<label class="login2 pull-right pull-right-pro">시험 마감일</label>
														</div>
														<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
															<input type="date" class="form-control" id="examEndDate" name="examEndDate" min="${infoAboutTeacher.lectureStartDate }" max="${infoAboutTeacher.lectureEndDate }" required="required" />
														</div>
													</div>
												</div>
												<div class="form-group-inner">
													<div class="login-btn-inner">
														<div class="row">
															<div class="col-lg-3"></div>
															<div class="col-lg-9">
																<div class="login-horizental cancel-wp pull-left form-bc-ele">
																	<button class="btn btn-white" type="reset">Cancel</button>
																	<button class="btn btn-sm btn-primary login-submit-cs" id="addExamBtn" type="submit">시험출제</button>
																</div>
															</div>
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
				</div>
			</div>
		</div>
	</div>
	<!-- Start tobbar -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- End tobbar -->

	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

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
<script type="text/javascript">
	/*
	 시험출제 버튼을 눌렀을 때 객관식 문항 + 단답형 문항이 10개 초과또는 미만일 경우 alert();
	 */
	$('#addExamBtn')
			.click(
					function() {
						if (Number(document.getElementById('multipleCnt').value)
								+ Number(document
										.getElementById('shortAnswerCnt').value) == 10) {
							$('#addExamForm').submit();
							return;
						} else {
							alert('총 문제 수를 10 문항으로 맞춰주세요');
							return false;
						}
					});
</script>
</html>