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
				<h3>?????? ?????? ????????? ??????</h3>
				<p>???????????? ??????????????? ??????????????????</p>
			</div>
			<div class="content-error">
				<div class="hpanel">
                    <div class="panel-body poss-recover">
                        <form action="${pageContext.request.contextPath}/accountStateMember" method="post" id="stateMemberForm">
                             <div class="form-group">
                                <label class="control-label" for="accountId">Id</label>
                                <input type="text" placeholder="Enter your Id..."  required="required"  name="accountId" id="accountId" class="form-control">
                                <span class="help-block small" id="idinfo"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="accountPw">PassWord</label>
                                <input type="password" placeholder="Enter your password..."  required="required"  name="accountPw" id="accountPw" class="form-control">
                                <span class="help-block small" id="pwinfo"></span>
                            </div>
                            <c:if test="${alertMsg eq 'Fail'}">
			               	<div class="alert alert-danger alert-mg-b alert-success-style4">
			                	<button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
			                    	<span class="icon-sc-cl" aria-hidden="true">&times;</span>
			                    </button>
			                    <i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
	                            <span>
	                              ??? ?????? ????????? ??????????????????. ???????????? ??????????????? ??????????????????.
	                            </span>
			                </div>
				   		   </c:if>	
                           <br>
                            	<button type="button" id="stateBtn" class="btn btn-success-search btn-block">?????? ????????? ??????</button>
                           </form>
                    </div>
                </div>
			</div>
			<div class="text-center login-footer">
				<p>Copyright ?? 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
			</div>
		</div>   
    </div>
    
	 <!-- Start script -->
	<jsp:include page="../js/alljs.jsp"/>
    <!-- End script --> 
    
    <script>
    var reg_pass = /(?=.*[A-Z])(?=.*[0-9])(?=.*[^\w]).{8,}/;
    
    // ???????????????
    $('#accountId').blur(function() {
		if ($('#accountId').val() == '') {
			$('#idinfo').text('??? ???????????? ????????? ?????????.');
		} else {
			$('#idinfo').text('');
		}
	})
    
	$('#accountPw').blur(function() {
		if ($('#accountPw').val() == '') {
			$('#pwinfo').text('??? ??????????????? ????????? ?????????.');
		} else if (!reg_pass.test($("#accountPw").val())) {
			$('#accountPw').val('');
			$('#pwinfo').text('??? ????????? 8?????? ???????????? 1?????? + ?????? 1?????? + ???????????? 1?????? ????????? ?????????.');
		} else {
			$('#pwinfo').text('');
		}
	})
	
	// ?????? ???????????????
	$('#stateBtn').click(function(){
		if($('#accountId').val() == ''){
			$('#idinfo').text('??? ???????????? ????????? ?????????.');
			$('#accountId').focus();
			if(reg_pass.test($("#accountPw").val())){
				 $('#accountId').focus();
			}
		} else if($('#accountPw').val() == ''){
			$('#idinfo').text('');
			$('#pwinfo').text('??? ??????????????? ????????? ?????????.');
			$("#accountPw").focus();
		} else if(!reg_pass.test($("#accountPw").val())){
			$('#idinfo').text('');
			$('#pwinfo').text('??? ????????? 8?????? ???????????? 1?????? + ?????? 1?????? + ???????????? 1?????? ????????? ?????????.');
			$("#accountPw").focus();
		} else {
			$('#stateMemberForm').submit();
		}
	})
	
	// Enter??? ???????????????
	$(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if($('#accountId').val() == ''){
				$('#idinfo').text('??? ???????????? ????????? ?????????.');
				$('#accountId').focus();
				if(reg_pass.test($("#accountPw").val())){
					 $('#accountId').focus();
				}
			} else if($('#accountPw').val() == ''){
				$('#pwinfo').text('');
				$('#pwinfo').text('??? ??????????????? ????????? ?????????.');
				$("#accountPw").focus();
			} else if(!reg_pass.test($("#accountPw").val())){
				$('#idinfo').text('');
				$('#pwinfo').text('??? ????????? 8?????? ???????????? 1?????? + ?????? 1?????? + ???????????? 1?????? ????????? ?????????.');
				$("#accountPw").focus();
			} else {
				$('#stateMemberForm').submit();
			}
		}
	});
    
	
    </script>
    
</body>

</html>