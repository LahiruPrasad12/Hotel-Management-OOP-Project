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

	<form action="updateBookingServlet" method="post">
		<c:forEach var="p" items="${details}">	
	
		bookId : <input type="text" name="bookId" value="${p.bookId}" readonly><br>
		Date : <input type="text" name="date" value="${p.date}" ><br>
		Number Of Adults : <input type="text" name="numAdult" value="${p.numOfAdults}"><br>
		Number Of Child : <input type="text" name="numChild" value="${p.numOfChild}"><br>
		packageID : <input type="text" name="packIg" value="${p.packageID}" readonly><br>
		userName : <input type="text" name="uname" value="${p.userName}" readonly ><br>
		<input type="submit" value="Update Booking">
		
	</c:forEach>
	</form>	
	
	<form action="deleteBooking" method="post">
	<input type="text" name="pack" placeholder="Enter package ID">
	<button>Delete package</button>
	</form> 
	
</body>
</html>