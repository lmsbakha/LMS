<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Lock | Kiaalap - Kiaalap Admin Template</title>
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
			<div class="hpanel">
				<div class="panel-body text-center lock-inner">
					<i class="fa fa-lock" aria-hidden="true"></i>
					<br/>
					<c:choose>
					<c:when test="${path eq 'modifyAccountPw'}">
					<h4><span class="text-success">본인 확인</span><strong>을 위해 비밀번호를 입력해 주세요.</strong></h4>
					<form id="checkPwForm" action="${pageContext.request.contextPath}/loginCheck/checkAccountPw?path=modifyAccountPw" class="m-t" method="post">
						<div class="form-group">
							<input type="text" name="accountId" value="${accountId}"  readonly="readonly" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" id="accountPw" name="accountPw"  placeholder="******" class="form-control">
						</div>
						<div style="text-align:left; font-size:17px;">
						<span id="pwinfo"></span>
						</div>
						<br>
						<c:if test="${alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <span>
	                                 ※ 정보가 일치하지 않습니다. 비밀번호를 확인해주세요.
	                              </span>
	                           </div>
		   				</c:if>
						<button id="checkBtn" class="btn btn-primary btn-block" type="button">본인 확인</button><br>
						<button class="btn btn-success btn-block" type="button" onclick="history.back();">돌아 가기</button>
					</form>
					</c:when>
					<c:when test="${path eq 'modifyMember'}">
					<h4><span class="text-success">본인 확인</span><strong>을 위해 비밀번호를 입력해 주세요.</strong></h4>
					<form id="checkPwForm" action="${pageContext.request.contextPath}/loginCheck/checkAccountPw?path=modifyMember" class="m-t" method="post">
						<div class="form-group">
							<input type="text" name="accountId" value="${accountId}"  readonly="readonly" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" id="accountPw" name="accountPw"  placeholder="******" class="form-control">
						</div>
						<span id="pwinfo"></span>
						<br>
						<c:if test="${alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <span>
	                                 ※ 정보가 일치하지 않습니다. 비밀번호를 확인해주세요.
	                              </span>
	                           </div>
		   				</c:if>
						<button id="checkBtn" class="btn btn-primary btn-block" type="button">본인 확인</button><br>
						<button class="btn btn-success btn-block" type="button" onclick="history.back();">돌아 가기</button>
					</form>
					</c:when>
					<c:when test="${path eq 'removeMember'}">
					<h4><span class="text-success">회원 탈퇴</span><strong>를 위해 비밀번호를 입력해 주세요.</strong></h4>
					<form id="checkPwForm" action="${pageContext.request.contextPath}/loginCheck/checkAccountPw?path=removeMember" class="m-t" method="post">
						<div class="form-group">
							<input type="text" name="accountId" value="${accountId}" readonly="readonly" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" id="accountPw" name="accountPw"  placeholder="******" class="form-control">
						</div>
						<span id="pwinfo"></span>
						<br>
						<c:if test="${alertMsg eq 'Fail'}">
	                           <div class="alert alert-danger alert-mg-b alert-success-style4">
	                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
	                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
	                              </button>
	                              <span>
	                                 ※ 정보가 일치하지 않습니다. 비밀번호를 확인해주세요.
	                              </span>
	                           </div>
		   				</c:if>
						<button id="checkBtn" class="btn btn-primary btn-block" type="button">본인 확인</button><br>
						<button class="btn btn-success btn-block" type="button" onclick="history.back();">돌아 가기</button>
					</form>
					</c:when>
					</c:choose>
				</div>
			</div>
			<div class="text-center login-footer">
				<p>Copyright © 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
			</div>
		</div>   
	</div>
	
	<!-- Start script -->
	<jsp:include page="../js/alljs.jsp" />
	<!-- End script -->
	
	<script>
    // 유효성검사
    $('#accountPw').blur(function() {
		if ($('#accountPW').val() == '') {
			$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
		} else {
			$('#pwinfo').text('');
		}
	})
	
	// 버튼 유효성 검사
	$('#checkBtn').click(function(){
		if($('#accountPw').val() == ''){
			$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
			$('#accountPw').focus();
		} else {
			$('#pwinfo').text('');
			$('#checkPwForm').submit();
		}
	})
	
	// Enter키 유효성검사
	$(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if($('#accountPw').val() == ''){
				$('#pwinfo').text('※ 비밀번호를 입력해 주세요.');
				$('#accountPw').focus();
			} else {
				$('#pwinfo').text('');
				$('#checkPwForm').submit();
			}
		}
	});
	</script>
	
</body>

</html>