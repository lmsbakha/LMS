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
                                        <ul class="breadcome-menu" style="float: left;">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><a href="/lms/loginCheck/QnAList">QnA</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li>상세보기 <span class="bread-slash"></span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         <div class="blog-details-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="blog-details-inner">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="latest-blog-single blog-single-full-view">
                                        <div class="blog-details blog-sig-details">
				                            <h4>QnA Detail</h4>
				                            <hr>
                                            <h1>질문: ${qnaQuestion.qnaQuestionTitle}</h1>
                                            <p> 작성자: ${qnaQuestion.accountId}</p>
                                            <hr>
                                            <div style="font-size:12px; text-align:right;">작성일: ${qnaQuestion.createDate}</div>
                                            <div style="font-size:12px; text-align:right;">수정일: ${qnaQuestion.updateDate}</div>
                                            
                                            <label for="noticeContent">질문</label>
                                            <p>${qnaQuestion.qnaQuestionContent}</p>
                                            <br>
                                            <hr>
                                            <br>
                                        </div>
                                    </div>
                                </div>
                            </div>
               			 </div> 
               			 <div class="add-product">
                              <a href="/lms/loginCheck/QnAList">목록으로</a>
                 		</div>
               		</div>
                 </div>  
            </div>
        </div>
        <div class="blog-details-area mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="blog-details-inner">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <div class="latest-blog-single blog-single-full-view">
                                        <div class="blog-details blog-sig-details">
       										<c:if test="${qnaAnswer.qnaAnswerTitle != null}">
	                                        <div class="blog-details blog-sig-details">
	                                            <h1>답변: ${qnaAnswer.qnaAnswerTitle}</h1>
	                                            <p>작성자: ${qnaAnswer.accountId}</p>
	                                            <hr>
	                                            <div style="font-size:12px; text-align:right;">작성일: ${qnaAnswer.createDate}</div>
	                                            <div style="font-size:12px; text-align:right;">수정일: ${qnaAnswer.updateDate}</div>
	                                            <label for="noticeContent">답변</label>
	                                            <p>${qnaAnswer.qnaAnswerContent}</p>
	                                            <br>
	                                            <hr>
                                        	</div>
                                       </c:if> 
                                       <c:if test="${qnaAnswer.qnaAnswerTitle eq null}">
                                    	 <form action="${pageContext.request.contextPath}/loginCheck/addQnaAnswer" class="dropzone dropzone-custom needsclick add-professors dz-clickable" id="addQnaAnswerForm" method="post" >
                                     		<div class="row">
                                              <div class="form-group edit-ta-resize res-mg-t-15">
                                                <div class="form-group">
                                                <h4> 답변 작성하기</h4>
                                                <hr>
                                                   <label for="qnaAnswerTitle">제목</label> <input name="qnaAnswerTitle" id="qnaAnswerTitle" type="text" class="form-control">
                                                    <input name="qnaNo" type="hidden" value="${qnaQuestionNo}">
                                                 </div>
                                                 <div class="form-group edit-ta-resize res-mg-t-15">
                                                    <label for="qnaAnswerContent">본문</label> <textarea name="qnaAnswerContent" id="qnaAnswerContent"  class="form-control" style="resize: none;"></textarea>
                                                 </div>
                                               </div>
                                           </div>	
										<div class="form-group col-lg-12">
					                		<div class="row">
                                                         <div class="col-lg-12">
                                                             <div class="payment-adress">
                                                             	<c:if test="${userLevel gt 1}">
                                                                 <button type="submit" id="addQnaAnswerSubmit" class="btn btn-primary waves-effect waves-light">제출</button>
                                                                 </c:if>
                                                             </div>
                                                         </div>
                                                 	</div>
                                                </div>
                                          </form>
                                    </c:if>
								</div>
							</div>
						</div>
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
<script>

$('#addQnaAnswerSubmit').click(function() {
	if ($('#qnaAnswerTitle').val() == '') {
		alert("제목을 입력해 주세요.");
		$('#qnaAnswerTitle').focus();
		return false;
	}
});
$('#addQnaAnswerSubmit').click(function() {
	if ($('#qnaAnswerContent').val() == '') {
		alert('내용을 입력해주세요.');
		$('#qnaAnswerContent').focus();
		return false;
	}
});


</script>
</html>