package com.ers.project.dao.types;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.project.model.ReimbursementTypes;
import com.ers.project.util.DataBaseConnect;

public class FindAllTypesDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}	
	public static List<ReimbursementTypes> findAll(){
		final String SQLQUERY = "SELECT * FROM ers_reimbursement_type";
		Connection cnn = connect.connectorDB();
		ReimbursementTypes ersType;
		boolean flag = false;
		List<ReimbursementTypes> ersTypesList = new ArrayList<>();
		try {
			PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				ersType  = new ReimbursementTypes();
				ersType.setTypeId(rs.getLong(1));
				ersType.setTypeName(rs.getNString(2));
				ersTypesList.add(ersType);
				flag = true;
			}
			if(flag) return ersTypesList;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
}
