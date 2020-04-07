<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
</head>
<body>
<table>
<thead>
<tr>
<th>Username</th>
<th>Password</th>
</tr>
</thead>
<tbody>
<s:iterator value="ajay">
<tr>
<td><s:property value="username" /></td>
<td><s:property value="password" /></td>
</tr>
</s:iterator>
</tbody>
</table>
<s:iterator value="lastList">
<a href="showData.action?page=<s:property />"><s:property /></a>
</s:iterator>
</body>
</html>