<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
	<h2 align="center">Students List</h2>
	<span class="collapse navbar-collapse navbar-right" id="myNavbar">
		<ul class="nav navbar-nav">
			<a class="whi" href="${pageContext.request.contextPath }/redirecting">Go
				Back</a>
		</ul>
	</span>
	<hr />
	<p />
	<table border="1" align="left">
		<tr>
			<th>Student ID</th>
			<th>Date</th>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Sap Id</th>
			<th>Course</th>
			<th>Medicine</th>
			<th>Chronic Ailment</th>
			<th>Allergies</th>
			<th>Travel</th>
		</tr>
		<c:forEach items="${patient}" var="patient">
			<tr>
				<td>${patient.stuid }</td>
				<td width="7%">${patient.date}</td>
				<td width="9%">${patient.name}</td>
				<td>${patient.age}</td>
				<td>${patient.gender}</td>
				<td>${patient.sapid}</td>
				<td width="9%">${patient.course}</td>
				<td width="30%">${patient.medicine}</td>
				<td width="25%">${patient.chronic_ailment}</td>
				<td width="20%">${patient.allergies}</td>
				<td>${patient.travel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>