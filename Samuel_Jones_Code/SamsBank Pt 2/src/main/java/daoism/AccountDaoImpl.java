package daoism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import items.Account;

public class AccountDaoImpl implements  AccountDAO {
	private static String url = "jdbc:oracle:thin:@samjavadb.cecxuvq3cw6r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "Sam93";
	private static String password = "raichu*8";
	
	@Override
	public int insertAccount(Account a) {
//		Connection conn = SoleConnection.getInstance();
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO pendingaccounts (?,?,?,?,?,?,?)");
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPassword());
			ps.setDouble(3, a.getBalance());
			ps.setString(4, a.getFirstname());
			ps.setString(5,  a.getLastname());
			ps.setString(6, a.getJointFirst());
			ps.setString(7, a.getJointLast());
			ps.executeQuery();
			// TODO Auto-generated method stub
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Account selectAccountByUsername(String username) {
		Account a = null;
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM pendingaccounts WHERE username =?");
			ResultSet rs = ps.executeQuery(); // no loop needed for one account
			a = new Account(rs.getString(1),rs.getString(2),rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
		}
		catch(SQLException e) {
					e.printStackTrace();
			}
		return a;
	}

	@Override
	public List<Account> selectAllAccounts() {
			ArrayList<Account> aList = null;
			try(Connection conn = DriverManager.getConnection(url,username,password)){
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM pendingaccounts");
				ResultSet rs = ps.executeQuery(); // no loop needed for one account
				aList.add(new Account(rs.getString(1),rs.getString(2),rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			catch(SQLException e) {
						e.printStackTrace();
				}
			return aList;
	}

	@Override
	public int updateAccount(Account a) {
		// TODO Auto-generated method stub
			try(Connection conn = DriverManager.getConnection(url,username,password)){
				PreparedStatement ps = conn.prepareStatement("UPDATE pendingaccounts SET (balance) = ? WHERE username =?");
				ResultSet rs = ps.executeQuery(); // no loop needed for one account
//				a = new Account(rs.getString(1),rs.getString(2),rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				ps.setDouble(1, a.getBalance());
				ps.setString(2, a.getUsername());
			}
			catch(SQLException e) {
						e.printStackTrace();
				}
		return 0;
	}

	@Override
	public int deleteAccount(Account a) {
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM pendingaccounts WHERE username =?");
			ResultSet rs = ps.executeQuery(); // no loop needed for one account
//			a = new Account(rs.getString(1),rs.getString(2),rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			ps.setString(1, a.getUsername());
		}
		catch(SQLException e) {
					e.printStackTrace();
			}
	return 0;
	}
	
}
