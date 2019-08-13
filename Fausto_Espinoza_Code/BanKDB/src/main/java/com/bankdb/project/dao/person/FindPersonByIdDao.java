package com.bankdb.project.dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Person;

public class FindPersonByIdDao {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public Person findById(Person person) {	
		final String SQLQUERY = "SELECT * FROM person WHERE username = ? AND pwd = ? AND kindperson = ?";				
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement  prStatement = conn.prepareStatement(SQLQUERY);
				prStatement.setString(1, person.getUser());
				prStatement.setString(2, person.getPwd());
				prStatement.setString(3, person.getKindPerson());
				ResultSet rs = prStatement.executeQuery();	
				Person persn = null;				
				while(rs.next()) {
					persn = new Person();
					persn.setUser(rs.getString(1));
					persn.setPwd(rs.getString(2));
					persn.setNmPerson(rs.getString(3));
					persn.setAddress(rs.getString(4));
					persn.setPhone(rs.getString(5));
					persn.setKindPerson(rs.getString(6));
				}
				return persn;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
