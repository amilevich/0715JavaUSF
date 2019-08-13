package com.accountDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.AccountStuff.Accounts;

public class CreateAccountDao {
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public int createAccount(Accounts account) {
    	
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts Values(?,?,?,?)");
	            ps.setLong(1,account.getAccount_number());
	            ps.setDouble(2,account.getBalance());
	            ps.setInt(3,account.getStatus());
	            ps.setString(4,account.getUsername());
	            return ps.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }

}
