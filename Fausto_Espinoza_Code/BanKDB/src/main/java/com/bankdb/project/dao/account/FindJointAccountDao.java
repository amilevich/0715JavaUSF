package com.bankdb.project.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.JointAccount;
import com.bankdb.project.model.Person;

public class FindJointAccountDao {	
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public List<JointAccount> findJAccount(Person person, String status) {
		final String SQLQUERY = "SELECT * FROM jointaccount WHERE username = ? "
				+ " AND status = ?";
		boolean flag = false;
		JointAccount jaccount = new JointAccount();
		List<JointAccount> jaccountList = new ArrayList<>();
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement statement = conn.prepareStatement(SQLQUERY);
				statement.setString(1, person.getUser());
				statement.setString(2, status);
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					jaccount = new JointAccount();
					jaccount.setUsername(rs.getString(1));
					jaccount.setAccountnumber(rs.getString(2));
					jaccount.setStatus(rs.getString(3));
					jaccountList.add(jaccount);
					flag = true;
				}
				if(flag) return jaccountList;
				else return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
