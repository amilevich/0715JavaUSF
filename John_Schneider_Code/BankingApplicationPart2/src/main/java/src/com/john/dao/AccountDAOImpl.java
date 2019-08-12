package src.com.john.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.com.john.core.Account;
import src.com.john.core.CheckingsAccount;
import src.com.john.core.SavingsAccount;

public class AccountDAOImpl implements AccountDAO 
{
	private static String url = "jdbc:oracle:thin:@database1.cqmnrwj9hkjl.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "Admin";
	private static String password = "Admin123";
	
	private static Connection conn;
	
	public AccountDAOImpl()
	{
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Account account) {
		double balance, min, odf;
		String approved, cancelled, jo, po;
		int max, current;
		
		balance = account.getBalance();
		approved = (account.isApproved() == true ? "t" : "f");
		cancelled = (account.isCancelled() == true ? "t" : "f");
		jo = account.getJointOwner();
		po = account.getPrimaryOwner();
		
		if(account instanceof CheckingsAccount)
		{
			odf = ((CheckingsAccount)account).getOverdraftFee();
			min = -1;
			max = -1;
			current = -1;
		} else {
			odf = -1;
			min = ((SavingsAccount)account).getMinBalance();
			max = ((SavingsAccount)account).getMax();
			current = ((SavingsAccount)account).getCurrent();
		}
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts (Accounts.account_balance, "
														+ "Accounts.account_approved, Accounts.account_cancelled, "
														+ "Accounts.account_joint_owner,"
														+ "Accounts.account_primary_owner, Accounts.account_overdraft_fee,"
														+ "Accounts.account_min_balance, Accounts.account_max_withdraws,"
														+ "Accounts.account_current_withdraws) "
														+ "Values(?,?,?,?,?,?,?,?,?)");
			
			ps.setDouble(1, balance);
			ps.setString(2, approved);
			ps.setString(3, cancelled);
			ps.setString(4, jo);
			ps.setString(5, po);
			ps.setDouble(6, odf);
			ps.setDouble(7, min);
			ps.setInt(8, max);
			ps.setInt(9, current);
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Account selectAccountByID(int ID) {
		Account newAccount = null;
		
		double balance = 0, min = 0, odf = 0;
		String approved = "", cancelled = "", jo = "", po = "";
		int max = 0, current = 0, aID = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts WHERE Accounts.account_id = ?");
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				balance = rs.getDouble("account_balance");
				min = rs.getDouble("account_min_balance");
				odf = rs.getDouble("account_overdraft_fee");
				approved = rs.getString("account_approved");
				cancelled = rs.getString("account_cancelled");
				jo = rs.getString("account_joint_owner");
				po = rs.getString("account_primary_owner");
				max = rs.getInt("account_max_withdraws");
				current = rs.getInt("account_current_withdraws");
				
				aID = rs.getInt("account_id");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		boolean appr = approved.equals("t") ? true : false;
		boolean canc = cancelled.equals("t") ? true : false;
		
		if(min != -1) {
			newAccount = new SavingsAccount(aID, po, jo, balance, min, max, current, appr, canc);
		} else {
			newAccount = new CheckingsAccount(aID, po, jo, balance, odf, appr, canc);
		}
		
		return newAccount;
	}

	@Override
	public ArrayList<Account> selectAllAccounts() {
		ArrayList<Account> newList = new ArrayList<Account>();
		Account newAccount = null;
		
		double balance = 0, min = 0, odf = 0;
		String approved = "", cancelled = "", jo = "", po = "";
		int max = 0, current = 0, aID = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Accounts");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				balance = rs.getDouble("account_balance");
				min = rs.getDouble("account_min_balance");
				odf = rs.getDouble("account_overdraft_fee");
				approved = rs.getString("account_approved");
				cancelled = rs.getString("account_cancelled");
				jo = rs.getString("account_joint_owner");
				po = rs.getString("account_primary_owner");
				max = rs.getInt("account_max_withdraws");
				current = rs.getInt("account_current_withdraws");
				aID = rs.getInt("account_id");
				
				boolean appr = approved.equals("t") ? true : false;
				boolean canc = cancelled.equals("t") ? true : false;
				
				if(min != -1) {
					newAccount = new SavingsAccount(aID, po, jo, balance, min, max, current, appr, canc);
				} else {
					newAccount = new CheckingsAccount(aID, po, jo, balance, odf, appr, canc);
				}
				
				newList.add(newAccount);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return newList;
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub
		
	}
	
	public void truncate() {
		try {
			PreparedStatement ps = conn.prepareStatement("TRUNCATE TABLE Accounts");
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}