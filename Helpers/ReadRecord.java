package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Drone;
import model.DroneService;
import model.Employee;
import model.Part;
import model.User;

public class ReadRecord 
{
	
	private Connection connection;
	private ResultSet DroneResults;
	private ResultSet DroneServiceResults;
	private ResultSet EmployeeResults;
	private ResultSet PartResults;
	private ResultSet UserResults;
	
	private int droneID;
	private int droneServiceID;
	private int employeeID;
	private int partID;
	private String userID;

	
	private Drone drone;
	private DroneService droneService;
	private Employee employee;
	private Part part;
	private User user;
	
	
	public ReadRecord(String dbName, String uname, String pwd)
	{
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDrone()
	{
		String query = "select * from drone where droneID = ?";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setLong(1, droneID);
			
			this.DroneResults = ps.executeQuery();
			
			this.DroneResults.next();
			
			drone.setDroneID(this.DroneResults.getInt("droneID"));
			drone.setMake(this.DroneResults.getString("make"));
			drone.setModel(this.DroneResults.getString("model"));
			drone.setYear(this.DroneResults.getString("year"));
			drone.setFaaNum(this.DroneResults.getString("faaNum"));
			drone.setLastService(this.DroneResults.getDate("lastService"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doDroneService()
	{
		String query = "select * from drone where droneID = ?";
		
		try
		{
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, droneServiceID);
			
			this.DroneServiceResults = ps.executeQuery();
			
			this.DroneResults.next();
			
			droneService.setServiceID(this.DroneServiceResults.getInt("serviceID"));
			droneService.setDescription(this.DroneServiceResults.getString("description"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doEmployee()
	{
		String query = "select * from employee where employeeID = ?";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setLong(1, employeeID);
			
			this.PartResults = ps.executeQuery();
			
			this.PartResults.next();
			
			
			employee.setFirstName(this.EmployeeResults.getString("employeeID"));
			employee.setLastName(this.EmployeeResults.getString("lastName"));
			employee.setPhone(this.EmployeeResults.getString("phone"));
			employee.setAddress(this.EmployeeResults.getString("address"));
			employee.setJobTitle(this.EmployeeResults.getString("jobTitle"));
			employee.setDateStarted(this.EmployeeResults.getDate("dateStarted"));
			employee.setDateTerminated(this.EmployeeResults.getDate("dateTerminated"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void doPart()
	{
		String query = "select * from part where partID = ?";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setLong(1, partID);
			
			this.PartResults = ps.executeQuery();
			
			this.PartResults.next();
			
			part.setPartID(this.PartResults.getInt("partID"));
			part.setSerialNum(this.PartResults.getString("serialNum"));
			part.setExpirationDate(this.PartResults.getDate("expirationDate"));
			part.setSupplierID(this.PartResults.getString("supplierID"));
			part.setCondition(this.PartResults.getString("condition"));
			part.setReorderLevel(this.PartResults.getInt("reorderLevel"));
			part.setAmount(this.PartResults.getInt("amount"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doUser()
	{
		String query = "select * from user where userID = ?";
		
		try 
		{
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, userID);
			
			this.UserResults = ps.executeQuery();
			
			this.UserResults.next();
			
			user.setUserID(this.UserResults.getString("userID"));
			user.setPassword(this.UserResults.getString("password"));
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Drone getDrone() 
	{
		return this.drone;
	}
	
	public DroneService getDroneService()
	{
		return this.droneService;
	}
	
	public Employee getEmployee()
	{
		return this.employee;
	}
	
	public Part getPart()
	{
		return this.part;
	}
	
	public User getUser()
	{
		return this.user;
	}
}
