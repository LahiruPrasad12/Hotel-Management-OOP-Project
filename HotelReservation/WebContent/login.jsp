<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<form action="loginController" method="post">
		<input type ="text" name="username" placeholder="Enter User Name"><br>
		<input type="password" name="psw" placeholder="Enter Password"><br>
		<input type="submit" value="Login"><br>
		<p>Don't have an account ?<a href="Register.jsp">Sign Up</a></p>
	</form>

</body>
</html>