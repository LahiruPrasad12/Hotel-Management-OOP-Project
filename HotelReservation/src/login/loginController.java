package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataBase.*;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//user input karana value capture kraganima mehidi sidu ve
		String uname = request.getParameter("username");
		String password = request.getParameter("psw");
		
		
		PrintWriter set = response.getWriter();
		response.setContentType("text/html");
		
		
		String result = "false";
		
		try {
			 result = userDB.validate(uname, password);
			 System.out.println("2"+result);
			 	if(result.equals("admin001")) {
				 request.setAttribute("Message", result);
				 request.getRequestDispatcher("AdminInterface.jsp").forward(request, response); 
			 	}
			 	
			 	else if(result != "false") {
			 		 request.setAttribute("Message", result);
					 request.getRequestDispatcher("Home.jsp").forward(request, response); 
					 
			 	}
			 	
			 else {
				 set.println("<script type = 'text/javascript'>");
				 set.println("alert('Ivalid User Name or Password!!!');");
				 set.println("location = 'login.jsp'");
				 set.println("</script>");
				
			 }
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		
			
			
		}
	

}
