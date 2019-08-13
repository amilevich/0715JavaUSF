package com.revature.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.revature.model.Userbank;

public class UserbankDaoImpls implements UserbankDao {
	
	private static String url = "jdbc:oracle:thin:@rubendb.crbseux6wvrb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "LopezR013";
	private static String password = "Wtwmbiwfil13";
	
	
	//CREATE
	public int createNewUserbank(String newusername, String newpassword) {
		

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Userbank ( username , password , privilege ) VALUES ( ? , ? , ? )");
			ps.setString(1, newusername);
			ps.setString(2, newpassword);
			ps.setInt(3, 1);
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	//READ
	@Override
	public List<Userbank> selectAllUserbank() {
		List<Userbank> userbanks = new ArrayList<Userbank>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Userbank");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userbanks.add(new Userbank(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userbanks;
	}


	public boolean checkForUserAndPassword(String username1,String password1) {
		boolean flag = false;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select count(*) from Userbank where username = ? AND password =?");
			ps.setString(1, username1);
			ps.setString(2, password1);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				flag = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	//returns an object
	public Userbank getUserbankByName(String usertracker) {
		Userbank userbank = new Userbank();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select * from Userbank where username = ? ");
			ps.setString(1, usertracker);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				userbank = new Userbank(rs.getString(1), rs.getString(2), rs.getInt(3) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userbank;
		
	}
	
	public boolean checkForForUser(String usertracker) {
		boolean flag = false;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("select count(*) from Userbank where username = ? ");
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
	
	
	
		
	//UPDATE------------------------------------------------------------------------------------------------------------------------------
	
		//A setter for user name
		public int setUsernameByOldName(String usertracker, String newusername) {
			
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("UPDATE Userbank SET username = ? where username = ? ");
				ps.setString(1, newusername);
				ps.setString(2, usertracker);
				ps.executeQuery();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return 1;
		}
		
		
		public int setPasswordByUserName(String usertracker , String newpassword) {
			
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("UPDATE Userbank SET password = ? where username = ? ");
				ps.setString(1, newpassword);
				ps.setString(2, usertracker);
				ps.executeQuery();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return 1;
			
			
		}
		
		public int setPrivilegeByUserName(String usertracker, int newprivilege) {
			
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("UPDATE Userbank SET privilege = ? where username = ? ");
				ps.setInt(1, newprivilege);
				ps.setString(2, usertracker);
				ps.executeQuery();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return 1;
		}
		
		
	//DELETE
		public int deleteUserbankByUsername(String oldname) {
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				PreparedStatement ps = conn.prepareStatement("DELETE FROM Userbank WHERE username = ?");
				
				ps.setString(1, oldname);
				
				ps.executeQuery();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 1;
			
			
			
		}
}
