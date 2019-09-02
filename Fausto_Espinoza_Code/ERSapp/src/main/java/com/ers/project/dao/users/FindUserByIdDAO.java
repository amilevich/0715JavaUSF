package com.ers.project.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ers.project.model.Users;
import com.ers.project.util.DataBaseConnect;

public class FindUserByIdDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}
	
	public static Users findById(Users users) {
		final String SQLQUERY = "SELECT * FROM ers_users WHERE ers_username = ?";
		Connection cnn = connect.connectorDB();
		Users user;		
		try {
			PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
			statement.setString(1, users.getUserName());
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				user  = new Users();
				user.setUserId(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setRoleId(rs.getLong(7));	
				return user;
			}			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	

}
