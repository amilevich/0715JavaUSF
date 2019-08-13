package com.bankdb.project.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Account;

public class UpdateAccountDAO {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;	
	
	public boolean updateAccountStatus(Account account) {
		final String SQLQUERY = "UPDATE account SET status = ? WHERE accountnumber = ?  ";
		
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, account.getStatus());
				statement.setString(2, account.getAccountNumber());			
				
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateAccountAmount(Account account) {
		final String SQLQUERY = "UPDATE account SET amount  = ? WHERE accountnumber = ? ";
				
		try {
			conn = dbConn.connectorDB();
			PreparedStatement statement = conn.prepareStatement(SQLQUERY);
			statement.setDouble(1, account.getAmount());
			statement.setString(2, account.getAccountNumber());
			
			return statement.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
