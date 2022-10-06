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
			<div class="text-center m-b-md custom-login">
				<h3>Bakha LMS</h3>
			</div>
			<div class="login-error">
				<div class="hpanel">
                    <div class="panel-body">
                        <form method="post" action="${pageContext.request.contextPath}/login" id="loginForm">
                            <div class="form-group">
                                <label class="control-label" for="accountId">아이디</label>
                                <input type="text" placeholder="Please enter you Id" name="accountId" id="accountId" class="form-control" value="admin">
                                <span id="idinfo"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="accountPw">비밀번호</label>
                                <input type="password" placeholder="Please enter your password"  name="accountPw" id="accountPw" class="form-control" value="1234">
                          	    <span class="help-block small">대문자, 소문자, 특수문자가 포함된 10자리 비밀번호</span>
                          	    <span id="passinfo"></span>
                          	    <input type="hidden" name="accountState" id="accountState">
                            </div>
                             <c:if test="${later eq 'Success'}">
	                           <div class="alert alert-success alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                               <h4> ※ 비밀번호 변경 기간이 3개월 연장되었습니다.<br><br>
	                               		  &nbsp;&nbsp;&nbsp;다시 로그인 부탁드립니다.</h4>
	                           </div>
                            </c:if>
                            <c:if test="${accountState == null && alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
	                              <span>
	                                 ※ 아이디와 비밀번호를 확인해주세요.
	                              </span>
	                           </div>
                            </c:if>
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
                            <c:if test="${accountState != null && accountState eq '거절' && alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
	                              <span>
	                                 ※ 해당 계정은 승인 거절된 계정입니다.
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
                            <button  type="button" class="btn btn-success btn-block loginbtn" id="loginBtn"><b>Login</b></button>
                            <hr>
                            <a class="btn btn-success  btn-block" href="${pageContext.request.contextPath}/register">회원가입</a>
                            <div style="text-align:right;">
                            	<a class="search"  href="${pageContext.request.contextPath}/searchAccountId">아이디 찾기</a> / 
           						<a class="search"  href="${pageContext.request.contextPath}/searchAccountPw">비밀번호 찾기</a>
							</div>
							<div>
								<p>[학생 대표 계정] ID: student PW:1234  </p>
								<p>[강사 대표 계정] ID: teacher PW:1234  </p>
								<p>[행정 대표 계정] ID: manager PW:1234  </p>
								<p>[총 관리자 계정] ID: admin PW:1234  </p>
							</div>
						</form>
						<c:if test="${ msg != null}">
                    	  <div class="alert alert-warning alert-st-three" role="alert">
                            <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
										<span class="icon-sc-cl" aria-hidden="true">×</span>
							</button>
                             <h4>
                              <i class="fa fa-exclamation-triangle edu-warning-danger admin-check-pro admin-check-pro-none" aria-hidden="true"></i>&nbsp;비밀번호를 변경한지 3개월이 지났습니다.
                              <br>
                              <br>
                             </h4>
                             <h4>&nbsp;&nbsp;&nbsp;&nbsp;회원님의 개인정보를 위해 비밀번호를 변경하시겠습니까?</h4>  
                             <br>
                              <div style="text-align:right;">
                            	<a  class="btn btn-primary"  href="${pageContext.request.contextPath}/laterAccountPw?later=yes&accountId=${accountId}">3개월 연장하기</a>&nbsp;
           						<a type="button" class="btn btn-success"  href="${pageContext.request.contextPath}/laterAccountPw?later=no&accountId=${accountId}">비밀번호 변경하기</a>
							</div>
                          </div>
                       </c:if>
                    </div>
                </div>
			</div>
			<br>
			<br>
			<br>
			<div class="text-center login-footer">
				<p>Copyright © 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
			</div>
		</div>   
    </div>
	 <!-- Start script -->
	<jsp:include page="../js/alljs.jsp"/>
    <!-- End script --> 
    
    <script>
    // 버튼 유효성검사
    $('#loginBtn').click(function() {
  		if($('#accountId').val() == '') {
  			$('#idinfo').text('※ 아이디를 입력하세요');
  			$('#accountId').focus();
  		} else if($('#accountPw').val() == '') {
  			$('#idinfo').text('');
  			$('#passinfo').text('※ 비밀번호를 입력하세요');
  			$('#accountPw').focus();
  		} else {
  			$('#loginForm').submit();
  		}
  	}); 
    
    // Enter키 유효성검사
    $(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if($('#accountId').val() == '') {
	  			$('#idinfo').text('※ 아이디를 입력하세요');
	  			$('#accountId').focus();
	  		} else if($('#accountPw').val() == '') {
	  			$('#idinfo').text('');
	  			$('#passinfo').text('※ 비밀번호를 입력하세요');
	  			$('#accountPw').focus();
	  		} else {
	  			$('#loginForm').submit();
	  		}	
		}
	});		
 </script>
</body>

</html>