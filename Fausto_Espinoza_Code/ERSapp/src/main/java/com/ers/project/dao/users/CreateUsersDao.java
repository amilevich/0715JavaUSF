package com.ers.project.dao.users;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ers.project.model.Users;
import com.ers.project.util.DataBaseConnect;

public class CreateUsersDao {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}
	public static boolean createUsers(Users users) {
		final String SQLQUERY = "INSERT INTO ers_users VALUES(NULL,?,?,?,?,?,?)";		
		Connection cnn = connect.connectorDB();
		try {			
			if(cnn != null) {
				PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
				statement.setString(1, users.getUserName());
				statement.setString(2, users.getPassword());
				statement.setString(3, users.getFirstName());
				statement.setString(4, users.getLastName());
				statement.setString(5, users.getEmail());
				statement.setLong(6, users.getRoleId());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
