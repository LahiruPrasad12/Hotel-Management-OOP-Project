package Bookings;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.HotelDBUtil;
import Packages.Packages;

@WebServlet("/viewPackageServlet")
public class viewPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelName = request.getParameter("hid");
		String username = request.getParameter("uname");
		System.out.println(hotelName);
		
		try {
			 List<Packages> pack = HotelDBUtil.getPackage(hotelName);
			 request.setAttribute("Message", username);
			 request.setAttribute("details", pack);
			 RequestDispatcher rd = request.getRequestDispatcher("viewPackage.jsp");
			 rd.forward(request, response);
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
