package com.expense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.expense.beans.Employee;
import com.expense.beans.manager;

public class managerDaoImpl implements managerDao {

	private static String url = "jdbc:oracle:thin:@db0715java.ce8jdxpwtsbf.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "niroj85";
	private static String password = "niroj4401";
	static{

	       try {

	           Class.forName("oracle.jdbc.driver.OracleDriver");

	       } catch (ClassNotFoundException e) {

	           e.printStackTrace();

	       }

	   }
	@Override
	public manager selectManager(String name, String pword) {
		
		manager manager1 = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM MANAGER WHERE USER_NAME =? AND PASS_WORD =?");
			ps.setString(1, name);
			ps.setString(2, pword);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				manager1 = new manager(rs.getString("USER_NAME"),rs.getString("PASS_WORD"));
			}
			//System.out.println(employee);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager1;
	}

}
