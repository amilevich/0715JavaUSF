package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.bank.Admin;
import com.bank.Employee;
import com.bank.User;


public class UserDaoImpl implements UserDao{
	private static String url = "jdbc:oracle:thin:@db0715bootcamp.c0szar4trj1r.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "dbMaster";
	private static String password = "p4ssw0rd";

	@Override
	public void insertUser(User f) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users Values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,f.getUserName());
			ps.setString(2,f.getPassword());
			ps.setDouble(3,f.getBalance());
			ps.setInt(4,f.isApproved());
			ps.setInt(5,f.isJoint());
			ps.setInt(6,f.isEmployee());
			ps.setInt(7,f.isAdmin());
			ps.setInt(8,f.getAcctNum());
			ps.setString(9,f.getJointId());
			ps.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			if(f.isAdmin()==0)
				e.printStackTrace();
		}
	}

	@Override
	public User selectUserByUserName(String name) {
		User temp = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE u_user_name=?"); //putting in a native SQL native query utilizing a prepared statement
			ps.setString(1,name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//temp = new User(rs.getInt("id"), rs.getString("name"), rs.getString("type"));
				if(rs.getInt(7)==1)				//if they are admin type accounts create admin objects
					temp = new Admin(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9));		
				else if(rs.getInt(6)==1)		//if they are employee type accounts create employee objects
					temp = new Employee(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),
							rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9));		
				else 							//if they are user type accounts create user objects
					temp = new User(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),
							rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public HashMap<String,User> selectAllUsers() {
		HashMap<String,User> users_temp = new HashMap<String,User>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(7)==1)				//if they are admin type accounts create admin objects
					users_temp.put(rs.getString(1),new Admin(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9)));		
				else if(rs.getInt(6)==1)		//if they are employee type accounts create employee objects
					users_temp.put(rs.getString(1),new Employee(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),
							rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9)));		
				else 							//if they are user type accounts create user objects
					users_temp.put(rs.getString(1),new User(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),
							rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getString(9)));		
			}			
			
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return users_temp;
	}

	@Override
	public void updateUser(User u) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE Users SET u_password =?," + 
					" u_balance =?, u_approved =?, u_joint =?, u_employee =?, u_admin =?, u_account_Num =?, u_joint_id =? WHERE u_user_name=?");
			ps.setString(1, u.getPassword());
			ps.setDouble(2, u.getBalance());
			ps.setInt(3, u.isApproved());
			ps.setInt(4, u.isJoint());
			ps.setInt(5, u.isEmployee());
			ps.setInt(6, u.isAdmin());
			ps.setInt(7, u.getAcctNum());
			ps.setString(8,u.getJointId());
			ps.setString(9, u.getUserName());
			ps.executeUpdate();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void deleteUser(User f) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Users WHERE u_user_name=?");
			ps.setString(1,f.getUserName());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

}
