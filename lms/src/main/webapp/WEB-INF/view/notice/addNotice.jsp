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
 <!-- dropzone CSS
		============================================ -->
<link rel="stylesheet" href="css/dropzone/dropzone.css">
</head>
<body>
   <!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

   <!-- Start sidebar -->
   <jsp:include page="/WEB-INF/view/inc/sidebar.jsp" />
   <!-- End sidebar -->

   <!-- Start tobbar -->
   <jsp:include page="/WEB-INF/view/inc/topbar.jsp" />
   <!-- End tobbar -->


    <!-- Main Contents -->
	<div class="header-advance-area">
            <div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list single-page-breadcome">
                                <div class="row"> 
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu" style="float: left;">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span></li>
                                            <li><a href="/lms/loginCheck/noticeList">공지사항</a> <span class="bread-slash">/</span></li>
                                            <li><a href="/lms/loginCheck/addNotice">신규 공지 작성</a> <span class="bread-slash"></span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <div class="single-pro-review-area mt-t-30 mg-b-15">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-status-wrap drp-lst">
                                <h4>Add Notice</h4>
                                <hr>
                            <div id="myTabContent" class="tab-content custom-product-edit">
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section" >
                                                <div id="dropzone1" class="pro-ad addcoursepro" >
                                                
                                                    <form action="${pageContext.request.contextPath}/loginCheck/addNotice" class="dropzone dropzone-custom needsclick add-professors dz-clickable" id="addNoticeForm" method="post" enctype="multipart/form-data" >
                                                        <div class="row">
                                                            <div class="form-group edit-ta-resize res-mg-t-15">
                                                                <div class="form-group">
                                                                    <label for="noticeTitle">제목</label> <input name="noticeTitle" id="noticeTitle" type="text" class="form-control">
                                                                     <input name="accountId" type="hidden" value="${notice.accountId}">
                                                                </div>
                                                                <div class="form-group edit-ta-resize res-mg-t-15">
                                                                    <label for="noticeContent">본문</label> <textarea name="noticeContent" id="noticeContent"  class="form-control" style="resize: none;"></textarea>
                                                                </div>
                                                            </div>
                                                        </div>
									                  	<div class="table table-write" id="add_mt">
															<div id="notice_file_upload" class="dz-message needsclick download-custom">
															<i class="fa fa-download edudropnone" aria-hidden="true"></i>
															<h2 class="edudropnone">드래그 또는 클릭하여 파일 첨부</h2>
																<div class="fallback">
																<input name="file" type="file" multiple />
																</div>
															</div>
														</div>
														
														<div class="form-group col-lg-12">
									                		<div class="row">
	                                                            <div class="col-lg-12">
	                                                                <div class="payment-adress">
	                                                                    <button type="submit" id="addNoticeSubmit" class="btn btn-primary waves-effect waves-light">제출</button>
	                                                                </div>
	                                                            </div>
	                                                    	</div>
                                                    	</div>
                                                 	</form>
                                                  
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
    <!-- footer -->
	<jsp:include page="../inc/footer.jsp" />
