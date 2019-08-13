package com.bankdb.project.dao.parameter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.ParametersDB;

public class FindParameterById {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public ParametersDB findParameterById(ParametersDB parameter) {
		final String SQLQUERY = "SELECT * FROM parameters WHERE idparameter = ? ";		 
		try {
			
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setLong(1, parameter.getIdparameter());
				ResultSet rs = statement.executeQuery();
				ParametersDB prDB = null;
				while(rs.next()) {
					prDB = new ParametersDB();
					prDB.setIdparameter(rs.getLong(1));
					prDB.setSeqaccount(rs.getLong(2));
					prDB.setNameparameter(rs.getString(3));
				}
				return prDB;				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
