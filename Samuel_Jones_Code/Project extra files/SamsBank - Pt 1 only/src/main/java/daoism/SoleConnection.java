package daoism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SoleConnection {
	private static String url = "jdbc:oracle:thin:@samjavadb.cecxuvq3cw6r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Sam93";
	private static String password = "raichu*8";
	private static Connection soleConn = getInstance();
	
	private SoleConnection() {
		try(Connection soleConn = DriverManager.getConnection(url, username, password)){
//			soleConn = DriverManager.getConnection(url,username,password);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getInstance() {
		if(soleConn==null) {
			soleConn = new SoleConnection().getInstance();
		}
		
		return soleConn;
	}
}
