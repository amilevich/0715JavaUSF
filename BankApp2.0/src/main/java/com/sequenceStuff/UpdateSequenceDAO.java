package com.sequenceStuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateSequenceDAO {
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public int updateSequence() {
    	int temp = 0;
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            PreparedStatement ps = conn.prepareStatement("Update parameter set id_sequence = id_sequence + 1  where id_parameter = 1" );
	            
	            return ps.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
    }
}
