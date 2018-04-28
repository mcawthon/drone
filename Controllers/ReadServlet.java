package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helpers.ReadQuery;

//import helpers.ReadQuery;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet(
		description = "Controller for reading from database", 
		urlPatterns = { 
				"/ReadServlet", 
				"/read"
		})
public class ReadServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String query = request.getParameter("string");
		String type = query.substring(0,1);
		int objectid = Integer.parseInt(query.substring(1));
		if(type.equalsIgnoreCase("d"))
		{
			// Create a ReadQuery helper object
			ReadQuery rq = new ReadQuery("droneservice", "root", "admin");
			rq.readDrone(objectid);
			// Get the html table from the ReadQuery object
			String table = rq.getDroneHTML();
			// pass execution control to read.jsp along with the table
			request.setAttribute("table", table);
			String url = "/drone.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else if(type.equalsIgnoreCase("s"))
		{
			ReadQuery rq = new ReadQuery("droneservice", "root", "admin");
			rq.readDroneService();
			
			//String table = rq.getDroneServiceHTML();
			
			//request.setAttribute("table", table);
			String url = "/service.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else if(type.equalsIgnoreCase("p"))
		{
			ReadQuery rq = new ReadQuery("droneservice", "root", "admin");
			rq.readPart();
			
			//String table = rq.getPartHTML();
			
			//request.setAttribute("table", table);
			String url = "part.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else if(type.equalsIgnoreCase("e"))
		{
			ReadQuery rq = new ReadQuery("droneservice", "root", "admin");
			rq.readEmployee();
			
			//String table = rq.getEmployeeHTML();
			
			//request.setAttribute("table", table);
			String url = "employee.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
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
