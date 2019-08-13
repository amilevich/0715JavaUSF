package com.AccountStuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApproveAccount {
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public int updateAcctStatus(int status, long account_number) {
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            PreparedStatement ps = conn.prepareStatement("Update accounts set status = ? and account_number = ?");
	            ps.setInt(1,status);
	            ps.setLong(2,account_number);
	            return ps.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;

}
}