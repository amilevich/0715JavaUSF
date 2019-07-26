package com.example.demo.model;

public class Customer extends User
{
	private String firstname;
	
	private String lastname;
	
	private String address;
	
	private int customerID;
	
	public Customer(String username, String password)
	{
		super(username, password);
		this.address = "";
		this.firstname = "";
		this.lastname = "";
		this.customerID = 0;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}
}
