package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.AddQuery;
import model.Part;
import model.DroneService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new book to the database", urlPatterns = { "/add" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type.equals("s"))
		{
			int serviceid = Integer.parseInt()request.getParameter("serviceid"));
			int droneid = Integer.parseInt(request.getParameter("droneid"));
			String date = request.getParameter("date");
			String description = request.getParameter("description");
			String parts = request.getParameter("parts");
			String technician = request.getParameter("technician");
	    
			DroneService ds = new DroneService();
			ds.setServiceID(serviceid);
			ds.setDroneID(droneid);
			ds.setDate(date);
			ds.setDescription(description);
			ds.setParts(parts);
			ds.setTechnician(technician);
	    
			AddQuery aq = new AddQuery("droneservice", "root", "admin");
	    
			aq.addService(ds);
	    
		// pass execution control to the ReadServlet
	    String url = "/read";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
		}
		else if(type = "p")
		{
			int partid = Integer.parseInt(request.getParameter("partid"));
			String serialnumber = request.getParameter("serialnumber");
		    long expdate = Date.parse(request.getParameter("expdate"));
		    String supplierID = request.getParameter("supplierid");
		    String condition = request.getParameter("condition");
		    int reorder = Integer.parseInt(request.getParameter("reorderlevel"));
		    int amount = Integer.parseInt(request.getParameter("amount"));
		    
		    Part part = new Part();
		    part.setPartID(partid);
		    part.setSerialNum(serialnumber);
		    part.setExpirationDate(expDate);
		    part.setSupplierID(supplierID);
		    part.setCondition(condition);
		    part.setReorderLevel(reorder);
		    part.setAmount(amount);
		    
		    AddQuery aq = new AddQuery("droneservice", "root", "admin");
		    
		    aq.addPart(part);
		    
			// pass execution control to the ReadServlet
		    String url = "/read";
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		}
		else
		{
			String url = "/read";
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		}
	    
		
	}

}
