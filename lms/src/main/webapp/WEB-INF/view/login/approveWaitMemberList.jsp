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

        <!-- Static Table Start -->
        <div class="data-table-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <div class="sparkline13-hd">
                                <div class="main-sparkline13-hd">
                                    <h1>Projects <span class="table-project-n">Data</span> Table</h1>
                                </div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="datatable-dashv1-list custom-datatable-overright">
                                    <div id="toolbar">
                                        <select style="font-size:15px;" name="select" id="viewProduct" onchange="window.open(value,'_self');">
											<c:if test="${memberCheck eq 'all'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=all"
													selected>전체 리스트</option>
											</c:if>
											<c:if test="${memberCheck != 'all'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=all"
															>전체 리스트</option>
											</c:if>	
											<c:if test="${memberCheck eq 'student'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=student"
													selected>학생 리스트</option>
											</c:if>
											<c:if test="${memberCheck != 'student'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=student"
															>학생 리스트</option>
											</c:if>	
											<c:if test="${memberCheck eq 'teacher'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=teacher"
													selected>강사 리스트</option>
											</c:if>
											<c:if test="${memberCheck != 'teacher'}">	
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=teacher"
															>강사 리스트</option>
											</c:if>
											<c:if test="${memberCheck eq 'manager'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=manager"
													selected>행정 리스트</option>
											</c:if>
											<c:if test="${memberCheck != 'manager'}">
												<option value="${pageContext.request.contextPath}/loginCheck/approveWaitMemberList?memberCheck=manager"
															>행정 리스트</option>
											</c:if>	
									</select>
										<input type="hidden" name="memberCheck" id="memberCheck" value="${memberCheck}">
                                    </div>
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="true" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="true" data-show-toggle="true" data-resizable="true" data-cookie="true"
                                        data-cookie-id-table="saveId"  data-click-to-select="true" data-toolbar="#toolbar">
                                        <thead>
                                            <tr>
                                                <th>아이디</th>
                                                <th>성함</th>
                                                <th>성별</th>
                                                <th>생년월일</th>
                                                <th>이메일</th>
                                                <th>전화번호</th>
                                                <th>가입날짜</th>
                                                <th>가입 승인 / 가입 거부</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:if test="${memberCheck eq 'all'}">
                                        	<c:forEach var="s" items="${studentList}">
                                            <tr>
												<td>${s.accountId}</td>
												<td>${s.studentName}</td>
												<td>${s.studentGender}</td>
												<td>${s.studentBirth}</td>
												<td>${s.studentEmail}</td>
												<td>${s.studentPhone}</td>
												<td>${s.createDate}</td>
												<td><button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyApproveWaitMemberList?accountId=${s.accountId}'"><i class="fa fa-check edu-checked-pro" aria-hidden="true"></i></button>
                                                 <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyDeniedWaitMemberList?accountId=${s.accountId}'"><i class="fa fa-times edu-danger-error" aria-hidden="true"></i></button>
                                                </td>
                                            </tr>
                                        	</c:forEach>
                                        	<c:forEach var="t" items="${teacherList}">
												<tr>
													<td>${t.accountId}</td>
													<td>${t.teacherName}</td>
													<td>${t.teacherGender}</td>
													<td>${t.teacherBirth}</td>
													<td>${t.teacherEmail}</td>
													<td>${t.teacherPhone}</td>
													<td>${t.createDate}</td>
													<td><button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyApproveWaitMemberList?accountId=${t.accountId}'"><i class="fa fa-check edu-checked-pro" aria-hidden="true"></i></button>
	                                                 	<button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyDeniedWaitMemberList?accountId=${t.accountId}'"><i class="fa fa-times edu-danger-error" aria-hidden="true"></i></button>
	                                                </td>
												</tr>
											</c:forEach>
											<c:forEach var="m" items="${managerList}">
												<tr>
													<td>${m.accountId}</td>
													<td>${m.managerName}</td>
													<td>${m.managerGender}</td>
													<td>${m.managerBirth}</td>
													<td>${m.managerEmail}</td>
													<td>${m.managerPhone}</td>
													<td>${m.createDate}</td>
													<td><button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyApproveWaitMemberList?accountId=${m.accountId}'"><i class="fa fa-check edu-checked-pro" aria-hidden="true"></i></button>
	                                                	 <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyDeniedWaitMemberList?accountId=${m.accountId}'"><i class="fa fa-times edu-danger-error" aria-hidden="true"></i></button>
	                                                </td>
												</tr>
											</c:forEach>
                                        </c:if>
                                        <c:if test="${memberCheck eq 'student'}">
                                        	<c:forEach var="s" items="${studentList}">
                                            <tr>
												<td>${s.accountId}</td>
												<td>${s.studentName}</td>
												<td>${s.studentGender}</td>
												<td>${s.studentBirth}</td>
												<td>${s.studentEmail}</td>
												<td>${s.studentPhone}</td>
												<td>${s.createDate}</td>
												<td><button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyApproveWaitMemberList?accountId=${s.accountId}'"><i class="fa fa-check edu-checked-pro" aria-hidden="true"></i></button>
                                                 <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyDeniedWaitMemberList?accountId=${s.accountId}'"><i class="fa fa-times edu-danger-error" aria-hidden="true"></i></button>
                                                </td>
                                            </tr>
                                        	</c:forEach>
                                        </c:if>
										<c:if test="${memberCheck eq 'teacher'}">
											<c:forEach var="t" items="${teacherList}">
												<tr>
													<td>${t.accountId}</td>
													<td>${t.teacherName}</td>
													<td>${t.teacherGender}</td>
													<td>${t.teacherBirth}</td>
													<td>${t.teacherEmail}</td>
													<td>${t.teacherPhone}</td>
													<td>${t.createDate}</td>
													<td><button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyApproveWaitMemberList?accountId=${t.accountId}'"><i class="fa fa-check edu-checked-pro" aria-hidden="true"></i></button>
	                                                 	<button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyDeniedWaitMemberList?accountId=${t.accountId}'"><i class="fa fa-times edu-danger-error" aria-hidden="true"></i></button>
	                                                </td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${memberCheck eq 'manager'}">
											<c:forEach var="m" items="${managerList}">
												<tr>
													<td>${m.accountId}</td>
													<td>${m.managerName}</td>
													<td>${m.managerGender}</td>
													<td>${m.managerBirth}</td>
													<td>${m.managerEmail}</td>
													<td>${m.managerPhone}</td>
													<td>${m.createDate}</td>
													<td><button type="button" class="btn btn-primary"  onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyApproveWaitMemberList?accountId=${m.accountId}'"><i class="fa fa-check edu-checked-pro" aria-hidden="true"></i></button>
	                                                	 <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/loginCheck/modifyDeniedWaitMemberList?accountId=${m.accountId}'"><i class="fa fa-times edu-danger-error" aria-hidden="true"></i></button>
	                                                </td>
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

    <!-- jquery
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/metisMenu/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/metisMenu/metisMenu-active.js"></script>
    <!-- data table JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/data-table/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/tableExport.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/data-table-active.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/bootstrap-table-editable.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/bootstrap-editable.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/bootstrap-table-resizable.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/colResizable-1.5.source.js"></script>
    <script src="${pageContext.request.contextPath}/js/data-table/bootstrap-table-export.js"></script>
    <!--  editable JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/editable/jquery.mockjax.js"></script>
    <script src="${pageContext.request.contextPath}/js/editable/mock-active.js"></script>
    <script src="${pageContext.request.contextPath}/js/editable/select2.js"></script>
    <script src="${pageContext.request.contextPath}/js/editable/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/editable/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/editable/bootstrap-editable.js"></script>
    <script src="${pageContext.request.contextPath}/js/editable/xediable-active.js"></script>
    <!-- Chart JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/chart/jquery.peity.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/peity/peity-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/tab.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
    <!-- tawk chat JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/tawk-chat.js"></script>
</body>

</html>