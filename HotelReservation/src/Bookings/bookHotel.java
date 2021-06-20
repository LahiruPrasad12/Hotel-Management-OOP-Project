package Bookings;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.userDB;

@WebServlet("/bookHotel")
public class bookHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PackageID = request.getParameter("packID");
		String UserName = request.getParameter("UserName");
		String Date = request.getParameter("Date");
		int NumOfAdults = Integer.parseInt(request.getParameter("NumOfAdults"));
		int NumOfChild = Integer.parseInt(request.getParameter("NumOfChild"));
		
		boolean answer = false;
		
		
		try {
			answer = userDB.addBookingDetails(PackageID, UserName, Date, NumOfAdults, NumOfChild);
			
			if(answer == true) {
				request.setAttribute("Message", UserName);
				RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
				
			}else {
				request.setAttribute("Message", UserName);
				request.setAttribute("erMessage", "Cann't Book this day");
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}catch (Exception e) {
			e.getMessage();
		}
		
		
		}


}
