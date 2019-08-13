/* Note to self: AccountNumber2 methods work. Everything else, not so much.
*  For part 2, cleanse code/restart if needed, account 2 methods are superior and actually function.
*/ 
package bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class User extends Bank implements Serializable
{
	private static final long serialVersionUID = -7762248277788976385L;
	String accountNumber;
	String userName;
	String password;
	double balance;
	boolean approved;
	boolean joint;
	boolean employee;
	boolean admin;
	private static final String fileName = "C:\\Users\\minqi\\Desktop\\Revvie\\Spring\\ProjectZero\\src\\main\\resources\\Bank.txt";
	public User() 
	{
		userName = "Default";
		password = "password";
		approved = true;
		joint = false;
		employee = true;
		admin = false;
	}
	public User(String s) 
	{
		userName = s;
		password = "password";
		approved = false;
		joint = false;
		employee = true;
		admin = false;
		System.out.println("Welcome " + s + " to the Iron Bank.");
	}
	public User(String s, String p) {
		userName = s;
		password = p;
		approved = false;
		joint = false;
		employee = false;
		admin = false;
		
//		System.out.println("Welcome " + s + " to the Iron Bank.");
	}
	public double getBalance(String username) 
	{
		return users.get(username).balance;
	}
	public void setBalance(String username, double balance) 
	{
		users.get(username).balance = balance;
	}
	public void menu() throws Exception {
		String username, acctNum2;
		int select;
		double amount;
		Scanner s = new Scanner(System.in);
		System.out.println("Thank you for choosing this bank branch.");
		System.out.println("");
		System.out.println("Enter your username to begin the login process, or type in 'create account' to initiate account creation.");
		username = s.nextLine();
		if ((username.compareToIgnoreCase("new") == 0)||(username.compareToIgnoreCase("create account")==0))
		{				
			System.out.println("Will this be a joint account?");
			System.out.println("Type y for yes or n for no.");
			String temp = s.nextLine();
			if(temp.compareToIgnoreCase("y") == 0) 
			{				
				System.out.println("Please enter new username: ");
				username = s.nextLine();			 
				System.out.println("Please set your password: ");
				password = s.nextLine();		
				applyNewAcct(username,password);
				System.out.println("Please enter the username for this joint account.");
				String username2 = s.nextLine();	
				users.put(username2, users.get(username));
				users.get(username2).joint = true;
			}
			else {
				System.out.println("Please enter your new username. ");
				username = s.nextLine();			 
				System.out.println("Please set you password. ");
				password = s.nextLine();		
				applyNewAcct(username,password);
			}				
			System.out.println("Thank you for choosing the Iron Bank. We will review your application, please check back at a later date for future updates.");
			
		} else {				
			System.out.println("Please enter your password.");		
			password = s.nextLine();			
			load();	
			if(login(username,password) && users.get(username).approved) 
			{		
				if(!users.get(username).employee) 
				{	
					do {
						System.out.println("Welcome " + username +"."); 
						System.out.println("Your account's current balance "+ getBalance(username));
						System.out.println("Please select your intended transaction: ");
						System.out.println("1) Deposit");
						System.out.println("2) Withdraw");
						System.out.println("3) Transfer Money");
						System.out.println("4) Log Out");
						select = s.nextInt();	
						switch(select) {
						case(1):
							System.out.println("Please enter your deposit amount. ");
							amount = s.nextDouble();
							deposit(username,amount);
							break;
						case(2):
							System.out.println("Please enter your withdrawl amount. ");
							amount = s.nextDouble();
							withdraw(username,amount);
							break;
						case(3):
							System.out.println("Please enter an amount to transfer.");
							amount = s.nextDouble();
							s.nextLine();
							System.out.println("Please enter the account number to transfer to: ");
							acctNum2 = s.nextLine();
							transfer(username,amount,acctNum2);
							break;
						case(4):
							System.out.println("Thank you for your business.");
//							break;
						menu();
						default:
							System.out.println("Invalid input. Please try again.");
							break;
						}							
					}while(select != 4);
					menu();
				}
				
				else {				//employee menu
					if(!users.get(username).admin) 
					{
						do 
						{
							System.out.println("Welcome employee " + username +". ");
//							System.out.println("You have $" + balance + " in your account.");
							System.out.println("Please select your intended action: \n 1) View Account");
							System.out.println("2) Approve account");
							System.out.println("3) Log out");
							select = s.nextInt();	
							s.nextLine();
							switch(select) 
							{
							case(1):
								System.out.print("Please enter account username: ");
								acctNum2 = s.nextLine();
								System.out.println(users.get(acctNum2));
								break;
							case(2):
								System.out.print("Enter Account Username to Approve: ");
								acctNum2 = s.nextLine();
								((Employee)(users.get(username))).approveAcct(acctNum2);
								break;
							case(3):
								System.out.print("Thank you for your business.");	
								break;							
							default:
								System.out.println("Invalid input. Please try again.");
								break;
							}							
						}
						while(select != 3);
					}
					else
					{
						adminMenu(username);
					}
				}
				
			}else if(!findAccount(username))
				System.out.println("Your password and username combination did not match. Please try again.");
			else if((!login(username,password) )&& users.get(username).approved)
				System.out.println("Your password and username combination did not match. Please try again.");			
			else
				System.out.println("Thank you for your interest. Your application is still under review; please return at a later time.");
		}
		logout();
		System.out.println();
		//s.close();
	}

	private void adminMenu(String username) throws Exception 
	{
		String accountNumber2;
		int select;
		Scanner s = new Scanner(System.in);
		
		do 
		{
			System.out.println("Welcome administrator " + username + ". ");
			System.out.println("Select an action to perform from the menu below.");
			System.out.println("");
			System.out.println("1) View account");
			System.out.println("2) Approve an account");
			System.out.println("3) Promote an account");
			System.out.println("4) Edit account");
			System.out.println("5) View all users");
			System.out.println("6) Log out");
			select = s.nextInt();
			s.nextLine();
			switch(select) 
			{
			case(1):
				System.out.print("Please enter account username to view: ");
				accountNumber2 = s.nextLine();
				System.out.println(users.get(accountNumber2));
				break;
			case(2):
				System.out.print("Enter the username of the account to approve.");
				System.out.println("");
				accountNumber2 = s.nextLine();
				((Employee)(users.get(username))).approveAcct(accountNumber2);
				System.out.println("Account approved.");
				break;
			case(3):
				System.out.print("Enter the username of the account to promote.");
				System.out.println("");
				accountNumber2 = s.nextLine();
				((Employee)(users.get(username))).employ(accountNumber2);
				System.out.println(accountNumber2 + " is now an employee.");
				break;
			case(4):
				System.out.print("Enter the username of the account you wish to edit.");
				System.out.println("");
				s.next();
				accountNumber2 = s.nextLine();
				((Admin)(users.get(username))).editAcct(accountNumber2);
				break;
			case(5):
				System.out.println("Current list of users: "+ users.keySet());
				System.out.println("");
				break;
			case(6):
				System.out.print("Thank you for your business.");
				logout();
				menu();
			default:
				System.out.println("Invalid input. Please try again.");
				break;
			}		
		}
		while(select != 6);		
	}
	protected static void applyNewAcct(String username, String pass) 
	{ 		
		User b = new User(username,pass);	
		users.put(username,b);		
	}
	
	protected static void save() 
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			oos.writeObject(users);
		}catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public static void load() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){			
			users = (HashMap<String, User>)ois.readObject();	
		}catch(IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(String userName, String password)  
	{		
        if( users.containsKey(userName) && users.get(userName).password.equals(password))        
        	return true;
        else
        	return false;
	}
	
	void logout() 
	{					
		save();
		System.out.println("\n\n");
		balance = 0;
		userName = "";
		password = "password";
	}
	public boolean findAccount(String accountNumber) {
		if(users.containsKey(accountNumber))
			return true;
		else
			return false;
	}
	
	protected void withdraw(String username, double amount) {
		balance = users.get(username).getBalance(username);
		if (amount > balance) {
			System.out.println("Error, not enough funds");
			tracker.warn("Error, not enough funds");
		}
		else {
			balance -= amount;
			users.get(username).setBalance(username,balance);
			tracker.info(username + " withdrew " + amount);
			System.out.println("Remaining Balance is: " + balance + "\n");
		}
	}

	protected void deposit(String username, double amount) {
		balance = users.get(username).getBalance(username);
		if(amount < 0) {
			System.out.println("Error, Please enter a positve amount to deposit");
			tracker.warn("Error, Not an accepted amount(negative)");
		}
		else {
			balance += amount;
			users.get(username).setBalance(username,balance);
			tracker.info(username + " deposited " + amount);
			System.out.println("New Balance is: " + balance + "\n");
		}
	}
	
	protected void deposit(String username, double amount, String acctTwo) {
		double balance = users.get(acctTwo).getBalance(acctTwo);
		if(amount < 0) {
			System.out.println("Please enter a positive amount of currency to deposit.");
			tracker.warn("Error, Not an acceptable amount(negative)");
		}
		else {
			balance += amount;
			users.get(acctTwo).setBalance(acctTwo,balance);
			tracker.info(username + " deposited " + amount + " to "+ acctTwo);
			System.out.println("Transfered " + amount + " to " + acctTwo + "\n");
		}
	}
	
	protected void transfer(String username,double amount, String acct) {
		
		if(amount < 0)
			System.out.println("Please enter a positive amount of currency to transfer.");
		else {
			if(users.get(username).getBalance(username) >= amount) {
				withdraw(username,amount);
				deposit(username,amount,acct);
			}
			else {
				System.out.println("Apologies, you possess insufficient funds.");
				tracker.warn("Apologies, you possess insufficient funds.");
			}
		}
	}
	public void approve(User u)
	{
		this.approved = true;
	}

	@Override
	public String toString() 
	{
		return "These are the details of username " + userName + ", who has an account number " + accountNumber + ". \n" + userName + "'s password is " + password + " and the account has a current balance of $" + balance
				+ "." + "\n Approval status is " + approved + ", joint account is " + joint + ", employee status is " + employee + ", admin status is " + admin + ". \n\n";
	}
}
