package com.application.bankapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private static String url = "jdbc:oracle:thin:@db0715javausf.chts6t7vjaia.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "user0715java";
	private static String password = "p4ssw0rd";

	@Override
	public int createUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?)");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassWord());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getStatus());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public User selectUserByName(String userName) {
		User u = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE userName = ?");
			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();
			ps.cancel();
			while (rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public boolean logIn(String userName, String passWord) {
		User u = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE userName = ? AND password = ?");
			ps.setString(1, userName);
			ps.setString(2, passWord);

			ResultSet rs = ps.executeQuery();
			ps.cancel();
			while (rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				String a = rs.getString(3);
				System.out.println("Welcome, " + a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> u = new ArrayList<User>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return u;
	}

	@Override
	public int updateUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET balance = ? WHERE accountId=?");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassWord());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getStatus());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("DELETE FROM Users WHERE username=?");
			ps.setString(1, u.getUserName());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public User pendingAccountApplication() {	
	User u = null;
	try (Connection conn = DriverManager.getConnection(url, username, password)) {

		PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE status=?");
		ps.setString(1, "Pending");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			//String userId = u.getUserName();
		}
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
	return u;
}

	@Override
	public void updateStatus(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("UPDATE Users SET status = 'Approved' WHERE userName=?");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getStatus());
			ps.executeUpdate();
			ps.cancel();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
