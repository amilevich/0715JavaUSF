package main.java.application.Dao;

import main.java.application.Domain.User;
import main.java.application.Utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

	@Override
	/**
	 * Function to load a User based on the User Name and the Password
	 * of the User. If the User name and Password matches with a given user
	 * he/she will be loaded from the database.
	 * 
	 * @param userName
	 * @param password
	 * @return user or null
	 */
	public User confirmLogin(String userName, String password) {
		
		User user = null;
		
		String sql = "SELECT * FROM USERS WHERE UserName=? and Password=?";
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				user = new User(userName, password, rs.getString("Role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	/**
	 * Function to check that a given User has a certain account identified 
	 * with the given Account Number. If the user has that account then the
	 * function returns true, otherwise the function will return false. 
	 * 
	 * The function also handle the Join Account 
	 * 
	 * @param userName
	 * @param accountNumber
	 * @return true if account exist, false otherwise
	 */
	public boolean hasAccountAccess(String userName, int accountNumber) {
		
		String sql = "SELECT AccountNo FROM BankAccounts WHERE (USER1 = ? or USER2 = ?) and " 
				 + " AccountNo = ?";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, userName);
			ps.setString(2, userName);
			ps.setInt(3, accountNumber);
			ResultSet rs = ps.executeQuery();

			//if rs returns a value then the sql query has returned an existing user
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	/**
	 * Function to check that the User with a given user name exist. If the 
	 * user exists, the function returns true, otherwise function returns
	 * false. 
	 */
	public boolean doesUserExist(String userName) {
		String sql = "SELECT USERNAME FROM USERS WHERE UserName = ?";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			//if rs returns a value then the sql query has returned an existing user
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	/**
	 * Function to save the user into the Users table if the user
	 * doesn't already exist, If the user exists return false. If the 
	 * user has been saved into the database return true. 
	 * 
	 * @param user
	 * @return true if saved, false otherwise
	 */
	public boolean saveUser(User user) {
		
		boolean result = false;
		
		// Check if the user already exist
		if(doesUserExist(user.getUserName())) {
			return false; 
		}
		
		// Doesn't exist, save it
		String sql = "INSERT INTO USERS VALUES(?, ?, ?)";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			
			int inserted = ps.executeUpdate();
			
			// check if inserted
			result = (inserted > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		   
		return result;
	}
}
