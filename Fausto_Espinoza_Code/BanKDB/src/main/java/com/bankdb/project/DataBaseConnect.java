package com.bankdb.project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnect {
	public static final String FILE = "C:\\Users\\frere\\Documents\\workspace-sts-3.9.4.RELEASE\\BanKDB\\src\\main\\resources\\Config.properties";
	
	public Connection connectorDB() {
		String url = new String();
		String user = new String();
		String pw = new String();
		try(InputStream readFile = new FileInputStream(FILE)) {
			Properties properties = new Properties();
			properties.load(readFile);
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			pw = properties.getProperty("pwd");	
			return DriverManager.getConnection(url,user,pw);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
