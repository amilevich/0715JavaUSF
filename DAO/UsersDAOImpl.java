package com.project1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project1.model.Users;

public class UsersDAOImpl implements UsersDAO {
	
	static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
	static String username = "gaelgino";
	 static String password = "Un2trois4";
	
	static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int insertUsers(Users u) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			PreparedStatement ps = conn.prepareStatement("INSERT INTO Users VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, u.getUsersID());
			ps.setString(2, u.getUsername());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getFirstname());
			ps.setString(5, u.getLastname());
			ps.setString(6, u.getEmail());
			ps.setInt(7, u.getUsersRoleID());
			ps.setString(8, u.getUsersRole());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Users selectUsersByUsersID(int UsersID) {
		
		Users user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE users_id=?");

			ps.setInt(1, UsersID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Users(rs.getInt("users_id"), rs.getString("users_username"), 
						rs.getString("users_password"), rs.getString("users_fname"), rs.getString("users_lname"), 
						rs.getString("users_email"), rs.getInt("users_role_id"), rs.getString("users_role"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	
	}
	
	
	@Override
	public Users selectUsersByUsername(String username1) {
		
		Users user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE users_username = ?");

			ps.setString(1, username1);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Users(rs.getInt("users_id"), rs.getString("users_username"), 
						rs.getString("users_password"), rs.getString("users_fname"), rs.getString("users_lname"), 
						rs.getString("users_email"), rs.getInt("users_role_id"), rs.getString("users_role"));
			}
			
			

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	
	}
	
	
	@Override
	public Users selectUsersByPassword(String password) {
		
		Users user = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE users_password=?");

			ps.setString(1, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Users(rs.getInt("users_id"), rs.getString("users_username"), 
						rs.getString("users_password"), rs.getString("users_fname"), rs.getString("users_lname"), 
						rs.getString("users_email"), rs.getInt("users_role_id"), rs.getString("users_role"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	
	}
	
	
	@Override
    public Users confirmLogin(String username1, String password1) {

        Users user = null;

        try(Connection conn = DriverManager.getConnection(url, username, password)){

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE users_username=? and users_password=?");

            ps.setString(1, username1);
            ps.setString(2, password1);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
            	user = new Users(rs.getString(2), rs.getString(3), rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
	}

	@Override
	public List<Users> selectAllUsers() {
		
		return null;
	}

	@Override
	public int updateUsers(Users u) {
		
		return 0;
	}

	@Override
	public int deleteUsers(Users u) {
		
		return 0;
	}
	
	
	

}
