package com.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.banking.accounts.CustomerAccount;
import com.banking.accounts.EmployeeAccount;

public class EmployeeDao implements EmployeeDaoInt{
	
private static String url = "jdbc:oracle:thin:@dylansrevaturedb.cpu77pyuv98o.us-east-2.rds.amazonaws.com:1521:orcl"; // endpoint: port: SID
	
	private static String username = "Dboycerev";
	private static String password = "Dylanrev91";

	@Override
	public void insertEmployeeAccount(EmployeeAccount emp) { //needs fleshed out
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO employee_accounts VALUES(null,?,?,?,?,null)"); 
			//ps.setInt(1, g.getCustomerID());  Set to null so database can autofill via trigger and sequence
			ps.setString(1, emp.getUsername());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getFirstName());
			ps.setString(4, emp.getLastName());
			
			//ps.setString(2, client.get());  placeHolder for JointAccess
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public EmployeeAccount selectEmployeeByUsername(String userName) { 
		EmployeeAccount employee = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee_accounts WHERE username =?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee = new EmployeeAccount(rs.getString("username"),rs.getInt("type"), rs.getInt("employeeID"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
		
	}
		
	

	@Override
	public EmployeeAccount selectEmployeeByName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeAccount> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double updateEmployeeTitle(EmployeeAccount emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteEmployeeAccount(EmployeeAccount emp) {
		// TODO Auto-generated method stub
		
	}

}
