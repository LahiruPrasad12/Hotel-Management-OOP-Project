package Packages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hotel.HotelDBUtil;

/**
 * Servlet implementation class DeletePackageServlet
 */
@WebServlet("/DeletePackageServlet")
public class DeletePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		import
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");	
		
boolean value = false;
		
	int packId = Integer.parseInt(request.getParameter("packId"));
	
		try {
			
			value = HotelDBUtil.deletePackage(packId);
			
			if(value==true) {
				out.println("<script type='text/javascript'>");
				out.println("alert('Package deleted successfully! ');");
				out.println("location='AdminInterface.jsp'");
				out.println("</script>");
			}
			else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Error!');");
				out.println("location='PackageDetails.jsp'");
				out.println("</script>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	

}
