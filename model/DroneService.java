package model;

public class DroneService 
{
	private int serviceID;
	private String description;
	private String serviceDate;
	
	
	
	
	public DroneService()
	{
		serviceID = 0; 
		description = "";
	}
	
	
	public int getServiceID()
	{
		return serviceID;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setServiceID(int serviceID)
	{
		this.serviceID = serviceID;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}


	public String getDate() 
	{
		return serviceDate;
	}


	public void setDate(String servicedate) 
	{
		
		this.serviceDate = servicedate;
	}
}
