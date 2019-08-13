package banking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import banking.application.Account;
import banking.application.User;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account account) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("INSERT INTO bank_account VALUES (0,?,?,?)");
			prep.setDouble(2, account.getBalance());
			prep.setString(1, account.getName());
			prep.setString(3, account.getStatus());
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		try {
			ArrayList<Account> store = new ArrayList<Account>();
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_account");
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				store.add(new Account(res.getDouble("balance"), res.getString("account_name"),
						res.getInt("account_number"), res.getString("status")));
			}
			prep.cancel();
			return store;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Account> getTiedAccounts(User user) {
		try {
			ArrayList<Account> accounts = new ArrayList<Account>();
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement(
					"SELECT * FROM linker RIGHT OUTER JOIN bank_account ON linker.account_number=bank_account.account_number WHERE user_id=?");
			String id = user.getID();
			prep.setString(1, id);
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				accounts.add(new Account(res.getDouble("balance"), res.getString("account_name"),
						res.getInt("account_number"), res.getString("status")));
			}
			prep.cancel();
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccount(int accountNumber) {
		try {
			Account account = new Account();
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_account WHERE account_number = ?");
			prep.setInt(1, accountNumber);
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				account = new Account(res.getDouble("balance"), res.getString("account_name"),
						res.getInt("account_number"), res.getString("status"));
			}
			prep.cancel();
			return account;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeAccount(int accountNumber) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("DELETE FROM linker WHERE account_number = ?");
			prep.setInt(1, accountNumber);
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(Account account) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con
					.prepareStatement("UPDATE bank_account SET balance=?,status=? WHERE account_number=?");
			prep.setDouble(1, account.getBalance());
			prep.setString(2, account.getStatus());
			prep.setInt(3, account.getNumber());
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tieAccount(Account account, User user) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("INSERT INTO linker VALUES (0,?,?)");
			prep.setInt(1, account.getNumber());
			prep.setString(2, user.getID());
			prep.execute();
			prep.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean findAccount(int accountNumber) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_account WHERE account_number = ?");
			prep.setInt(1, accountNumber);
			ResultSet res = prep.executeQuery();
			prep.cancel();
			if (res.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean findPending() {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_account WHERE status = 'Pending'");
			ResultSet res = prep.executeQuery();
			prep.cancel();
			if (res.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean findPending(int accountNumber) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con
					.prepareStatement("SELECT * FROM bank_account WHERE status = 'Pending' AND account_number=?");
			prep.setInt(1, accountNumber);
			ResultSet res = prep.executeQuery();
			prep.cancel();
			if (res.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Account> viewPending() {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			ArrayList<Account> accounts = new ArrayList<Account>();
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_account WHERE status = 'Pending'");
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				accounts.add(new Account(res.getDouble("balance"), res.getString("account_name"),
						res.getInt("account_number"), res.getString("status")));
			}
			prep.cancel();
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int size() {
		try {
			int size = 0;
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT * FROM bank_account");
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				size++;
			}
			prep.cancel();
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean isTied(Account account, User user) {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT * FROM linker WHERE account_number=? AND user_id=?");
			prep.setInt(1, account.getNumber());
			prep.setString(2, user.getID());
			ResultSet res = prep.executeQuery();
			prep.cancel();
			if (res.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int retrieve() {
		try {
			Connection con = DriverManager.getConnection(Info.url, Info.user, Info.pass);
			PreparedStatement prep = con.prepareStatement("SELECT MAX(account_number) FROM BANK_ACCOUNT");
			ResultSet res = prep.executeQuery();
			prep.cancel();
			while (res.next()) {
				return res.getInt("MAX(account_number)");
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
