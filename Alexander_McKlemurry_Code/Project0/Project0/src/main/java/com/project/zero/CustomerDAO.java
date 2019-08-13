package com.project.zero;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public interface CustomerDAO {
			
	
	
	
	public  String insertCustomer(Customer c);
	
	
	public Customer selectCustomerByName(String name);
	public List<Customer> selectAllCustomers();
	
	public Customer updateCustomer(Customer c);
	
	public String deleteCustomer(Customer c);
}
