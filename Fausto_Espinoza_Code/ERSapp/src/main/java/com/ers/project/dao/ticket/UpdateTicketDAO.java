package com.ers.project.dao.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ers.project.model.ReimbursementTicket;
import com.ers.project.util.DataBaseConnect;

public class UpdateTicketDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}	
	public static boolean updateTicket(ReimbursementTicket ticket) {
		final String SQLQUERY = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";		
		Connection cnn = connect.connectorDB();
		try {			
			if(cnn != null) {
				PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
				statement.setTimestamp(1, ticket.getReimbResolved());
				statement.setLong(2, ticket.getReimbResolver());
				statement.setLong(3, ticket.getReimbstatusId());
				statement.setLong(4, ticket.getReimbId());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
