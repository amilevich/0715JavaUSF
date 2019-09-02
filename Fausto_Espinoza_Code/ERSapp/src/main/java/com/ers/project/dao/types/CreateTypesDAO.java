package com.ers.project.dao.types;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ers.project.model.ReimbursementTypes;
import com.ers.project.util.DataBaseConnect;

public class CreateTypesDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}	
	public static boolean createTypes(ReimbursementTypes ersTypes) {
		final String SQLQUERY = "INSERT INTO ers_reimbursement_type VALUES(NULL,?)";		
		Connection cnn = connect.connectorDB();
		try {			
			if(cnn != null) {
				PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
				statement.setString(1, ersTypes.getTypeName());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
