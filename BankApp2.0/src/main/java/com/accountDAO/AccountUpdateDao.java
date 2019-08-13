package com.accountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AccountStuff.Accounts;

public class AccountUpdateDao {
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public int updateAccount(String username, long account_number, int status) {
    	
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET status = ? WHERE account_number = ? and username = ? ");
	            ps.setInt(1, status);
	            ps.setLong(2,account_number);
	            ps.setString(3,username);
	            return ps.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }
	

}
