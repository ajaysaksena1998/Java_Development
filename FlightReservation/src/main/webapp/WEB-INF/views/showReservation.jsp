<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Reservation</title>
</head>
<body>
<h2>Flight Reservation</h2>
Airlines: ${ flight.operatingAirlines}<br>
Departure City: ${ flight.departureCity }<br>
Arrival City: ${flight.arrival_city }<br>

<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details</h2>
First Name: <input type="text" name="firstName">
Last Name: <input type="text" name="lastName">
Email: <input type="text" name="email">
Phone: <input type="text" name="phone">

<h2>Card Details</h2>
Name On Card: <input type="text" name="name_on_card">
Card Number: <input type="text" name="cardNumber">
Expiry Date: <input type="text" name="expirationDate">
3-digit Security Code: <input type="text" name="secCode">

<input type="hidden" name="flightId" value="${flight.id }">

<input type="submit" value="Confirm">
</pre>
</form>

</body>
</html>