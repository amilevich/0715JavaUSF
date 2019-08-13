package com.bankdb.project.dao.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Transaction;

public class FindTransactionByIdDAO {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public List<Transaction> finAll(Account transantion) {
		final String SQLQUERY = "SELECT * FROM transaction WHERE accountnumber = ? ORDER BY datetime ASC";
		List<Transaction> transactionList = new ArrayList<>();		
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, transantion.getAccountNumber());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					Transaction tr = new Transaction();
					tr.setIdtransaction(rs.getLong(1));
					tr.setAmount(rs.getDouble(2));
					tr.setDateTime(rs.getDate(3));
					tr.setKindTransaction(rs.getString(4));
					tr.setObservation(rs.getString(5));
					tr.setAccountnumber(rs.getString(6));
					transactionList.add(tr);
				}
				return transactionList;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