</div>
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
    <!-- dropzone JS
		============================================ -->
    <script src="js/dropzone/dropzone.js"></script>
    <!-- 작업 중
    <script>
    $(document).ready(function() {	
    	edit_mode_note();
    	//$("div#my_file_upload").dropzone({ url: "/editor/file_upload" });
    	$(".file-dropzone").on('dragover', handleDragEnter);
    	$(".file-dropzone").on('dragleave', handleDragLeave);
    	$(".file-dropzone").on('drop', handleDragLeave);

    	function handleDragEnter(e) {
    		this.classList.add('drag-over');
    	}

    	function handleDragLeave(e) {
    		this.classList.remove('drag-over');
    	}

    	Dropzone.autoDiscover = false;	// 초기화
    	
    	$("div#my_file_upload").dropzone({ url: "/editor/file_uploads" ,
    		addRemoveLinks : true,
    			maxFilesize : 256,
    		  dictResponseError: 'Error uploading file!',
    		  headers: {
    		    'X-CSRF-TOKEN': $("#csrf_token").val()
    		    , uid : $('#i_uid').val()
    		  },
    		  params: {
    		         uid: $('#i_uid').val()
    		    },
    		  uploadMultiple : true,
    		  thumbnailWidth: 180,
    		  thumbnailHeight: 120,
    		  parallelUploads: 100,		
    		  maxFiles: 255,
    		  autoProcessQueue : true,
    		  accept: function(file, done) {
    			    if (file.name == "") {
    			      done("제한사항 없어도 될듯 한뎅?");
    			    }
    			    else {			    	
    			    	done(); 
    			    	}
    			  },
    	init : function() {
    		var myDropzone = this;
    		var count = myDropzone.options.maxFiles;
    		var url = "/editor/file_list";
    		var data = JSON.stringify({ 
    			uid : $('#i_uid').val()
    		});
    		
    		var callback_init=function (data) {
                if (data.data != '' && data.data != undefined) {
                	var existingFileCount = 0;
                    $.each(data.data, function (index, item) {
                        var mockFile = {
                            name: item.mt_filename,
                            size: item.mt_contentlength,
                            seq: item.idx
                        };
                        var filePath = "/editor/get_editor_thumbnail_image/?idx="+item.idx;
                        myDropzone.emit("addedfile", mockFile);
                        myDropzone.emit("thumbnail", mockFile, filePath);
                        myDropzone.emit("success", mockFile);
                        myDropzone.emit("complete", mockFile);                    
                        myDropzone.files.push(mockFile);
                        //file.previewElement.classList.add("dz-processing"); //sms;
                        //file.previewElement.classList.add("dz-complete");
                        existingFileCount = existingFileCount + 1;
                    });
                    myDropzone.options.maxFiles = myDropzone.options.maxFiles - existingFileCount;
                }
            };
    		getPostData(url,data,callback_init);
    		
    		this.on("maxfilesexceeded", function (file) {
    			showmessage("알림","한번에 올릴수 있는 파일의 갯수 제한을 넘었습니다",2000,'');
    			myDropzone.removeFile(file);
    		});
            
            this.on("success", function( file, resp, formData ){
            	existingFileCount=0;
            	var type = $("#"+id).data("type");
            	if(resp != null && resp != '' && resp != undefined) {
    	        	if(resp.data != null && resp.data != '' && resp.data != undefined) {
    	    			var existingFileCount = 0;
    	    			$.each(resp.data, function(){
    	    				if(this.mt_filename==file.name)
    	    				{
    	    					file.previewElement.appendChild(Dropzone.createElement("<input type='hidden' name='fileId' value='" + this.fileId + "'/>"));
    	    					existingFileCount = existingFileCount + 1;
    	    				}
    	    			});
    	    		}
            	}
            	if(file.seq != null && file.seq != '' && file.seq != undefined) {
    				file.previewElement.appendChild(Dropzone.createElement("<input type='hidden' name='fileId' value='" + file.seq + "'/>"));
        		}
            });
            
            this.on("removedfile", function (data) {
            	var id = $(data.previewElement).find('input[name=fileId]').val();
        		var sql_state_value = 'delete';
        		var data = JSON.stringify({
        			   sql_state : sql_state_value		 
        			 , idx : id    	
        			 , uid : $('#i_uid').val()
        		   	 , mt_input_id : $('#login_mt_id').val()
        			 , mt_update_id : $('#login_mt_id').val()
        		});
        		var url ='/editor/editor_note_delete_img';
        		getPostData(url,data,null);
        		myDropzone.options.maxFiles = myDropzone.options.maxFiles + 1;
        		if(count < myDropzone.options.maxFiles) myDropzone.options.maxFiles = count;
        	    });
    		}
    	
    	});
    	$('.push').click(function() {
    		$('.dropzone').each(function() {
    			alert("어휴.");
    		});
    	});


    });
    
    
    </script>
    
     -->
       
</body>
</html>