package com.bankdb.project.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.JointAccount;

public class JointAccountDao {	
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean createJoint(JointAccount jointAcount) {
		final String SQLQUERY = "INSERT INTO jointaccount VALUES(?,?,?)";
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, jointAcount.getUsername());
				statement.setString(2, jointAcount.getAccountnumber());
				statement.setString(3, jointAcount.getStatus());
				
				return statement.executeUpdate() > 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
