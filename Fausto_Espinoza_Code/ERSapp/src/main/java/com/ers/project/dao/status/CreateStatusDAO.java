package com.ers.project.dao.status;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ers.project.model.ReimbursementStatus;
import com.ers.project.util.DataBaseConnect;

public class CreateStatusDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}
		
	public static boolean createStatus(ReimbursementStatus ersStatus) {		
		final String SQLQUERY = "INSERT INTO ers_reimbursement_status VALUES(NULL,?)";		
		Connection cnn = connect.connectorDB();
		try {
			cnn = connect.connectorDB();
			if(cnn != null) {
				PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
				statement.setString(1, ersStatus.getStatusName());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
