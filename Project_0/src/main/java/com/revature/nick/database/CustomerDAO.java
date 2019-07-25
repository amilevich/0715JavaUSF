package com.revature.nick.database;

import java.util.ArrayList;

import com.revature.nick.events.Event;
import com.revature.nick.events.Subscriber;
import com.revature.nick.model.Customer;

public class CustomerDAO implements Insert<Customer>, Delete<Customer>, Select<Customer>, 
	Update<Customer>, Subscriber
{
	Customers customerData = Customers.getInstance();
	
	@Override
	public void update(Customer obj)
	{
		customerData.updateCustomer(obj);
	}

	@Override
	public Customer selectOne(int id)
	{
		return customerData.getCustomer(id);
	}

	@Override
	public ArrayList<Customer> selectAll()
	{
		return customerData.getAllCustomers();
	}

	@Override
	public void delete(int id)
	{
		customerData.deleteCustomer(id);
	}

	@Override
	public void insert(Customer obj)
	{
		customerData.addCustomer(obj);
	}

	@Override
	public void notify(Event event)
	{
		// TODO Auto-generated method stub
		
	}

}
