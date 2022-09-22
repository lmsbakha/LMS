<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Password Recevery | Kiaalap - Kiaalap Admin Template</title>
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
			<div class="text-center ps-recovered">
				<h3>비밀번호 변경</h3>
				<p>새로운 비밀번호를 입력해주세요</p>
			</div>
			<div class="content-error">
				<div class="hpanel">
                    <div class="panel-body poss-recover">
                        <form action="${pageContext.request.contextPath}/modifySearchAccountPw" method="post">
                             <div class="form-group">
								<input type="hidden" name="accountId" id="accountId" value="${accountId}">
                                <label class="control-label" for="username">New PassWord</label>
                                <span class="help-block small"><b>(비밀번호는 영어 대소문자, 숫자, 특수문자를 포함해 최소 8문자 입력해 주셔야 합니다.)</b></span>
                                <input type="password" placeholder="Enter your password..."  required="required"  name="accountPw" id="accountPw" class="form-control">
                            	<span id="passinfo"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="username">Check PassWord</label>
                                <input type="password" placeholder="Enter your password..."  required="required"  name="accountPwCk" id="accountPwCk" class="form-control">
                                <span id="passckinfo"></span>
                            </div>
                            	<button type="submit" class="btn btn-success-search btn-block">비밀번호 변경</button>
                           </form>
                    </div>
                </div>
			</div>
			<div class="text-center login-footer">
				<p>Copyright © 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
			</div>
		</div>   
    </div>
    <!-- jquery
		============================================ -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="js/metisMenu/metisMenu.min.js"></script>
    <script src="js/metisMenu/metisMenu-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="js/tab.js"></script>
    <!-- icheck JS
		============================================ -->
    <script src="js/icheck/icheck.min.js"></script>
    <script src="js/icheck/icheck-active.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="js/main.js"></script>
    <!-- tawk chat JS
		============================================ -->
    <script src="js/tawk-chat.js"></script>
    <script>
	    // 유효성 
		// 비밀번호 유효성
		var reg_pass = /(?=.*[A-Z])(?=.*[0-9])(?=.*[^\w]).{8,}/;
		
		$('#accountPw').blur(function() {
			if ($('#accountPw').val() == '') {
				$('#passinfo').text('※ 비밀번호를 입력해주세요.');
			} else if (!reg_pass.test($("#accountPw").val())) {
				$('#accountPw').val('');
				$('#passinfo').text('※ 최소한 8문자 대소문자 1이상 + 숫자 1이상 + 특수문자 1이상 입력해주세요.');
			} else {
				$('#passinfo').text('');
			}
		})
		$('#accountPwCk').blur(function() {
	  		 if($('#accountPwCk').val()=='') {
	   			$('#passckinfo').text('※ 비밀번호 재확인을 위해 입력해주세요.');
	  		 } else if($('#accountPw').val() != $('#accountPwCk').val()) {
	   			$('#passckinfo').text('※ 비밀번호와 일치하지 않습니다.');
	  		 	$('#accountPwCk').val('');
	  		 } else {
	  			$('#passckinfo').text('');
	  		 }
	  	})
    </script>
</body>

</html>