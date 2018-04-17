package model;

public class User 
{
	private String userID;
	private String password;
	private String type;
	
	public User()
	{
		
	}
	
	public User(String userID, String password, String type)
	{
		this.userID = userID;
		this.password = password;
		this.type = type;
	}
	
	public String getUserID() 
	{
		return userID;
	}

	public void setUserID(String userID) 
	{
		this.userID = userID;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}
}
