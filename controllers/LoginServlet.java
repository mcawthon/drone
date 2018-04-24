package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.LoginHelper;
import helpers.ReadQuery;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public LoginServlet()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.doGet(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Code to check for valid login credentials
		LoginHelper lh = new LoginHelper();
		boolean validUser =
		lh.validateUser(request.getParameter("username"), request.getParameter("password"));
		
		if(validUser)
		{
			String url = "repairs.jsp";
		    
			ReadQuery rq = new ReadQuery("droneservice","root","admin");
			String repairstable = rq.getDroneServiceHTML();
			
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    request.setAttribute("repairstable", repairstable);
		    dispatcher.forward(request, response);
		}
		else
		{
			String url = "index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
