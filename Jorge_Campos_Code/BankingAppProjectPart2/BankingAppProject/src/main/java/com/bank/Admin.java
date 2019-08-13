package com.bank;

import java.util.Scanner;

import com.dao.UserDaoImpl;

public class Admin extends Employee{
	
	/**
	 * @author JCampos Admin ID to store to hashmap
	 */
	private static final long serialVersionUID = 6123793905217370736L;

	public Admin() {
		userName = "username";
		password = "password";
		approved = true;
		joint = false;
		employee = true;
		admin = true;
		acctNum = 0;
		jointId = null;
		users.put("username", this);
	}
	
	public Admin(String name, String pass) {
		userName = name;
		password = pass;
		approved = true;
		joint = false;
		employee = true;
		admin = true;
		acctNum = 0;
		jointId = null;
		users.put(name, this);
	}
	
	public Admin(String s, String p, double b, int a, int j, int e, int ad, int aNum, String jId) {
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
	
	protected void addEmployee(String username) {
		Employee e = new Employee(username,"password");
		users.put(username, e);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.insertUser(e);
	}
	
	protected void editAcct(String username) {
		int select;
		Scanner input = new Scanner(System.in);
		
		do {
			if(findAccount(username))
				System.out.println(users.get(username));
			System.out.println("Please select field you would like to edit: \n"
					+ "1) Account Number\n"
					+ "2) Username\n"
					+ "3) Password\n"
					+ "4) Balance\n"
					+ "5) Approval\n"
					+ "6) Employee Access\n"
					+ "7) Grant Administrative Access\n"
					+ "8) Cancel Account\n"
					+ "9) Save/Exit Edit");
			select = input.nextInt();	
			input.nextLine();
			switch(select) {
			case(1):
				System.out.print("Please enter account number: ");
				int temp = input.nextInt();	
				input.nextLine();
				tracker.info(this.userName + " edited account number from "+ users.get(username).acctNum +" to "+temp);
				users.get(username).acctNum = temp;				
				break;
			case(2):
				System.out.print("Enter New Account Username(not available): ");
				String temp2 = input.nextLine();
				/*tracker.info(this.userName + " edited account name from "+ users.get(username).userName +" to "+temp2);
				users.get(username).userName = temp2;
				users.put(temp2, users.get(username));
				users.remove(username);*/
				break;
			case(3):
				System.out.print("Enter New Account Password: ");
				String temp3 = input.nextLine();		
				tracker.info(this.userName + " edited "+ username+"'s account password from "+ users.get(username).password +" to "+temp3);
				users.get(username).password = temp3;
				break;
			case(4):
				System.out.print("Enter Corrected Account Balance: ");
				double temp4 = input.nextDouble();	
				tracker.info(this.userName + " corrected "+ username+"'s balance from "+ users.get(username).balance +" to "+temp4);
				input.nextLine();
				users.get(username).setBalance(username,temp4);
				break;
			case(5):
				System.out.print("Approved Account: \n   Y/N?\n");
				String temp5 = input.nextLine();
				if(temp5.compareToIgnoreCase("y") == 0) {
					System.out.println("Account Approved\n");
					tracker.info(this.userName + " edited "+ username+"'s approval setting from "+ users.get(username).approved +" to true");
					users.get(username).approved = true;
				}
				else if(temp5.compareToIgnoreCase("n") == 0) {
					System.out.println("Account Approval Removed\n");
					tracker.info(this.userName + " edited "+ username+"'s approval setting from "+ users.get(username).approved +" to false");
					users.get(username).approved = false;
				}				
				else
					System.out.println("Error, Nothing Changed, Pleas Try Again.\n");
				break;
			case(6):
				System.out.print("Grant Employee Access: \n Y/N? \n");
				String temp6 = input.nextLine();		
				if(temp6.compareToIgnoreCase("y") == 0) {
					System.out.println("Employee Access Granted\n");
					tracker.info(this.userName + " edited employee access from "+ users.get(username).employee +" to true");
					users.get(username).employee = true;
				}
				else if(temp6.compareToIgnoreCase("n") == 0) {
					System.out.println("Employee Access Revoked\n");
					tracker.info(this.userName + " edited employee access from "+ users.get(username).employee +" to false");
					users.get(username).employee = false;
				}
				else
					System.out.println("Error, Nothing Changed, Pleas Try Again.\n");
				break;
			case(7):
				System.out.print("Grant Administrative Access: \n Y/N?\n");
				String temp7 = input.nextLine();
				if(temp7.compareToIgnoreCase("y") == 0) {
					System.out.println("Access Granted\n");
					users.get(username).admin = true;
					tracker.info(this.userName + " approved administrative privilages for "+ username);
				}
				else if(temp7.compareToIgnoreCase("n") == 0)
					System.out.println("Access Not Granted\n");
				else
					System.out.println("Error, Nothing Changed, Pleas Try Again.\n");
				break;
			case(8):
				System.out.print("Cancel Account " + username +": \n Y/N? \n");
				String temp8 = input.nextLine();
				if(temp8.compareToIgnoreCase("y") == 0) {
					System.out.println("Account Canceled\n");
					if(users.get(username).joint)
						users.get(username).joint = false;
					tracker.info(this.userName + " canceled "+ username +"'s account");
					users.get(username).approved = false;
				}else if(temp8.compareToIgnoreCase("n") == 0)
					System.out.println("Aborted, Account Not Canceled");
				else
					System.out.println("Error, Nothing Changed, Pleas Try Again.\n");
				break;
			case(9):
				System.out.println("Exiting Edit Mode\n");
				break;
			default:
				System.out.println("Sorry that is not an option, please try again.\n");
				break;
			}							
		}while(select != 9);
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.updateUser(users.get(username));
		
	}

}
