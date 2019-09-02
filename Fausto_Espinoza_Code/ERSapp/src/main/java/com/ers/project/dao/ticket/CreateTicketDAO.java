package com.ers.project.dao.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalTime;

import com.ers.project.model.ReimbursementTicket;
import com.ers.project.model.ReimbursementTypes;
import com.ers.project.util.DataBaseConnect;

public class CreateTicketDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}	
	public static boolean createTicket(ReimbursementTicket ticket) {
		final String SQLQUERY = "INSERT INTO ers_reimbursement VALUES(NULL,?,?,NULL,?,?,?,NULL,1,?)";		
		Connection cnn = connect.connectorDB();
		try {			
			if(cnn != null) {
				PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
				statement.setDouble(1, ticket.getReimbAmount());
				statement.setTimestamp(2, ticket.getReimbSubmitted());
				statement.setString(3, ticket.getReimbDescription());
				statement.setBlob(4, ticket.getBlob());
				statement.setLong(5, ticket.getReimbAuthor());
				statement.setLong(6, ticket.getReimbtypeId());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
