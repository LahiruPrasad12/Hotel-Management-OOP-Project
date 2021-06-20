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
 * Servlet implementation class DeleteHotelServlet
 */
@WebServlet("/DeleteHotelServlet")
public class DeleteHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		import
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");	
		
		boolean value = false;
		
		String hName = request.getParameter("hn");
	
		try {
			
			value = HotelDBUtil.deleteHotel(hName);
			
			if(value==true) {
				out.println("<script type='text/javascript'>");
				out.println("alert('Hotel deleted successfully! ');");
				out.println("location='AdminInterface.jsp'");
				out.println("</script>");
			}
			else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Error');");
				out.println("location='HotelDetails.jsp'");
				out.println("</script>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
