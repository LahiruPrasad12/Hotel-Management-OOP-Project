package Hotel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateHootelServlet
 */
@WebServlet("/UpdateHootelServlet")
public class UpdateHootelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		import
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		
		boolean value = false;
		
		String name = request.getParameter("name");
		String address = request.getParameter("add");
		String contact = request.getParameter("contact");
		String director = request.getParameter("dir");
		String owner = request.getParameter("own");
		String rating = request.getParameter("rate");
		String noOfHalls = request.getParameter("nOh");
		
		try {
			
			value = HotelDBUtil.updatetHotel(name, address, contact, director, owner, rating, noOfHalls);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(value==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Hotel updated successfully! ');");
			out.println("location='AdminInterface.jsp'");
			out.println("</script>");
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Error!');");
			out.println("location='HotelDetails.jsp'");
			out.println("</script>");
		}
		
	}

}
