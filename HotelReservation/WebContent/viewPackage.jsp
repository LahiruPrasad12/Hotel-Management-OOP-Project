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

	<table border="1">
		<tr>
			<th>Package ID</th> <th>Package Name</th> <th>Buffet Price</th> <th>Number Of Meals</th> <th>Pool Charges</th> <th>Gym Charges</th> <th>Liquor</th> <th>Time Duration</th> <th>Hotel Name</th>
		</tr>
			<c:forEach var="h" items="${details}">
				<tr>
					<td>${h.packId}</td> <td>${h.packageName}</td> <td>${h.buffetPrice}</td> <td>${h.numberOfMeals}</td> <td>${h.poolCharges}</td> <td>${h.gymCharges}</td> <td>${h.liquor}</td> <td>${h.timeDuration}</td> <td>${h.hotelName}</td>                   
				</tr>
			</c:forEach>
		</table>
		
	<form action="bookHotel" method="post">
		<input type="text" name="packID" placeholder="Enter Package ID"><br>
		<input type="text" name="UserName" value="${Message}" readonly><br>
		<input type="text" name="Date" placeholder="Enter Date"><br>
		<input type="text" name="NumOfAdults" placeholder="Number Of Adults"><br>
		<input type="text" name="NumOfChild" placeholder="Number Of Children"><br>
		<input type="submit" value="submit">
	</form>	
	
	
	
		

</body>
</html>