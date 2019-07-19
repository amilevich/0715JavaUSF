package com.revature.nick.database;

import java.util.ArrayList;
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
	
	public static Customers getInstance()
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
	
	public void deleteCustomer(int id)
	{
		this.customerMap.remove(id);
	}
	
	public void updateCustomer(Customer update)
	{
		int key = update.getCustomerID();
		this.customerMap.get(key).setAddress(update.getAddress());
		this.customerMap.get(key).setFirstname(update.getFirstname());
		this.customerMap.get(key).setLastname(update.getLastname());
	}
	
	public ArrayList<Customer> getAllCustomers()
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		for(int i : this.customerMap.keySet())
		{
			list.add(this.customerMap.get(i));
		}
		
		return list;
	}
}
