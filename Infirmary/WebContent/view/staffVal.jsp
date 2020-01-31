<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
h2 {
	color: #fff;
}

.abc {
	padding-left: 10px;
}

@media screen and (min-width: 992px) {
	.modal-lg {
		width: 2950px; /* New width for large modal */
	}
}

.modal-megamenu {
	width: 80%;
	height: 80%;
}

.modal-body {
	max-height: calc(100vh - 200px);
	overflow-y: auto;
	position: relative;
	padding: 1px;
}

.whi {
	color: white;
}

body {
	background-color: RGBA(13, 70, 83, 0.78);
}

table, tr {
	color: #fff;
}
</style>
<meta charset="ISO-8859-1">
<title>Students List</title>
</head>
<body>
	<h2 align="center">Provide Medicines</h2>
	<span class="collapse navbar-collapse navbar-left container"
		id="myNavbar">
		<ul class="nav navbar-nav">
			<a class="whi" href="${pageContext.request.contextPath }/redirecting">Go
				Back</a>
		</ul>
	</span>
	<br>
	<p />
	<hr />
	<table border="1" align="left">
		<tr>
			<th>Student ID</th>
			<th>Date</th>
			<th>SAP ID</th>
			<th>Medicines Prescribed</th>
			<th>Medicines</th>
		</tr>
		<c:forEach items="${staff}" var="staff">
			<tr>
				<td>${staff.stuid }</td>
				<td>${staff.date}</td>
				<td>${staff.sapid}</td>
				<td>${staff.medicine}</td>
				<td><a href="#" data-target="#staffmodal" data-toggle="modal"
					class="whi">Provide Medicines</a></td>
			</tr>
		</c:forEach>
	</table>








	<!-- Modal -->
	<div id="staffmodal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Stock Management</h4>
				</div>
				<div class="modal-body">
					<div class="abc">
						<br />
						<h2 align="center">Add Medicines</h2>
						<div class="form-group">
							<form name="add_name" id="add_name" action="addmed" method="GET">
								<div class="form-group">
									<label class="control-label">Sap Id</label>
									<div>
										<input type="text" class="form-control input-lg" name="sapid"
											size="10%" required>
									</div>
								</div>



								<div class="table-responsive">
									<table class="table table-bordered" id="dynamic_field">
										<tr>
											<td><input type="text" name="medicine[]"
												placeholder="Enter Medicine" class="form-control name_list"
												size="0.5" required /></td>
											<td><input type="text" name="stock[]"
												placeholder="Enter Stock" class="form-control name_list"
												size="0.5" required /></td>
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
																'<tr id="row'+i+'"><td><input type="text" name="medicine[]" placeholder="Enter Medicine" class="form-control name_list" /></td><td><input type="text" name="stock[]" placeholder="Enter Stock" class="form-control name_list" /></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
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