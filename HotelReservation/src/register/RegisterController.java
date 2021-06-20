package register;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dataBase.userDB;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean ans = false;
		
		//unsuccessful pop up message ekk print kirimat avashya js code ek livima sadaha meya import kara atha
		PrintWriter set = response.getWriter();
		response.setContentType("text/html");
		
		//new userge data capture kraganima mehidi siduve
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		String Address = request.getParameter("address");
		String NIC = request.getParameter("Nic");
		String UserName = request.getParameter("userName");
		String Password = request.getParameter("password");
		
		try {
			//Send Captured details to entity class
			ans = userDB.addBusOwner(fName,lName, Email, Phone, Address,NIC, UserName, Password);
		}catch(Exception e) {
			e.getMessage();
		}
		
		if(ans == true) {
			//if userID not exists system redirect user to user login page 
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);	
		}
		else {
			//user exists user name ekk use krot inavlid message ekk print kara navat register page ekatam redirect karai
			set.println("<script type = 'text/javascript'>");
			set.println("alert('user name already exits');");
			set.println("location = 'Register.jsp'");
			set.println("</script>");
		}
		
	}

}
