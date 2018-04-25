package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.LoginHelper;

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
		String url = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginHelper lg = new LoginHelper();
		if (lg.validateUser(username, password))
		{
			url = "repairs.jsp";
		}
		else 
		{
			url = "index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
