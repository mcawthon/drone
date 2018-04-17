package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grocery;
import dbhelpers.ReadRecord;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get an item and use the data to fill in a table for updating the record", urlPatterns = { "/update" })
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
		// get the bookID
		String sku = request.getParameter("sku");
		
		// create ReadRecord class
		ReadRecord rr = new ReadRecord("grocery_list", "root", "admin", sku);
		
		// Use ReadRecord to get the book data
		rr.doRead();
		
		Grocery grocery = rr.getGrocery();
		
		// pass Book and control to the updateForm.jsp
		request.setAttribute("grocery", grocery);
		
		String url = "/updateForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
