package com.bankdb.project.dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bankdb.project.DataBaseConnect;
import com.bankdb.project.model.Person;

public class FindAllPersonsDao {
	static DataBaseConnect dbConn = new DataBaseConnect();
	static Connection conn;
	public List<Person> findAll(){
		final String SQLQUERY = "SELECT * FROM person WHERE username";
		List<Person> pList = new ArrayList<>();
		try {
			conn = dbConn.connectorDB();
			if(conn != null) {
				PreparedStatement  prStatement = conn.prepareStatement(SQLQUERY);
				ResultSet rs = prStatement.executeQuery();	
				while(rs.next()){
					Person per = new Person();
					per.setUser(rs.getString(1));
					per.setPwd(rs.getString(2));
					per.setNmPerson(rs.getString(3));
					per.setAddress(rs.getString(4));
					per.setPhone(rs.getString(5));
					per.setKindPerson(rs.getString(6));
					pList.add(per);
				}
				return pList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
