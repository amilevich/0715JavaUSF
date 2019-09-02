package com.ers.project.dao.userroles;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ers.project.model.UserRoles;
import com.ers.project.util.DataBaseConnect;

public class CreateUserRolesDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}	
	public static boolean createUserRoles(UserRoles ersUserRol) {
		final String SQLQUERY = "INSERT INTO ers_user_roles VALUES(NULL,?)";
		Connection cnn = connect.connectorDB();
		try {
			if(cnn != null) {
				PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
				statement.setString(1, ersUserRol.getRoleName());
				return statement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
