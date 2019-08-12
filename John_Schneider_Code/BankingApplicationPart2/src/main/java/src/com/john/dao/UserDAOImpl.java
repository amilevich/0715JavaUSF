package src.com.john.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.com.john.core.Admin;
import src.com.john.core.Customer;
import src.com.john.core.Employee;
import src.com.john.core.User;

public class UserDAOImpl implements UserDAO
{
	private static String url = "jdbc:oracle:thin:@database1.cqmnrwj9hkjl.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "Admin";
	private static String password = "Admin123";
	
	private static Connection conn;
	
	public UserDAOImpl()
	{
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(User user) {
		int type = 1;
		
		if(user instanceof Admin)
			type = 3;
		else if(user instanceof Employee)
			type = 2;
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users VALUES(?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, type);
			
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User selectUserByName(String username) {
		User user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE User.username = ?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				switch(rs.getInt("type"))
				{
				case 1:
					user = new Customer(rs.getString("username"), rs.getString("password"));
					break;
				case 2:
					user = new Employee(rs.getString("username"), rs.getString("password"));
					break;
				case 3:
					user = new Admin(rs.getString("username"), rs.getString("password"));
					break;
				}
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public ArrayList<User> selectAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				switch(rs.getInt(3))
				{
				case 1:
					user = new Customer(rs.getString("username"), rs.getString("password"));
					break;
				case 2:
					user = new Employee(rs.getString("username"), rs.getString("password"));
					break;
				case 3:
					user = new Admin(rs.getString("username"), rs.getString("password"));
					break;
				}
				
				users.add(user);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
