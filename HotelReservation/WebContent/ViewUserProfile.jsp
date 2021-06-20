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


	
	<form action="UpdateProfileServlet" method="post" >
	
	<!-- userge details display kirima meme forEach loop ek magin sidu karai -->
	<c:forEach var="detail" items="${det}">
	user name : <input type ="text" name="userName" value="${detail.username}"> <br>
	First Name  :  <input type ="text" name="fname" value="${detail.fname}"> <br>
	Last Name :  <input type ="text" name="lname" value="${detail.lname}"><br>
	Phone Number :  <input type ="text" name="phone" value="${detail.phone}"><br>
	Email :  <input type ="text" name="email" value="${detail.email}"><br>
	address :  <input type ="text" name="addr" value="${detail.address}"><br>
	NIC :  <input type ="text" name="nic" value="${detail.nic}"><br>
	Password : <input type ="password" name="pass" value="${detail.password}"><br>
	
	<!--Display Error Message-->
	<div class="error">${Message}</div>
	
	<!-- mema button eka click kirimen userge details update kragata hakiya -->
	<input type="submit" value="Update">
	</c:forEach>
	</form>
	
	<form action="DeleteAccountServlete" method="post" >
	<button type = "submit" name ="name" value="${uname}">Deactivate</button>
	</form>
	
	
	
</body>
</html>