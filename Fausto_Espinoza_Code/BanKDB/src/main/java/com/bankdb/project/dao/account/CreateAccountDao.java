package com.bankdb.project.dao.account;


import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Account;

public class CreateAccountDao {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean createRgister(Account account) {
		final String SQLQUERY = "INSERT INTO account VALUES(? , ? ,? , ? , ?)";
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, account.getAccountNumber());
				statement.setDouble(2, account.getAmount());
				statement.setString(3, account.getKindAccount());
				statement.setDate(4, account.getDate());
				statement.setString(5, account.getStatus());
				
				return statement.executeUpdate() > 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
