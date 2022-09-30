<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Departments | Kiaalap - Kiaalap Admin Template</title>
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
   <!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
   <!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

   <!-- Start sidebar -->
   <jsp:include page="/WEB-INF/view/inc/sidebar.jsp" />
   <!-- End sidebar -->

   <!-- Start tobbar -->
   <jsp:include page="/WEB-INF/view/inc/topbar.jsp" />
   <!-- End tobbar -->

    <!-- Start Welcome area -->
       <div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list single-page-breadcome">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu" style="float: left;">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><a href="/lms/loginCheck/noticeList">QnA</a> <span class="bread-slash"></span>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <div class="product-status mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap drp-lst">
                            <h4>Departments List</h4>
                            <div class="add-product">
                                <a href="add-department.html">질문하기</a>
                            </div>
                            <div class="asset-inner">
                                <table>
                                    <tr>
                                        <th>No</th>
                                        <th>Id</th>
                                        <th>Title</th>
                                        <th>State</th>
                                        <th>CreateDate</th>
                                        <th>UpdateDate</th>
                                        <th>Setting</th>
                                    </tr>
                                    <c:forEach var="qna" items="${qnaList}">
                                    <tr>
                                        <td><a href="${pageContext.request.contextPath}/loginCheck/qnaOne?qnaNo=${qna.qnaNo}">${qna.qnaNo}</a></td>
                                        <td>${qna.accountId}</td>
                                        <td><a href="${pageContext.request.contextPath}/loginCheck/qnaOne?qnaNo=${qna.qnaNo}">${qna.qnaTitle}</a></td>
                                        <td>
                                        	<button class="pd-setting"> 대기중 </button>
											<button class="pd-setting"> 답변완료 </button>	 
                                        </td>
                                        <td>${qna.createDate}</td>
                                        <td>${qna.updateDate}</td>
                                        <td>
                                            <c:if test="${accountId eq notice.accountId}"> 
                                    		<a class="btn btn-primary"  type="button" data-toggle="tooltip" title="Edit" class="pd-setting-ed" 
                                    		href="${pageContext.request.contextPath}/loginCheck/modifyQnaForm?qnaNo=${qna.qnaNo}">
                                            <i class="fa fa-pencil-square-o" aria-hidden="true" ></i></a>
                                            </c:if>
                                            <c:if test="${userLevel eq 4 || accountId eq notice.accountId}"> 
                                            <a class="btn btn-primary"  type="button" data-toggle="tooltip" title="Trash" class="pd-setting-ed" 
                                            href="${pageContext.request.contextPath}/loginCheck/removeQna?qnaNo=${qna.qnaNo}">
                                            <i class="fa fa-trash-o" aria-hidden="true" ></i></a>
                                            </c:if>
                                        </td>
                                    </tr>
                                   	</c:forEach>
                                </table>
                            </div>
                            <!-- 
                            <div class="custom-pagination">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                        <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                    </ul>
                                </nav>
                            </div>
                             -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- footer -->
	<jsp:include page="../inc/footer.jsp" />

<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

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
   <!-- morrisjs JS
      ============================================ -->
   <script src="${pageContext.request.contextPath}/js/sparkline/jquery.sparkline.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/sparkline/jquery.charts-sparkline.js"></script>
   <!-- calendar JS
      ============================================ -->
   <script src="${pageContext.request.contextPath}/js/calendar/moment.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/calendar/fullcalendar.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/calendar/fullcalendar-active.js"></script>
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