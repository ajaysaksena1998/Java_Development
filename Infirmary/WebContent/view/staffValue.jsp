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
			<th>Remove Entry</th>
		</tr>
		<c:forEach items="${staff}" var="staff">
			<tr>
				<td>${staff.stuid }</td>
				<td>${staff.date}</td>
				<td>${staff.sapid}</td>
				<td>${staff.medicine}</td>
				<td><a href="#" data-target="#staffmodal" data-toggle="modal"
					class="whi">Provide Medicines</a></td>
				<td><a href="#" class="whi">Remove</a></td>
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
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">

					<div class="container">
						<div class="row">
							<input type="hidden" name="count" value="1" />
							<div class="control-group" id="fields">
								<label class="control-label" for="field1">Add Medicines</label>
								<div class="controls" id="profs">
									<form action="formmeth" class="input-append">
										<div id="field">
											<input autocomplete="off" class="input" id="field1"
												name="prof1" type="text" placeholder="Type something"
												data-items="8" /> <input autocomplete="off" class="input"
												id="field2" name="prof2" type="text"
												placeholder="Type something" data-items="8" />
											<button id="b1" class="btn add-more" type="button">+</button>
										</div>
										<input type="submit" value="submit" />
									</form>
									<br> <small>Press + to add another form field :)</small>
								</div>
							</div>
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
							var next = 1;
							$(".add-more")
									.click(
											function(e) {
												e.preventDefault();
												var addto = "#field" + next;
												var addRemove = "#field"
														+ (next);
												next = next + 1;
												var newIn = '<input autocomplete="off" class="input form-control" id="field' + next + '" name="field' + next + '" type="text">';
												var newInput = $(newIn);
												var newIn2 = '<input autocomplete="off" class="input form-control" id="field' + next + '" name="field' + next + '" type="text">';
												var newInput2 = $(newIn2);
												var removeBtn = '<button id="remove'
														+ (next - 1)
														+ '" class="btn btn-danger remove-me" >-</button></div><div id="field">';
												var removeButton = $(removeBtn);
												$(addto).after(newInput);
												$(addto).after(newInput2);
												$(addRemove)
														.after(removeButton);
												$("#field" + next).attr(
														'data-source',
														$(addto).attr(
																'data-source'));
												$("#count").val(next);

												$('.remove-me')
														.click(
																function(e) {
																	e
																			.preventDefault();
																	var fieldNum = this.id
																			.charAt(this.id.length - 1);
																	var fieldID = "#field"
																			+ fieldNum;
																	$(this)
																			.remove();
																	$(fieldID)
																			.remove();
																});
											});

						});
	</script>

</body>
</html>