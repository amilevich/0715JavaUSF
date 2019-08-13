package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountsDaoImpl implements AccountDao {
	{
		private static String url = "jdbc:oracle:thin:@dbrevature.civvot2n2xbn.us-east-2.rds.amazonaws.com:1521:revature";
		private static String username = "erozenblum";
		private static String password = "ella1975";
		
		@Override
		public List<Account> getAll() {

			List<Account> accounts = new ArrayList<>();
			try(Connection conn =
					DriverManager.getConnection(url, username, password)) {
				

					String sql = "SELECT * FROM Accounts";
					
					
					Statement stmt = conn.createStatement();
					
					
					ResultSet rs = stmt.executeQuery(sql);
					accounts = this.mapResultSet(rs);
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return accounts;
		}
		
		@Override
		public Account getById(int Id) {
			
			Account account = new Account();
			
			try(Connection conn =
					DriverManager.getConnection(url, username, password)) {			
				
				String sql = "SELECT * FROM accounts WHERE account_id = ?";
				
			
				PreparedStatement prepState = conn.prepareStatement(sql);
				
				//Parameterized and therefore no SQL injection
				prepState.setInt(1, Id);
				
				
				ResultSet rs = prepState.executeQuery();
				
		
				while(rs.next()) {
					account.setId(rs.getInt(1));
					account.setAccountType(rs.getString(2));
					account.setBalance(rs.getInt(3));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(account.getId() == 0) return null;
			
			return account;
		}
		
		public List<Account> getByUserId(int UserId) {
			
			List<Account> accounts = new ArrayList<>();
			
			try(Connection conn =
					DriverManager.getConnection(url, username, password)) {			
				String sql = "SELECT * FROM accounts WHERE account_id IN (SELECT account_id FROM Usersaccounts WHERE User_id = ?)";
				
				PreparedStatement prepState = conn.prepareStatement(sql);
				
				prepState.setInt(1, UserId);
				
				ResultSet rs = prepState.executeQuery();
				
				while(rs.next()) {
					Account temp = new Account();
					temp.setId(rs.getInt("account_id"));
					temp.setAccountType(rs.getString("account_type"));
					temp.setBalance(rs.getInt("balance"));
					accounts.add(temp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return accounts;
		}
		
		@Override
		public Account add(Account newAccount) {
			List<Account> accountList = this.getByUserId(AppState.getCurrentUser().getId());
			for(Account a: accountList) {
				
				//If account already exits, give a warning
				if(a.getAccountType().equals(newAccount.getAccountType())) {
					System.out.println("[WARN] - Account not created, account of this type already exists for current User");
					return null;
				}	
				
			}
			
			try(Connection conn =
					DriverManager.getConnection(url, username, password)) {			
				conn.setAutoCommit(false);
				
				String sql = "INSERT INTO accounts VALUES (0, ?, 0)";
				
				String[] keys = new String[1];
				keys[0] = "account_id";
				
				PreparedStatement prepState = conn.prepareStatement(sql, keys);
				prepState.setString(1, newAccount.getAccountType());
				
				int rowsInserted = prepState.executeUpdate();
				ResultSet rs = prepState.getGeneratedKeys();
				
				if(rowsInserted != 0) {
					
					while(rs.next()) {
						newAccount.setId(rs.getInt(1));
					}
					
					conn.commit();
					
				}
				
				String sqlTwo = "INSERT INTO Usersaccounts VALUES (?, ?)";
				
				PreparedStatement prepStateTwo = conn.prepareStatement(sqlTwo);
				prepStateTwo.setInt(1, AppState.getCurrentUser().getId());
				prepStateTwo.setInt(2, newAccount.getId());
				
				int rowsInsertedTwo = prepStateTwo.executeUpdate();
				
				if(rowsInsertedTwo != 0) {
					conn.commit();
				}
						
			} catch (SQLIntegrityConstraintViolationException sicve) { 
				sicve.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(newAccount.getId() == 0) return null;
			
			System.out.println("New account created");
			System.out.println("Create another account or leave this menu");
			return newAccount;
		}
		
		@Override
		public Account update(Account updatedAccount) {
			
			try(Connection conn =
					DriverManager.getConnection(url, username, password)) {			
				conn.setAutoCommit(false);
				
				String sql = "UPDATE accounts SET balance = ? WHERE account_id IN (SELECT account_id FROM Usersaccounts WHERE User_id = ?) AND account_type = ?";
				
				PreparedStatement prepState = conn.prepareStatement(sql);
				prepState.setInt(1, updatedAccount.getBalance());
				prepState.setInt(2, AppState.getCurrentUser().getId());
				prepState.setString(3, updatedAccount.getAccountType());
				
				int rowsUpdated = prepState.executeUpdate();
				
				if(rowsUpdated != 0) {
					conn.commit();
					return updatedAccount;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		public boolean delete(int id) {
			
			return false;
			
		}
		
		public List<Account> mapResultSet(ResultSet rs) throws SQLException {
			List<Account> accounts = new ArrayList<>();

			while (rs.next()) {
				Account temp = new Account();
				temp.setId(rs.getInt("account_id"));
				temp.setAccountType(rs.getString("account_type"));
				temp.setBalance(rs.getInt("balance"));
				accounts.add(temp);
			}

			return accounts;
		}
		
		
	}

	@Override
	public int insertPet(Pet p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pet selectPetByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> selectAllPets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePet(Pet p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePet(Pet p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
