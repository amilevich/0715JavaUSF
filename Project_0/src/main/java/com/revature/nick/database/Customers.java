package com.revature.nick.database;

import java.util.HashMap;

import com.revature.nick.model.Customer;

public class Customers
{
	private static Customers instance = null;
	
	private HashMap<Integer, Customer> customerMap; 
	
	private Customers()
	{
		customerMap = new HashMap<Integer, Customer>();
	}
	
	public Customers getInstance()
	{
		if (instance == null)
		{
			instance = new Customers();
		}
		return instance;
	}
	
	public void addCustomer(Customer customer)
	{
		this.customerMap.put(customer.getCustomerID(), customer);
	}
	
	public Customer getCustomer(int id)
	{
		return this.customerMap.get(id);
	}
}
