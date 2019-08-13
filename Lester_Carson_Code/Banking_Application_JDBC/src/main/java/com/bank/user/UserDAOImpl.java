package com.bank.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	
	private static String url = "jdbc:oracle:thin:@lestercarson.cij8ici48e2h.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "lbcarson4";
	private static String password = "Lbc49681ataws";

	@Override
	public void insertUser(User u) {
	
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Username already exists...");
		}
	}

	@Override
	public User selectUserByUsernameAndPassword(String name, String pass, int input, int id) {
		User u = null;
		
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM acclink WHERE pk_accountID = ? AND pk_username = ?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs, rs1;
			if (input == 1) {
				ps1.setInt(1, id);
				ps1.setString(2, name);
				rs1 = ps1.executeQuery();
				if (!rs1.next()) {
					return null;
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(rs.getString("username"), rs.getString("password"), rs.getInt("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}