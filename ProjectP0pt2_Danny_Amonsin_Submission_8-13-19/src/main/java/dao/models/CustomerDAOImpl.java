package dao.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO
{
	private static String url = "jdbc:oracle:thin:@dbbcrevature.cr84lpfaefq1.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username ="admin119";
	private static String password ="passWord4";

	//CRUD
	//creates a new customer account DB
	@Override
	public boolean createCAcct(Customer account) {
		try(
				Connection conn = DriverManager.getConnection(url, username, password)){
					PreparedStatement ps =  conn.prepareStatement("INSERT INTO damon_accounts (account_id, balance, firstname, lastname, account_type, account_status) VALUES (?,?,?,?,?,?)");
					ps.setInt(1,account.getAccountID());
					ps.setDouble(2,account.getBalance());					
					ps.setString(3,account.getFirstName());
					ps.setString(4,account.getLastName());
					ps.setString(5,account.getAccountType());
					ps.setString(6,account.getAccountStatus());
					
					ps.executeUpdate();
				}catch(Exception e){
					//e.printStackTrace();
					return false;
				}
		return true;
	}
	
	//only finds single account for personal account, will need to make a way for joint account, likely thru the use of a hashmap object to pull in the data
	//then iterate thru it to pull out the account_id fields to use in the method that displays what accounts they have
	@Override
	public JunctionInfo findPersRelAcct(String userName) {
		JunctionInfo jun = new JunctionInfo();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM user_acct_junction WHERE username = ?");
			ps.setString(1, userName);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				jun.setUsername(r.getString(1));
				jun.setAccount_id(r.getInt(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jun;
	}
	
	//admin app approval updates row, single cell update, requires a specified row
	@Override
	public void updateCustDB(int accountID, String verdict) {
		try(
				Connection conn = DriverManager.getConnection(url, username, password)){
					PreparedStatement ps =  conn.prepareStatement("UPDATE damon_accounts SET account_status = ? WHERE account_id = ?");					
					ps.setString(1,verdict);
					ps.setInt(2,accountID);
					
					ps.executeUpdate();
				}catch(Exception e){
					//e.printStackTrace();
				}
	}
	@Override
	public void updateCustDBbalance(int accountID, double amount) {
		try(
				Connection conn = DriverManager.getConnection(url, username, password)){
					PreparedStatement ps =  conn.prepareStatement("UPDATE damon_accounts SET balance = ? WHERE account_id = ?");					
					ps.setDouble(1,amount);
					ps.setInt(2, accountID);
					
					ps.executeUpdate();
				}catch(Exception e){
					//e.printStackTrace();
				}
	}
	
	//get personal customer information to view
	@Override
	public Customer findAcctById(int accountid) {
		Customer cust = new Customer();
		try(
				Connection conn = DriverManager.getConnection(url, username, password)){
					PreparedStatement ps =  conn.prepareStatement("SELECT * FROM damon_accounts WHERE account_id = ?");
					ps.setInt(1,accountid);
					ResultSet r = ps.executeQuery();
					while(r.next()) {
						cust.setAccountID(r.getInt(1));
						cust.setBalance(r.getInt(2));
						cust.setFirstName(r.getString(3));
						cust.setLastName(r.getString(4));
						cust.setAccountType(r.getString(5));
						cust.setAccountStatus(r.getString(6));
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
		return cust;
	}
	
}
