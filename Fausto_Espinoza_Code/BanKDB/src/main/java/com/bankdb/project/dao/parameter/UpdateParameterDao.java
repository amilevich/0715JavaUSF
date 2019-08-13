package com.bankdb.project.dao.parameter;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.ParametersDB;

public class UpdateParameterDao {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean updateParameter(ParametersDB parametersDB) {
		final String SQLQUERY = "UPDATE parameters SET seqaccount = seqaccount + 1 WHERE idparameter = ? ";
		ParametersDB prDB = new ParametersDB();
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setLong(1, parametersDB.getIdparameter());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
