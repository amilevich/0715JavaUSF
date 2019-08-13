package com.bankdb.project.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Account;

public class FindAccountByIdDAO {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public Account findById(Account account) {
		final String SQLQUERY = "SELECT * FROM account WHERE  accountnumber = ? and status = ?";
		Account acct = new Account();
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, account.getAccountNumber());
				statement.setString(2, account.getStatus());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					acct.setAccountNumber(rs.getString(1));
					acct.setAmount(rs.getDouble(2));
					acct.setKindAccount(rs.getString(3));
					acct.setDate(rs.getDate(4));
					acct.setStatus(rs.getString(5));
				}
			
				return acct;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
