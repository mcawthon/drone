package model;

import java.util.Date;

public class Part 
{
	private int partID;
	private String serialNum;
	private Date expirationDate;
	private String supplierID;
	private String condition;
	private int reorderLevel;
	private int amount;
	
	public Part()
	{
		
	}

	public Part(int partID, String serialNum, Date expirationDate, String supplierID, String condition,
			int reorderLevel, int amount) 
	{
		this.partID = partID;
		this.serialNum = serialNum;
		this.expirationDate = expirationDate;
		this.supplierID = supplierID;
		this.condition = condition;
		this.reorderLevel = reorderLevel;
		this.amount = amount;
	}

	public int getPartID() 
	{
		return partID;
	}

	public void setPartID(int partID) 
	{
		this.partID = partID;
	}

	public String getSerialNum() 
	{
		return serialNum;
	}

	public void setSerialNum(String serialNum) 
	{
		this.serialNum = serialNum;
	}

	public Date getExpirationDate() 
	{
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) 
	{
		this.expirationDate = expirationDate;
	}

	public String getSupplierID() 
	{
		return supplierID;
	}

	public void setSupplierID(String supplierID) 
	{
		this.supplierID = supplierID;
	}

	public String getCondition() 
	{
		return condition;
	}

	public void setCondition(String condition) 
	{
		this.condition = condition;
	}

	public int getReorderLevel() 
	{
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) 
	{
		this.reorderLevel = reorderLevel;
	}

	public int getAmount() 
	{
		return amount;
	}

	public void setAmount(int amount) 
	{
		this.amount = amount;
	}	
}
