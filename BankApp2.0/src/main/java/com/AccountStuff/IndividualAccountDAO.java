package com.AccountStuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mybank.app.Individual;

public class IndividualAccountDAO {
	
	private static String url = "jdbc:oracle:thin:@mydatabase.cwt31yjy325o.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static String username = "gaelgino";
    private static String password = "Un2trois4";
    
    public List<Accounts > defineindiv(String individual) {
    	List<Accounts> xyz = new ArrayList<Accounts>();
    	 try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            
	            Accounts individual2 ; 
    		 PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE username = ? and status = 1");
	            ps.setString(1,individual);
	            ResultSet non = ps.executeQuery();
	            while(non.next()) {
	            	individual2 = new Accounts();
	            	individual2.setAccount_number(non.getLong(1));
	            	individual2.setBalance(non.getDouble(2));
	            	individual2.setStatus(non.getInt(3));
	            	individual2.setUsername(non.getString(4));
	            	xyz.add(individual2);
	            	
	            }
	            
	            return xyz;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
    }

}
