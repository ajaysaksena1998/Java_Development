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
	background-color: #6610f2;
}

table, tr {
	color: #fff;
}
</style>
<meta charset="ISO-8859-1">
<title>Medicine List</title>
</head>
<body>
	<h2 align="center">Medicine Stock List</h2>
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
			<th width="10%">Medicine</th>
			<th width="10%">Stock Amount</th>
		</tr>
		<c:forEach items="${stock}" var="stock">
			<tr>
				<td>${stock.medicine}</td>
				<td>${stock.amount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>