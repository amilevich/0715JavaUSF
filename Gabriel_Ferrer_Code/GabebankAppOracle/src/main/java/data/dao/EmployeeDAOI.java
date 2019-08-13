package data.dao;

import static data.db.DBConnector.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

public class EmployeeDAOI implements CommonDAO<String,Employee> {

	@Override
	public Employee getOne(String id) {
		Employee employee = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT USERNAME, ISADMIN FROM EMPLOYEES WHERE USERNAME = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				employee = new Employee(rs.getString("USERNAME"), ( rs.getInt("ISADMIN") == 1 )  ); 
			}
		} catch (SQLException e) {
			//System.out.println("Having problems connecting");
			//e.printStackTrace();
			return employee;
		}
		
		return employee;
	}

	@Override
	public String insertOne(Employee member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean updateOne(Employee member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Integer deleteOne(String id) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
}
