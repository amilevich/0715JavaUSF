package bank.running;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bank.accounts.Employee;
import bank.accounts.Joint;
import bank.accounts.Personal;
import bank.accounts.User;
import dao.models.Customer;
import dao.models.CustomerDAOImpl;
import dao.models.JunctionInfo;
import db.bank.admin.AdminDBM;


//account manager
public class AccountsM 
{	
	String filename = "./BankAccounts.txt";
	
	  Map<Integer, User> accounts = new HashMap<Integer, User>();
	  Scanner scan = new Scanner(System.in);
	  Iterator<Entry<Integer, User>> it = accounts.entrySet().iterator();
	  final static Logger log = Logger.getLogger(AccountsM.class);
	  AdminDBM aDbm = new AdminDBM();
	  CustomerDAOImpl cDao = new CustomerDAOImpl();
	  
	  public Employee createAccountE(String firstName, String lastName, String userName, String password)
		{			
			{
				int nAcctID;
				nAcctID = getNextAccountID();
				Employee pAcc = new Employee(nAcctID, firstName, lastName, userName, password);
				pAcc.setFirstName(firstName);
				pAcc.setLastName(lastName);
				pAcc.setUserName(userName);
				pAcc.setPassword(password);
				accounts.put(nAcctID, pAcc); 
				return pAcc;
				
			}
		}
	  
	  
	 //withdrawqm method
	  public void withdraw(double amount, String userName) 
		{
		  int acctID = cDao.findPersRelAcct(userName).getAccount_id();
			System.out.println("Withdrawing for account number: " + acctID);


			if (aDbm.getDBbalance(acctID).getBalance() < amount)
			{
				
				System.out.println("Transfering amount cannot be over account balance. Current balance has not changed: " + aDbm.getDBbalance(acctID).getBalance());	
				
				
			}
			else if(amount < 0)
			{
				System.out.println("Withdrawal amount cannot be negative. Current balance has not changed: " + aDbm.getDBbalance(acctID).getBalance());
				
			}
			else
			{
				double newAmt = aDbm.getDBbalance(acctID).getBalance() - amount;
				cDao.updateCustDBbalance(acctID, newAmt);
				System.out.println("Withdrawal successful, your current balance is now: " + newAmt);	
				log.info("Customer: Withdraw successful for: "+ acctID + " " + amount);
			}
		}
	  
	//depositqm method
	  public void deposit(double amount, String userName) 
		{
			int acctID = cDao.findPersRelAcct(userName).getAccount_id();
			System.out.println("Depositing for account number: " + acctID);
	
			if (amount > 0)
			{
				
				double newAmt = aDbm.getDBbalance(acctID).getBalance() + amount;
//				System.out.println(newAmt);
//				accounts.get(accountID).setBalance(accounts.get(accountID).getBalance() + amount);
				cDao.updateCustDBbalance(acctID, newAmt); //<<works
				System.out.println("Deposit successful, your current balance is now "
						+  newAmt);
				log.info("Customer: Deposit successful for: "+ acctID + " " + amount);
			}
			else
			{
				System.out.println("Deposit amount cannot be negative. Balance not changed: " + aDbm.getDBbalance(acctID).getBalance());
				
			}
		}
	  
	  //transferqm method
	  public void transfer(double amount, int accountID, int accountID2) 
			{			
				System.out.println("Transfering money for account number: " + accountID);
				System.out.println("to account number: " + accountID2);

				if (aDbm.getDBbalance(accountID).getBalance() < amount)
				{					
					System.out.println("Transfering amount cannot be over account balance. Current balance has not changed: " + aDbm.getDBbalance(accountID).getBalance());									
				}
				else if(amount < 0)
				{
					System.out.println("Transfering amount cannot be negative. Current balance has not changed: " + aDbm.getDBbalance(accountID).getBalance());
					
				}
				else
				{
					double newAmt = aDbm.getDBbalance(accountID).getBalance() - amount;
					cDao.updateCustDBbalance(accountID, newAmt);
					double newAmt2 = aDbm.getDBbalance(accountID2).getBalance() + amount;
					cDao.updateCustDBbalance(accountID2, newAmt2);
					System.out.println("Transfering successful, your current balance for account number " + accountID +  " is now: " + aDbm.getDBbalance(accountID).getBalance());
					System.out.println(" and current balance for account number " + accountID2 +  " is now: " + aDbm.getDBbalance(accountID2).getBalance());
					log.info("Customer: Transfer successful for: "+ accountID + " " + amount);
				}
			}
	  
