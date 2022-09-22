<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
			<div class="text-center m-b-md custom-login">
				<h3>PLEASE LOGIN TO LMS</h3>
			</div>
			<div class="login-error">
				<div class="hpanel">
                    <div class="panel-body">
                        <form method="post" action="${pageContext.request.contextPath}/login" id="loginForm">
                            <div class="form-group">
                                <label class="control-label" for="accountId">아이디</label>
                                <input type="text" placeholder="Please enter you Id" required="required" name="accountId" id="accountId" class="form-control">
                                <span id="idinfo"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="accountPw">비밀번호</label>
                                <input type="password" placeholder="Please enter your password" required="required" name="accountPw" id="accountPw" class="form-control">
                          	    <span class="help-block small">대문자, 소문자, 특수문자가 포함된 10자리 비밀번호</span>
                          	    <span id="passinfo"></span>
                          	    <input type="hidden" name="accountState" id="accountState">
                            </div>
                            <c:if test="${accountState != null && accountState eq '대기' && alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
	                              <span>
	                                 ※ 해당 계정은 승인 대기중인 계정입니다.
	                              </span>
	                           </div>
                            </c:if>
                            <c:if test="${accountState != null && accountState eq '탈퇴' && alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
	                              <span>
	                                 ※ 해당 계정은 탈퇴한 계정입니다.
	                              </span>
	                           </div>
                            </c:if>
                            <br>
                            <button  type="submit" class="btn btn-success btn-block loginbtn" id="loginBtn"><b>Login</b></button>
                            <hr>
                            <a class="btn btn-success  btn-block" href="${pageContext.request.contextPath}/register">회원가입</a>
                            <div style="text-align:right;">
                            	<a class="search"  href="${pageContext.request.contextPath}/searchAccountId">아이디 찾기</a> / 
           						<a class="search"  href="${pageContext.request.contextPath}/searchAccountPw">비밀번호 찾기</a>
							</div>
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
     $('#loginBtn').click(function() {
  		if($('#accountId').val() == '') {
  			$('#idinfo').text('※ 아이디를 입력하세요');
  		} else if($('#accountPw').val() == '') {
  			$('#idinfo').text('');
  			$('#passinfo').text('※ 비밀번호를 입력하세요');
  		} else {
  			$('#loginForm').submit();
  		}
  	}); 
 </script>
</body>

</html>