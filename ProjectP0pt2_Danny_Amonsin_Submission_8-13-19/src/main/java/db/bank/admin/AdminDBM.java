package db.bank.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.models.Customer;
import dao.models.Username;

public class AdminDBM {
	private static String url = "jdbc:oracle:thin:@dbbcrevature.cr84lpfaefq1.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "admin119";
	private static String password = "passWord4";
	
	//checks username in database for new customer to ensure unique
	public Username userNameChecker(String usernameC) 
	{

		Username user1 = new Username();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
			ps.setString(1, usernameC);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				user1.setUserName(r.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user1;
	}
	
	//checks password in database for new customer for logging in
		public Username PasswordChecker(String passWord) 
		{

			Username user1 = new Username();
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE password = ?");
				ps.setString(1, passWord);
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					user1.setPassword(r.getString(1));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return user1;
		}
	
	
	
	//checks if account status is pending, if so, will not let log in
	public Customer findAcctStaDB(int accountID) 
	{

		Customer cust = new Customer();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT account_id, account_status FROM damon_accounts WHERE account_Id = ?");
			ps.setInt(1, accountID);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				cust.setAccountID(r.getInt(1));
				cust.setAccountStatus(r.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
		
	public List<Customer> findPendingAcctDB() {
		List<Customer> pending = new ArrayList<Customer>();
		try(
				Connection conn = DriverManager.getConnection(url, username, password)){
					PreparedStatement ps =  conn.prepareStatement("SELECT * FROM damon_accounts WHERE account_status = 'pending' ");
					ResultSet r = ps.executeQuery();
					while(r.next()) {						
						pending.add(new Customer(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6)));
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
		return pending;
	}
	
	public Customer getDBbalance(int accountID) 
	{

		Customer cust = new Customer();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT balance FROM damon_accounts WHERE account_id = ?");
			ps.setInt(1, accountID);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				cust.setBalance(r.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
	//view all accounts in damon database tables
	
	
	
	
}
