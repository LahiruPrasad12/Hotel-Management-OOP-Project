package user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataBase.userDB;
import dataBase.userDB.*;

@WebServlet("/ViewProfileServelet")
public class ViewProfileServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Log vela inna userge user name ek capture karagnima memegin siduve
		String name = request.getParameter("name");
		
		try {
			
		//Database ekt user name ek pass kirima saha database eken return krana value capture karaganima mehidi siduve
			List<User> details = userDB.ViewDetails(name);
			
			//me "nam" variable ek use kre data view krana userge username ek laba ganimata 
			String nam = details.get(0).getUsername();
			
			//ema user name ek uname valata set kirima mehidi sidu karai
			request.setAttribute("uname", nam);
			
			
			//loged userge retrieve karagat siyaluma details det valata assign kirimak saha ViewUserProfile page ekete redirect mehidid sidu karai
			request.setAttribute("det", details);
			RequestDispatcher redD = request.getRequestDispatcher("ViewUserProfile.jsp");
			redD.forward(request, response);
			
			
			
			
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
