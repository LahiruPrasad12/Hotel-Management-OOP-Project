<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>Welcome ${Message}</div>
	<form action="ViewProfileServelet" method="post" >
	<button type = "submit" name ="name" value="${Message}">View Profile</button>
	</form>
	
	<form action="ViewAllHotelServlet" method="post" >
	<button type = "submit" name="uName" value="${Message}">Book Hotel</button>
	</form>
	
	<form action="ViewBookingDetails" method="post" >
	<button type ="submit" name="uname" value="${Message}">View Booking</button>
	</form>
	
	<div class="error">${erMessage}</div>	
	
</body>
</html>