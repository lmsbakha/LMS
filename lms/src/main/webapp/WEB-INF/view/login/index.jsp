<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<!-- buttons CSS
		============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/buttons.css">
<!-- modals CSS
		============================================ -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/modals.css"> 
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
   <jsp:include page="../inc/sidebar.jsp" />
   <!-- End sidebar -->

   <!-- Start tobbar -->
   <jsp:include page="../inc/topbar.jsp" />
   <!-- End tobbar -->


   <div class="header-advance-area">
      <div class="breadcome-area">
         <div class="container-fluid">
            <div class="row">
               <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                  <div class="breadcome-list single-page-breadcome">
                     <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                           <div class="breadcome-list single-page-breadcome">
                              <div class="sparkline12-graph">
                                 <div class="basic-login-form-ad">
                                    <div class="row">
                                       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                          <iframe width="100%" height="245" src="https://forecast.io/embed/#lat=37.5662&lon=126.9785&name=??????&color=#F6A8A6&font=arial&units=si" frameborder="0"></iframe>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
                           <div class="breadcome-list single-page-breadcome">
                              <div class="sparkline12-graph">
                                 <div class="basic-login-form-ad">
                                    <div class="row">
                                       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                          <iframe id="pageFrame" name="pageFrame" src="http://www.jobkorea.co.kr/Starter/calendar/sub/week" frameborder="0" width="100%" height="335px" scrolling="auto"></iframe>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>

   <div class="header-advance-area">
      <div class="breadcome-area">
         <div class="container-fluid">
            <div class="row">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<div class="calender-inner">
						<c:if test="${sessionLevel < 3}">
							<h1>${lectureName}?????????</h1>
						</c:if>
						<c:if test="${sessionLevel > 2}">
							<h1>?????? ?????????</h1>
						</c:if>
						<div class="table-responsive">
							<h2 style="text-align: center; font-size:50px;">${year}.${month}</h2>
								<div>
								<a class="btn btn-custon-rounded-three btn-success"
									href="${pageContext.request.contextPath}/loginCheck/index?year=${year}&month=${month-1}">?????????</a>&nbsp;&nbsp;
								<a class="btn btn-custon-rounded-three btn-success"
									href="${pageContext.request.contextPath}/loginCheck/index?year=${year}&month=${month+1}">?????????</a>
								</div>
								<div class="text-right">
									<c:if test="${sessionLevel > 2}">
										<div class="modal-area-button">
											<a class="Warning Warning-color mg-b-10" href="#" data-toggle="modal" data-target="#addScheduleModal">????????? ??????</a>
										</div>
										<div id="addScheduleModal" class="modal modal-edu-general Customwidth-popup-WarningModal fade" role="dialog">
			                            <div class="modal-dialog">
			                                <div class="modal-content">
			                                    <div class="modal-close-area modal-close-df">
			                                        <a class="close" data-dismiss="modal"  id="close"><i class="fa fa-close"></i></a>
			                                    </div>
			                                    <form id="addScheduleForm" action="${pageContext.request.contextPath}/loginCheck/addSchedule" method="post">
				                                    <div class="modal-body">
				                                    	<hr>
				                                    	<h2 style="text-align:center;">????????? ??????</h2>
				                                    	<span id="addScheduleHelper"></span>
														<div>
															???????????? : <input id="scheduleStartDate" type="date"
																name="scheduleStartDate">
														</div>
														<div>
															???????????? : <input id="scheduleEndDate" type="date"
																name="scheduleEndDate">
														</div>
														<label for="lectureSubjectNo">?????? ??????</label>&nbsp;&nbsp;&nbsp;&nbsp;
														 <select id="lectureSubjectNo" name="lectureSubjectNo">
																<option value="default" selected>[??????]????????? ???????????????.</option>
																<c:forEach var="ls" items="${lectureSubjectList}">
																	<option value="${ls.lectureSubjectNo}">[${ls.lectureName}]${ls.subjectName}</option>
																</c:forEach>
															</select>
														<hr>	
				                                    </div>
				                                    <div class="button-style-three" style="padding-bottom:10px; padding-right:10px;">
				                                        <button class="btn btn-custon-rounded-three btn-success" type="button"  id="addScheduleBtn">??????</button>
				                                        <button class="btn btn-custon-rounded-three btn-danger" type="button" id="resetBtn" data-dismiss="modal">??????</button>
				                                    </div>
			                                    </form>
			                                </div>
			                            </div>
			                        </div>
									</c:if>
								</div>
								<br>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th style="text-align:center;" class="text-danger"> ???</th>
											<th style="text-align:center;">???</th>
											<th style="text-align:center;">???</th>
											<th style="text-align:center;">???</th>
											<th style="text-align:center;">???</th>
											<th style="text-align:center;">???</th>
											<th style="text-align:center;" class="text-primary">???</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<c:forEach var="i" begin="1" end="${totalBlank}" step="1">
												<c:choose>
													<c:when
														test="${(i - startBlank) > 0 && i <= lastDay+startBlank}">
														<c:choose>
															<c:when test="${i%7==0}">
																<c:set var="e" value="text-primary" />
															</c:when>
															<c:when test="${i%7==1}">
																<c:set var="e" value="text-danger" />
															</c:when>
															<c:otherwise>
																<c:set var="e" value="" />
															</c:otherwise>
														</c:choose>
														<td class="${e}" style="height: 150px; text-align:right; width:13%;">
															${i - startBlank}
															<div>
																<c:forEach var="c" items="${scheduleList}">
																	<c:if test="${(c.scheduleDateDay) ==  (i - startBlank)}">
																		<span id="c${c.scheduleNo}" > 
																		<br>
																			<c:if test="${sessionLevel <= 2}">
																			<input name="scheduleNo" class="btn btn-custon-rounded-three btn-default" type="button" data-toggle="modal" data-target="#scheduleOneModal" onclick="javascript:Click(${c.scheduleNo})" value="[${c.lectureName}]${c.subjectName}"> 
																			<br>
																			</c:if>
																			<c:if test="${sessionLevel > 2}">
																				<input style="font-size:11px;"  name="scheduleNo" class="btn btn-custon-rounded-three btn-default" type="button" data-toggle="modal" data-target="#scheduleOneModal" onclick="javascript:Click(${c.scheduleNo})" value="[${c.lectureName}]${c.subjectName}"> 
																				<div class="btn-group">
																					<a class=" btn-sm btn-primary"
																						data-toggle="modal" data-target="#modifyScheduleModal" onclick="javascript:CClick(${c.scheduleNo});">??????</a>
																					<a class=" btn-sm btn-danger"
																						href="${pageContext.request.contextPath}/loginCheck/removeSchedule?scheduleNo=${c.scheduleNo}">??????</a>
																				</div>
																				<div id="modifyScheduleModal" class="modal modal-edu-general Customwidth-popup-WarningModal fade" role="dialog">
													                            <div class="modal-dialog">
													                                <div class="modal-content">
													                                    <div class="modal-close-area modal-close-df">
													                                   		<a class="close" data-dismiss="modal"  id="close"><i class="fa fa-close"></i></a>
													                                    </div>
													                                    <form id="modifyScheduleForm" action="${pageContext.request.contextPath}/loginCheck/modifySchedule" method="post">
														                                    <div class="modal-body">
														                                    	<hr>
														                                    	<h2 style="text-align:center;">????????? ??????</h2>
														                                    	<span id="addScheduleHelper"></span>
														                                    	<input id="scheduleDateOne" type="date" name="scheduleDateOne" hidden="hidden">
																								<label for="scheduleDateTwo">?????? ??????</label>&nbsp;&nbsp;&nbsp;&nbsp;
																								<input id="scheduleDateTwo" type="Date" name="scheduleDateTwo">
																								<br>
																								<label for="lectureSubjectNo">?????? ??????</label>&nbsp;&nbsp;&nbsp;&nbsp;
																								<input type="hidden" name="lectureSubjetNo" id="lectureSubjetNo"><input type="text" name="lectureMName" id="lectureMName"> 
																								<hr>	
														                                    </div>
														                                    <div class="button-style-three" style="padding-bottom:10px; padding-right:10px;">
														                                        <button class="btn btn-custon-rounded-three btn-success" type="submit"  id="modifyScheduleBtn" >??????</button>
														                                        <button class="btn btn-custon-rounded-three btn-danger" type="button" id="resetBtn" data-dismiss="modal">??????</button>
														                                    </div>
													                                    </form>
													                                </div>
													                            </div>
													                        </div>
																			<br>
																			</c:if>
																		</span>
																		<div id="scheduleOneModal" class="modal modal-edu-general Customwidth-popup-WarningModal fade" role="dialog">
													                            <div class="modal-dialog">
													                                <div class="modal-content">
													                                    <div class="modal-close-area modal-close-df">
													                                        <a class="close" data-dismiss="modal" href="#"><i class="fa fa-close"></i></a>
													                                    </div>
														                                    <div class="modal-body">
														                                    	<hr>
														                                    	<h2 style="text-align:center;">?????? ????????????</h2>
														                                    	<br>
																								<h5>????????? : <span id="lectureName"></span></h5>
																								<br>
																								<h5>????????? : <span id="subjectName"></span></h5>
																								<br>
																								<h5>?????? ?????? : <span id="scheduleDateThree"></span></h5>
																								<hr>
														                                    </div>
													                                </div>
													                            </div>
													                        </div>
																	</c:if>
																</c:forEach>
															</div>
														</td>
													</c:when>
													<c:when test="${(i-startBlank)<1}">
														<td></td>
													</c:when>
													<c:when test="${i>lastDay}">
														<td></td>
													</c:when>
												</c:choose>
												<c:if test="${i%7==0}">
										</tr>
										<tr>
											</c:if>
											</c:forEach>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
            </div>
         </div>
      </div>

   <div class="header-advance-area">
      <!-- Mobile Menu end -->
      <div class="breadcome-area">
         <div class="container-fluid">
            <div class="row">
               <div class="product-status mg-b-15">
                  <div class="container-fluid"></div>
               </div>
            </div>
         </div>
      </div>
   </div>

   <!-- Main Contents -->
   <div class="analytics-sparkle-area">
      <div class="container-fluid">
         <div class="row">

            <!-- iframe -->

         </div>
      </div>
   </div>
   <div class="product-sales-area mg-tb-30">
      <div class="container-fluid">
         <div class="row"></div>
      </div>
   </div>
   <div class="traffic-analysis-area">
      <div class="container-fluid">
         <div class="row"></div>
      </div>
   </div>
   <div class="library-book-area mg-t-30">
      <div class="container-fluid">
         <div class="row"></div>
      </div>
   </div>
   <div class="product-sales-area mg-tb-30">
      <div class="container-fluid">
         <div class="row"></div>
      </div>
   </div>
   <div class="courses-area mg-b-15">
      <div class="container-fluid">
         <div class="row"></div>
      </div>
   </div>


   <!-- Start footer -->
   <jsp:include page="../inc/footer.jsp" />
   <!-- End footer -->


   	<!-- Start js -->
	<jsp:include page="../js/alljs.jsp" />
	<!-- End js -->
   <script>
      /*<![CDATA[*/
      $(document).ready(function() {
         setTimeout(function() {
            window.location.reload(1)
         }, 10000)
      })
      /*]]>*/
   </script>
   	<script>
	<!-- ????????? ??????-->
	$('#addScheduleBtn').click(function(){
		if($('#scheduleDate').val() == '') {
			$('#addScheduleHelper').text('????????? ???????????????.');
		} else if($('#lectureSubjectNo').val() == '') {
			$('#addScheduleHelper').text('[??????]????????? ???????????????.');
		} else if($('#scheduleStartDate').val() > $('#scheduleEndDate').val()) {
			$('#addScheduleHelper').text('??????????????? ?????????????????? ?????? ??????????????????.');
		} else {
			$('#addScheduleHelper').text('');
			$('#addScheduleForm').submit();
		}
	});
	<!-- ???????????? ????????? ???????????? ????????? ?????????-->
	$('#resetBtn').click(function(){
		$('#scheduleDate').val('')
		$('#lectureSubjectNo').val('')	
	});
	$('#close').click(function(){
		$('#scheduleDate').val('')
		$('#lectureSubjectNo').val('')	
	});
	
	// ????????????
	function Click(scheduleNo) {
			var url = "${pageContext.request.contextPath}";
			$.ajax({
				type: "GET", //?????? ????????? ??????(post, get)
				url: url+"/getScheduleOne",
				data :  "scheduleNo="+scheduleNo,
				dataType:"json", //????????? ?????? URL??? ????????? ???????????? ????????? ?????? (return???)
				success : function(result){ // ??????????????? ????????? 
				console.log(result);
					$('#lectureName').text(result.lectureName)
					$('#subjectName').text(result.subjectName)
					$('#scheduleDateThree').text(result.scheduleDate)
				},
				error : function(error){
					alert(error);
				}
			});
		}
	
	// ??????
	function CClick(scheduleNo) {
		var url = "${pageContext.request.contextPath}";
		$.ajax({
			type: "GET", //?????? ????????? ??????(post, get)
			url: url+"/getScheduleOne",
			data :  "scheduleNo="+scheduleNo,
			dataType:"json", //????????? ?????? URL??? ????????? ???????????? ????????? ?????? (return???)
			success : function(result){ // ??????????????? ????????? 
			console.log(result);
				$('#lectureMName').val(result.lectureName+result.subjectName)
				$('#scheduleDateOne').val(result.scheduleDate)
				$('#scheduleDateTwo').val(result.scheduleDate)
				$('#lectureSubjetNo').val(result.lectureSubjectNo)
			},	
			error : function(error){
				alert(error);
			}
		});
	}
	</script>
   <script src="//code.jquery.com/jquery-latest.min.js"></script>
</body>

</html>