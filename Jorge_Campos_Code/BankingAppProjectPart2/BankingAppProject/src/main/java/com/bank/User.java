package com.bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

import com.dao.UserDaoImpl;

public class User extends Bank implements Serializable{
	/**
	 * @author JCampos Storing users in HashMap
	 */
	private static final long serialVersionUID = -7762248277788976385L;
	
	int acctNum;
	String userName;
	String password;
	double balance;
	boolean approved;
	boolean joint;
	boolean employee;
	boolean admin;
	String jointId;
	
	//static HashMap<String, User> users = new HashMap<String,User>();
	private static final String fileName = ".\\src\\main\\java\\com\\bank\\memory.txt";
	
	public User() {
		userName = "Default";
		password = "password";
		approved = false;
		joint = false;
		employee = false;
		admin = false;
		acctNum = 0;
		jointId = null;
	}

	public User(String s) {
		userName = s;
		password = "password";
		approved = false;
		joint = false;
		employee = false;
		admin = false;
		acctNum = 0;
		jointId = null;
		//System.out.println("Welcome " + s + ", In constructor");
	}
	
	public User(String s, String p) {
		userName = s;
		password = p;
		approved = false;
		joint = false;
		employee = false;
		admin = false;
		acctNum = 0;
		jointId = null;
		//System.out.println("Welcome " + s + ", In constructor: set password");
	}
	
	public User(String s, String p, double b, int a, int j, int e, int ad, int aNum, String jId) {
		userName = s;
		password = p;
		balance = b;
		if(a==0)
			approved = false;
		else
			approved = true;
		if(j==0)
			joint = false;
		else
			joint = true;
		if(e==0)
			employee = false;
		else
			employee = true;
		if(ad==0)
			admin = false;
		else
			admin = true;
		acctNum = aNum;
		jointId = jId;
		//System.out.println("Welcome " + s + ", In constructor: load acct");
	}
	
	
			
