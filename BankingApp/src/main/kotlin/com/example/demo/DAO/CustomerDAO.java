package com.example.demo.DAO;

import com.example.demo.data.UserData;
import com.example.demo.model.Customer;
import com.example.demo.utility.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO implements Insert<Customer>, Select<Customer>,
        Update<Customer>
{
	ConnectionManager connectionManager = ConnectionManager.getInstance();

	UserDAO userDAO = new UserDAO();

	@Override
	public void update(Customer obj)
	{
		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CUSTOMERS set FIRSTNAME = ?, " +
					"LASTNAME = ?, ADDRESS = ? where CUSTOMER_ID = ?");
			preparedStatement.setString(1, obj.getFirstname().getValue());
			preparedStatement.setString(2, obj.getLastname().getValue());
			preparedStatement.setString(3, obj.getAddress().getValue());
			preparedStatement.setInt(4, obj.getCustomerID());

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Customer selectOne(int id)
	{
		Connection connection = connectionManager.getConnection();
		Customer customer = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from CUSTOMERS where CUSTOMER_ID = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				customer = new Customer();
				customer.setCustomerID(resultSet.getInt(1));
				customer.setFirstname(resultSet.getString(2));
				customer.setLastname(resultSet.getString(3));
				customer.setAddress(resultSet.getString(4));

				UserData userData = userDAO.selectOne(customer.getCustomerID());
				customer.setUsername(userData.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public ArrayList<Customer> selectAll()
	{
		Connection connection = connectionManager.getConnection();
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from CUSTOMERS");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next())
			{
				Customer customer = new Customer();
				customer.setCustomerID(resultSet.getInt(1));
				customer.setFirstname(resultSet.getString(2));
				customer.setLastname(resultSet.getString(3));
				customer.setAddress(resultSet.getString(4));

				UserData userData = userDAO.selectOne(customer.getCustomerID());
				customer.setUsername(userData.getUsername());

				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;
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
		int id = 0;

		Connection connection = connectionManager.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from USER_JUNCTION where USERNAME = ?");
			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				id = resultSet.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.selectOne(id);
	}
}
