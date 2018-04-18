package helpers;

import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginHelper
{
	DBConnection dbc = new DBConnection("root", "root");
	Connection conn = dbc.getConnection();
	
	public boolean validateUser(String user, String password)
	{
		String sql = "select * from Users where userID = ? and password = ?;";
		
		try 
		{
			PreparedStatement ps  = conn.prepareStatement(sql);
			
			ps.setString(1, user);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			
		}
		return false;
	}
}
