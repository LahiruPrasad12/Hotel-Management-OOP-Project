package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.userDB;

@WebServlet("/DeleteAccountServlete")
public class DeleteAccountServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean answer = false;
		String name = request.getParameter("name");
		
		//this statement for write java script code to display pop up message
		PrintWriter set = response.getWriter();
		response.setContentType("text/html");
		
		try {
			answer = userDB.deleteAccount(name);
		
			if(answer == true) {
			
				set.println("<script type = 'text/javascript'>");
				set.println("alert('SUCCESSFUL DEACTIVATED!!!');");
				set.println("location = 'login.jsp'");
				set.println("</script>");
			
			}else {
			
				set.println("<script type = 'text/javascript'>");
				set.println("alert('TRY AGAIN');");
				set.println("location = 'ViewUserProfile.jsp'");
				set.println("</script>");
			
			}
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
