<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!int SAPID = 0;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	https: //cdnjs.cloudflare.com/ajax/libs/javascript.util/0.12.12/javascript.util.min.js
</script>
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
	background-color: #6610f2;
}

table, tr {
	color: #fff;
}

#hn {
	word-spacing: 2em;
}
</style>
<meta charset="ISO-8859-1">
<title>Students List</title>
</head>
<body>
	<h2 align="center">Patient List</h2>
	<div id="hn">
		<a class="whi" href="${pageContext.request.contextPath }/redirecting">GoBack</a>
		<a class="whi" href="${pageContext.request.contextPath }//doctab">All</a>
		<a class="whi"
			href="${pageContext.request.contextPath }/act?id=Doctor A">DocA</a> <a
			class="whi"
			href="${pageContext.request.contextPath }/act?id=Doctor B">DocB</a> <a
			class="whi"
			href="${pageContext.request.contextPath }/act?id=Doctor C">DocC</a> <a
			class="whi"
			href="${pageContext.request.contextPath }/act?id=Doctor D">DocD</a>
	</div>
	<hr />
	<p />
	<table border="1.5" align="left" id="tab">
		<tr>
			<th width="10%">Stu ID</th>
			<th width="10%">Examining Doctor</th>
			<th width="10%">Date</th>
			<th width="10%">Temperature</th>
			<th width="20%">Blood Pressure</th>
			<th width="10%">Weight</th>
			<th width="10%">Chronic Ailment</th>
			<th width="10%">Allergies</th>
			<th width="20%">Past History</th>
			<th width="20%">SAPId</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.stuid }</td>
				<td>${list.doctor }</td>
				<td>${list.date}</td>
				<td>${list.temp }</td>
				<td>${list.bp}</td>
				<td>${list.weight }</td>
				<td>${list.chronic_ailment}</td>
				<td>${list.allergies }</td>
				<td><a href="#" class="whi" data-toggle="modal"
					data-target="#simple">Click Here</a></td>
				<td><a href="#" class="whi" data-toggle="modal"
					data-target="#modalLoginForm" data-id="1234" id="clicked">${list.sapid}</a></td>
			</tr>
		</c:forEach>
	</table>

	<script>
	$(document).on("click", "#clicked", function () {
	     var myBookId = $(this).data('id');
	     $(".modal-body #book").val( myBookId );
	    $('#modalLoginForm').modal('show');
	});
	</script>

	<div class="modal fade" id="simple" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Past History</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="simplepage" method="POST">
					<div class="modal-body mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-envelope prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="defaultForm-email">Re
								Enter Sapid</label> <input type="text" name="sapid"
								id="defaultForm-pass" class="form-control validate" required>
						</div>
					</div>
					<div class="modal-footer d-flex justify-content-center">
						<button class="btn btn-success">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Prescribe
						Medicines</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="doctorMed" method="POST">
					<div class="modal-body mm mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-envelope prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="defaultForm-email">Re
								Enter Sapid</label> <input type="text" name="sapid"
								id="defaultForm-pass" class="form-control validate" required>
						</div>

						<div class="md-form mb-4">
							<i class="fas fa-lock prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="defaultForm-pass">Medicines</label>
							<textarea name="medicine" id="defaultForm-pass"
								class="form-control validate" required></textarea>
						</div>

						<div class="md-form mb-4">
							<i class="fas fa-lock prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="defaultForm-pass">Provisional
								Diagnosis</label>
							<textarea name="diagnosis" id="defaultForm-pass"
								class="form-control validate"></textarea>
						</div>

					</div>
					<div class="modal-footer d-flex justify-content-center">
						<button class="btn btn-success">Prescribe</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Please prescribe medicines</h4>
				</div>
				<div class="modal-body">


					<form action="doctorMed" method="POST">
						SapId: <input type="hidden" name="sapid" id="value"></input>
						<div class="form-group">
							<label class="control-label">Medicine</label>
							<div>
								<input type="text" class="form-control input-lg" name="medicine"
									required>
							</div>
						</div>
						<button type="submit" class="btn btn-success">Submit</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
<script>
$(document).on("click","#clicked",function(){
	var myBookId = $(this).data('id');
	$(".modal-body #book").val( myBookId );
})

</script>
</body>
</html>