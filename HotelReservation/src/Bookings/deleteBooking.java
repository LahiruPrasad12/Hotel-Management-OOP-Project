package Bookings;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.userDB;


@WebServlet("/deleteBooking")
public class deleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bkId = Integer.parseInt(request.getParameter("pack"));
		System.out.println(bkId);
		
		boolean answer = false;
		
		try {
			
			answer = userDB.deleteBooking(bkId);
			
			if(answer==true) {
				//Display successful message
				request.setAttribute("Message",bkId );
				request.setAttribute("erMessage", "Successfull Deleted");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				
			}else {
				//Display successful message
				request.setAttribute("Message",bkId );
				request.setAttribute("erMessage", "Try Again");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
				
			}
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
