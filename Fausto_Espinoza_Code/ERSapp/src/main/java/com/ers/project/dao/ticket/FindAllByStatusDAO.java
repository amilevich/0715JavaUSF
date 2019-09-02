package com.ers.project.dao.ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.project.model.ReimbursementTicket;
import com.ers.project.util.DataBaseConnect;

public class FindAllByStatusDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}	
	public static List<ReimbursementTicket> findAll(long status){
		final String SQLQUERY = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
		Connection cnn = connect.connectorDB();
		ReimbursementTicket ticket;
		boolean flag = false;
		List<ReimbursementTicket> ticketList = new ArrayList<>();
		try {
			PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
			statement.setLong(1, status);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				ticket  = new ReimbursementTicket();
				ticket.setReimbId(rs.getLong(1));
				ticket.setReimbAmount(rs.getDouble(2));
				ticket.setReimbSubmitted(rs.getTimestamp(3));
				ticket.setReimbResolved(rs.getTimestamp(4));
				ticket.setReimbDescription(rs.getString(5));
				ticket.setBlob(rs.getBlob(6));
				ticket.setReimbAuthor(rs.getLong(7));
				ticket.setReimbResolver(rs.getLong(8));
				ticket.setReimbstatusId(rs.getLong(9));
				ticket.setReimbtypeId(rs.getLong(10));				
				ticketList.add(ticket);
				flag = true;
			}
			if(flag) return ticketList;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
}
