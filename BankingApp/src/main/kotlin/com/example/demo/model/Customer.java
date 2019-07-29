package com.example.demo.model;

import javafx.beans.property.SimpleStringProperty;

public class Customer extends User
{
	private SimpleStringProperty firstname;
	
	private SimpleStringProperty lastname;
	
	private SimpleStringProperty address;
	
	private int customerID;
	
	public Customer()
	{
		super();
		this.address = new SimpleStringProperty("");
		this.firstname = new SimpleStringProperty("");
		this.lastname = new SimpleStringProperty("");
		this.customerID = 0;
	}

	public SimpleStringProperty getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname.set(firstname);
	}

	public SimpleStringProperty getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname.set(lastname);
	}

	public SimpleStringProperty getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address.set(address);
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
