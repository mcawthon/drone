package model;

import java.util.Date;

public class Employee 
{
	private int employeeID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String jobCode;
	private String jobTitle;
	private Date dateStarted;
	private Date dateTerminated;
	
	public Employee()
	{
		
	}

	public Employee(int employeeID, String firstName, String lastName, String phone, String address, String jobCode,
			String jobTitle, Date dateStarted, Date dateTerminated)
	{
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.jobCode = jobCode;
		this.jobTitle = jobTitle;
		this.dateStarted = dateStarted;
		this.dateTerminated = dateTerminated;
	}

	public int getEmployeeID() 
	{
		return employeeID;
	}

	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getJobCode() 
	{
		return jobCode;
	}

	public void setJobCode(String jobCode) 
	{
		this.jobCode = jobCode;
	}

	public String getJobTitle() 
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) 
	{
		this.jobTitle = jobTitle;
	}

	public Date getDateStarted() 
	{
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) 
	{
		this.dateStarted = dateStarted;
	}

	public Date getDateTerminated() 
	{
		return dateTerminated;
	}

	public void setDateTerminated(Date dateTerminated)
	{
		this.dateTerminated = dateTerminated;
	}
	
	
}
