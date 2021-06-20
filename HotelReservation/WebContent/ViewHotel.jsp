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
			<th>Hotel Name</th> <th>Hotel Address</th> <th>Contact Number</th> <th>Director</th> <th>Owner</th> <th>Rating</th> <th>Number of halls</th> <th>View Package</th>
		</tr>
			<c:forEach var="h" items="${det}">
				<tr>
					<td>${h.name}</td> <td>${h.address}</td> <td>${h.contact}</td> <td>${h.director}</td> <td>${h.owner}</td> <td>${h.rating}</td> <td>${h.noOfHalls}</td>
					 <td> <form action="viewPackageServlet" method="post"><input type="hidden" name="hid" value="${h.name}"><input type="hidden" name="uname" value="${Message}"><input type="submit" value="View Package"></form>                    
				</tr>
			</c:forEach>
		</table>


</body>
</html>