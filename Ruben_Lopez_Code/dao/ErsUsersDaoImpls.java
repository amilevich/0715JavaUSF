package com.revature.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.model.ErsUsers;

public class ErsUsersDaoImpls implements ErsUsersDao {
	
	
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }
	
	private static String url = "jdbc:oracle:thin:@rubendb.crbseux6wvrb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "LopezR013";
	private static String password = "Wtwmbiwfil13";
	
	
	//CREATE
	public int insertErsUser(ErsUsers newuser) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS ( ERS_USER_ID , ERS_USERNAME , ERS_PASSWORD , USER_FIRST_NAME , USER_LAST_NAME , USER_EMAIL , USER_ROLE_ID) \r\n" + 
					"VALUES ( ? , ? , ? , ? , ? , ? , ? )");
			ps.setInt(1, 		newuser.getErsUserId());
			ps.setString(2, 	newuser.getErsUserName());
			ps.setString(3, 	newuser.getErsPassword());
			ps.setString(4, 	newuser.getUserFirstName());
			ps.setString(5, 	newuser.getUserLastName());
			ps.setString(6, 	newuser.getUserEmail());
			ps.setInt(7, 		newuser.getUserRoleId());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	
	//READ
		
	public ErsUsers selectErsUserbyId(int userId) {
		ErsUsers tempUser = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USER_ID=?");
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tempUser = new ErsUsers( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempUser;
		
	}
	
	public ErsUsers selectErsUserbyUsername(String username1) {
		
		ErsUsers tempUser = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			
			ps.setString(1, username1);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tempUser = new ErsUsers( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempUser;
		
		
		
	}
	
	
	
	//UPDATE
	public int updateUsers(ErsUsers p) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE ERS_USERS SET ERS_USERNAME = ? , ERS_PASSWORD= ? , USER_FIRST_NAME=? , USER_LAST_NAME=? , USER_EMAIL = ?, USER_ROLE_ID=?  WHERE ERS_USER_ID =?");
			ps.setInt(7, p.getErsUserId());
			ps.setString(1, p.getErsUserName());
			ps.setString(2, p.getErsPassword());
			ps.setString(3, p.getUserFirstName());
			ps.setString(4, p.getUserLastName());
			ps.setString(5, p.getUserEmail());
			ps.setInt(6, p.getUserRoleId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return 1;
	}
	//DELETE
	
	public int deleteErsUsersById(int p) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM ERS_USERS WHERE ERS_USER_ID = ?");
			ps.setInt(1, p);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
}
