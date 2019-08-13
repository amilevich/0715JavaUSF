package com.application.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
	private static String url = "jdbc:oracle:thin:@db0715javausf.chts6t7vjaia.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "user0715java";
	private static String password = "p4ssw0rd";

	@Override
	public int createAccount(Account acc) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Account(balance) VALUES(?,?)");
			ps.setString(1, acc.getAccountUsername());
			ps.setDouble(1, acc.getBalance());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}



	@Override
	public List<Account> selectAllAccounts() {
		List<Account> acc = new ArrayList<Account>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				acc.add(new Account(rs.getString(1), rs.getDouble(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return acc;
	}

	@Override
	public int updateAccount(double balance, String userName) {
		Account acc1 = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("UPDATE Account SET balance = ? WHERE userName=?");
			ps.setDouble(1, acc1.getBalance());
			ps.setString(2, acc1.getAccountUsername());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccount(Account acc) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Account WHERE userName=?");
			ps.setString(1, acc.getAccountUsername());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}



	@Override
	public Account selectAccByUsername(String userName) {
		Account acc = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE userName = ?");
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				acc = new Account(rs.getString(1), rs.getDouble(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

//	@Override
//	public void createJunctiontable(Account acc1) {
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO Junction VALUES(?,?)");
//			ps.setInt(1, acc1.getAccountId());
//			ps.setString(2, acc1.getUserName1());
//			ps.executeUpdate();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}

}
