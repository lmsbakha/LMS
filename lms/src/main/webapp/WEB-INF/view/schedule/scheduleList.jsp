<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Event | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
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
    <script src="${pageContext.request.contextPath}/s/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
 	<!-- Start sidebar -->
	<jsp:include page="../inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="../inc/topbar.jsp" />
	<!-- End tobbar -->       
            <div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                            <form role="search" class="sr-input-func">
                                                <input type="text" placeholder="Search..." class="search-int form-control">
                                                <a href="#"><i class="fa fa-search"></i></a>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><span class="bread-blod">Events</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <div class="calender-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="calender-inner">
                            <div id='calendar'></div>
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
    <!-- morrisjs JS
		============================================ -->
    <script src="${pageContext.request.contextPath}/js/sparkline/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/sparkline/jquery.charts-sparkline.js"></script>
    <script src="${pageContext.request.contextPath}/js/sparkline/sparkline-active.js"></script>
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