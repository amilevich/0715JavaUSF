package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Junction;



public class JunctionDaoImpls implements JunctionDao {
	
	
	private static String url = "jdbc:oracle:thin:@rubendb.crbseux6wvrb.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "LopezR013";
	private static String password = "Wtwmbiwfil13";

	
	//CREATE
	public int createNewJunction(String newusername , int newaccountnumber) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Junction ( accountnumber , username ) VALUES ( ? , ? )");
			
			ps.setInt(1, newaccountnumber);
			ps.setString(2, newusername );
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
	}
	
	
	
	//READ
	
	public int getBalanceByUsername(String username1) {
		
		int newnumber = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT Account.balance FROM Account , Junction \r\n" + 
					"WHERE Junction.username = ? AND junction.accountnumber = account.accountnumber ");
			
			ps.setString(1, username1);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				newnumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newnumber;
		
	}
	
	@Override
	public int getAccountNumberByUserName(String username1) {
		// TODO Auto-generated method stub
		int newnumber = 0;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT accountnumber FROM Junction Where ? = username");
			
			ps.setString(1, username1);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				newnumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newnumber;
	}
	
	public List<Junction> seeUnapprovedAccountsbyJunctiontable(){
		
		
		//sees all pending accounts
		List<Junction> alist = new ArrayList<Junction>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT Junction.accountnumber , junction.username FROM Junction , Account Where Junction.accountnumber = Account.accountnumber AND status = 0");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				alist.add(new Junction(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alist;
		
		
		
		
		
	}
	
	
	public String getUsernameByAccountNumber(int accountnumber) {
		String tempusername = " ";
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT username FROM Junction Where ? = accountnumber");
			
			ps.setInt(1, accountnumber);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tempusername = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempusername;
	}
	
	//UPDATE
	
	public int setAccountnumberByuserName(String usertracker,  int newaccountnumber) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Junction set accountnumber = ? Where username = ?");
			
			ps.setInt(1, newaccountnumber);
			ps.setString(2, usertracker);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	
	//DELETE
	
	public int deleteByAccountNumber(int oldaccount) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Junction WHERE accountnumber = ?");
			
			ps.setInt(1, oldaccount);
			
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
		
		
	}

}
