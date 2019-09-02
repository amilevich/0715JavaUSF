package com.ers.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnect {	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public Connection connectorDB() {
		String url = System.getenv("url");				
		String user = System.getenv("user");
		String pw = System.getenv("pwd");
		try{
			return DriverManager.getConnection(url,user,pw);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
