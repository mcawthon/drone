package Helpers;

import java.sql.SQLException;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginHelper
{
	DBConnection dbc = new DBConnection("root", "9921559");
	Connection conn = dbc.getConnection();
	
	public PreparedStatement validateUserPS;
	
	public User validateUser(String username, String password) throws SQLException 
	{
		String sql = "select * from Users where userID = ? and password = ?";
		User user = null;
		try 
		{
			validateUserPS = conn.prepareStatement(sql);
			
			validateUserPS.setString(1, username);
			validateUserPS.setString(2, password);
			
			ResultSet rs = validateUserPS.executeQuery();
			
			if (rs.next())
			{
				user = new User(rs.getString("userID"), rs.getString("password"));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return user;
	}
}
