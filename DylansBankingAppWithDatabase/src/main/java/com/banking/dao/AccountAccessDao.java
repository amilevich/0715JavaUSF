package com.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.banking.accounts.CustomerAccount;


public class AccountAccessDao implements AccountAccessDaoInt {
	
private static String url = ""; // endpoint: port: SID
	
	private static String username = "";
	private static String password = "";
	

	@Override
	public void insertAccountJunction(int customerID, int accountID,String accounttype) {
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO account_access VALUES(?,?,?)"); 
			ps.setInt(1, accountID);
			ps.setInt(2, customerID);
			ps.setString(3, accounttype);
			
			ps.executeUpdate(); 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void insertAccountJunction(int customerID, int accountID) {
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO account_access (accountid,customerid) VALUES(?,?)"); 
			ps.setInt(1, accountID);
			ps.setInt(2, customerID);
			
			
			ps.executeUpdate(); 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getAccountID(int customerID) {
		int accountID = 0;
try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT accountid FROM account_access WHERE customerid =? AND jointaccess IS NULL");
			ps.setInt(1, customerID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountID =  rs.getInt("accountid");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountID;
	}
	
	
	public int getJointAccountID(int customerID, String jointAccess) {
		int accountID = 0;
try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT accountid FROM account_access WHERE customerid =? AND jointaccess=?");
			ps.setInt(1, customerID);
			ps.setString(2, jointAccess);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountID =  rs.getInt("accountid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountID;
	}
	
	public String getJointAccess(int customerID) {
		String jointAccess = "null";
		try(Connection conn = DriverManager.getConnection(url, username, password)){
					
					PreparedStatement ps = conn.prepareStatement("SELECT jointaccess FROM account_access WHERE customerid =? AND jointaccess IS NOT NULL");
					ps.setInt(1, customerID);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						jointAccess =  rs.getString("jointaccess");
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return jointAccess;
	}
	

	@Override
	public List<CustomerAccount> viewAllJunctionIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount updateJunctionInfo(CustomerAccount client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomerAccount(CustomerAccount client) {
		// TODO Auto-generated method stub
		
	}

}
