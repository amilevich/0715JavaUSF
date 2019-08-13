package com.bankdb.project.dao.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Transaction;

public class CreateTransactionDAO {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean createTransation(Transaction transaction) {
		final String SQLQUERY = "INSERT INTO transaction VALUES(NULL,?,?,?,?,?)";
		
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
//				statement.setDouble(1, transaction.getAmount());
				statement.setDouble(1, transaction.getAmount());
				statement.setDate(2, transaction.getDateTime());
				statement.setString(3, transaction.getKindTransaction());
				statement.setString(4, transaction.getObservation());
				statement.setString(5, transaction.getAccountnumber());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
