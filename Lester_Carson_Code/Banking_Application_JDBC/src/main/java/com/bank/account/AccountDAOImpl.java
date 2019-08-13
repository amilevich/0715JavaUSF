package com.bank.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO {

	private static String url = "jdbc:oracle:thin:@lestercarson.cij8ici48e2h.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "lbcarson4";
	private static String password = "Lbc49681ataws";
	
	@Override
	public void insertAccount(Account a, String name) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES(?,?,?)");
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM (SELECT * FROM accounts ORDER BY accountID DESC) WHERE ROWNUM = 1");
			PreparedStatement ps3 = conn.prepareStatement("INSERT INTO acclink VALUES(?,?)");
			
			ps.setNull(1, java.sql.Types.INTEGER);
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getIsapproved());
			ps.executeUpdate();
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				a = new Account(rs.getInt("accountID"), rs.getInt("isapproved"), rs.getDouble("balance"));
			}
			ps3.setInt(1, a.getAccountID());
			System.out.println("Account " + a.getAccountID() + " Created...");
			ps3.setString(2, name);
			ps3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertUsernameToAccount(Account a, String name) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO acclink VALUES(?,?)");
			
			ps.setInt(1, a.getAccountID());
			ps.setString(2, name);
			ps.executeUpdate();
			ps.cancel();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account selectAccountByID(int id) {
		Account acc = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE accountID = ?");
			PreparedStatement ps1 = conn.prepareStatement("SELECT pk_username FROM acclink WHERE pk_accountID = ?");
			ps.setInt(1, id);
			ps1.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ResultSet rs1 = ps1.executeQuery();
			while (rs.next()) {
				acc = new Account(rs.getInt("accountID"), rs.getInt("isapproved"), rs.getDouble("balance"));
			}
			while (rs1.next()) {}
			ps.cancel();
			ps1.cancel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	
	@Override
	public ArrayList<String> selectUsernamesLinkedToAccount(int id) {
		
		ArrayList<String> users = new ArrayList<String>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT pk_username FROM acclink WHERE pk_accountID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(rs.getString("pk_username"));
			}
			ps.cancel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void updateAccountBalance(Account a) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = ? WHERE accountID = ?");
			ps.setDouble(1, a.getBalance());
			ps.setInt(2, a.getAccountID());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccountisapproved(Account a) {
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET isapproved = ? WHERE accountID = ?");
			ps.setInt(1, a.getIsapproved());
			ps.setInt(2, a.getAccountID());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}