package user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.userDB;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = "false";
		
		//successful pop up message ekk print kirimat avashya js code ek livima sadaha meya import kara atha
		PrintWriter set = response.getWriter();
		response.setContentType("text/html");
		
		
		//update kirima sadaha user edit krpu variable labaganima
		String username = request.getParameter("userName");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("addr");
		String nic = request.getParameter("nic");
		String pass = request.getParameter("pass");
		System.out.println(nic);
		answer = userDB.updateData(username, fname, lname, phone, email, address, nic, pass);
		
		if(answer != "false") {
			request.setAttribute("Message", answer);
			request.getRequestDispatcher("Home.jsp").forward(request, response); 
		}
		else {
			request.setAttribute("Message", "Your User Name is Already Exixts");
			request.getRequestDispatcher("ViewUserProfile.jsp").forward(request, response);
		}
		
		
	}

}
