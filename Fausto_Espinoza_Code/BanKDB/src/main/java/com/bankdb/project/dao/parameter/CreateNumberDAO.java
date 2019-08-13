package com.bankdb.project.dao.parameter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.ParametersDB;

public class CreateNumberDAO {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean createNum(ParametersDB parameterDB) {
		final String SQLQUERY = "INSERT INTO parameters VALUES(NULL,?,?) ";
		
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setLong(1, parameterDB.getSeqaccount());
				statement.setString(2, parameterDB.getNameparameter());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
}
