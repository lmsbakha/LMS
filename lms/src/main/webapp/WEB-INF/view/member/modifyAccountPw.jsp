<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
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
<!-- main CSS
============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
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
<!-- forms CSS
============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form/all-type-forms.css">
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
	<div class="error-pagewrap">
		<div class="error-page-int">
			<div class="text-center ps-recovered">
				<h3>비밀번호 변경</h3>
				<p>새로운 비밀번호를 입력해주세요</p>
			</div>
			<div class="content-error">
				<div class="hpanel">
                    <div class="panel-body poss-recover">
                        <form action="${pageContext.request.contextPath}/loginCheck/modifyAccountPw" method="post" id="updatePwForm">
                             <div class="form-group">
                                <label class="control-label" for="accountPw">Id</label>
                                <input type="text" name="accountId" readonly="readonly" value="${accountId}" class="form-control">
                            </div>
                             <div class="form-group">
                                <label class="control-label" for="accountPw">New PassWord</label>
                                <span class="help-block small"><b>(비밀번호는 영어 대소문자, 숫자, 특수문자를 포함해 최소 8문자 입력해 주셔야 합니다.)</b></span>
                                <input type="password" placeholder="Enter your password..."  name="accountPw" id="accountPw" class="form-control">
                            	<span class="help-block small" id="pwinfo"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="accountPwCk">Check PassWord</label>
                                <input type="password" placeholder="Enter your password..."   name="accountPwCk" id="accountPwCk" class="form-control">
                                <span class="help-block small" id="pwckinfo"></span>
                            </div>
                            	<button type="button" id="updateBtn" class="btn btn-success-search btn-block">비밀번호 변경</button>
								<button type="button" class="btn btn-danger btn-block" onclick="location.href='${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${accountId}'">취소</button>
                           </form>
                    </div>
                </div>
			</div>
			<div class="text-center login-footer">
				<p>Copyright © 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
			</div>
		</div>   
    </div>
    
	 <!-- Start script -->
	<jsp:include page="../js/alljs.jsp"/>
    <!-- End script --> 
    
     <script>
	    // 유효성 
		// 비밀번호 유효성
		var reg_pass = /(?=.*[A-Z])(?=.*[0-9])(?=.*[^\w]).{8,}/;
		
		$('#accountPw').blur(function() {
			if ($('#accountPw').val() == '' ) {
				$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
				$('#accountPw').focus();
			} else if (!reg_pass.test($("#accountPw").val())) {
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
	  	
	  	// 버튼 유효성검사
		$('#updateBtn').click(function(){
			if($('#accountPw').val() == ''){
				$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
				$('#accountPw').focus();
			} else if(!reg_pass.test($("#accountPw").val())){
				$('#pwinfo').text('');
				$('#pwinfo').text('※ 최소한 8문자 대소문자 1이상 + 숫자 1이상 + 특수문자 1이상 입력해 주세요.');
				$('#accountPw').focus();
			} else if($('#accountPwCk').val() == ''){
				$('#accountPwCk').focus();
				$('#pwinfo').text('');
				$('#pwckinfo').text('※ 비밀번호 재확인을 위해 입력해 주세요.');
			} else if($('#accountPw').val() != $('#accountPwCk').val()){
				$('#pwckinfo').text('');
				$('#pwckinfo').text('※ 비밀번호와 일치하지 않습니다.');
			} else {
				// 비동기 호출
				$.ajax({
					type :'POST',
					url : '${pageContext.request.contextPath}/checkNewAccountPwByPrAccountPw',
					data : {
						accountId:"${accountId}", accountPw:$('#accountPw').val()
					},
					success : function(pw) {
						console.log('pw :', pw);
						if (pw == 'false') {
							alert('※ 이전 비밀번호와 동일한 비밀번호 입니다. 다른 비밀번호로 설정해 주세요.');
							$('#accountPw').val('');
							$('#accountPwCk').val('');
							$('#accountPw').focus();
						} else {
							$('#updatePwForm').submit();
						}
					}
				})
			}
		});
	  	
		// Enter키 유효성검사
	$(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if($('#accountPw').val() == ''){
				$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
				$('#accountPw').focus();
			} else if(!reg_pass.test($("#accountPw").val())){
				$('#pwinfo').text('');
				$('#pwinfo').text('※ 최소한 8문자 대소문자 1이상 + 숫자 1이상 + 특수문자 1이상 입력해 주세요.');
				$('#accountPw').focus();
			} else if($('#accountPwCk').val() == ''){
				$('#accountPwCk').focus();
				$('#pwinfo').text('');
				$('#pwckinfo').text('※ 비밀번호 재확인을 위해 입력해 주세요.');
			} else if($('#accountPw').val() != $('#accountPwCk').val()){
				$('#pwckinfo').text('');
				$('#pwckinfo').text('※ 비밀번호와 일치하지 않습니다.');
			} else {
				// 비동기 호출
				$.ajax({
					type :'POST',
					url : '${pageContext.request.contextPath}/checkNewAccountPwByPrAccountPw',
					data : {
						accountId:"${accountId}", accountPw:$('#accountPw').val()
					},
					success : function(pw) {
						console.log('pw :', pw);
						if (pw == 'false') {
							alert('※ 이전 비밀번호와 동일한 비밀번호 입니다. 다른 비밀번호로 설정해 주세요.');
							$('#accountPw').val('');
							$('#accountPwCk').val('');
							$('#accountPw').focus();
						} else {
							$('#updatePwForm').submit();
						}
					}
				})
			}
		}
	});
    </script>
</body>

</html>