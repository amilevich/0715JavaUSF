package src.com.john.ui;

import java.util.ArrayList;
import java.util.Set;

import src.com.john.core.Account;
import src.com.john.core.AccountManager;
import src.com.john.core.Admin;
import src.com.john.core.Customer;
import src.com.john.core.Employee;
import src.com.john.core.User;
import src.com.john.core.UserManager;

public class CoreStarter
{
	final String EMPLOYEE_AUTH = "123";
	final String ADMIN_AUTH = "321";
	
	AccountManager accountManager;
	UserManager userManager;
	
	DataBaser databaser;
	
	public CoreStarter()
	{
		databaser = new DataBaser();
		
		accountManager = databaser.am;
		userManager = databaser.um;
		
		if(accountManager == null)
			accountManager = new AccountManager();
		if(userManager == null)
			userManager = new UserManager();
	}
	
	void finish()
	{
		databaser.save(userManager, accountManager);
	}
	
	void depositToAccount(String username, String ID, double amount)
	{
		Account to = getAccountByID(ID);
		
		if(to == null) {
			System.out.println("Account does not exist.");
			return;
		}
		
		if(!to.isApproved() || to.isCancelled()) {
			System.out.println("Account is not active.");
			return;
		}
		
		User[] owners = getUsersByAccount(to);
		
		String[] usernames = {owners[0].getUsername(), 
								(owners[1] == null ? "" : owners[1].getUsername())};
		
		if(!isAdmin(username)) {
			if(!usernames[0].equals(username) && !usernames[1].equals(username)) {
				System.out.println("You are not authorized to deposit to this account.");
				return;
			}
		}
		
		to.deposit(amount);
	}
	
	void withdrawFromAccount(String username, String ID, double amount)
	{
		Account to = getAccountByID(ID);
		
		if(to == null) {
			System.out.println("Account does not exist.");
			return;
		}
		
		if(!to.isApproved() || to.isCancelled()) {
			System.out.println("Account is not active.");
			return;
		}
		
		User[] owners = getUsersByAccount(to);
		
		String[] usernames = {owners[0].getUsername(), 
				(owners[1] == null ? "" : owners[1].getUsername())};

		if(!isAdmin(username)) {
			if(!usernames[0].equals(username) && !usernames[1].equals(username)) {
				System.out.println("You are not authorized to deposit to this account.");
				return;
			}
		}
		
		double completed = to.withdraw(amount);
		
		if(completed == -1) {
			System.out.println("Withdraw failed.");
		}
	}
	
	boolean addUser(String username, String password, int type)
	{
		return userManager.addUser(username, password, type);
	}
	
	boolean addAccount(String username, int type, String jointOwner)
	{
		if(jointOwner != "null" && ! userManager.doesUserExist(jointOwner))
			return false;
		
		User jointOwnerUser;
		
		if(jointOwner == "null")
			jointOwnerUser = null;
		else
			jointOwnerUser = userManager.getUser(jointOwner);
		
		User currentUser = userManager.getUser(username);
		
		accountManager.addNewAccount(currentUser, type, jointOwnerUser);
		
		return true;
	}
	
	int tryLogin(String username, String password)
	{
		if(! userManager.doesUserExist(username))
			return 0;
		
		return userManager.isCorrectCombination(username, password) ? 1 : -1;
	}
	
	boolean isCustomer(String username)
	{
		return userManager.getUser(username) instanceof Customer;
	}
	
	boolean isEmployee(String username)
	{
		return userManager.getUser(username) instanceof Employee;
	}
	
	boolean isAdmin(String username)
	{
		return userManager.getUser(username) instanceof Admin;
	}
	
	void printAllUsers()
	{
		System.out.println(userManager);
	}
	
	void printAccounts(String username)
	{
		ArrayList<Account> accounts = accountManager.getAccounts(username);
		
		if(!userManager.doesUserExist(username)) {
			System.out.println("User does not exist.");
			return;
		}
		
		if(accounts == null)
			System.out.println(username+" has no accounts open at this time.");
		else {
			for(Account a : accounts)
				System.out.println(a);
		}
	}
	
	void printApplications()
	{
		Set<String> usernames = accountManager.getKeySet();
		ArrayList<Account> accounts;
		
		for(String s : usernames)
		{
			accounts = accountManager.getAccounts(s);
			
			if(accounts==null) continue;
			else {
				for(Account a : accounts) {
					if(a.isApproved() || a.isCancelled()) {
						continue;
					} else {
						System.out.println(a);
					}
				}
			}
		}
	}
	
	void approveAccountByID(String ID)
	{
		Account accountToApprove = getAccountByID(ID);
		
		if(accountToApprove == null) {
			System.out.println("No such account exists at this time.");
			return;
		}
		
		if(accountToApprove.isCancelled()) {
			System.out.println("This account has been cancelled.");
			return;
		}
		
		if(accountToApprove.isApproved()) {
			System.out.println("This account has already been approved.");
			return;
		}
		
		accountToApprove.setApproved(true);
	}
	
	void denyAccountByID(String username, String ID)
	{
		if(!isInt(ID)) return;
		
		Account accountToDeny = getAccountByID(ID);
		
		if(accountToDeny == null) {
			System.out.println("No such account exists at this time.");
			return;
		}
		
		if(!isAdmin(username)) {
			if(accountToDeny.isApproved()) {
				System.out.println("This account has already been approved.");
				return;
			}
		}
		
		accountToDeny.cancelAccount();
	}
	
	Account getAccountByID(String ID)
	{
		Set<String> usernames = accountManager.getKeySet();
		ArrayList<Account> accounts;
		
		Account account = null;
		
		for(String s : usernames)
		{
			accounts = accountManager.getAccounts(s);
			
			if(accounts==null) continue;
			else {
				for(Account a : accounts) {
					if(a.getId() == Integer.parseInt(ID)){
						account = a;
						break;
					}
				}
			}
		}
		
		return account;
	}
	
	User[] getUsersByAccount(Account account)
	{
		User[] owners = { userManager.getUser(account.getPrimaryOwner()), userManager.getUser(account.getJointOwner()) };
		return owners;
	}
	
	void transferFunds(String username, String from_id, String to_id, double amount)
	{	
		Account from_Account = getAccountByID(from_id);
		Account to_Account = getAccountByID(to_id);
		
		boolean can_From = (from_Account == null || from_Account.isCancelled() || !from_Account.isApproved()) ? false : true;
		boolean can_To = (to_Account == null || to_Account.isCancelled() || !to_Account.isApproved()) ? false : true;
		
		if(!can_From || !can_To) {
			System.out.println("Invalid entry. Account is not active.");
			return;
		}
		
		if(from_Account.equals(to_Account)) {
			System.out.println("Invalid entry. Must choose two different accounts.");
			return;
		}
		
		User[] from_Users = getUsersByAccount(from_Account);
		String[] from_Usernames = { from_Users[0].getUsername(),
									(from_Users[1] == null ? "" : from_Users[1].getUsername())};
		
		if((isCustomer(username) && 
				(username.equals(from_Usernames[0]) || username.equals(from_Usernames[1])))
				|| isAdmin(username)) {
			double tryTransfer = from_Account.withdraw(amount);
			
			if(tryTransfer == -1) {
				System.out.println("Transfer failed. Insufficient funds.");
				return;
			} else {
				to_Account.deposit(amount);
			}
		} else {
			System.out.println("You do not have permission to perform this operation.");
		}
	}
	
	boolean isDouble(String str)
	{
		try{
			Double.parseDouble(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	boolean isInt(String str)
	{
		try {
			Integer.parseInt(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}