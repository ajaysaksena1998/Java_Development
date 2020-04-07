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
	background-color: #6610f2;
}

table, tr {
	color: #fff;
}
</style>
<meta charset="ISO-8859-1">
<title>Student Report</title>
</head>
<body>
	<h2 align="center">Download Student Report</h2>
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
			<th>Student Report</th>
		</tr>
		<c:forEach items="${student}" var="student">
			<tr>
				<td width="10%">${student.stuid }</td>
				<td width="5%">${student.date}</td>
				<td width="10%">${student.sapid}</td>
				<td width="10%"><a href="#" class="whi" data-toggle="modal"
					data-target="#simple">Click Here</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="modal fade" id="simple" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Student Report</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="${pageContext.request.contextPath }/view/createpdf.jsp" method="GET">
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
</body>
</html>