	  //customer view account information db
	  public void viewAcct(String userName)
	  {
		  System.out.println("This is your current account details");
		  JunctionInfo juncObj = cDao.findPersRelAcct(userName);
//		  System.out.println(juncObj.toString());
		   int acctNum = juncObj.getAccount_id();
		   System.out.println("Here is your current account information");
		   System.out.println(cDao.findAcctById(acctNum));
//		  if(accounts.get(accountID).getJointStatus().equals("true"))
//		  {
//			  System.out.println(accounts.get(accounts.get(accountID).getJointAcctID()).toString());
//		  }
	  }
	  
	//joint account signup, 
	  public void createJointAccount(int accountID)
	  {
		  int nextID = getNextAccountJointID();
		  accounts.get(accountID).setJointAcctID(nextID);
	  }
	  
	//find account id method
	public boolean findAccID(int accountID)
	{
//		System.out.println(accounts.keySet());
//		System.out.println(accounts.get(1));
//		System.out.println(accounts.size());
		if(accounts.containsKey(accountID))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//check username match account
	public boolean finduName(String username, int accountID)
	{
		if(accounts.get(accountID).getUserName().equals(username))
		{ 
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//check password match account
	public boolean findPassword(String password, int accountID)
	{
		if(accounts.get(accountID).getPassword().equals(password))
		{ 
			return true;
		}
		else if(accounts.get(accountID).getPasswordJ().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//check if personal only or has joint account, if true, has joint account, false does not
	public boolean perOrJoint(int accountID)
	{
		if(accounts.get(accountID).getJointStatus().equals("true"))
		{ 
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//customer check account approval method local
//	public boolean findAcctSta(int accountID)
//	{
//		if(accounts.get(accountID).toString().contains("NotApp"))
//		{
//			System.out.println("Your account has not yet been approved, please wait for bank approval, before logging in, now returning to main menu");
//			return false;
//		}
//		else if(accounts.get(accountID).toString().contains("DenyApp"))
//		{
//			System.out.println("Your account has been denied, now returning to main menu");
//			return false;
//		}
//		else
//		{
//			return true;
//		}
//	}
	
	//customer check account approval method database
	public boolean AcctStatChecker(String userName)
	{
		CustomerDAOImpl cDao = new CustomerDAOImpl();
		int acctIDUsername = cDao.findPersRelAcct(userName).getAccount_id();
		try {
			if(aDbm.findAcctStaDB(acctIDUsername).getAccountStatus().equals(null))
			{
				return false;
			}
			else if(aDbm.findAcctStaDB(acctIDUsername).getAccountStatus().equals("pending"))
			{
				System.out.println("Your account has not yet been approved, please wait for bank approval, before logging in, now returning to main menu");
				return false;
			}
			else if(aDbm.findAcctStaDB(acctIDUsername).getAccountStatus().equals("deny"))
			{
				System.out.println("Your account has been denied, now returning to main menu");
				return false;
			}
			else if(aDbm.findAcctStaDB(acctIDUsername).getAccountStatus().equals("app"))
			{
				return true;
			}
			System.out.println("We apologize, your account could not be found, if you haven't applied before, please sign up for a new account");
			return false;			
		} catch (Exception e) {
			System.out.println("We apologize, your account could not be found, if you haven't applied before, please sign up for a new account");
			return false;
		}
	}
	
	
		
	
		//admin approve accounts method
		public void adminApprove()
		{			 		
			List<Customer> check = aDbm.findPendingAcctDB();		
				System.out.println("Showing accounts pending approval...");
							
				for (Customer x : check) 
				{
				       System.out.println("This account is pending approval: " + x);
				       scan = new Scanner(System.in);
		    			if(check.toString().contains("pending"))
		    			{
		    				System.out.println("Do you approve this account?");
		    				System.out.println("Enter \"app\" to Approve Account and \"deny\" to Deny Account Application" );	    				
		    				String y = scan.nextLine();
		    				System.out.println("Account number " + x.getAccountID() + " approved");
		    				cDao.updateCustDB(x.getAccountID(), y);
//		    				accounts.get(x).setAccountStatus(y);
//		    				System.out.println(getAllAccounts());
		    				
		    			}
		    			else
		    			{
		    				System.out.println("No accounts to approve");
					}			
				}
				System.out.println("No more accounts to approve, approval process complete, returning to main admin menu");
		}
		
		//admin cancel accounts method
		
		public void adminCancel()
		{			 		
			List<Customer> check = aDbm.findPendingAcctDB();		
				System.out.println("Showing accounts abled to be cancelled...");
							
				for (Customer x : check) 
				{
				       System.out.println("This account can be cancelled: " + x);
				       scan = new Scanner(System.in);
		    			if(check.toString().contains("app"))
		    			{
		    				System.out.println("Do you want to cancel this account?");
		    				System.out.println("Enter \"can\" to Cancel this Account and \"app\" to allow account to stay approved" );	    				
		    				String y = scan.nextLine();
		    				if(y.equals("can"))
		    				{
		    					System.out.println("Account number " + x.getAccountID() + " cancelled");
		    				}
		    				else if(y.equals("app"))
		    				{
		    					System.out.println("Account number " + x.getAccountID() + " still approved");
		    				}
		    				else
		    				{
		    					System.out.println("command not valid, moving on to next account");
		    				}
		    				cDao.updateCustDB(x.getAccountID(), y);
		    			}
		    			else
		    			{
		    				System.out.println("No accounts to cancel");
					}			
				}
				System.out.println("No more accounts to cancel, cancellation process complete, returning to main admin menu");
		}
		
	
	    		
	//create new account method, adds new accoutn object to hashmap
	public Personal createAccount(String accountType, String firstName, String lastName, String userName, String password)
	{
//		if(accountType.equalsIgnoreCase("personal"))
		{
			int nAcctID;
			nAcctID = getNextAccountID();
			Personal pAcc = new Personal(nAcctID, firstName, lastName, userName, password);
			pAcc.setFirstName(firstName);
			pAcc.setLastName(lastName);
			pAcc.setUserName(userName);
			pAcc.setPassword(password);
			accounts.put(nAcctID, pAcc);
			System.out.println("This is your Account ID, please remember it for logging in: " + nAcctID);
//			System.out.println("account size at creation " + accounts.size());
			System.out.println("Thank you for applying at Damon Bank, our managers will review your account and get back to you if you are approved");
			System.out.println("You will now be returned to the main menu");
			return pAcc;
			
		}
	}
		
		public Joint createAccountJ(String accountType, String firstName, String firstNameJ, String lastName, String lastNameJ, String userName, String userNameJ, String password, String passwordJ, int personalAcctID)
		{	
			int nAcctID;
			nAcctID = getNextAccountJointID();
			Joint jAcc = new Joint(nAcctID, firstName, firstNameJ, lastName, lastNameJ, userName, userNameJ, password, passwordJ, personalAcctID);
			jAcc.setFirstName(firstName);
			jAcc.setLastName(lastName);
			jAcc.setUserName(userName);
			jAcc.setPassword(password);
			accounts.put(nAcctID, jAcc);
			accounts.get(personalAcctID).setJointAcctID(nAcctID);
			accounts.get(personalAcctID).setJointStatus("true");
			System.out.println("Thank you for applying for a joint account at Damon Bank, our managers will review your account and get back to you if you are approved");
			System.out.println("You will now be returned to the main menu");
			return jAcc;
		}
//		else
//		{
//			System.out.println("Account Type must be checking or savings");
//			return null;
//		}
	
	
	//get next account id method, return the size of the accounts Map plus 100 for personal and 200 for joint accounts
	public int getNextAccountID()
	{
		return (accounts.size() + 100);
	}
	
	public int getNextAccountJointID()
	{
		return (accounts.size() + 200);
	}
	
	public int getAcctSize()
	{
		return (accounts.size());
	}
	
	//show all accounts method, returns a List of all of the Accounts within the accounts Map
	public ArrayList<User> getAllAccounts()
	{
		ArrayList<User> acctList = new ArrayList<User>();
		
		Collection<User> acctMap = accounts.values();
		acctList.addAll(acctMap);
		return acctList;		
	}		
	
	public void showAllAccounts()
	{			 			
		if(accounts.isEmpty())
		{
			System.out.println("No accounts to view");
		}
		else
		{	
			for (Entry<Integer, User> pair : accounts.entrySet()) 
			{
			Object x = pair.getKey();		   
		    System.out.println(accounts.get(x));		     		
			}		
		}
		
		System.out.println("All accounts have been displayed, returning to main admin menu");			
	}
	
	 //admin withdrawqa method
	  public void withdrawAd(double amount, int accountID) 
		{
			System.out.println("Withdrawing for account number: " + accountID);


			if (accounts.get(accountID).getBalance() < amount)
			{
				
				System.out.println("Transfering amount cannot be over account balance. Current balance has not changed: " + accounts.get(accountID).getBalance());	
				
				
			}
			else if(amount < 0)
			{
				System.out.println("Withdrawal amount cannot be negative. Current balance has not changed: " + accounts.get(accountID).getBalance());
				
			}
			else
			{
				accounts.get(accountID).setBalance(accounts.get(accountID).getBalance() - amount);
				System.out.println("Withdrawal successful, your current balance is now: " + accounts.get(accountID).getBalance());
				log.info("Admin: Withdraw successful for: "+ accountID + " " + amount);
			}
		}
	  
	//depositqa method
	  public void depositAd(double amount, int accountID) 
		{
			
			System.out.println("Depositing for account number: " + accountID);


			if (amount > 0)
			{
				accounts.get(accountID).setBalance(accounts.get(accountID).getBalance() + amount);	
				System.out.println("Deposit successful, your current balance is now "
						+ accounts.get(accountID).getBalance());
				log.info("Admin: Deposit successful for: "+ accountID + " " + amount);
			}
			else
			{
				System.out.println("Deposit amount cannot be negative." + accounts.get(accountID).getBalance());
				
			}
		}
	  
	  //transferqa method
	  public void transferAd(double amount, int accountID, int accountID2) 
			{			
				System.out.println("Transfering money for account number: " + accountID);
				System.out.println("to account number: " + accountID2);

				if (accounts.get(accountID).getBalance() < amount)
				{					
					System.out.println("Transfering amount cannot be over account balance. Current balance has not changed: " + accounts.get(accountID).getBalance());									
				}
				else if(amount < 0)
				{
					System.out.println("Transfering amount cannot be negative. Current balance has not changed: " + accounts.get(accountID).getBalance());
					
				}
				else
				{
					accounts.get(accountID).setBalance(accounts.get(accountID).getBalance() - amount);
					accounts.get(accountID2).setBalance(accounts.get(accountID2).getBalance() + amount);
					System.out.println("Transfering successful, your current balance for account number " + accountID +  "is now: " + accounts.get(accountID).getBalance());
					System.out.println(" and current balance for account number " + accountID2 +  " is now: " + accounts.get(accountID2).getBalance());
					log.info("Admin: Transfer successful for: "+ accountID + " " + amount);
				}
			}
}
