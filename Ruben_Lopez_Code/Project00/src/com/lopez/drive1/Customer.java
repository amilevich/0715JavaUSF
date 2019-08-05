package com.lopez.drive1;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Map.Entry;

import com.staff.AP;
import com.staff.VAB;
import com.staff.VAI;
import com.staff.VPI;
import com.userinterface.UserInterface;

//Once the account is open, customers should be able to 
//1.withdraw,
//2.deposit, and 
//3.transfer funds between accounts
//All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.


public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7633632019175765L;
	public double balance = 0.0;
	public String fName = "";
	public String lName = "";
	public String address = "";
	public String city = "";
	public String userName = "";
	public String passWord = "";
	
	int pendingJointNumber = 0;
	int JointNumber = 0;

	//Last part
	public int getPendingJointNumber() {
		return pendingJointNumber;
	}

	public void setPendingJointNumber(int pendingJointNumber) {
		this.pendingJointNumber = pendingJointNumber;
	}

	public int getJointNumber() {
		return JointNumber;
	}

	public void setJointNumber(int jointNumber) {
		JointNumber = jointNumber;
	}

	public Customer( double balance, String fName, String lName, String address, String city, String userName, String passWord) {
		
		
		this.balance = balance;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.userName = userName;
		this.passWord = passWord;

		
		
	}
	
	public Customer() {
		//Oi 
	}
	//Getter and setter  User Name
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//Getter and setter Password
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	//Getter and setter of balance
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//Getter and Setter first Name
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	//Getter and Setter for last name
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
		
		

	//Getter and Setter for address
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Getter and Setter for City
	public String getCity() {
		return city;
	}
	 
	public void setCity(String city) {
		this.city = city;
	}

	public static int getObjectType() {
		return getObjectType();
	}

	
	
	public static void customerMenu(String tracker) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		int key = getKeyByUser(tracker);
		
		
		int pseudoJointNumber = ((Customer)FileIn.getLmao().get(key)).getJointNumber();
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		//1.withdraw,
		//2.deposit, and 
		//3.transfer funds between accounts
		//All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.

		while ( !("EXIT".equals(input))) {
			
			double pbalance = ((Customer) FileIn.getLmao().get(key)).getBalance();
			System.out.println(	"\n What would you like to do? ");
			System.out.println(	"\n Here is your Account number " +
								"\n");
			System.out.println("    " +getKeyByUser(tracker) + " " + tracker);
			System.out.println(	"\n balance		" + pbalance);

			//System.out.println(((Customer) FileIn.getLmao().get(UserInterface.getObjectTypeByUserName(tracker))).getBalance());
			System.out.println(	"\n What would you like to do?" +
								"\n Withdraw? 					DRAW" +
								"\n Deposit? 					DEPOS" +
								"\n Transfer Funds?				TRANS"  +
								"\n Make Joint accounts				MJA"  +
								"\n Access Joint account			AJA" +
								"\n Exit?						EXIT");
		
			input = sc.next();
			//1.withdraw,
			if ("DRAW".equals(input)) {
				
				//Withdrawing
				Withdraw.withdraw(tracker, key);
				
			//1.Account information	
			} else if ("DEPOS".equals(input)) {
				
				Deposit.deposit(tracker,key);
			
			//3.Personal information
			} else if ("TRANS".equals(input)) {
				
				TransferFunds.transferFunds(tracker,key);
				
			} else if ("MJA".equals(input)) {
				
				JointAccounts.jointAccount(key);
				
			} else if ("EXIT".equals(input)){
				
				input = "EXIT";
			} else if (("AJA".equals(input))&&(pseudoJointNumber > 0)){
				
				String Tracker2 =((Customer)FileIn.getLmao().get(pseudoJointNumber)).getUserName();
				
				AccessJointAccountPoint.access(Tracker2, pseudoJointNumber);
				
			} else {
				System.out.println("Try again!");
			}
			
			/////////////////////////////////////////////////////////////////////////////////////
		}
	}
		
		
	public static int getKeyByUser(String tracker) {
		
		for (Entry<Integer, Object> entry : FileIn.getLmao().entrySet()) {
  			
  			//Checks if input is equal to the user name inside an object, through a for each loop of entry key, inside a map 'LMAO', through File class
  		    if (tracker.equals((((Customer) FileIn.getLmao().get(entry.getKey())).getUserName() )) ) {
  				int j = entry.getKey();
  				return j;
  			}
  		}
		System.out.println("Error");
		return -1;
		
	}

	
	
}
