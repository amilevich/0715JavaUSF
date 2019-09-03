package com.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.accounts.BankAccount;
import com.banking.accounts.CustomerAccount;


public class CustomerDao implements CustomerDaoInt {
	
private static String url = ""; // endpoint: port: SID
	
	private static String username = "";
	private static String password = "";

	@Override
	public void insertCustomerAccount(CustomerAccount client) {
		
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customer_accounts VALUES(null,?,?,?,?,?,?,null,1)"); 
			//ps.setInt(1, g.getCustomerID());  Set to null so database can autofill via trigger and sequence
			ps.setString(1, client.getUsername());
			ps.setString(2, client.getPassword());
			ps.setString(3, client.getFirstName());
			ps.setString(4, client.getLastName());
			ps.setLong(5, client.getPhoneNumber());
			ps.setInt(6, client.getAge());
			//ps.setString(2, client.get());  placeHolder for JointAccess
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public CustomerAccount selectCustomerByUsername(String userName) { //use for printing toString of customer info
		CustomerAccount customer = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer_accounts WHERE username =?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new CustomerAccount(rs.getInt("customerid"),rs.getString("firstname"), rs.getString("lastname"), rs.getLong("phonenumber"), rs.getInt("age"), rs.getString("username"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
		
	}
	
	
	

	@Override
	public List<CustomerAccount> selectAllCustomers() {
		List<CustomerAccount> accounts = new ArrayList<CustomerAccount>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer_accounts");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new CustomerAccount(rs.getInt("customerid"), rs.getString("firstname"), rs.getString("lastname"), rs.getLong("phonenumber"), rs.getInt("age"), rs.getString("username")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	

	@Override
	public void deleteCustomerAccount(CustomerAccount client) {
		// TODO Auto-generated method stub
	}
		


	@Override
	public String validateUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount updateAccountInfo(CustomerAccount client) {
		// TODO Auto-generated method stub
		return null;
}	
	
	public void setJointAccess(int customerid, String jointAccess) {
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("UPDATE customer_accounts SET jointaccess = ? WHERE customerid = ?"); 
			ps.setString(1, jointAccess);
			ps.setInt(2, customerid);
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
