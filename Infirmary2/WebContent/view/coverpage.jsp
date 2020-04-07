<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<style>
#abc {
	color: white;
}

@media screen and (min-width: 992px) {
	.modal-lg {
		width: 950px; /* New width for large modal */
	}
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Welcome</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/css2/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/vendors2/linericon/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/css2/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/vendors2/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/vendors2/lightbox/simpleLightbox.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/vendors2/nice-select/css/nice-select.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/vendors2/animate-css/animate.css">
<!-- main css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/files/assets/css2/style.css">
</head>

<body>

	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<!-- <div class="header-top">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-3 col-sm-6 col-4 header-top-left">
					</div>
				</div>
			</div>
		</div> -->
		<div class="main_menu">
			<!-- <div class="search_input" id="search_input_box">
				<div class="container">
					<form class="d-flex justify-content-between">
						<input type="text" class="form-control" id="search_input"
							placeholder="Search Here">
						<button type="submit" class="btn"></button>
						<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
					</form>
				</div>
			</div> -->
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<img
						src="${pageContext.request.contextPath }/files/images/upes.png"
						alt="" height=80>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item active" data-toggle="modal"
								data-target="#exampleModal"><a class="nav-link"
								href="#banner">Patient</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/doctab">Doctor</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/staffUpdation">Staff</a></li>
							<li class="nav-item" data-toggle="modal"
								data-target="#addingmedicines"><a class="nav-link" href="#">Add
									Medicines</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/getpatient">Student
									List</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/getstock">Stock
									List</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/getExpired">Expiry</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/HelloWorld">Student
									Report</a></li>
						</ul>
					</div>
					<div class="collapse navbar-collapse navbar-right" id="myNavbar">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath }/">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>



	<!-- Modal -->
	<div id="addingmedicines" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title">Stock Management</h2>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="abc">
						<br />
						<h4 align="center">Add Medicines</h4>
						<div class="form-group">
							<form name="add_name" id="add_name" action="addingMedicines"
								method="GET">

								<div class="table-responsive">
									<table class="table table-bordered" id="dynamic_field">
										<tr>
											<td><input type="text" name="medicine[]"
												placeholder="Enter Medicine" class="form-control name_list"
												size="10%" required /></td>
											<td><input type="text" name="stock[]"
												placeholder="Enter Stock" class="form-control name_list"
												size="0.5" required /></td>
											<td><input type="date" name="expiry[]"
												placeholder="Enter Expiry Date"
												class="form-control name_list" size="0.5" required /></td>
											<td><button type="button" name="add" id="add"
													class="btn btn-success">Add More</button></td>
										</tr>
									</table>
									<input type="submit" name="submit" id="submit"
										class="btn btn-info" value="Submit" />
								</div>
							</form>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>




	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Patient Details</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="patient" method="POST">
						<div class="form-group">
							<label class="control-label">Date</label>
							<div>
								<input type="date" class="form-control input-lg" name="date"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Name</label>
							<div>
								<input type="text" class="form-control input-lg" name="name"
									required>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label">Contact Number</label>
							<div>
								<input type="text" class="form-control input-lg" name="contact"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Age</label>
							<div>
								<input type="text" class="form-control input-lg" name="age"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Gender: </label> Male <input
								type="radio" name="gender" value="Male" required> Female
							<input type="radio" name="gender" value="Female" required>
						</div>
						<div class="form-group">
							<label class="control-label">Sap Id/ Others</label>
							<div>
								<input type="text" class="form-control input-lg" name="sapid"
									required>
							</div>
						</div>
						<div class="form-group">

							<label class="control-label">Examining Doctor</label>
							<div>
								<select class="form-control input-lg" name="doctor">
									<option disabled="" value="" selected="">Select Doctor</option>
									<c:forEach items="${list}" var="list">
										<option value="${list}">${list}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br> <br>

						<div class="form-group">
							<label class="control-label">Course</label>
							<div>
								<input type="text" class="form-control input-lg" name="course"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Temperature</label>
							<div>
								<input type="text" class="form-control input-lg" name="temp"></input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Blood Pressure</label>
							<div>
								<input type="text" class="form-control input-lg" name="bp"></input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Weight</label>
							<div>
								<input type="text" class="form-control input-lg" name="weight"></input>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Chronic Ailment</label>
							<div>
								<textarea class="form-control input-lg" name="chronic_ailment"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Allergies</label>
							<div>
								<textarea class="form-control input-lg" name="allergies"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div>
								Day Scholar <input type="radio" name="travel"
									value="Day Scholar" required> Hostel Boarding <input
									type="radio" name="travel" value="Hostel Boarding" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Current Address</label>
							<div>
								<textarea class="form-control input-lg" name="address"></textarea>
							</div>
						</div>

						<div class="form-group">
							<div>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-success">Register</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<!--================ End Header Menu Area =================-->

	<!--================ Start Home Banner Area =================-->
	<section class="home_banner_area">
		<div class="banner_inner">
			<div class="container">
				<div class="banner_content">
					<h2>
						UPES Infirmary<br>
					</h2>
					<p>Automation Drive!!!</p>
				</div>
			</div>
		</div>
	</section>
	<!--================ End Home Banner Area =================-->

	<!--================ Start footer Area  =================-->
	<footer class="footer-area section-gap">
		<div class="footer_top section_gap">
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h4 class="text-white">About Us</h4>
							<p>We, at UPES aims to provide well equipped medical
								facilities to our staff and to all our students.</p>
						</div>
					</div>
					<div class="col-lg-4  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h4 class="text-white">Contact Us</h4>
							<p>Please feel free to contact us in case of any query.</p>
							<a id="abc" href="tel:+918764987234"><span
								class="lnr lnr-phone-handset"></span> <span class="text"><span
									class="text">+91 8764987234</span></span></a><br> <a id="abc"
								href="mailto:ajaysaksena1998@gmail.com"><span
								class="lnr lnr-envelope"></span> <span class="text"><span
									class="text">ajaysaksena1998@gmail.com</span></span></a>
						</div>
					</div>
					<div class="col-lg-4  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h4 class="text-white">From Owner's Desk</h4>
							<p>We declare to keep all your information shared with us
								confidential to the best of our knowledge.</p>
						</div>
					</div>

				</div>

			</div>
		</div>
	</footer>
	<!--================ End footer Area  =================-->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/jquery-3.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/popper.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/stellar.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/vendors2/lightbox/simpleLightbox.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/vendors2/nice-select/js/jquery.nice-select.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/vendors2/owl-carousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/jquery.ajaxchimp.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/vendors2/counter-up/jquery.waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/vendors2/counter-up/jquery.counterup.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/mail-script.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/gmaps.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/files/assets/js2/theme.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							var i = 1;
							$('#add')
									.click(
											function() {
												i++;
												$('#dynamic_field')
														.append(
																'<tr id="row'+i+'"><td><input type="text" name="medicine[]" placeholder="Enter Medicine" class="form-control name_list" /></td><td><input type="text" name="stock[]" placeholder="Enter Stock" class="form-control name_list" /></td><td><input type="date" name="expiry[]" placeholder="Enter Expiry Date" class="form-control name_list" size="0.5" required /></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
											});
							$(document).on('click', '.btn_remove', function() {
								var button_id = $(this).attr("id");
								$('#row' + button_id + '').remove();
							});
							$('#submit').click(function() {
								$.ajax({
									url : "name.php",
									method : "POST",
									data : $('#add_name').serialize(),
									success : function(data) {
										alert(data);
										$('#add_name')[0].reset();
									}
								});
							});
						});
	</script>
</body>
</html>