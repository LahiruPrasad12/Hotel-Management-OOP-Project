package Bookings;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBase.userDB;

@WebServlet("/updateBookingServlet")
public class updateBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookingId = Integer.parseInt(request.getParameter("bookId")); 
		String date = request.getParameter("date");
		int numberChild = Integer.parseInt(request.getParameter("numChild")); 
		int NumberAdult = Integer.parseInt(request.getParameter("numAdult")); 
		String uname = request.getParameter("uname");
		
		boolean answer = false;
		
		//unsuccessful pop up message ekk print kirimat avashya js code ek livima sadaha meya import kara atha
		PrintWriter set = response.getWriter();
		response.setContentType("text/html");
		
		
		try {
			
			answer = userDB.updateBooking(bookingId, date, numberChild, NumberAdult);
			
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		if(answer == true) {
			//Display successful message
			request.setAttribute("Message",uname );
			request.setAttribute("erMessage", "Successfull Updated");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}else {
			
			set.println("<script type = 'text/javascript'>");
			set.println("alert('TRY AGIAN');");
			set.println("location = 'Home.jsp'");
			set.println("</script>");
			
		}
	}

}
