package model;

public class User 
{
	private String userID;
	private String password;
	
	public User()
	{
		userID = "";
		password = "";
	}
	
	public User(String userID, String password)
	{
		this.userID = userID;
		this.password = password;
	}
	
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getUserID()
	{
		return userID;
	}
	
	public String getPassword()
	{
		return password;
	}
}

