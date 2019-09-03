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

public class BankDao implements BankDaoInt{
	
private static String url = ""; // endpoint: port: SID
	
	private static String username = "";
	private static String password = "";

	@Override
	public void insertBankAccount(BankAccount client, String user) {

		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_accounts VALUES(null,?,?,?,null,?)"); 
			//ps.setInt(1, client.getAccountID());
			ps.setDouble(1, client.getAccountBalance());
			ps.setString(2, client.getAccountType());
			ps.setString(3, user);
			//ps.setString(2, client.get());  placeHolder for JointAccess
			ps.setString(4, client.getStatus());
			ps.executeUpdate(); 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertJointBankAccount(BankAccount client, String user) {

		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_accounts VALUES(null,?,?,?,?,?)"); 
			//ps.setInt(1, client.getAccountID());
			ps.setDouble(1, client.getAccountBalance());
			ps.setString(2, client.getAccountType());
			ps.setString(3, user);
			ps.setString(4, client.getJointAccess());
			ps.setString(5, client.getStatus());
			ps.executeUpdate(); 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BankAccount selectBankByID(int accountID) {
		BankAccount account = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_accounts WHERE accountid =?");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				account = new BankAccount(rs.getString("accounttype"),rs.getInt("accountid"), rs.getDouble("accountbalance"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public double getAccountBalance(int accountid) {
		double accountbalance = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT accountbalance FROM bank_accounts WHERE accountid =?");
			ps.setInt(1, accountid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountbalance = rs.getDouble("accountbalance");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return accountbalance;
	}
	
	
	@Override
	public int getAccountId(String user) {
		int accountid = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT accountid FROM bank_accounts WHERE username =?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountid = rs.getInt("accountid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountid;
	}
	
	public String getJointAccess(String user) {
		String jointaccess = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT jointaccess FROM customer_accounts WHERE username =?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				jointaccess = rs.getString("jointaccess");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jointaccess;
	}
	
	public String getAccountStatus(String user) {
		String status = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT status FROM bank_accounts WHERE username =? AND accounttype= 'checking'");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				status = rs.getString("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public int getJointAccountId(String user, String jointAccess) {
		int accountid = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT accountid FROM bank_accounts WHERE username =? AND jointaccess = ?");
			ps.setString(1, user);
			ps.setString(2, jointAccess);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accountid = rs.getInt("accountid");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountid;
	}


	@Override
	public List<BankAccount> selectAllBankAccounts() {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_accounts");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new BankAccount(rs.getString("accounttype"), rs.getInt("accountid"), rs.getDouble("accountbalance")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	public List<BankAccount> selectAllPendingAccounts() {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_accounts WHERE status='pending'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new BankAccount(rs.getString("accounttype"),rs.getString("status"), rs.getInt("accountid"), rs.getDouble("accountbalance"), rs.getString("username"), rs.getString("jointaccess")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<BankAccount> selectAllActiveAccounts() {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_accounts WHERE status='active'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new BankAccount(rs.getString("accounttype"), rs.getString("status"), rs.getInt("accountid"), rs.getDouble("accountbalance"), rs.getString("username"), rs.getString("jointaccess")));
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public List<BankAccount> selectAllDeniedAccounts() {
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_accounts WHERE status='denied'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				accounts.add(new BankAccount(rs.getString("accounttype"), rs.getString("status"), rs.getInt("accountid"), rs.getDouble("accountbalance"), rs.getString("username"), rs.getString("jointaccess")));
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	

	@Override
	public void updateAccountBalance(int accountid, double cash) {
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("UPDATE bank_accounts SET accountbalance = ? WHERE accountid = ?"); 
			ps.setDouble(1, cash);
			ps.setInt(2, accountid);
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void approveAccount(int accountid) {
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("UPDATE bank_accounts SET status = 'active' WHERE accountid = ?"); 
			ps.setInt(1, accountid);
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void denyAccount(int accountid) {
		try {
			Connection conn = DriverManager.getConnection(url,username, password);
			PreparedStatement ps = conn.prepareStatement("UPDATE bank_accounts SET status = 'denied' WHERE accountid = ?");
			PreparedStatement ps2 = conn.prepareStatement("UPDATE bank_accounts SET accountid = 00000 WHERE accountid = ?");
			ps.setInt(1, accountid);
			ps2.setInt(1, accountid);
			ps.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBankAccount(BankAccount client) {
		// TODO Auto-generated method stub
		
	}

}
