<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Data Table | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
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
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/educate-custon-icon.css">
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
    <!-- x-editor CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/datetimepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/bootstrap-editable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/editor/x-editor-style.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/data-table/bootstrap-table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/data-table/bootstrap-editable.css">
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
	
	<!-- Start sidebar -->
    <jsp:include page="../inc/sidebar.jsp"/>
    <!-- End sidebar -->
    
    <!-- Start tobbar -->
	<jsp:include page="../inc/topbar.jsp"/>
    <!-- End tobbar --> 
    <br>
    <!-- Static Table Start -->
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <div class="sparkline13-hd">
                                <div class="main-sparkline13-hd">
                                   <c:if test="${memberCheck eq 'student'}">
                                    	<h1>학생 <span class="table-project-n">회원</span>목록</h1>
									</c:if>	
                                </div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId"  data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                            <tr>
                                                <th>아이디</th>
                                                <th>성함</th>
                                                <th>성별</th>
                                                <th>생년월일</th>
                                                <th>가입날짜</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:if test="${memberCheck eq 'student'}">
	                                        	<c:forEach var="s" items="${studentList}">
		                                            <tr>
														<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${s.accountId}">${s.accountId}</a></td>
														<td>${s.studentName}</td>
														<td>${s.studentGender}</td>
														<td>${s.studentBirth}</td>
														<td>${s.createDate}</td>
		                                            </tr>
	                                        	</c:forEach>
                                        	</c:if>
                                        	<c:if test="${memberCheck eq 'teacher'}">
	                                        	<c:forEach var="t" items="${teacherList}">
		                                            <tr>
														<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${t.accountId}">${t.accountId}</a></td>
														<td>${t.teacherName}</td>
														<td>${t.teacherGender}</td>
														<td>${t.teacherBirth}</td>
														<td>${t.createDate}</td>
		                                            </tr>
	                                        	</c:forEach>
                                        	</c:if>
                                        	<c:if test="${memberCheck eq 'manager'}">
	                                        	<c:forEach var="m" items="${managerList}">
		                                            <tr>
														<td><a href="${pageContext.request.contextPath}/loginCheck/memberOne?accountId=${m.accountId}">${m.accountId}</a></td>
														<td>${m.managerName}</td>
														<td>${m.managerGender}</td>
														<td>${m.managerBirth}</td>
														<td>${m.createDate}</td>
		                                            </tr>
	                                        	</c:forEach>
                                        	</c:if>
									</tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	 <!-- Start footer -->
	<jsp:include page="../inc/footer.jsp"/>
    <!-- End footer -->  

	 <!-- Start script -->
	<jsp:include page="../js/alljs.jsp"/>
    <!-- End script -->  
    
</body>

</html>