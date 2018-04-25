package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Drone;
import model.DroneService;
import helpers.HTMLHelper;


public class ReadQuery {
	
	private Connection connection;
	private ResultSet DroneResults;
	private ResultSet DroneServiceResults;
	private ResultSet DroneServiceHistoryResults;
	private ResultSet EmployeeResults;
	private ResultSet PartResults;
	private ResultSet UserResults;
	
	public ReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void readDrone(int droneid)
	{
		String query = "select * from drone where droneid = ?";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setInt(1, droneid);
			this.DroneResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readDroneService()
	{
		String query = "select * from droneservice;";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.DroneServiceResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readDroneServiceHistory(int droneid)
	{
		String query = "select date, description from droneservice where droneID = ?;";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setInt(1, droneid);
			this.DroneServiceHistoryResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readEmployee()
	{
		String query = "select * from employee;";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.EmployeeResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void readPart()
	{
		String query = "select * from part;";
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.PartResults= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getDroneHTML()
	{
		HTMLHelper hh = new HTMLHelper();
		try {
			while(this.DroneResults.next())
			{
				Drone drone = new Drone();
				drone.setDroneID(this.DroneResults.getInt("droneID"));
				drone.setMake(this.DroneResults.getString("make"));
				drone.setModel(this.DroneResults.getString("model"));
				drone.setYear(this.DroneResults.getString("year"));
				drone.setVin(this.DroneResults.getString("vin"));
				drone.setFaaNum(this.DroneResults.getString("faaNum"));
				
				
				hh.openTableTag();
				hh.Label("Drone:");
				hh.PlainText(drone.getDroneID());
				hh.LineBreak();
				hh.Label("Make:");
				hh.PlainText(drone.getMake());
				hh.LineBreak();
				hh.Label("Model:");
				hh.PlainText(drone.getModel());
				hh.LineBreak();
				hh.Label("Year:");
				hh.PlainText(drone.getYear());
				hh.LineBreak();
				hh.Label("VIN:");
				hh.PlainText(drone.getVin());
				hh.LineBreak();
				hh.Label("FAA Licence:");
				hh.PlainText(drone.getFaaNum());
				hh.LineBreak();
				
				//code to do html for service history
				hh.PlainText(getDroneServiceHTML());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		hh.closeTableTag();
		
		return hh.returnHTML();
	}
	
	public String getDroneServiceHTML()
	{
		 HTMLHelper hh = new HTMLHelper();
		 
		try {
			hh.openFormTag();
			DroneService ds = new DroneService();
			ds.setServiceID(this.DroneServiceHistoryResults.getInt("serviceid"));
			ds.setDate(this.DroneServiceHistoryResults.getString("date"));
			
			hh.openTableTag();
				hh.openTableRowTag();
					hh.openTableCellTag();
						hh.PlainText("Date");
					hh.closeTableCellTag();
					hh.openTableCellTag();
						hh.PlainText("Service ID");
					hh.closeTableCellTag();
				hh.closeTableRowTag();
			while(this.DroneServiceHistoryResults.next())
			{
				hh.openTableRowTag();
					hh.openTableCellTag();
						hh.PlainText(ds.getDate());
					hh.closeTableCellTag();
					hh.openTableCellTag();
						hh.PlainText(ds.getServiceID());
					hh.closeTableCellTag();
				hh.closeTableRowTag();
			}
			
			hh.closeTableTag();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hh.returnHTML();
		
		}

	
	
	
	
	

}
