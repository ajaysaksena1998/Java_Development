<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.Font"%>
<%@page import="upes.techteam.configuration.App"%>
<%@page import="upes.techteam.models.Patient"%>
<%@page import="upes.techteam.dao.AppDaoImpl"%>
<%@page import="com.itextpdf.text.Element"%>
<%@page import="com.itextpdf.text.Chunk"%>
<%@page import="com.itextpdf.text.FontFactory"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Report</title>
</head>
<body>
	<c:set var="test" value="${jobs.name }" />
	<%!%>
	<%
		response.setContentType("application/pdf");
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		Font f1 = new Font();
		f1.setStyle(Font.BOLD);
		f1.setSize(20);
		Paragraph p = new Paragraph("Student Report",f1);
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		document.add( Chunk.NEWLINE );
		App obj = new App();
        Connection connection = obj.getConnection();
		String query = "select * from patient where sapid=? order by stuid desc limit 1";
		String q= "delete from studentreport where sapid=?";
		PreparedStatement stmt = connection.prepareStatement(query);
		PreparedStatement st = connection.prepareStatement(q);
		stmt.setString(1, request.getParameter("sapid"));
		st.setString(1, request.getParameter("sapid"));
	%>
	<%
		ResultSet rs = stmt.executeQuery();
	    st.executeUpdate();
		Paragraph p3 = null;
		Paragraph p4 = null;
		while (rs.next()) {
			p3 = new Paragraph();
			p3.add("Date:                   ");
			p3.add(rs.getString("date"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Name:                 ");
			p3.add(rs.getString("name"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p4 = new Paragraph();
			p4.add("Contact:              ");
			p4.add(rs.getString("contact"));
			document.add(p4);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Age:                    ");
			p3.add(rs.getString("age"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Gender:              ");
			p3.add(rs.getString("gender"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("SAP ID:              ");
			p3.add(rs.getString("sapid"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Doctor:               ");
			p3.add(rs.getString("doctor"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Course:              ");
			p3.add(rs.getString("course"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Medicine:           ");
			p3.add(rs.getString("medicine"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Diagnosis:          ");
			p3.add(rs.getString("diagnosis"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Temperature:     ");
			p3.add(rs.getString("temp"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Blood Pressure: ");
			p3.add(rs.getString("bp"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Weight:               ");
			p3.add(rs.getString("weight"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Chronic Ailment: ");
			p3.add(rs.getString("chronic_ailment"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Allergies:             ");
			p3.add(rs.getString("allergies"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Conveyance:       ");
			p3.add(rs.getString("travel"));
			document.add(p3);
			document.add( Chunk.NEWLINE );
			p3 = new Paragraph();
			p3.add("Current Address: ");
			p3.add(rs.getString("HostelAddr"));
			document.add(p3);
		}
		document.close();
	%>

</body>
</html>