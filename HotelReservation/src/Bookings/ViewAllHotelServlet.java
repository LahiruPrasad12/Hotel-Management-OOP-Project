package Bookings;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.Hotel;
import dataBase.userDB;

@WebServlet("/ViewAllHotelServlet")
public class ViewAllHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uName");
		
		try {
			List<Hotel> details = userDB.viewHotel();
			request.setAttribute("det", details);
			
			request.setAttribute("Message", uname);
			RequestDispatcher rd = request.getRequestDispatcher("ViewHotel.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
