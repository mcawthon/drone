package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grocery;
import dbhelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updateBook" })
public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemServlet() {
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
		String sku = request.getParameter("sku");
		String producttype = request.getParameter("producttype");
		String flavor = request.getParameter("flavor");
		double cost = Double.parseDouble(request.getParameter("cost"));
		double retail = Double.parseDouble(request.getParameter("retail"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		Grocery grocery = new Grocery();
		grocery.setSKU(sku);
		grocery.setProductType(producttype);
		grocery.setFlavor(flavor);
		grocery.setCost(cost);
		grocery.setRetail(retail);
		grocery.setAmount(amount);
		
		// create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("grocery_list", "root", "admin");
		uq.doUpdate(grocery);
		
		// pass control on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
