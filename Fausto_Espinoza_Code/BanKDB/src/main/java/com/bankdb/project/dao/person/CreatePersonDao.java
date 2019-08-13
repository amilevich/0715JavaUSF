package com.bankdb.project.dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Person;

public class CreatePersonDao {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public boolean createPerson(Person person) {
		final String SQLQUERY = "INSERT INTO person VALUES(?,?,?,?,?,?) ";
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement prStatement = conn.prepareStatement(SQLQUERY);
				prStatement.setString(1, person.getUser());			
				prStatement.setString(2, person.getPwd());			
				prStatement.setString(3, person.getNmPerson());			
				prStatement.setString(4, person.getAddress());			
				prStatement.setString(5, person.getPhone());			
				prStatement.setString(6, person.getKindPerson());				
				return prStatement.executeUpdate() > 0;				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
