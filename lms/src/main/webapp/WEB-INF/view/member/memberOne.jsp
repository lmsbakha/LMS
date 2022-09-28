<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Student Profile | Kiaalap - Kiaalap Admin Template</title>
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
<!-- forms CSS
		============================================ -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/form/all-type-forms.css">
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
	<!--[if lt IE 8]>
			<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
		<![endif]-->
	<!-- Start sidebar -->
	<jsp:include page="../inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="../inc/topbar.jsp" />
	<!-- End tobbar -->

	<!-- Start Main -->
	<div class="breadcome-area">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcome-list single-page-breadcome">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="breadcome-heading"></div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<ul class="breadcome-menu">
									<li><a href="#">Home</a> <span class="bread-slash">/</span>
									</li>
									<c:if test="${accountLevel eq 1}">
										<li><span class="bread-blod">Student Profile</span></li>
									</c:if>
									<c:if test="${accountLevel eq 2}">
										<li><span class="bread-blod">Teacher Profile</span></li>
									</c:if>
									<c:if test="${accountLevel eq 3}">
									<li><span class="bread-blod">Manager Profile</span></li>
									</c:if>
									<c:if test="${accountLevel eq 4}">
										<li><span class="bread-blod">Admin Profile</span></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Single pro tab review Start-->
	<div class="single-pro-review-area mt-t-30 mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-1 col-md-1 col-sm-1 col-xs-12">
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
					<div class="profile-info-inner">
						<ul id="myTabedu1" class="tab-review-design">
							<c:if test="${accountLevel eq 1}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
							<c:if test="${accountLevel eq 2}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
							<c:if test="${accountLevel eq 3}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
							<c:if test="${accountLevel eq 4}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
						</ul>
						<div class="profile-img">
							<img src="${pageContext.request.contextPath}/file/memberPhoto/${memberFile.memberFileName}" alt="프로필" />
						</div>
						<br>
						<div style="text-align: right;">
							<c:if test="${sessionId eq member.accountId }">
								<a type="button" class="btn btn-custon-rounded-three btn-success"
									href="${pageContext.request.contextPath}/loginCheck/modifyMemberFile?memberFileName=${memberFile.memberFileName}">사진수정</a>
							</c:if>	
						</div>
					</div>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
					<div class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn">
						<ul id="myTabedu1" class="tab-review-design">
							<c:if test="${accountLevel eq 1}">
								<li class="active"><a><b>${member.accountId}</b>님의 학생 정보</a></li>
							</c:if>
							<c:if test="${accountLevel eq 2}">
								<li class="active"><a><b>${member.accountId}</b>님의 강사 정보</a></li>
							</c:if>
							<c:if test="${accountLevel eq 3}">
								<li class="active"><a><b>${member.accountId}</b>님의 행정 정보</a></li>
							</c:if>
							<c:if test="${accountLevel eq 4}">
								<li class="active"><a><b>${member.accountId}</b>님의 총관리자 정보</a></li>
							</c:if>
						</ul>
						<div id="myTabContent"
							class="tab-content custom-product-edit st-prf-pro">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div class="row">
												<c:choose>
													<c:when test="${accountLevel eq 1}">
														<table class="table table-striped">
															<tr>
																<th>아이디</th>
																<td>${member.accountId}</td>
															</tr>
															<tr>
																<th>이름</th>
																<td>${member.studentName}</td>
															</tr>
															<tr>
																<th>성별</th>
																<td>${member.studentGender}</td>
															</tr>
															<tr>
																<th>생년월일</th>
																<td>${member.studentBirth}</td>
															</tr>
															<tr>
																<th>이메일</th>
																<td>${member.studentEmail}</td>
															</tr>
															<tr>
																<th>주소</th>
																<td>${member.studentAddress}-
																	${member.studentDetailAddress}</td>
															</tr>
															<tr>
																<th>연락처</th>
																<td>${member.studentPhone}</td>
															</tr>
															<tr>
																<th>병역유무</th>
																<td>${member.studentMilitary}</td>
															</tr>
															<tr>
																<th>학력</th>
																<td>${member.studentGraduate}</td>
															</tr>
															<tr>
																<th>전공</th>
																<td>${member.studentMajor}</td>
															</tr>
															<tr>
																<th>가입날짜</th>
																<td>${member.createDate}</td>
															</tr>
														</table>
													</c:when>
													<c:when test="${accountLevel eq 2}">
														<table class="table table-striped">
															<tr>
																<th>아이디</th>
																<td>${member.accountId}</td>
															</tr>
															<tr>
																<th>이름</th>
																<td>${member.teacherName}</td>
															</tr>
															<tr>
																<th>성별</th>
																<td>${member.teacherGender}</td>
															</tr>
															<tr>
																<th>생년월일</th>
																<td>${member.teacherBirth}</td>
															</tr>
															<tr>
																<th>이메일</th>
																<td>${member.teacherEmail}</td>
															</tr>
															<tr>
																<th>주소</th>
																<td>${member.teacherAddress} - ${member.teacherDetailAddress}</td>
															</tr>
															<tr>
																<th>연락처</th>
																<td>${member.teacherPhone}</td>
															</tr>
															<tr>
																<th>가입날짜</th>
																<td>${member.createDate}</td>
															</tr>
														</table>
													</c:when>
													<c:when test="${accountLevel eq 3}">
														<table class="table table-striped">
															<tr>
																<th>아이디</th>
																<td>${member.accountId}</td>
															</tr>
															<tr>
																<th>이름</th>
																<td>${member.managerName}</td>
															</tr>
															<tr>
																<th>성별</th>
																<td>${member.managerGender}</td>
															</tr>
															<tr>
																<th>생년월일</th>
																<td>${member.managerBirth}</td>
															</tr>
															<tr>
																<th>이메일</th>
																<td>${member.managerEmail}</td>
															</tr>
															<tr>
																<th>주소</th>
																<td>${member.managerAddress} - ${member.managerDetailAddress}</td>
															</tr>
															<tr>
																<th>연락처</th>
																<td>${member.managerPhone}</td>
															</tr>
															<tr>
																<th>담당부서</th>
																<td>${member.managerDept}</td>
															</tr>
															<tr>
																<th>가입날짜</th>
																<td>${member.createDate}</td>
															</tr>
														</table>
													</c:when>
													<c:when test="${accountLevel eq 4}">
														<table class="table table-striped">
															<tr>
																<th>아이디</th>
																<td>${member.accountId}</td>
															</tr>
															<tr>
																<th>이름</th>
																<td>${member.adminName}</td>
															</tr>
															<tr>
																<th>이메일</th>
																<td>${member.adminEmail}</td>
															</tr>
															<tr>
																<th>연락처</th>
																<td>${member.adminPhone}</td>
															</tr>
															<tr>
																<th>가입날짜</th>
																<td>${member.createDate}</td>
															</tr>
														</table>
													</c:when>
												</c:choose>
												<div style="text-align: right;">
												<c:if test="${accountLevel < 4 && sessionId eq member.accountId }">
													<a type="button" class="btn btn-custon-rounded-three btn-primary" href="${pageContext.request.contextPath}/loginCheck/checkAccountPw?path=modifyAccountPw">비밀번호 수정</a>
													<a type="button" class="btn btn-custon-rounded-three btn-primary" href="${pageContext.request.contextPath}/loginCheck/checkAccountPw?path=modifyMember">정보 수정</a>
													<a type="button" class="btn btn-custon-rounded-three btn-danger" href="${pageContext.request.contextPath}/loginCheck/checkAccountPw?path=removeMember">회원 탈퇴</a>
												</c:if>
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

	<!-- Start script -->
	<jsp:include page="../js/alljs.jsp" />
	<!-- End script -->
</body>

</html>