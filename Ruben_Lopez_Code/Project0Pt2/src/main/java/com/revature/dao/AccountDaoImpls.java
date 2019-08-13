package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.model.Account;

public class AccountDaoImpls implements AccountDao {
	
	
	private static String url = "jdbc:oracle:thin:@rubendb.crbseux6wvrb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "LopezR013";
	private static String password = "Wtwmbiwfil13";

	
	//CREATE
	public int createNewAccount() {
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Account(accountnumber, balance, status, thirdaccount ) VALUES (  ? , ? , ? , ? ) ");
			ps.setInt(1, 0);
			ps.setInt(2, 20);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
		
	}
	
	

	
	//READ
	@Override
	public List<Account> selectAllAccount() {
		List<Account> account = new ArrayList<Account>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				account.add(new Account(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public int gethighestAccountNumber() {
		int highestInt = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(Accountnumber) FROM Account");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				highestInt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return highestInt;
	}
	
	public boolean checkForaccount(int accountnumber) {
		
		boolean flag = false;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select count(*) from Account where accountnumber = ?");
			ps.setInt(1, accountnumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				flag = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int getBalanceByAccountNumber(int accountnumber) {
		
		int tempnumber = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select balance from Account where accountnumber = ?");
			ps.setInt(1, accountnumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tempnumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempnumber;
	}
	
	public int getStatusByAccountNumber(int accountnumber) {
		
		int tempnumber = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select status from Account where accountnumber = ?");
			ps.setInt(1, accountnumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tempnumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempnumber;
		
	}
	
	public boolean checkIfJoinable(String usertracker) {
		
		boolean flag = false;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("Select count(*) FROM Account a , Account b ,junction c Where c.username = ? AND c.accountnumber = a.accountnumber AND a.accountnumber = b.status And b.status = a.accountnumber");
			ps.setString(1, usertracker);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				flag = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
		
	}
	public int getThirdAccountByAccountnumber(int tempaccountnumber) {
		
		int tempnumber = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select thirdaccount from Account where accountnumber = ?");
			ps.setInt(1, tempaccountnumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tempnumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempnumber;
		
		
		
	}
	
	
	
	
			
	//UPDATE
	
	public int setBalacne(int accountnumber, int newbalance) {
		
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("Update Account set balance = ? where accountnumber = ?");
			
			ps.setInt(1, newbalance);
			ps.setInt(2, accountnumber);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;	
	}
	
	public int setStatus(int accountnumber, int newstatus) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Account set status = ? Where accountnumber = ?");
			
			ps.setInt(1, newstatus);
			ps.setInt(2, accountnumber);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	public int setThirdAccount(int accountnumber, int thirdaccountnumber) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Account set thirdaccount = ? Where accountnumber = ?");
			
			ps.setInt(1, thirdaccountnumber);
			ps.setInt(2, accountnumber);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
		
	}
			
	//DELETE
	
	public int deleteAccountbyAccountNumber(int accountnumber) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Account WHERE accountnumber = ?");
			
			ps.setInt(1, accountnumber);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
		
	}
	

	
	
		
		
		

	

}
