package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Account;
import beans.User;
import menus.AdminMenu;
import menus.CustomerMenu;
import menus.MainMenu;

public class Transaction {
	static Connection conn;
	private static String url = "jdbc:oracle:thin:@samjavadb.cecxuvq3cw6r.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "sambo";
	private static String password = "sambo";
	AccountDimple adi = new AccountDimple();
	UserDimple udi = new UserDimple();
	MainMenu mainMenu = new MainMenu();
	CustomerMenu custMenu = new CustomerMenu();
	AdminMenu adminMenu = new AdminMenu();
	
	public void insertAdmins() {
		if(udi.findUserByUsername("admin")==null) {
			User u = new User("admin","admin");
			createUser(u);
			if(udi.findUserByUsername("emp")==null) {
				u = new User("emp","emp");
				createUser(u);
			}
		}
	}
	
	public User login(String un, String pw) {
//		Account a = null;
//		User user = null;
		User user = findUser(un);
//		if (user == null) {
//			System.out.println("User does not exist.");
//			mainMenu.mainMenu();
//		} else if (pw.equals(user.getPassword())) {
//			Transaction t = new Transaction();
//			a = t.findAccountByUsername(un);
//			custMenu.actionMenu(a);
//		} else {
//			System.out.println("Incorrect password. Entered " + pw + "On file: " + user.getPassword());
//			System.out.println(a.toString());
//			mainMenu.mainMenu();
//		}
		
		return user;
	}

	public void createUser(User u) {
		udi.insertUser(u);
	}

	public User findUser(String un) {
		User user = null;
		user = udi.findUserByUsername(un);
//		if(user==null) {
////			System.out.println("No such user exists.");
////			adminMenu.mainMenu();
//		} 
		return user;
	}
	public List<String> findAllUsernames(){
		List<String> users = udi.findAllUsernames();
		return users;
	}
	// methods for the junction table (lookuptable)-------------------
	public String findAIDByUsername(String un) {
		String aid = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM lookuptable WHERE username = ?");
			ps.setString(1, un);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				aid = rs.getString("aid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aid;
	}

	public void insertIntoJunction(String un) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO lookuptable VALUES (?,null)");
			ps.setString(1, un);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// methods for accounts -- deposit, withdraw, transfer, approve & delete
	public static Boolean checkApproved(Account a) {
		if (a.getIsApproved()==0) {
			System.out.println("Account is not approved. Unable to complete transaction.");
			return false;
		}

		return true;
	}

	public void createAccount(Account a) {
		adi.insertAccount(a);
	}
	public Account findAccountByAID(String aid) {
		return adi.findAccountByAID(aid);
	}
	public void deposit(String aid, Double amount) {
		Account a = adi.findAccountByAID(aid);
		if (!checkApproved(a)) {
			return;
		}
		Double currBalance = a.getBalance();
		Double newBalance = currBalance + amount;
		a.setBalance(newBalance);
		adi.updateAccountBalance(a);

	}

	public void withdraw(String aid, Double amount) {
		Account a = adi.findAccountByAID(aid);
		if (!checkApproved(a)) {
			return;
		}
		Double currBalance = a.getBalance();
		if ((currBalance - amount > 0)) {
			Double newBalance = currBalance - amount;
			a.setBalance(newBalance);
			adi.updateAccountBalance(a);
			System.out.println("Withdrawal Successful");

		} else {
			System.out.println("Insufficient funds to withdraw.");
		}
	}

	public void deleteAccountByAID(String aid) {
		Account a = adi.findAccountByAID(aid);
		adi.deleteAccount(a);
	}

	public  void approveAccount(Account a) {
		adi.updateAccountApproval(a);
	}

	public void transferAmount(String aid1, String aid2, Double amount) {
		Account a1 = adi.findAccountByAID(aid1);
		Account a2 = adi.findAccountByAID(aid2);
		if(!checkApproved(a1)) {
			System.out.println("First account is not approved.");
			return;
		}
		else if(!checkApproved(a2)) {
			System.out.println("Second account is not approved.");
			return;
		}
		Double balanceOne = a1.getBalance();
		Double balanceTwo = a2.getBalance();
		if ((balanceOne - amount) > 0) {
			a1.setBalance(balanceOne - amount); // subtract the amount from the first account
			a2.setBalance(balanceTwo + amount); // add the amount to the second balance
			adi.updateAccountBalance(a1);
			adi.updateAccountBalance(a2);
		} else {
			System.out.println("Insufficient funds to complete transfer.");
		}

	}

}
