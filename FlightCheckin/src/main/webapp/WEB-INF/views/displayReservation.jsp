<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Information</title>
</head>
<body>
<h2>Flight Details</h2>
Airlines : ${reservation.flight.operatingAirlines }<br>
Flight Number: ${reservation.flight.flightNumber }<br>
Departure City : ${reservation.flight.departureCity }<br>
Arrival City : ${reservation.flight.arrival_city }<br>
Date Of Departure : ${reservation.flight.date_of_departure }<br>
Estimated Departure Time : ${reservation.flight.estimated_departure_time }<br><br>

<h2>Passenger Details</h2>
First Name : ${reservation.passenger.firstName }<br>
Last Name : ${reservation.passenger.lastName }<br>
Email : ${reservation.passenger.email }<br>
Phone : ${reservation.passenger.phone }<br><br>

<form action="completeCheckIn" method="post">
Enter the Number Of Bags You Want To Check In : <input type="text" name="number_of_bags">
<input type="hidden" name="reservationId" value="${reservation.id }">
<input type="submit" value="Check In"/>
</form>
</body>
</html>