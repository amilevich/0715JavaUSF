package com.sequenceStuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class findSequenceaccountDAO {
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public int selectSequence() {
    	int temp = 0;
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            PreparedStatement ps = conn.prepareStatement("Select id_sequence from parameter where id_parameter = 1" );
	            ResultSet rs = ps.executeQuery();
	            rs.next();
	            return rs.getInt(1);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }

}
