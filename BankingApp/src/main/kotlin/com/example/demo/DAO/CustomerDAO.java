package com.example.demo.DAO;

import com.example.demo.database.Customers;
import com.example.demo.model.Customer;
import com.example.demo.utility.ConnectionManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO implements Insert<Customer>, Delete<Customer>, Select<Customer>,
        Update<Customer>
{
	Customers customerData = Customers.getInstance();

	ConnectionManager connectionManager = ConnectionManager.getInstance();

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
		Connection connection = connectionManager.getConnection();
		try {
			CallableStatement callableStatement = connection.prepareCall("{call INSERT_NEW_CUSTOMER(?,?,?,?,?)}");
			callableStatement.setString(1, obj.getFirstname().getValue());
			callableStatement.setString(2, obj.getLastname().getValue());
			callableStatement.setString(3, obj.getAddress().getValue());
			callableStatement.setString(4, obj.getUsername().getValue());
			callableStatement.setString(5, obj.getPassword().getValue());

			callableStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Customer getCustomerByUsername(String username)
	{
		return customerData.getCustomerByUsername(username);
	}
}
