package data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;

import model.UserAccount;
import static data.db.DBConnector.conn;

public class UserAccountDAOI implements 
	CommonDAO<String, UserAccount>, GetAllStrDAO {
	final static Logger logger = Logger.getLogger(UserAccountDAOI.class);
	private Set<String> useraccounts = new TreeSet<String>();
	@Override
	public UserAccount getOne(String id) {
		UserAccount useraccount = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERACCOUNTS WHERE USERNAME = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				useraccount = new UserAccount(rs.getString("USERNAME"), rs.getString("PASSWORD")); 
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			return useraccount;
		}
		
		return useraccount;
	}

	@Override
	public String insertOne(UserAccount member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean updateOne(UserAccount member) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	public Integer deleteMany(Integer id) {
		Integer numOfRows = 0;
		try {
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM USERACCOUNTS WHERE USERNAME IN (SELECT USERNAME FROM BANKACCOUNTSOFCUSTOMERS WHERE BA_ID = ?) ");
			ps.setInt(1, id);
			numOfRows = ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			numOfRows = 0;
			return numOfRows;
		}
		logger.info( String.format("Unregistred Customers and User Accounts with Bank Account Number of %1$s", id) );
		return numOfRows;
	}
	
	@Override
	public Integer deleteOne(String id) {
		throw new java.lang.UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Set<String> getAll() {
		try {
			PreparedStatement ps = 
					conn.prepareStatement
					("SELECT USERNAME FROM USERACCOUNTS");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				useraccounts.add(rs.getString("USERNAME"));
			}
		} catch (SQLException e) {
			System.out.println("Having problems connecting");
			//e.printStackTrace();
		}
		
		return useraccounts;
	}

}
