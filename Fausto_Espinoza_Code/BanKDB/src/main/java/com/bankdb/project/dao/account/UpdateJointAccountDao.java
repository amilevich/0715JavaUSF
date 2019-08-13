package com.bankdb.project.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.JointAccount;

public class UpdateJointAccountDao {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean updateJAcount(JointAccount jAccount, String status) {
		final String SQLQUERY = "UPDATE jointaccount SET status = 'J' where username = ? and"
				+ " accountnumber = ? and status = ? ";
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, jAccount.getUsername());
				statement.setString(2, jAccount.getAccountnumber());
				statement.setString(3, status);				
				return statement.executeUpdate() > 0;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
