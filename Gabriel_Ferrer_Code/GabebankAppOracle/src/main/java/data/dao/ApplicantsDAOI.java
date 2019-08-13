package data.dao;

import static data.db.DBConnector.conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Applicant;

public class ApplicantsDAOI implements CommonDAO <String, Applicant> {
	
	@Override
	public Applicant getOne(String id) {
		Applicant applicant = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT USERNAME FROM APPLICANTS WHERE USERNAME = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			applicant = new Applicant(rs.getString("USERNAME"));
		} catch (SQLException e) {
			applicant = null;
			//e.printStackTrace();
		}
		return applicant;
	}

	@Override
	public String insertOne(Applicant member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean updateOne(Applicant member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Integer deleteOne(String id) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}
	
	
	
}
