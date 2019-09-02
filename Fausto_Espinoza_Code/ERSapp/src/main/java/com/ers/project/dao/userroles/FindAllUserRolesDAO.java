package com.ers.project.dao.userroles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.project.model.UserRoles;
import com.ers.project.util.DataBaseConnect;

public class FindAllUserRolesDAO {
	private static DataBaseConnect connect;
	static {
		connect = new DataBaseConnect();
	}		
	public static List<UserRoles> findAll(){
		final String SQLQUERY = "SELECT * FROM ers_user_roles";
		Connection cnn = connect.connectorDB();
		UserRoles ersUserRole;
		boolean flag = false;
		List<UserRoles> ersUserRolesList = new ArrayList<>();
		try {
			PreparedStatement statement = cnn.prepareStatement(SQLQUERY);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				ersUserRole  = new UserRoles();
				ersUserRole.setRoleId(rs.getLong(1));
				ersUserRole.setRoleName(rs.getNString(2));
				ersUserRolesList.add(ersUserRole);
				flag = true;
			}			
			if(flag) return ersUserRolesList;
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
}
