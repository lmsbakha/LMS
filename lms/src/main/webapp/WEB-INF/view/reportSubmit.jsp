<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Edit Professor | Kiaalap - Kiaalap Admin Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
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
<!-- meanmenu icon CSS
		============================================ -->
<link rel="stylesheet" href="css/meanmenu.min.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="css/main.css">
<!-- educate icon CSS
		============================================ -->
<link rel="stylesheet" href="css/educate-custon-icon.css">
<!-- morrisjs CSS
		============================================ -->
<link rel="stylesheet" href="css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet"
	href="css/scrollbar/jquery.mCustomScrollbar.min.css">
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
<!-- dropzone CSS
		============================================ -->
<link rel="stylesheet" href="css/dropzone/dropzone.css">
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
	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->

	<!-- Start sidebar -->
	<jsp:include page="inc/sidebar.jsp" />
	<!-- End sidebar -->

	<!-- Start tobbar -->
	<jsp:include page="inc/topbar.jsp" />
	<!-- End tobbar -->
	<div class="header-advance-area">
		<!-- Mobile Menu end -->
		<div class="breadcome-area">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="breadcome-list single-page-breadcome">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<ul class="breadcome-menu" style="float: left;">
										<li><a href="#">Home</a> <span class="bread-slash">/</span></li>
										<li><a href="#">강의</a> <span class="bread-slash">/</span></li>
										<li><a href="#">과제</a> /</li>
										<li><span class="bread-blod" style="font-weight: bold;">출제</span></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Main Contents -->
	<div class="single-pro-review-area mt-t-30 mg-b-15">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="product-payment-inner-st">
						<ul id="myTabedu1" class="tab-review-design">
							<li class="active"><a href="#description">과제 출제</a></li>
						</ul>
						<div id="myTabContent" class="tab-content custom-product-edit">
							<div class="product-tab-list tab-pane fade active in"
								id="description">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div id="dropzone1" class="pro-ad">
												<form action="#"
													class="dropzone dropzone-custom needsclick add-professors"
													id="demo1-upload">
													<div class="row">
														<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
																<input name="number" type="text" class="form-control"
																	placeholder="Fly Zend" value="Fly Zend">
															</div>
															<div class="form-group">
																<input type="text" class="form-control"
																	placeholder="E104, catn-2, UK."
																	value="E104, catn-2, UK.">
															</div>
															<div class="form-group">
																<input type="text" class="form-control"
																	placeholder="12/10/1993" value="12/10/1993">
															</div>
															<div class="form-group">
																<input type="number" class="form-control"
																	placeholder="1213" value="1213">
															</div>
															<div class="form-group">
																<input type="number" class="form-control"
																	placeholder="01962067309" value="01962067309">
															</div>
															<div class="form-group alert-up-pd">
																<div class="dz-message needsclick download-custom">
																	<i class="fa fa-download edudropnone"
																		aria-hidden="true"></i>
																	<h2 class="edudropnone">Drop image here or click
																		to upload.</h2>
																	<p class="edudropnone">
																		<span class="note needsclick">(This is just a
																			demo dropzone. Selected image is <strong>not</strong>
																			actually uploaded.)
																		</span>
																	</p>
																	<input name="imageico" class="hd-pro-img" type="text" />
																</div>
															</div>
														</div>
														<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
															<div class="form-group">
																<input type="text" class="form-control"
																	placeholder="CSE" value="CSE">
															</div>
															<div class="form-group edit-ta-resize res-mg-t-15">
																<textarea name="description">Lorem ipsum dolor sit amet of, consectetur adipiscing elitable. Vestibulum tincidunt est vitae ultrices accumsan.</textarea>
															</div>
															<div class="form-group">
																<select class="form-control">
																	<option>Male</option>
																	<option>Male</option>
																	<option>Female</option>
																</select>
															</div>
															<div class="form-group">
																<select class="form-control">
																	<option>Nepal</option>
																	<option>India</option>
																	<option>Pakistan</option>
																	<option>Amerika</option>
																	<option>China</option>
																	<option>Dubai</option>
																	<option>Nepal</option>
																</select>
															</div>
															<div class="form-group">
																<select class="form-control">
																	<option>Maharastra</option>
																	<option>Gujarat</option>
																	<option>Maharastra</option>
																	<option>Rajastan</option>
																	<option>Maharastra</option>
																	<option>Rajastan</option>
																	<option>Gujarat</option>
																</select>
															</div>
															<div class="form-group">
																<select class="form-control">
																	<option>Baroda</option>
																	<option>Surat</option>
																	<option>Baroda</option>
																	<option>Navsari</option>
																	<option>Baroda</option>
																	<option>Surat</option>
																</select>
															</div>
															<div class="form-group">
																<input type="text" class="form-control"
																	placeholder="www.uttara.com" value="www.uttara.com">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-12">
															<div class="payment-adress">
																<button type="submit"
																	class="btn btn-primary waves-effect waves-light">Submit</button>
															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="product-tab-list tab-pane fade" id="reviews">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div class="row">
												<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
													<div class="devit-card-custom">
														<div class="form-group">
															<input type="text" class="form-control"
																placeholder="Email" value="Admin@gmail.com">
														</div>
														<div class="form-group">
															<input type="number" class="form-control"
																placeholder="Phone" value="01962067309">
														</div>
														<div class="form-group">
															<input type="password" class="form-control"
																placeholder="Password" value="#123#123">
														</div>
														<div class="form-group">
															<input type="password" class="form-control"
																placeholder="Confirm Password" value="#123#123">
														</div>
														<a href="#!"
															class="btn btn-primary waves-effect waves-light">Submit</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="product-tab-list tab-pane fade" id="INFORMATION">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<div class="review-content-section">
											<div class="row">
												<div class="col-lg-12">
													<div class="devit-card-custom">
														<div class="form-group">
															<input type="url" class="form-control"
																placeholder="Facebook URL"
																value="http://www.facebook.com">
														</div>
														<div class="form-group">
															<input type="url" class="form-control"
																placeholder="Twitter URL" value="http://www.twitter.com">
														</div>
														<div class="form-group">
															<input type="url" class="form-control"
																placeholder="Google Plus"
																value="http://www.google-plus.com">
														</div>
														<div class="form-group">
															<input type="url" class="form-control"
																placeholder="Linkedin URL"
																value="http://www.Linkedin.com">
														</div>
														<button type="submit"
															class="btn btn-primary waves-effect waves-light">Submit</button>
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
	<!-- Start footer -->
	<jsp:include page="inc/footer.jsp" />
	<!-- End footer -->

	<!-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->
	<!-- jquery
		============================================ -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script src="js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="js/jquery.scrollUp.min.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
		============================================ -->
	<script src="js/metisMenu/metisMenu.min.js"></script>
	<script src="js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script src="js/sparkline/jquery.sparkline.min.js"></script>
	<script src="js/sparkline/jquery.charts-sparkline.js"></script>
	<!-- calendar JS
		============================================ -->
	<script src="js/calendar/moment.min.js"></script>
	<script src="js/calendar/fullcalendar.min.js"></script>
	<script src="js/calendar/fullcalendar-active.js"></script>
	<!-- maskedinput JS
		============================================ -->
	<script src="js/jquery.maskedinput.min.js"></script>
	<script src="js/masking-active.js"></script>
	<!-- datepicker JS
		============================================ -->
	<script src="js/datepicker/jquery-ui.min.js"></script>
	<script src="js/datepicker/datepicker-active.js"></script>
	<!-- form validate JS
		============================================ -->
	<script src="js/form-validation/jquery.form.min.js"></script>
	<script src="js/form-validation/jquery.validate.min.js"></script>
	<script src="js/form-validation/form-active.js"></script>
	<!-- dropzone JS
		============================================ -->
	<script src="js/dropzone/dropzone.js"></script>
	<!-- tab JS
		============================================ -->
	<script src="js/tab.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="js/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="js/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
	<script src="js/tawk-chat.js"></script>
</body>

</html>