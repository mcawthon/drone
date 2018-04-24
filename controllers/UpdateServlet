package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.UpdateQuery;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateBook" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the form data and set up a Book object
		
		String type;
		// create an UpdateQuery object and use it to update the book
		if(type.equals("s"))
		{
			UpdateQuery uq = new UpdateQuery("droneservice", "root", "admin");
			uq.doServiceUpdate(service);
			
			// pass control on to the ReadServlet
			String url = "/read";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else if(type.equals("p"))
		{
			UpdateQuery uq = new UpdateQuery("droneservice", "root", "admin");
			uq.doPartUpdate(part);
			
			// pass control on to the ReadServlet
			String url = "/read";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else 
		{
			// pass control on to the ReadServlet
			String url = "/read";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
		
	}

}
