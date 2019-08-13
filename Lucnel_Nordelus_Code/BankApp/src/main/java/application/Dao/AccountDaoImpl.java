package main.java.application.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.application.Domain.Account;
import main.java.application.Domain.User;
import main.java.application.Utils.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	/**
	 * This method creates a SQL query to read the balance associated with the provided account number.
	 * The Account object is then updated with the new balance, waiting to be pulled for use.
	 */
	@Override
	public Account getBalance(int accountNumber) {
		
		// Load the account by account number. 
		Account a = getAccount(accountNumber);
		
		// if account doesn't exist
		if(a == null) {
			a = new Account();
			a.setBalance(-1);
		}
		
		return a;
	}

	@Override
	/**
	 * This function is not needed as it is not manipulating the balance
	 * 
	 * NO banking application ever update or set the balance directly into
	 * an account. 
	 */
	public boolean setBalance(int accountNumber) {
		return false;
	}

	@Override
	/**
	 * Function to update the balance of an account by depositing the amount
	 * The balance will be increase by amount after the execution of this 
	 * function. 
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return true if deposited, false otherwise. 
	 */
	public boolean deposit(int accountNumber, double amount) {
		
		boolean result = false;
		
		// update query
		String sql = "UPDATE BANK_ACCOUNTS SET Balance=Balance + ? WHERE AccountNo=?";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setDouble(1, amount);
			ps.setInt(2, accountNumber);
			
			int updated = ps.executeUpdate();
			
			// check if inserted
			result = (updated > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}

	@Override
	/**
	 * Function to withdraw funds from the account. The function uses getBalance()
	 * function to fetch the balance of the account. If the balance is sufficient
	 * to withdraw "amount", it decreases the balance by amount, If not no 
	 * change happens. 
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return true if withdrawn, false otherwise. 
	 */
	public boolean withdraw(int accountNumber, double amount) {
		
		boolean result = false;
		
		// Get the Balance
		Account account = getBalance(accountNumber);
		
		// if balance is sufficient, decrease the balance
		if(account.getBalance() >= amount) {
		
			// update query
			String sql = "UPDATE BANK_ACCOUNTS SET Balance=? WHERE AccountNo=?";
			try(Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql) ){
	
				ps.setDouble(1, account.getBalance() - amount);
				ps.setInt(2, accountNumber);
				
				int updated = ps.executeUpdate();
				
				// check if inserted
				result = (updated > 0) ? true : false;
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return result;

	}

	@Override
	/**
	 * Function to transfer the amount from one account to another account. 
	 * 
	 * 1. Check both accounts exist
	 * 2. Check from account has sufficient balance
	 * 3. Withdraw from "From Account"
	 * 4. Deposit into "To Account"
	 * 
	 * @param accountFrom
	 * @param accountTo
	 * @param amount
	 * @return true if successful, false otherwise
	 */
	public boolean transfer(int accountFrom, int accountTo, double amount) {
		
		// Get Accounts
		Account from = getAccount(accountFrom);
		Account to = getAccount(accountTo);
		
		boolean result = false;
		
		// if any of the account doesn't exist, return - else
		if(from != null || to != null) {
			
			// Check Balance is sufficient
			if(from.getBalance() >= amount) {
				
				// withdraw from from account
				boolean withdrawFlag = withdraw(accountFrom, amount);
				
				// deposit into account
				boolean depositFlag = deposit(accountTo, amount);
				
				result = withdrawFlag && depositFlag;
			}
		}
		
		return result;
	}

	@Override 
	/**
	 * Function to load an account identified by the Account Number. 
	 * 
	 * @param accountNumber
	 * @return account loaded from database or null 
	 */
	public Account getAccount(int accountNumber) {
		
		String sql = "SELECT * FROM BANK_ACCOUNTS WHERE AccountNo = ?";
		Account a = null;
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){

			// Set the Account Number Parameter
			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			
			//if rs returns a value then the sql query has returned the balance
			if(rs.next()) {
				a = new Account();
				String status = rs.getString("Status");
				double balance = rs.getDouble("BALANCE");
				String user1 = rs.getString("User1");
				String user2 = rs.getString("User2");
				
				a.setAccountNumber(accountNumber);
				a.setBalance(balance);
				a.setStatus(status);
				a.setUser1(user1);
				a.setUser2(user2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	/**
	 * Function to deny an account application. If account exist, its
	 * status will be set to DENIED. 
	 * 
	 *  @param accountNum
	 *  @return true if denied, false otherwise
	 */
	public boolean denyAccountApplication(int accountNum) {
		
		return changeAccountStatus(accountNum, 'D');  
	}

	@Override
	/**
	 * Function to deny the Join Application. 
	 * 
	 * @param username
	 * @param accountNumber
	 * @return true if denied, false otherwise
	 */
	public boolean denyJointApplication(String username, int accountNum) {
		return changeAccountStatus(accountNum, 'D');  
	}

	@Override
	/**
	 * Function to approve an account application. 
	 * 
	 * @param accountNum
	 * @return true if approved, false otherwise
	 */
	public boolean approveAccountApplication(int accountNum) {
		return changeAccountStatus(accountNum, 'A');  
	}

	@Override 
	/**
	 * Function to approve a joint application. 
	 * 
	 * @param username
	 * @param accountNum
	 * @return true if approved, false otherwise
	 */
	public boolean approveJointApplication(String username, int accountNum) {
		return changeAccountStatus(accountNum, 'A');
	}

	@Override
	/**
	 * Function to Cancel an account. 
	 * 
	 * @param accountNum
	 * @return true if cancelled, false otherwise
	 */
	public boolean cancelAccount(int accountNum) {
		return changeAccountStatus(accountNum, 'C');
	}

	@Override
	public boolean createAccountApplication(User user) {
		
		boolean result = false;
		
		// Doesn't exist, save it
		String sql = "INSERT INTO BANK_ACCOUNTS (Status, Balance, User1) VALUES(?, ?, ?)";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, "PENDING");
			ps.setDouble(2, 0);
			ps.setString(3, user.getUserName());
			
			int inserted = ps.executeUpdate();
			
			// check if inserted
			result = (inserted > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}

	@Override
	public boolean createAccount(String userName, double balance) {
		boolean result = false;
		
		// Doesn't exist, save it
		String sql = "INSERT INTO BANK_ACCOUNTS (Status, Balance, User1) VALUES(?, ?, ?)";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, "PENDING");
			ps.setDouble(2, balance);
			ps.setString(3, userName);
			
			int inserted = ps.executeUpdate();
			
			// check if inserted
			result = (inserted > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}

	@Override
	/**
	 * Join Account Application needs two User Names. 
	 */
	public boolean createJointAccountApplication(String user1, String user2) {
		boolean result = false;
		
		// Doesn't exist, save it
		String sql = "INSERT INTO BANK_ACCOUNTS (Status, Balance, User1, User2) VALUES(?, ?, ?)";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, "PENDING");
			ps.setDouble(2, 0);
			ps.setString(3, user1);
			ps.setString(3, user2);
			
			int inserted = ps.executeUpdate();
			
			// check if inserted
			result = (inserted > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}

	@Override
	/**
	 * Function to change the Account status. This function will be extensively 
	 * used for for all account related applications. 
	 * 
	 *  @param accountNumber
	 *  @param operation
	 *  @return true if updated, false otherwise. 
	 */
	public boolean changeAccountStatus(int accountNumber, char operation) {
		boolean result = false;
		
		// update query
		String sql = "UPDATE BANK_ACCOUNTS SET Status=? WHERE AccountNo=?";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			String status = "";
			
			switch(Character.toUpperCase(operation)) {
				case 'D': status = "DENIED"; break;
				case 'P': status = "PENDING"; break;
				case 'C': status = "CANCELLED"; break;
				case 'A': status = "APPROVED"; break;
			}
			
			ps.setString(1, status);
			ps.setInt(2, accountNumber);
			
			int updated = ps.executeUpdate();
			
			// check if inserted
			result = (updated > 0) ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
		
		return result;
	}

	@Override
	/**
	 * Function to get all the Accounts for a given user identified by the 
	 * user name. 
	 * 
	 *  @param userName
	 *  @return list of accounts. 
	 */
	public ArrayList<Integer> getUserAccounts(String userName) {
		
		ArrayList<Integer> accounts = new ArrayList<Integer>();
		
		String sql = "SELECT AccountNo FROM BANK_ACCOUNTS WHERE USER1 = ?";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				accounts.add(rs.getInt("AccountNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	/**
	 * Function to read the Status of a given account identified by the account number. 
	 * 
	 * @return account status
	 */
	public String getAccountStatus(int accountNumber) {
		String status = "UNKNOWN";
		
		String sql = "SELECT Status FROM BANK_ACCOUNTS WHERE AccountNumber = ?";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){

			ps.setInt(1, accountNumber);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				status = rs.getString("Status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	/**
	 * Function to get the list of all the accounts from the database. 
	 * 
	 * @return account list
	 */
	public ArrayList<Integer> getAllAccounts() {
		ArrayList<Integer> accounts = new ArrayList<Integer>();
		
		String sql = "SELECT AccountNo FROM BANK_ACCOUNTS";
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql) ){
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				accounts.add(rs.getInt("AccountNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	/**
	 * Function to get the list of all the pending accounts. 
	 * 
	 * @return list of accounts. 
	 */
	public ArrayList<Account> getPendingApplications() {
		String sql = "SELECT * FROM BANK_ACCOUNTS WHERE AccountNo = ?";
		Account a = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet rs = ps.executeQuery();
			
			//if rs returns a value then the sql query has returned the balance
			if(rs.next()) {
				
				String status = rs.getString("Status");
				
				if(status.equalsIgnoreCase("PENDING")) {
				
					a = new Account();
					int accountNumber = rs.getInt("AccountNo");
					double balance = rs.getDouble("BALANCE");
					String user1 = rs.getString("User1");
					String user2 = rs.getString("User2");
					
					a.setAccountNumber(accountNumber);
					a.setBalance(balance);
					a.setStatus(status);
					a.setUser1(user1);
					a.setUser2(user2);
					
					accounts.add(a);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	/**
	 * Function to fetch the list of all the accounts that are Join Accounts. 
	 * An account is join, where user2 is not null. 
	 * 
	 * @return list of all pending joint accounts. 
	 */
	public ArrayList<Account> getPendingJointApplications() {
		
		String sql = "SELECT * FROM BANK_ACCOUNTS WHERE AccountNo = ?";
		Account a = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try(Connection con = ConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){

			ResultSet rs = ps.executeQuery();
			
			//if rs returns a value then the sql query has returned the balance
			if(rs.next()) {
				
				String status = rs.getString("Status");
				String user2 = rs.getString("User2");
				
				if(status.equalsIgnoreCase("PENDING") && user2 != null) {
				
					a = new Account();
					int accountNumber = rs.getInt("AccountNo");
					double balance = rs.getDouble("BALANCE");
					String user1 = rs.getString("User1");
					a.setAccountNumber(accountNumber);
					a.setBalance(balance);
					a.setStatus(status);
					a.setUser1(user1);
					a.setUser2(user2);
					
					accounts.add(a);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
		
	}

}
