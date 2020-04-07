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
<title>Expiry List</title>
</head>
<body>
	<h2 align="center">Expiry List</h2>
	<span class="collapse navbar-collapse navbar-right" id="myNavbar">
		<ul class="nav navbar-nav">
			<a class="whi" href="${pageContext.request.contextPath }/redirecting">Go
				Back</a>
		</ul>
	</span>
	<hr />
	<p />
	<p class="whi">The following medicines are expired or will be expired in the present month.</p>
	<table border="1" align="left">
		<tr>
			<th>Medicine</th>
			<th>Expiry Date</th>
		</tr>
		<c:forEach items="${expired}" var="items">
			<tr>
				<td width="5%">${items.medicine }</td>
				<td width="5%">${items.expiry}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>