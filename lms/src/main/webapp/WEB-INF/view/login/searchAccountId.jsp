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
				<h3>????????? ??????</h3>
				<p>????????? ???????????? ??????????????????</p>
			</div>
			<div class="content-error">
			<!-- memberCheck ?????? -->
				<ul class="nav nav-tabs nav-justified">
				    <li class="nav-item">
				      <c:choose>
				      	 <c:when test="${memberCheck eq 'student'}">
				     		<a class="nav-link active" href="${pageContext.request.contextPath}/searchAccountId?memberCheck=student">??????</a>
				     	 </c:when>	
				     	 <c:otherwise>
				     	 	<a class="nav-link" href="${pageContext.request.contextPath}/searchAccountId?memberCheck=student">??????</a>
					    </c:otherwise>
				      </c:choose>
				    </li>
				    <li class="nav-item">
				      <c:choose>
				      	 <c:when test="${memberCheck eq 'teacher'}">
				     		<a class="nav-link active" href="${pageContext.request.contextPath}/searchAccountId?memberCheck=teacher">??????</a>
				     	 </c:when>	
				     	 <c:otherwise>
				     	 	<a class="nav-link" href="${pageContext.request.contextPath}/searchAccountId?memberCheck=teacher">??????</a>
					    </c:otherwise>
				      </c:choose>
				    </li>
				    <li class="nav-item">
				     <c:choose>
				      	 <c:when test="${memberCheck eq 'manager'}">
				     		<a class="nav-link active" href="${pageContext.request.contextPath}/searchAccountId?memberCheck=manager">??????</a>
				     	 </c:when>	
				     	 <c:otherwise>
				     	 	<a class="nav-link" href="${pageContext.request.contextPath}/searchAccountId?memberCheck=manager">??????</a>
					    </c:otherwise>
				      </c:choose>
				    </li>
			 	 </ul>
				<div class="hpanel">
                    <div class="panel-body poss-recover">
                        <form action="${pageContext.request.contextPath}/searchAccountId" method="post" id="searchAccountIdForm">
                        	<c:if test="${resultMsg eq null}">
                             <div class="form-group">
                                <label class="control-label" for="memberName">Name</label>
                              	<input type="hidden" name="memberCheck" id="memberCheck" value="${memberCheck}">
                                <input type="text" placeholder="Enter your name..."  name="memberName" id="memberName" class="form-control">
                                <span class="help-block small" id="nameinfo"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="memberEmail">Email</label>
                                <input type="email" placeholder="example@gmail.com"  name="memberEmail" id="memberEmail" class="form-control">
                                <span class="help-block small" id="eminfo"></span>
                            </div>
                            	<button type="button" class="btn btn-success-search btn-block" id="searchBtn">????????? ??????</button>
                            	<hr>
                           	 	<button type="button" class="btn btn-success btn-block" onclick="location.href='${pageContext.request.contextPath}/bakha/login'">????????? ????????????</button>
                            </c:if>
                            </form>
                             <c:if test="${resultMsg != null}">
                       			<c:choose>
					   				<c:when test="${resultMsg eq 'false' || alertMsg eq 'Fail'}">
				                           <div class="alert alert-danger alert-mg-b alert-success-style4">
				                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
				                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
				                              </button>
				                              <i class="fa fa-times edu-danger-error admin-check-pro" aria-hidden="true"></i>
				                              <span>
				                                 ??? ???????????? ????????? ???????????? ???????????? ????????????.
				                              </span>
				                           </div>
					   					<a class="btn btn-success btn-block" style="color:white; " href="${pageContext.request.contextPath}/searchAccountId">????????? ????????????</a>
					   				</c:when>
					   				 <c:otherwise>
					   				 	<c:if test="${alertMsg eq 'Success'}">
				                           <div class="alert alert-success alert-success-style1">
				                              <button type="button" class="close sucess-op" data-dismiss="alert" aria-label="Close">
				                                 <span class="icon-sc-cl" aria-hidden="true">&times;</span>
				                              </button>
				                              <i class="fa fa-check edu-checked-pro admin-check-pro" aria-hidden="true"></i>
				                              <span>
				                                 ??? ???????????? ???????????? <b style="font-size:20px;">"${resultMsg}"</b> ?????????.
				                              </span>
				                           </div>
				                        </c:if>
					   				 	<br>
					   				 	<a class="btn btn-success-search btn-block" style="color:white;" href="${pageContext.request.contextPath}/searchAccountPw">???????????? ??????</a>
					   				 	<hr>
					   				 	<a class="btn btn-success btn-block" style="color:white;" href="${pageContext.request.contextPath}/bakha/login">????????? ????????????</a>
					   				 </c:otherwise>
					   			</c:choose>
                        	</c:if>
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
    var reg_email = /^[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\w+\.)+\w+$/;
    
    // ???????????????
    $('#memberName').blur(function() {
		if ($('#memberName').val() == '') {
			$('#nameinfo').text('??? ????????? ????????? ?????????.');
		} else {
			$('#nameinfo').text('');
		}
	})
    
    $('#memberEmail').blur(function() {
		if ($('#memberEmail').val() == '') {
			$('#eminfo').text('??? ???????????? ????????? ?????????.');
		} else if (!reg_email.test($("#memberEmail").val())) {
			$('#memberEmail').val('');
			$('#eminfo').text('??? ????????? ????????? ????????????.');
		} else {
			$('#eminfo').text('');
		}
	})
	
	// ?????? ???????????????
	$('#searchBtn').click(function(){
		if($('#memberName').val() == ''){
			$('#nameinfo').text('??? ????????? ????????? ?????????.');
			$('#memberName').focus();
			if(reg_email.test($("#memberEmail").val())){
				 $('#memberName').focus();
			}
		} else if($('#memberEmail').val() == ''){
			$('#nameinfo').text('');
			$('#eminfo').text('??? ???????????? ????????? ?????????.');
			$("#memberEmail").focus();
		} else if(!reg_email.test($("#memberEmail").val())){
			$('#nameinfo').text('');
			$('#eminfo').text('??? ????????? ????????? ????????????.');
			$("#memberEmail").focus();
		} else {
			$('#searchAccountIdForm').submit();
		}
	})
	
	// Enter??? ???????????????
	$(document).keypress(function(e) {
		if (e.which == 13) {
			event.preventDefault();
			if($('#memberName').val() == ''){
				$('#nameinfo').text('??? ????????? ????????? ?????????.');
				$('#memberName').focus();
			 	if(reg_email.test($("#memberEmail").val())){
					 $('#memberName').focus();
				}
			} else if($('#memberEmail').val() == ''){
				$('#memberEmail').val('');
				$('#eminfo').text('??? ???????????? ????????? ?????????.');
				$('#memberEmail').focus();
			}else if(!reg_email.test($("#memberEmail").val())){
				$('#memberEmail').val('');
				$('#eminfo').text('??? ????????? ????????? ????????????.');
				$("#memberEmail").focus();
			} else {
				$('#searchAccountIdForm').submit();
			}
		}
	});
	
    </script>
</body>

</html>