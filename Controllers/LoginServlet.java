package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Helpers.LoginHelper;
import Helpers.ReadQuery;
import model.User;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private int loginAttempts;
	private String url;

	
	public LoginServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();

		//check to make sure we've clicked link
		if(request.getParameter("logout") !=null){

			//logout and redirect to frontpage
			logout();
			url="index.jsp";
		}

		//forward our request along
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();

		//get the number of logins
		if(session.getAttribute("loginAttempts") == null){
			loginAttempts = 0;
		}
		
		//exceeded logins
				if(loginAttempts > 2){
					String errorMessage = "Error: Number of Login Attempts Exceeded";
					request.setAttribute("errorMessage", errorMessage);
					url = "index.jsp";
				}else {
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					LoginHelper lh;
					
					User validUser = null;
					
					try {
						lh = new LoginHelper();
						
						validUser = lh.validateUser(username, password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(validUser != null)
					{
					    session.invalidate();
					    session=request.getSession(true);
					    session.setAttribute("user", validUser);
					    url = "repairs.jsp";
					    
						ReadQuery rq = new ReadQuery("droneservice","root","9921559");
					}
					else
					{
						String errorMessage = "Error: Unrecognized Username or Password<br>Login attempts remaining: "+(3-(loginAttempts));
						request.setAttribute("errorMessage", errorMessage);

						//track login attempts (combats: brute force attacks)
						session.setAttribute("loginAttempts", loginAttempts++);
						url = "index.jsp";
					}
				}	
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			    //request.setAttribute("repairstable", rq.getDroneServiceHTML());
			    dispatcher.forward(request, response);	
	}
	
	public void logout() {
		session.invalidate();
	}
}
