package com.revature.nick.data;

import com.revature.nick.model.Customer;

public class CurrentLoggedInCustomer
{
	private static CurrentLoggedInCustomer instance = null;
	
	private Customer customer;
	
	private CurrentLoggedInCustomer() {}
	
	public static CurrentLoggedInCustomer getInstance()
	{
		if (instance == null)
		{
			instance = new CurrentLoggedInCustomer();
		}
		return instance;
	}

	public Customer getLoggedInCustomer()
	{
		return customer;
	}

	public void setLoggedInCustomer(Customer customer)
	{
		this.customer = customer;
	}
}
