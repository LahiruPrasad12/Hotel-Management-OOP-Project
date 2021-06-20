package Bookings;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.userDB;

@WebServlet("/ViewBookingDetails")
public class ViewBookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("uname");
		System.out.println(uName);
		try {
			List<Booking> det = userDB.viewBookDet(uName);
			request.setAttribute("details", det);
			RequestDispatcher rd = request.getRequestDispatcher("viewBookingDetails.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