	public int getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int isApproved() {
		if(approved)
			return 1;
		else
			return 0;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int isJoint() {
		if(joint)
			return 1;
		else
			return 0;
	}

	public void setJoint(boolean joint) {
		this.joint = joint;
	}

	public int isEmployee() {
		if(employee)
			return 1;
		else
			return 0;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	public int isAdmin() {
		if(admin)
			return 1;
		else
			return 0;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getJointId() {
		return jointId;
	}

	public void setJointId(String jointId) {
		this.jointId = jointId;
	}

	public double getBalance(String username) {
		return users.get(username).balance;
	}

	public void setBalance(String username, double balance) {
		users.get(username).balance = balance;
	}

	public void menu() throws Exception {
		String username, acctNum2;
		int select;
		double amount;
		Scanner input = new Scanner(System.in);
		System.out.println(
				"Hello, Welcome to the Bank \n   Please enter your username or enter 'New' to create new account: ");
		username = input.nextLine();
		if (username.compareToIgnoreCase("new") == 0) {				//create new user
			System.out.println("Do you wish to apply for a joint account? \n\t Y/N");
			String temp = input.nextLine();
			if(temp.compareToIgnoreCase("y") == 0) {				//perform joint acct here
				System.out.println("Please enter new username: ");
				username = input.nextLine();			 
				if(findAccount(username))
					System.out.println("Please enter another username.");
				System.out.println("Please set password: ");
				password = input.nextLine();		
				applyNewAcct(username,password);
				System.out.println("Please enter new username of joint account: ");
				String username2 = input.nextLine();	
				System.out.println("Please set password: ");
				password = input.nextLine();	
				applyNewAcct(username2,password);
				users.get(username).setJoint(true);
				users.get(username).setJointId(username2);
				users.get(username2).setJoint(true);
				users.get(username2).setJointId(username);		
				save(username2);
			}
			else {
				System.out.println("Please enter new username: ");
				username = input.nextLine();			 
				System.out.println("Please set password: ");
				password = input.nextLine();		
				applyNewAcct(username,password);
			}				
			System.out.println("Thank you for applying for a new account, an employee will review your application "	//standby message
					+ "and we will get back to you as soon as possible.\n  Please check back at a later time.\n\n");
			
		} else {				
			System.out.println("Please enter password: ");		
			password = input.nextLine();			
			load();											//load users into hashmap
			
			if(login(username,password) && users.get(username).approved) {		// login acct info 
				if(!users.get(username).employee) {		// customer menu
					do {
						System.out.println("Welcome " + username +": \t\tYour Current balance is: "+ getBalance(username));
						System.out.println("Please select transaction: \n1) Deposit \n"
								+ "2) Withdraw\n"
								+ "3) Transfer Money\n"
								+ "4) Exit/Logout");
						select = input.nextInt();	
						switch(select) {
						case(1):
							System.out.print("Please enter amount to deposit: ");
							amount = input.nextDouble();
							deposit(username,amount);
							break;
						case(2):
							System.out.print("Please enter amount to withdraw: ");
							amount = input.nextDouble();
							withdraw(username,amount);
							break;
						case(3):
							System.out.print("Please enter amount to transfer: ");
							amount = input.nextDouble();
							input.nextLine();
							System.out.print("Please enter account username to transfer to: ");
							acctNum2 = input.nextLine();
							if(findAccount(acctNum2))
								transfer(username,amount,acctNum2);
							else
								System.out.println("Error, please try again.");
							break;
						case(4):
							System.out.print("Logging Out ");
							break;
						default:
							System.out.println("Sorry that is not an option, please try again.");
							break;
						}							
					}while(select != 4);
				}
				
				else {				//employee menu
					if(!users.get(username).admin) {
						do {
							System.out.println("\nWelcome Employee " + username +": \t\tYour Current balance is: "+ balance);
							System.out.println("Please select action: \n1) View Account \n"
									+ "2) Approve Acount\n"
									+ "3) Exit/Logout");
							select = input.nextInt();	
							input.nextLine();
							switch(select) {
							case(1):
								System.out.print("Please enter account username: ");
								acctNum2 = input.nextLine();
								if(findAccount(username))
									System.out.println(users.get(acctNum2));
								else
									System.out.println("Account Not Found, Please Try Again.\n");
								break;
							case(2):
								System.out.print("Enter Account Username to Approve: ");
								acctNum2 = input.nextLine();
								if(findAccount(acctNum2))
									((Employee)(users.get(username))).approveAcct(acctNum2);
								else
									System.out.println("Account Not Found, Please Try Again.\n");
								break;
							case(3):
								System.out.print("Logging Out ");	
								break;							
							default:
								System.out.println("Sorry that is not an option, please try again.\n");
								break;
							}							
						}while(select != 3);
					}else
						adminMenu(username);
				}
				
			}else if(!findAccount(username))
				System.out.println("Sorry, Please create an account before using our services.\n\n\n\n\n\n\n\n\n\n");//possibly remove/edit for security
			else if((!login(username,password) )&& users.get(username).approved)
				System.out.println("Sorry your password didn't match, please try again.\n\n\n\n");			
			else
				System.out.println("Thank you for applying for a new account, your application is still being reviewed "	//standby message
						+ "\n  Please check back at a later time.\n\n");
		}
		Thread.sleep(2000);
		if(findAccount(username) && users.get(username).isAdmin()==0)
			logout(username);
		System.out.println();
		//input.close();
	}
	
	private void adminMenu(String username) {
		String acctNum2;
		String temp;
		int select = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("Welcome Admin " + username +": \t\tYour Current balance is: "+ balance);
			System.out.println("Please select transaction: \n1) View Account \n"
					+ "2) Approve Acount\n"
					+ "3) Edit Account Info\n"
					+ "4) Add Employee Account\n"
					+ "5) View All Users\n"
					+ "6) Exit/Logout");
			
			
			select = input.nextInt();
			input.nextLine();
			
			switch(select) {
			case(1):
				System.out.print("Please enter account username to view: ");
				acctNum2 = input.nextLine();
				if(findAccount(acctNum2))
					System.out.println(users.get(acctNum2));
				else
					System.out.println("Error, please try again.");
				break;
			case(2):
				System.out.print("Enter Account Username to Approve: ");
				acctNum2 = input.nextLine();
				if(findAccount(acctNum2))
					((Employee)(users.get(username))).approveAcct(acctNum2);
				else
					System.out.println("Error, please try again.");
				break;
			case(3):
				System.out.print("Enter Account Username to Edit: ");
				acctNum2 = input.nextLine();
				if(findAccount(acctNum2))
					((Admin)(users.get(username))).editAcct(acctNum2);
				else
					System.out.println("Error, please try again.");
				break;
			case(4):
				System.out.print("Enter New Employee Username: ");
				acctNum2 = input.nextLine();
				((Admin)(users.get(username))).addEmployee(acctNum2);
				
				break;
			case(5):
				System.out.println("All Current Users: "+ users.keySet());
				break;
			case(6):
				System.out.print("Logging Out \n\n\n\n\n\n\n\n\n\n\n\n\n");
				break;
			default:
				System.out.println("Sorry that is not an option, please try again.");
				break;
			}
		
			
		}while(select != 6);		
		//input.close();		
	}
	
	protected static void applyNewAcct(String username, String pass) {
		//wait for admin/employee to approve 		
		User b = new User(username,pass);			
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(b);
		b = userDaoImpl.selectUserByUserName(username);
		users.put(username,b);
			
	}
	
	protected static void save(String username) {
		//try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			userDaoImpl.updateUser(users.get(username));			
		/*}catch(IOException exc) {
			exc.printStackTrace();
		}*/
	}
	
	public static void load() {
		//try(){
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			users = userDaoImpl.selectAllUsers();	
		/*}catch(IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public boolean login(String userName, String password)  {		//login/load customer info
		
        //findAccount(userName);
        if( users.containsKey(userName) && users.get(userName).password.equals(password))        
        	return true;
        else
        	return false;
	}
	
	void logout(String username) {					
		//save hashmap into database
		save(username);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		balance = 0;
		userName = "";
		password = "password";
	}
	
	public boolean findAccount(String acctNum) {
		if(users.containsKey(acctNum))
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
			if(users.get(username).isJoint()==1) {
				String temp = users.get(username).getJointId();
				users.get(temp).setBalance(temp,balance);
				save(temp);
			}
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
			if(users.get(username).isJoint()==1) {
				String temp = users.get(username).getJointId();
				users.get(temp).setBalance(temp,balance);
				save(temp);
			}
			tracker.info(username + " deposited " + amount);
			System.out.println("New Balance is: " + balance + "\n");
		}
	}
	
	protected void deposit(String username, double amount, String acctTwo) {
		double balance = users.get(acctTwo).getBalance(acctTwo);
		if(amount < 0) {
			System.out.println("Error, Please enter a positve amount to deposit");
			tracker.warn("Error, Not an acceptable amount(negative)");
		}
		else {
			balance += amount;
			users.get(acctTwo).setBalance(acctTwo,balance);
			if(users.get(acctTwo).isJoint()==1) {
				String temp = users.get(acctTwo).getJointId();
				users.get(temp).setBalance(temp,balance);
				save(temp);
			}
			tracker.info(username + " deposited " + amount + " to "+ acctTwo);
			System.out.println("Transfered " + amount + " to " + acctTwo + "\n");
		}
	}
	
	protected void transfer(String username,double amount, String acct) {
		
		if(amount < 0)
			System.out.println("Error, Please enter a positve amount to transfer");
		//use findAccount to connect to other acct(create new user with loaded data)
		else {
			if(users.get(username).getBalance(username) >= amount) {
				withdraw(username,amount);
				deposit(username,amount,acct);
				save(acct);
			}
			else {
				System.out.println("Error, not enough funds");
				tracker.warn("Error, not enough funds");
			}
		}
	}

	@Override
	public String toString() {
		return "User [acctNum=" + acctNum + ", userName=" + userName + ", balance=" + balance + ", approved=" 
				+ approved + ", joint=" + joint + ", employee=" + employee + ", admin=" + admin + "]\n";
	}

	
	
	
}
