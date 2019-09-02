package com.ers.project.dao.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.project.model.ReimbursementStatus;
import com.ers.project.util.DataBaseConnect;

public class FindAllStatusDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}
	
	public static List<ReimbursementStatus> findAll(){
		final String SQLQUERY = "SELECT * FROM ers_reimbursement_status";
		Connection cnn = connect.connectorDB();
		ReimbursementStatus ersStatus;
		boolean flag = false;
		List<ReimbursementStatus> ersStatusList = new ArrayList<>();
		try {
			PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				ersStatus  = new ReimbursementStatus();
				ersStatus.setStatusId(rs.getLong(1));
				ersStatus.setStatusName(rs.getNString(2));
				ersStatusList.add(ersStatus);
				flag = true;
			}			
			if(flag) return ersStatusList;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
}
