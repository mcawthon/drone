package model;

import java.util.Date;

public class Drone 
{
	private int droneID;
	private String make;
	private String model;
	private String year;
	private String vin;
	private String faaNum;
	private Date lastService;
	
	public Drone()
	{
		
	}

	public Drone(int droneID, String make, String model, String year, String vin, String faaNum, Date lastService)
	{
		this.droneID = droneID;
		this.make = make;
		this.model = model;
		this.year = year;
		this.vin = vin;
		this.faaNum = faaNum;
		this.lastService = lastService;
	}

	public int getDroneID() 
	{
		return droneID;
	}

	public void setDroneID(int droneID) 
	{
		this.droneID = droneID;
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make) 
	{
		this.make = make;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getYear() 
	{
		return year;
	}

	public void setYear(String year) 
	{
		this.year = year;
	}

	public String getVin() 
	{
		return vin;
	}

	public void setVin(String vin) 
	{
		this.vin = vin;
	}

	public String getFaaNum() 
	{
		return faaNum;
	}

	public void setFaaNum(String faaNum) 
	{
		this.faaNum = faaNum;
	}

	public Date getLastService() 
	{
		return lastService;
	}

	public void setLastService(Date lastService) 
	{
		this.lastService = lastService;
	}
	
	
}
