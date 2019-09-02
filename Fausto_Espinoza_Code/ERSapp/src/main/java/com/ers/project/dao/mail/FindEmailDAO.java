package com.ers.project.dao.mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.project.model.Email;
import com.ers.project.model.ReimbursementStatus;
import com.ers.project.util.DataBaseConnect;

public class FindEmailDAO {
	
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}
	
	public static Email findEmail(Email email){
		final String SQLQUERY = "SELECT * FROM email where email_id = ?";
		Connection cnn = connect.connectorDB();
		Email emailMsg = new Email();
		boolean flag = false;
		try {
			PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
			statement.setLong(1, email.geteMailId());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				emailMsg.seteMailId(rs.getLong(1));
				emailMsg.seteFromEmail(rs.getString(2));
				emailMsg.setePassword(rs.getString(3));
				emailMsg.seteSubject(rs.getString(4));
				emailMsg.seteMessage(rs.getString(5));
				flag = true;
			}			
			if(flag) return emailMsg;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
}
