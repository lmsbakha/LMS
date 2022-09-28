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
<style>
   .warning {
      color : red;
   }
</style>
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
									<li><span class="bread-blod">Student Profile</span></li>
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
							<c:if test="${sessionLevel eq 1}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
							<c:if test="${sessionLevel eq 2}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
							<c:if test="${sessionLevel eq 3}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
							<c:if test="${sessionLevel eq 4}">
								<li class="active"><a><b>${member.accountId}</b>님의 프로필</a></li>
							</c:if>
						</ul>
						<div class="profile-img">
							<img src="${pageContext.request.contextPath}/file/memberPhoto/${memberFile.memberFileName}" alt="프로필" />
						</div>
					</div>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
					<div class="product-payment-inner-st res-mg-t-30 analysis-progrebar-ctn">
						<ul id="myTabedu1" class="tab-review-design">
							<c:if test="${sessionLevel eq 1}">
								<li class="active"><a><b>${member.accountId}</b>님의 학생 정보</a></li>
							</c:if>
							<c:if test="${sessionLevel eq 2}">
								<li class="active"><a><b>${member.accountId}</b>님의 강사 정보</a></li>
							</c:if>
							<c:if test="${sessionLevel eq 3}">
								<li class="active"><a><b>${member.accountId}</b>님의 행정 정보</a></li>
							</c:if>
							<c:if test="${sessionLevel eq 4}">
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
													<c:when test="${sessionLevel eq 1}">
														<form method="post" action="${pageContext.request.contextPath}/loginCheck/modifyMember" id="modifyForm">	
															<table class="table table-striped">
																<tr>
																	<th>아이디</th>
																	<td>
																		<input type="text" class="form-control"  name="accountId" value="${member.accountId}" readonly="readonly">
																	</td>
																</tr>
																<tr>
																	<th>이름</th>
																	<td>
																		<input class="form-control" placeholder="이름을 입력해주세요." id="Name" name="studentName" value="${member.studentName}">
																		<div class="warning" id="nameinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>성별</th>
																	<td>
																		<select class="form-control" name="studentGender" id="Gender">
															             	<option value="${member.studentGender}" disabled selected>${member.studentGender}</option>
														                    <option value="default">===선택해 주세요.===</option>
														                    <option value="남">남자</option>
														                    <option value="여">여자</option>
												                  		</select>
												                  		<div class="warning" id="genderinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>생년월일</th>
																	<td>
																		<input class="form-control" type="date" id="Birth" name="studentBirth" value="${member.studentBirth}" >
																		<div class="warning" id="birthinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>이메일</th>
																	<td>
																		<input type="email" class="form-control" id="Email" name="studentEmail"  value="${member.studentEmail}">
																		<div class="warning" id="eminfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>주소</th>
																	<td>
																		<input style="margin-bottom: 5px" class="form-control" id="Address" name="studentAddress" type="text" readonly="readonly" value="${member.studentAddress}" placeholder="주소"/> 
																		<button type="button" class="btn btn-primary btn-block form-group" id="addrBtn" style="margin-bottom: 5px">
																		<b>주소검색</b>
																		</button>
																		<div class="warning" id="addrinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>상세주소</th>
																	<td>
																		<input class="form-control" id="DetailAddress" name="studentDetailAddress" type="text" placeholder="상세주소를 입력해주세요." value="${member.studentDetailAddress}"  />
																	<div class="warning" id="detailaddrinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>연락처</th>
																	<td>
																		<input class="form-control" type="tel" id="Phone" name="studentPhone" required="required" placeholder="010-1234-5678" value="${member.studentPhone}" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"/>
																	<div class="warning" id="phoneinfo"></div>
																	</td>
																</tr>
																<tr>	
																	<th>병역유무</th>
																	<td>
																		 <select class="form-control" name="studentMilitary" id="Military">
															             	<option value="${member.studentMilitary}" disabled selected>${member.studentMilitary}</option>
															             	<option value="default">===선택해 주세요.===</option>
															             	<option value="해당없음">해당없음</option>
														                    <option value="군필">군필</option>
														                    <option value="미필">미필</option>
												                  		</select>
												                  		<div class="warning" id="militaryinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>학력</th>
																	<td>
																		<select class="form-control" name="studentGraduate" id="Graduate">
															             	<option value="${member.studentGraduate}" disabled selected>${member.studentGraduate}</option>
															             	<option value="default">===선택해 주세요.===</option>
															             	<option value="고졸">고졸</option>
														                    <option value="초대졸">초대졸</option>
														                    <option value="대졸">대졸</option>
												                  		</select>
												                  		<div class="warning" id="graduateinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>전공</th>
																	<td>
																		<input class="form-control" placeholder="전공을 입력해주세요." id="Major" name="studentMajor" value="${member.studentMajor}">
																		<div class="warning" id="majorinfo"></div>
																	</td>
																</tr>
															</table>
															<div style="text-align: right;">
																<button id="modifyBtn"  type="button" class="btn btn-custon-rounded-three btn-success">수정</button>
																<button  type="button" class="btn btn-custon-rounded-three btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${member.accountId}'">취소</button>
															</div>
														</form>
													</c:when>
													<c:when test="${sessionLevel eq 2}">
														<form method="post" action="${pageContext.request.contextPath}/loginCheck/modifyMember" id="modifyForm">	
															<table class="table table-striped">
																<tr>
																	<th>아이디</th>
																	<td>
																		<input type="text" class="form-control"  name="accountId" value="${member.accountId}" readonly="readonly">
																	</td>
																</tr>
																<tr>
																	<th>이름</th>
																	<td>
																		<input class="form-control" placeholder="이름을 입력해주세요." id="Name" name="teacherName" value="${member.teacherName}">
																		<div class="warning" id="nameinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>성별</th>
																	<td>
																		<select class="form-control" name="teacherGender" id="Gender">
															             	<option value="${member.teacherGender}" disabled selected>${member.teacherGender}</option>
														                    <option value="default">===선택해 주세요.===</option>
														                    <option value="남">남자</option>
														                    <option value="여">여자</option>
												                  		</select>
												                  		<div class="warning" id="genderinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>생년월일</th>
																	<td>
																		<input class="form-control" type="date" id="Birth" name="teacherBirth" value="${member.teacherBirth}" >
																		<div class="warning" id="birthinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>이메일</th>
																	<td>
																		<input type="email" class="form-control" id="Email" name="teacherEmail"  value="${member.teacherEmail}">
																		<div class="warning" id="eminfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>주소</th>
																	<td>
																		<input style="margin-bottom: 5px" class="form-control" id="Address" name="teacherAddress" type="text" readonly="readonly" value="${member.teacherAddress}" placeholder="주소"/> 
																		<button type="button" class="btn btn-primary btn-block form-group" id="addrBtn" style="margin-bottom: 5px">
																		<b>주소검색</b>
																		</button>
																		<div class="warning" id="addrinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>상세주소</th>
																	<td>
																		<input class="form-control" id="DetailAddress" name="teacherDetailAddress" type="text" placeholder="상세주소를 입력해주세요." value="${member.teacherDetailAddress}"  />
																	<div class="warning" id="detailaddrinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>연락처</th>
																	<td>
																		<input class="form-control" type="tel" id="Phone" name="teacherPhone" required="required" placeholder="010-1234-5678" value="${member.teacherPhone}" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"/>
																	<div class="warning" id="phoneinfo"></div>
																	</td>
																</tr>
															</table>
															<div style="text-align: right;">
																<button id="modifyBtn"  type="button" class="btn btn-custon-rounded-three btn-success">수정</button>
																<button  type="button" class="btn btn-custon-rounded-three btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${member.accountId}'">취소</button>
															</div>
														</form>
													</c:when>
													<c:when test="${sessionLevel eq 3}">
														<form method="post" action="${pageContext.request.contextPath}/loginCheck/modifyMember" id="modifyForm">	
															<table class="table table-striped">
																<tr>
																	<th>아이디</th>
																	<td>
																		<input type="text" class="form-control"  name="accountId" value="${member.accountId}" readonly="readonly">
																	</td>
																</tr>
																<tr>
																	<th>이름</th>
																	<td>
																		<input class="form-control" placeholder="이름을 입력해주세요." id="Name" name="managerName" value="${member.managerName}">
																		<div class="warning" id="nameinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>성별</th>
																	<td>
																		<select class="form-control" name="managerGender" id="Gender">
															             	<option value="${member.managerGender}" disabled selected>${member.managerGender}</option>
														                    <option value="default">===선택해 주세요.===</option>
														                    <option value="남">남자</option>
														                    <option value="여">여자</option>
												                  		</select>
												                  		<div class="warning" id="genderinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>생년월일</th>
																	<td>
																		<input class="form-control" type="date" id="Birth" name="managerBirth" value="${member.managerBirth}" >
																		<div class="warning" id="birthinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>이메일</th>
																	<td>
																		<input type="email" class="form-control" id="Email" name="managerEmail"  value="${member.managerEmail}">
																		<div class="warning" id="eminfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>주소</th>
																	<td>
																		<input style="margin-bottom: 5px" class="form-control" id="Address" name="managerAddress" type="text" readonly="readonly" value="${member.managerAddress}" placeholder="주소"/> 
																		<button type="button" class="btn btn-primary btn-block form-group" id="addrBtn" style="margin-bottom: 5px">
																		<b>주소검색</b>
																		</button>
																		<div class="warning" id="addrinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>상세주소</th>
																	<td>
																		<input class="form-control" id="DetailAddress" name="managerDetailAddress" type="text" placeholder="상세주소를 입력해주세요." value="${member.managerDetailAddress}"  />
																	<div class="warning" id="detailaddrinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>연락처</th>
																	<td>
																		<input class="form-control" type="tel" id="Phone" name="managerPhone" required="required" placeholder="010-1234-5678" value="${member.managerPhone}" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"/>
																	<div class="warning" id="phoneinfo"></div>
																	</td>
																</tr>
																<tr>
																	<th>담당부서</th>
																	<td>
																		<select class="form-control" name="managerDept" id="Dept">
																			<option value="${member.managerDept}" disabled selected>${member.managerDept}</option>
															             	<option value="default">===선택해 주세요.===</option>
															             	<option value="교무행정">교무행정</option>
														                    <option value="능력개발">능력개발</option>
														                    <option value="취업지원">취업지원</option>
												                  		</select>
												                  		<div class="warning" id="deptinfo"></div>
																	</td>
																</tr>
															</table>
															<div style="text-align: right;">
																<button id="modifyBtn"  type="button" class="btn btn-custon-rounded-three btn-success">수정</button>
																<button  type="button" class="btn btn-custon-rounded-three btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${member.accountId}'">취소</button>
															</div>
														</form>
													</c:when>
												</c:choose>
												<!-- /////////////////////////////////////// -->
												<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요. -->
												<div id="layer" style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
													<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1" onclick="closeDaumPostcode()" alt="닫기 버튼">
												</div>
												<!-- ////////////id="registerBtn" type="button"/////////////////////////// -->
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
	
	<script>

	// 유효성검사
	var reg_email = /^[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\w+\.)+\w+$/;
	var reg_phone = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;
	
	$('#Email').blur(function() {
		if ($('#Email').val() == '') {
			$('#eminfo').text('※ 이메일을 입력해 주세요.');
		} else if (!reg_email.test($("#Email").val())) {
			$('#Email').val('');
			$('#eminfo').text('※ 이메일 형식이 아닙니다.');
		} else {
			$('#eminfo').text('');
		}
	})

	$('#Name').blur(function() {
		if ($('#Name').val() == '') {
			$('#nameinfo').text('※ 이름을 입력해 주세요.');
		} else {
			$('#nameinfo').text('');
		}
	})

	$('#Birth').blur(function() {
		if ($('#Birth').val() == '') {
			$('#birthinfo').text('※ 생년월일을 입력해 주세요.');
		} else {
			$('#birthinfo').text('');
		}
	})

	$('#Phone').blur(function() {
		if ($('#Phone').val() == '') {
			$('#phoneinfo').text('※ 전화번호를 입력해 주세요.');
		} else if(!reg_phone.test($("#Phone").val())) {
			$('#phoneinfo').text('※ 전화번호 형식이 아닙니다. (-)를 같이 입력해 주세요.');
		} else {
			$('#phoneinfo').text('');
		}
	})

	$('#Address').blur(function() {
		if ($('#Address').val() == '') {
			$('#addrinfo').text('※ 주소를 검색해 주세요.');
		} else {
			$('#addrinfo').text('');
		}
	})

	$('#DetailAddress').blur(function() {
		if ($('#DetailAddress').val() == '') {
			$('#detailaddrinfo').text('※ 상세 주소를 입력해 주세요.');
		} else {
			$('#detailaddrinfo').text('');
		}
	})

	$('#Major').blur(function() {
		if ($('#Major').val() == '') {
			$('#majorinfo').text('※ 전공을 입력해 주세요.');
		} else {
			$('#majorinfo').text('');
		}
	})
		
	// 버튼 눌렀을때 유효성 검사
	$('#modifyBtn').click(function() {
		if ($('#Name').val() == '') {
			$('#nameinfo').text('※ 이름을 입력해 주세요.');
			$('#Name').focus();
		} else if($('#Gender').val() == 'default') {
			$('#nameinfo').text('');
			$('#genderinfo').text('※ 성별을 선택해 주세요.');
			$('#Gender').focus();
		} else if ($('#Birth').val() == '') {
			$('#genderinfo').text('');
			$('#birthinfo').text('※ 생년월일을 선택해 주세요.');
			$('#Birth').focus();
		} else if ($('#Email').val() == '') {
			$('#birthinfo').text('');
			$('#eminfo').text('※ 이메일을 입력해주세요.');
			$('#Email').focus();
		} else if (!reg_email.test($("#Email").val())) {
			$('#eminfo').text('※ 이메일 형식이 아닙니다.');
			$('#Email').focus();
		} else if ($('#Address').val() == '') {
			$('#eminfo').text('');
			$('#addrinfo').text('※ 주소를 검색해 주세요.');
			$('#addrBtn').focus();
		} else if ($('#DetailAddress').val() == '') {
			$('#detailaddrinfo').text('※ 상세주소를 입력해 주세요.');
			$('#DetailAddress').focus();
		} else if ($('#Phone').val() == '') {
			$('#detailaddrinfo').text('');
			$('#phoneinfo').text('※ 전화번호를 입력해 주세요.');
			$('#Phone').focus();
		} else if ($('#Military').val() == 'default') {
			$('#phoneinfo').text('');
			$('#militaryinfo').text('※ 병역여부를 선택해 주세요.');
			$('#Military').focus();
		} else if ($('#Graduate').val() == 'default') {
			$('#militaryinfo').text('');
			$('#graduateinfo').text('※ 학력을 선택해 주세요.');
			$('#Graduate').focus();
		} else if ($('#Major').val() == '') {
			$('#graduateinfo').text('');
			$('#majorinfo').text('※ 전공을 입력해 주세요.');
			$('#Major').focus();
		} else if ($('#Dept').val() == 'default') {
			$('#majorinfo').text('');
			$('#deptinfo').text('※ 부서를 선택해 주세요.');
			$('#Dept').focus();
		} else {
			$('#modifyForm').submit();
		}
	});
		
	// Enter키 눌렀을때 유효성 검사
	$(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if ($('#Name').val() == '') {
				$('#nameinfo').text('※ 이름을 입력해 주세요.');
				$('#Name').focus();
			} else if($('#Gender').val() == 'default') {
				$('#nameinfo').text('');
				$('#genderinfo').text('※ 성별을 선택해 주세요.');
				$('#Gender').focus();
			} else if ($('#Birth').val() == '') {
				$('#genderinfo').text('');
				$('#birthinfo').text('※ 생년월일을 선택해 주세요.');
				$('#Birth').focus();
			} else if ($('#Email').val() == '') {
				$('#birthinfo').text('');
				$('#eminfo').text('※ 이메일을 입력해주세요.');
				$('#Email').focus();
			} else if (!reg_email.test($("#Email").val())) {
				$('#eminfo').text('※ 이메일 형식이 아닙니다.');
				$('#Email').focus();
			} else if ($('#Address').val() == '') {
				$('#eminfo').text('');
				$('#addrinfo').text('※ 주소를 검색해 주세요.');
				$('#addrBtn').focus();
			} else if ($('#DetailAddress').val() == '') {
				$('#detailaddrinfo').text('※ 상세주소를 입력해 주세요.');
				$('#DetailAddress').focus();
			} else if ($('#Phone').val() == '') {
				$('#detailaddrinfo').text('');
				$('#phoneinfo').text('※ 전화번호를 입력해 주세요.');
				$('#Phone').focus();
			} else if ($('#Military').val() == 'default') {
				$('#phoneinfo').text('');
				$('#militaryinfo').text('※ 병역여부를 선택해 주세요.');
				$('#Military').focus();
			} else if ($('#Graduate').val() == 'default') {
				$('#militaryinfo').text('');
				$('#graduateinfo').text('※ 학력을 선택해 주세요.');
				$('#Graduate').focus();
			} else if ($('#Major').val() == '') {
				$('#graduateinfo').text('');
				$('#majorinfo').text('※ 전공을 입력해 주세요.');
				$('#Major').focus();
			} else if ($('#Dept').val() == 'default') {
				$('#majorinfo').text('');
				$('#deptinfo').text('※ 부서를 선택해 주세요.');
				$('#Dept').focus();
			} else {
				$('#modifyForm').submit();
			}
		}
	});
	
	</script>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$('#addrBtn').click(function() {
		sample2_execDaumPostcode();
	});
	// 우편번호 찾기 화면을 넣을 element
	var element_layer = document.getElementById('layer');

	function closeDaumPostcode() {
		// iframe을 넣은 element를 안보이게 한다.
		element_layer.style.display = 'none';
	}

	function sample2_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					//document.getElementById("sample2_extraAddress").value = extraAddr;

				} else {
					//document.getElementById("sample2_extraAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				//document.getElementById('sample2_postcode').value = data.zonecode;
				//document.getElementById("sample2_address").value = addr;

				//$('#addr').val(data.zonecode + ' '+ addr)
				document.getElementById('Address').value = data.zonecode
						+ ' ' + addr;

				// 커서를 상세주소 필드로 이동한다.
				//document.getElementById("sample2_detailAddress") .focus();

				// iframe을 넣은 element를 안보이게 한다.
				// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
				element_layer.style.display = 'none';
			},
			width : '100%',
			height : '100%',
			maxSuggestItems : 5
		}).embed(element_layer);

		// iframe을 넣은 element를 보이게 한다.
		element_layer.style.display = 'block';

		// iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
		initLayerPosition();
	}

	// 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
	// resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
	// 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
	function initLayerPosition() {
		var width = 300; //우편번호서비스가 들어갈 element의 width
		var height = 400; //우편번호서비스가 들어갈 element의 height
		var borderWidth = 5; //샘플에서 사용하는 border의 두께

		// 위에서 선언한 값들을 실제 element에 넣는다.
		element_layer.style.width = width + 'px';
		element_layer.style.height = height + 'px';
		element_layer.style.border = borderWidth + 'px solid';
		// 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
		element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width) / 2 - borderWidth)
				+ 'px';
		element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height) / 2 - borderWidth)
				+ 'px';
	}
</script>
	
</body>

</html>