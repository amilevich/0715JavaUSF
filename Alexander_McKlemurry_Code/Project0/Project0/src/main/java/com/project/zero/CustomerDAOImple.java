package com.project.zero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







public class CustomerDAOImple implements CustomerDAO {

			
	private static String url = "jdbc:oracle:thin:@database-2.cquzpqvssqcb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Attacus";
	private static String password = "Shadow678";
	
	
	
	
	
	

	public Customer selectCustomerByName(String name) {
		
	Customer customer = null;
	try(Connection conn = DriverManager.getConnection(url, username, password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankAccountA WHERE a_fname=?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			customer = new Customer(rs.getString("a_fname"), rs.getString("a_lname"), rs.getInt("a_accNumber"), rs.getString("a_passWord"), rs.getInt("a_id"), 9000 );
		}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return customer;	
			
		
	}
	@Override
	public Customer updateCustomer(Customer c) {
		Customer customer = null;
		try {Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement ps = conn.prepareStatement("UPDATE BankAccountA WHERE name=?,?,?,?,?,?");
		ps.setInt(1,c.getid());
		ps.setString(2,c.getpassWord());
		ps.setString(3,c.getfName());
		ps.setString(4,c.getlName());
		ps.setInt(5,c.getaccNumber());
		ps.setInt(6,c.getBalance());
		ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String deleteCustomer(Customer c) {
		try(Connection conn = DriverManager.getConnection(url, username, password);){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM BankAccountA WHERE name =?,?,?,?,?,?");
			ps.setInt(1, c.getid());
			ps.setString(2, c.getpassWord());
			ps.setString(3,  c.getfName());
			ps.setString(4, c.getlName());
			ps.setInt(5, c.getaccNumber());
			ps.setInt(6, c.getBalance());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return null;
	}

	@Override
	public String insertCustomer(Customer c) {
		try{Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO BankAccountA VALUES(?,?,?,?,?,?)");
			ps.setInt(1, c.getid());
			ps.setString(2, c.getpassWord());
			ps.setString(3, c.getfName());
			ps.setString(4, c.getlName());
			ps.setInt(5, c.getaccNumber());
			ps.setInt(6, c.getBalance());
			ps.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return toString();
	}

	

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> customer = new ArrayList<Customer>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM BankAccountA");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer.add(new Customer(rs.getString(1), rs.getString(2), 0, null, 0, 9000));
				
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	public int getBalance(int  balance) {
		return balance;
	}

	
		
	

	
	
	
	
		
}
