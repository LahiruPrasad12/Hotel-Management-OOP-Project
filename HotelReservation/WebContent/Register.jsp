<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	
	<div class="regnbox">
	<h1>Register Here</h1>
	<form action="RegisterController" method="post">
	
		<input type="text" name="fname" placeholder="First Name"><br>
		<input type="text" name="lname" placeholder="Last Name"><br>
		<input type="text" name="phone" placeholder="Contact Number"><br>
		<input type="text" name="email" placeholder="Email"><br>
		<input type="text" name="address" placeholder="Address"><br>
		<input type="text" name="Nic" placeholder="Nic"><br>
		<input type="text" name="userName" placeholder="User Name"><br>
		<input type="Password" name="password" placeholder="password">
		<input type="submit"  value="submit">
		<a href="login.jsp"><button type="button">back</button></a>
		<div class="error">${Message}</div>
		
	
	</form><!-- End Of The Form -->
	</div>

</body>
</html>