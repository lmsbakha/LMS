<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Register | Kiaalap - Kiaalap Admin Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- favicon
      ============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
      ============================================ -->
<link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
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
<!-- main CSS
      ============================================ -->
<link rel="stylesheet" href="css/main.css">
<!-- morrisjs CSS
      ============================================ -->
<link rel="stylesheet" href="css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
      ============================================ -->
<link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
      ============================================ -->
<link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
<link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
<!-- calendar CSS
      ============================================ -->
<link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
<link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
<!-- forms CSS
      ============================================ -->
<link rel="stylesheet" href="css/form/all-type-forms.css">
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
	<!--[if lt IE 8]>
      <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
   <![endif]-->
	<div class="error-pagewrap">
		<div class="error-page-int">
			<div class="text-center custom-login">
				<h3>Registration</h3>
				<p>This is the best app ever!</p>
			</div>
			<div class="content-error">
				<!-- memberCheck 선택 -->
				<ul class="nav nav-tabs nav-justified">
				    <li class="nav-item">
				      <c:choose>
				      	 <c:when test="${memberCheck eq 'student'}">
				     		<a class="nav-link active" href="${pageContext.request.contextPath}/register?memberCheck=student">학생</a>
				     	 </c:when>	
				     	 <c:otherwise>
				     	 	<a class="nav-link" href="${pageContext.request.contextPath}/register?memberCheck=student">학생</a>
					    </c:otherwise>
				      </c:choose>
				    </li>
				    <li class="nav-item">
				      <c:choose>
				      	 <c:when test="${memberCheck eq 'teacher'}">
				     		<a class="nav-link active" href="${pageContext.request.contextPath}/register?memberCheck=teacher">강사</a>
				     	 </c:when>	
				     	 <c:otherwise>
				     	 	<a class="nav-link" href="${pageContext.request.contextPath}/register?memberCheck=teacher">강사</a>
					    </c:otherwise>
				      </c:choose>
				    </li>
				    <li class="nav-item">
				     <c:choose>
				      	 <c:when test="${memberCheck eq 'manager'}">
				     		<a class="nav-link active" href="${pageContext.request.contextPath}/register?memberCheck=manager">행정</a>
				     	 </c:when>	
				     	 <c:otherwise>
				     	 	<a class="nav-link" href="${pageContext.request.contextPath}/register?memberCheck=manager">행정</a>
					    </c:otherwise>
				      </c:choose>
				    </li>
			 	 </ul>
				<div class="hpanel">
					<div class="panel-body">
						<form id="registerForm" action="${pageContext.request.contextPath}/register" id="registerForm" method="post" enctype="multipart/form-data">
							<div class="row">
								<div class="form-group col-lg-12">
								<input type="hidden" name="memberCheck" id="memberCheck" value="${memberCheck}">
									<label for="idck">아이디</label> 
									<input type="text" placeholder="ID 입력해주세요." name="idck" id="idck" 
										class="form-control">
									<span id="idinfo"></span>										
									<br>
									<button type="button" class="btn btn-success btn-block" id="idckBtn" style="margin-bottom: 5px;">
										<b>아이디 중복검사</b>
									</button>
								</div>
								<div class="form-group col-lg-12">
									<label for="accountId">아이디</label> 
									<input type="text" class="form-control"  id="accountId" name="accountId" readonly="readonly">
								</div>
								<div class="form-group col-lg-12">
									<label for="accountPw">비밀번호</label><br>
									<span class="help-block small">(비밀번호는 영어 대소문자, 숫자, 특수문자를 포함해 최소 8문자 입력해 주셔야 합니다.)</span> 
									<input type="password" class="form-control" id="accountPw" name="accountPw" >
									<span id="pwinfo"></span>	
								</div>
								<div class="form-group col-lg-12">
									<label for="accountPwCk">비밀번호 확인</label> 
									<input type="password" class="form-control" id="accountPwCk" name="accountPwCk" >
									<span id="pwckinfo"></span>
								</div>
								<div class="form-group col-lg-12">
									<label for="email">이메일</label> 
									<input type="email" placeholder="email 입력해주세요."  name="email" id="email" 
										class="form-control"> 
									<span id="eminfo"></span>	
									<br>
									<button type="button" class="btn btn-success btn-block" id="emailBtn" style="margin-bottom: 5px;">
										<b>이메일 중복검사</b>
									</button>
								</div>
								<div class="form-group col-lg-12">
									<label for="memberEmail">이메일</label> 
									<input type="email" class="form-control" id="memberEmail" name="memberEmail"  readonly="readonly">
								</div>
								<div class="form-group col-lg-12">
									<label for="memberName">이름</label> 
									<input class="form-control" placeholder="이름을 입력해주세요." id="memberName" name="memberName" >
									<span id="nameinfo"></span>	
								</div>
								<div class="form-group col-lg-12 ">
									<label for="memberGender">성별</label>
							            <select class="form-control" name="memberGender" id="memberGender">
							             	<option value="default">===선택해주세요.===</option>
						                    <option value="남">남자</option>
						                    <option value="여">여자</option>
				                  		</select>
									<span id="genderinfo"></span>
								</div>
								<div class="form-group col-lg-12">
									<label for="memberBirth">생년월일</label>
									<input class="form-control" type="date" id="memberBirth" name="memberBirth" >
									<span id="birthinfo"></span>	
								</div>
								<div class="form-group col-lg-12">
									<label for="memberPhone">연락처</label> 
									<input class="form-control" type="tel" id="memberPhone" name="memberPhone" required="required" placeholder="010-1234-5678" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"/>
									<span id="phoneinfo"></span>
								</div>
								<div class="form-group col-lg-12">
									<label for="memberAddress">주소</label>
									<input style="margin-bottom: 5px" class="form-control" id="memberAddress" name="memberAddress" type="text" readonly="readonly"  placeholder="주소"/> 
									<button type="button" class="btn btn-success btn-block form-group" id="addrBtn" style="margin-bottom: 5px">
									<b>주소검색</b>
									</button>
									<span id="addrinfo"></span>
									<br>
									<br>
									<label for="memberDetailAddress">상세주소</label>
									<input class="form-control" id="memberDetailAddress" name="memberDetailAddress" type="text" placeholder="상세주소를 입력해주세요."  />
									<span id="detailaddrinfo"></span>
								</div>
								<div class="form-group col-lg-12">
									<label>회원 사진</label>
									<br>
									<span class="help-block small">(이미지 파일은 jpeg, jpg, png 확장자로 업로드해 주세요.)</span> 
									<div class="filebox">
									    <input class="upload-name" id="uploadFile" placeholder="파일첨부" readonly="readonly">
									    <input type="file" id="memberFile" name="memberFile" required="required">
									    <label for="memberFile">파일 찾기</label> 
									</div>
									<span id="fileinfo"></span>
								</div>
					            <!-- 학생만 memberCheck eq 'student' -->
					            <c:if test="${memberCheck eq 'student'}">
						            <div class="form-group col-lg-12">
							            <label for="memberGraduate">학력</label>
								            <select class="form-control" name="memberGraduate" id="memberGraduate">
								             	<option value="default">===선택해주세요.===</option>
								             	<option value="고졸">고졸</option>
							                    <option value="초대졸">초대졸</option>
							                    <option value="대졸">대졸</option>
					                  		</select>
				                  		<span id="graduateinfo"></span>
						            </div>
							    <div class="form-group col-lg-12">
									<label for="memberMajor">전공</label> 
									<input class="form-control" placeholder="전공을 입력해주세요." id="memberMajor" name="memberMajor">
									<span id="majorinfo"></span>	
								</div>       
						            <div class="form-group col-lg-12">
							            <label for="memberMilitary">병역 여부</label>
								            <select class="form-control" name="memberMilitary" id="memberMilitary">
								             	<option value="default">===선택해주세요.===</option>
								             	<option value="해당없음">해당없음</option>
							                    <option value="군필">군필</option>
							                    <option value="미필">미필</option>
					                  		</select>
				                  		<span id="militaryinfo"></span>
						            </div>
					            </c:if>
					            <!-- 행정만 memberCheck eq 'manager' -->
						        <c:if test="${memberCheck eq 'manager'}">
						            <div class="form-group col-lg-12">
							            <label for="memberDept">부서</label>
								            <select class="form-control" name="memberDept" id="memberDept">
								             	<option value="default">===선택해주세요.===</option>
								             	<option value="교무행정">교무행정</option>
							                    <option value="능력개발">능력개발</option>
							                    <option value="취업지원">취업지원</option>
					                  		</select>
				                  		<span id="deptinfo"></span>
						            </div>
						        </c:if>       
								<!-- /////////////////////////////////////// -->
								<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요. -->
								<div id="layer" style="display: none; position: fixed; overflow: hidden; z-index: 1; -webkit-overflow-scrolling: touch;">
									<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor: pointer; position: absolute; right: -3px; top: -3px; z-index: 1" onclick="closeDaumPostcode()" alt="닫기 버튼">
								</div>
								<!-- ////////////id="registerBtn" type="button"/////////////////////////// -->
							</div>
							<div class="text-center">
								<button type="reset" class="btn btn-warning btn-block">초기화</button>
								<button type="button" class="btn btn-success btn-block loginbtn" id="registerBtn">회원가입</button>
								<br>
								<button type="reset" class="btn btn-success btn-block" onclick="location.href='${pageContext.request.contextPath}/bakha/login';">Home</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="text-center login-footer">
				<p>
					Copyright © 2018. All rights reserved. Template by
					<a href="https://colorlib.com/wp/templates/">Colorlib</a>
				</p>
			</div>
		</div>
	</div>
	 <!-- Start script -->
	<jsp:include page="../js/alljs.jsp"/>
    <!-- End script -->  
	<script>
	// 아이디 중복검사
	$('#idckBtn').click(function() {
		if ($('#idck').val().length < 4) {
			$('#idinfo').text('※ 아이디는 4자 이상 입력해 주셔야 합니다.');
			$('#idck').focus();
			$('#idck').val('');
		} else {
			// 비동기 호출
			$.ajax({
				type :'get',
				url : '${pageContext.request.contextPath}/idck',
				data : {
					idck : $('#idck').val()
				},
				success : function(id) {
					console.log('id :', id);
					if (id == 'false') {
						$('#idinfo').text('※ 이미 사용중인 아이디 입니다.');
						$('#accountId').val('');
					} else {
						$('#idinfo').text('※ 사용가능한 아이디 입니다.');
						$('#idck').val(id);
						$('#accountId').val(id);
					}
				}
			})
		}
	});
	
	// 이메일 중복검사
	var reg_email = /^[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\w+\.)+\w+$/;

	$('#emailBtn').click(function() {
		if ($('#email').val().length < 10) {
			$('#eminfo').text('※ 이메일은 10자 이상 입력해 주셔야 합니다.');
		}else if(!reg_email.test($("#email").val())) {
 			$('#eminfo').text('※ 이메일 형식이 아닙니다.');	
 		} else {
			// 비동기 호출
			$.ajax({
				type :'get',
				url : '${pageContext.request.contextPath}/email',
				data : {
					email : $('#email').val(), memberCheck : $('#memberCheck').val()
				},
				success : function(em) {
					console.log('em :', em);
					if (em == 'false') {
						$('#eminfo').text('※ 이미 사용중인 이메일 입니다.');
						$('#memberEmail').val('');
					} else {
						$('#eminfo').text('※ 사용 가능한 이메일 입니다.');
						$('#email').val(em);
						$('#memberEmail').val(em);
					}
				}
			})
		}
	});
	

	// 유효성검사
	var reg_pass = /(?=.*[A-Z])(?=.*[0-9])(?=.*[^\w]).{8,}/;
	var reg_phone = /01[016789]-[^0][0-9]{2,3}-[0-9]{3,4}/;
	var reg_file = /(.*?)\.(jpg|jpeg|png)$/i;
	
	// 파일 확장자 체크
	$('#memberFile').blur(function() {
		if($('#uploadFile').val() == ''){
			alert("※ 파일을 선택해 주세요.");			
		} else if (!reg_file.test($("#memberFile").val())) {
			$('#fileinfo').text('※ 파일 형식 또는 파일 확장자가 잘못되었습니다.');
  		} else {
  			$('#fileinfo').text('');
  		}
	});
	
	
	$('#accountPw').blur(function() {
		if ($('#accountPw').val() == '') {
			$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
		} else if (!reg_pass.test($("#accountPw").val())) {
			$('#accountPw').val('');
			$('#pwinfo').text('※ 최소한 8문자 대소문자 1이상 + 숫자 1이상 + 특수문자 1이상 입력해 주세요.');
			$('#accountPw').focus();
		} else {
			$('#pwinfo').text('');
		}
	})
	
	$('#accountPwCk').blur(function() {
  		 if($('#accountPwCk').val()=='') {
   			$('#pwckinfo').text('※ 비밀번호 재확인을 위해 입력해 주세요.');
  		 } else if($('#accountPw').val() != $('#accountPwCk').val()) {
   			$('#pwckinfo').text('※ 비밀번호와 일치하지 않습니다.');
  		 } else {
  			$('#pwckinfo').text('');
  		 }
  	})

	$('#email').blur(function() {
		if ($('#email').val() == '') {
			$('#memberEmail').val('');
			$('#eminfo').text('※ 이메일을 입력해 주세요.');
		} else if (!reg_email.test($("#email").val())) {
			$('#memberEmail').val('');
			$('#eminfo').text('※ 이메일 형식이 아닙니다.');
		} else {
			$('#eminfo').text('');
		}
	})

	$('#memberName').blur(function() {
		if ($('#memberName').val() == '') {
			$('#nameinfo').text('※ 이름을 입력해 주세요.');
		} else {
			$('#nameinfo').text('');
		}
	})

	$('#memberBirth').blur(function() {
		if ($('#memberBirth').val() == '') {
			$('#birthinfo').text('※ 생년월일을 입력해 주세요.');
		} else {
			$('#birthinfo').text('');
		}
	})

	$('#memberPhone').blur(function() {
		if ($('#memberPhone').val() == '') {
			$('#phoneinfo').text('※ 전화번호를 입력해 주세요.');
		} else if(!reg_phone.test($("#memberPhone").val())) {
			$('#phoneinfo').text('※ 전화번호 형식이 아닙니다. (-)를 같이 입력해 주세요.');
		} else {
			$('#phoneinfo').text('');
		}
	})

	$('#memberAddress').blur(function() {
		if ($('#memberAddress').val() == '') {
			$('#addrinfo').text('※ 주소를 검색해 주세요.');
		} else {
			$('#addrinfo').text('');
		}
	})

	$('#memberDetailAddress').blur(function() {
		if ($('#memberDetailAddress').val() == '') {
			$('#detailaddrinfo').text('※ 상세 주소를 입력해 주세요.');
		} else {
			$('#detailaddrinfo').text('');
		}
	})

	$('#memberMajor').blur(function() {
		if ($('#memberMajor').val() == '') {
			$('#majorinfo').text('※ 전공을 입력해 주세요.');
		} else {
			$('#majorinfo').text('');
		}
	})
		
	// 버튼 눌렀을때 유효성 검사
	$('#registerBtn').click(function() {
		if ($('#idck').val() == '') {
			$('#idinfo').text('※ 아이디를 입력해 주세요.');
			$('#idck').focus();
		} else if ($('#idck').val().length < 4) {
			$('#idinfo').text('※ 아이디는 4자 이상 입력해주셔야합니다.');
			$('#idck').focus(); 
		} else if ($('#accountId').val() == '') {
			alert('※ 아이디 중복 검사를 해주세요.');
			$('#idckBtn').focus();
			$('#idinfo').text('');
		} else if ($('#accountPw').val() == '') {
			$('#idinfo').text('');
			$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
			$('#accountPw').focus();
		} else if (!reg_pass.test($("#accountPw").val())) {
			$('#pwinfo').text('※ 최소한 8문자 대소문자 1이상 + 숫자 1이상 + 특수문자 1이상 입력해 주세요..');
			$('#accountPw').focus();
		} else if ($('#accountPwCk').val() == '') {
			$('#pwckinfo').text('※ 비밀번호 재확인을 위해 입력해 주세요.');
			$('#accountPwCk').focus();
		} else if($('#accountPw').val() != $('#accountPwCk').val()){
			$('#accountPwCk').focus();
			$('#pwckinfo').text('※ 비밀번호와 일치하지 않습니다.');
		}  else if ($('#email').val() == '') {
			$('#pwckinfo').text('');
			$('#eminfo').text('※ 이메일을 입력해주세요.');
			$('#email').focus();
		} else if (!reg_email.test($("#email").val())) {
			$('#eminfo').text('※ 이메일 형식이 아닙니다.');
			$('#email').focus();
		} else if ($('#memberEmail').val() == '') {
			alert('※ 이메일 중복 검사를 해주세요.');
			$('#emailBtn').focus();
		} else if ($('#memberName').val() == '') {
			$('#eminfo').text('');
			$('#nameinfo').text('※ 이름을 입력해 주세요.');
			$('#memberName').focus();
		} else if ($('#memberGender').val() == 'default') {
			$('#nameinfo').text('');
			$('#genderinfo').text('※ 성별을 선택해 주세요.');
			$('#memberGender').focus();
		} else if ($('#memberBirth').val() == '') {
			$('#genderinfo').text('');
			$('#birthinfo').text('※ 생년월일을 선택해 주세요.');
			$('#memberBirth').focus();
		} else if ($('#memberPhone').val() == '') {
			$('#birthinfo').text('');
			$('#phoneinfo').text('※ 전화번호를 입력해 주세요.');
			$('#memberPhone').focus();
		} else if (!reg_phone.test($("#memberPhone").val())) {
			$('#phoneinfo').text('※ 전화번호 형식이 아닙니다.');
			$('#memberPhone').focus();
		} else if ($('#memberAddress').val() == '') {
			$('#phoneinfo').text('');
			alert('※ 주소를 검색해 주세요.');
			$('#addrBtn').focus();
		} else if ($('#memberDetailAddress').val() == '') {
			$('#detailaddrinfo').text('※ 상세주소를 입력해 주세요.');
			$('#memberDetailAddress').focus();
		} else if ($('#memberFile').val() == '') {
			$('#detailaddrinfo').text('');
			$('#fileinfo').text('※ 파일을 등록해 주세요.');
			$('#uploadFile').focus();
		} else if($('#uploadFile').val() == ''){
			alert("※ 파일을 선택해 주세요.");			
		} else if (!reg_file.test($("#memberFile").val())) {
			$('#fileinfo').text('※ 파일 형식 또는 파일 확장자가 잘못되었습니다.');
			$('#uploadFile').focus();
		} else if ($('#memberGraduate').val() == 'default') {
			$('#fileinfo').text('');
			$('#graduateinfo').text('※ 학력을 선택해 주세요.');
			$('#memberGraduate').focus();
		} else if ($('#memberMajor').val() == '') {
			$('#graduateinfo').text('');
			$('#majorinfo').text('※ 전공을 입력해 주세요.');
			$('#memberMajor').focus();
		} else if ($('#memberMilitary').val() == 'default') {
			$('#graduateinfo').text('');
			$('#militaryinfo').text('※ 병역여부를 선택해 주세요.');
			$('#memberMilitary').focus();
		} else if ($('#memberDept').val() == 'default') {
			$('#militaryinfo').text('');
			$('#deptinfo').text('※ 부서를 선택해 주세요.');
			$('#memberDept').focus();
		} else {
			$('#registerForm').submit();
		}
	});
		
	// Enter키 눌렀을때 유효성 검사
	$(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if ($('#idck').val() == '') {
				$('#idinfo').text('※ 아이디를 입력해 주세요.');
				$('#idck').focus();
			} else if ($('#idck').val().length < 4) {
				$('#idinfo').text('※ 아이디는 4자 이상 입력해주셔야합니다.');
				$('#idck').focus(); 
			} else if ($('#accountId').val() == '') {
				alert('※ 아이디 중복 검사를 해주세요.');
				$('#idckBtn').focus();
				$('#idinfo').text('');
			} else if ($('#accountPw').val() == '') {
				$('#idinfo').text('');
				$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
				$('#accountPw').focus();
			} else if (!reg_pass.test($("#accountPw").val())) {
				$('#pwinfo').text('※ 최소한 8문자 대소문자 1이상 + 숫자 1이상 + 특수문자 1이상 입력해 주세요..');
				$('#accountPw').focus();
			} else if ($('#accountPwCk').val() == '') {
				$('#pwckinfo').text('※ 비밀번호 재확인을 위해 입력해 주세요.');
				$('#accountPwCk').focus();
			} else if($('#accountPw').val() != $('#accountPwCk').val()){
				$('#accountPwCk').focus();
				$('#pwckinfo').text('※ 비밀번호와 일치하지 않습니다.');
			}  else if ($('#email').val() == '') {
				$('#pwckinfo').text('');
				$('#eminfo').text('※ 이메일을 입력해주세요.');
				$('#email').focus();
			} else if (!reg_email.test($("#email").val())) {
				$('#eminfo').text('※ 이메일 형식이 아닙니다.');
				$('#email').focus();
			} else if ($('#memberEmail').val() == '') {
				alert('※ 이메일 중복 검사를 해주세요.');
				$('#emailBtn').focus();
			} else if ($('#memberName').val() == '') {
				$('#eminfo').text('');
				$('#nameinfo').text('※ 이름을 입력해 주세요.');
				$('#memberName').focus();
			} else if ($('#memberGender').val() == 'default') {
				$('#nameinfo').text('');
				$('#genderinfo').text('※ 성별을 선택해 주세요.');
				$('#memberGender').focus();
			} else if ($('#memberBirth').val() == '') {
				$('#genderinfo').text('');
				$('#birthinfo').text('※ 생년월일을 선택해 주세요.');
				$('#memberBirth').focus();
			} else if ($('#memberPhone').val() == '') {
				$('#birthinfo').text('');
				$('#phoneinfo').text('※ 전화번호를 입력해 주세요.');
				$('#memberPhone').focus();
			} else if (!reg_phone.test($("#memberPhone").val())) {
				$('#phoneinfo').text('※ 전화번호 형식이 아닙니다.');
				$('#memberPhone').focus();
			} else if ($('#memberAddress').val() == '') {
				$('#phoneinfo').text('');
				alert('※ 주소를 검색해 주세요.');
				$('#addrBtn').focus();
			} else if ($('#memberDetailAddress').val() == '') {
				$('#detailaddrinfo').text('※ 상세주소를 입력해 주세요.');
				$('#memberDetailAddress').focus();
			} else if ($('#memberFile').val() == '') {
				$('#detailaddrinfo').text('');
				$('#fileinfo').text('※ 파일을 등록해 주세요.');
				$('#uploadFile').focus();
			} else if($('#uploadFile').val() == ''){
				alert("※ 파일을 선택해 주세요.");			
			} else if (!reg_file.test($("#memberFile").val())) {
				$('#fileinfo').text('※ 파일 형식 또는 파일 확장자가 잘못되었습니다.');
				$('#uploadFile').focus();
			} else if ($('#memberGraduate').val() == 'default') {
				$('#fileinfo').text('');
				$('#graduateinfo').text('※ 학력을 선택해 주세요.');
				$('#memberGraduate').focus();
			} else if ($('#memberMajor').val() == '') {
				$('#graduateinfo').text('');
				$('#majorinfo').text('※ 전공을 입력해 주세요.');
				$('#memberMajor').focus();
			} else if ($('#memberMilitary').val() == 'default') {
				$('#graduateinfo').text('');
				$('#militaryinfo').text('※ 병역여부를 선택해 주세요.');
				$('#memberMilitary').focus();
			} else if ($('#memberDept').val() == 'default') {
				$('#militaryinfo').text('');
				$('#deptinfo').text('※ 부서를 선택해 주세요.');
				$('#memberDept').focus();
			} else {
				$('#registerForm').submit();
			}
		}
	});
	
	$("#memberFile").on('change',function(){
		  var fileName = $("#memberFile").val().split("\\").pop();
		  $(".upload-name").val(fileName);
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
				document.getElementById('memberAddress').value = data.zonecode
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