package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:3306/droneservice?useSSL=false";
	
	public DBConnection(String username, String password)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
}
