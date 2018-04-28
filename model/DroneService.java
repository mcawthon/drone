package model;

public class DroneService 
{
	private int serviceID;
	private String description, serviceDate;
	private int employeeID, droneID, partID;
	
	
	
	
	public DroneService()
	{
		serviceID = 0; 
		description = "";
		serviceDate = "";
		employeeID = 0;
		droneID = 0;
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


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public int getDroneID() {
		return droneID;
	}


	public void setDroneID(int droneID) {
		this.droneID = droneID;
	}

	public int getPartID() {
		return partID;
	}


	public void setPartID(int partID) {
		this.partID = partID;
	}


}
