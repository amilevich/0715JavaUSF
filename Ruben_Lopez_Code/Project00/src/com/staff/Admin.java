package com.staff;

import java.io.IOException;
import java.util.Scanner;

import com.lopez.drive1.Customer;
import com.lopez.drive1.Deposit;
import com.lopez.drive1.FileIn;
import com.lopez.drive1.Withdraw;

public class Admin extends Employee{

	/**Bank admins should be able to view and 
	1.edit all accounts
	This includes:
	2.Approving/denying accounts
	3.Withdrawing, depositing, transferring from all accounts
	Canceling accounts

	 * 
	 */
	private static final long serialVersionUID = 2188599825555669908L;

	public Admin(double balance, String fName, String lName, String address, String city, String userName,
			String passWord) {
		super(balance, fName, lName, address, city, userName, passWord);
		// TODO Auto-generated constructor stub
	}
	
	public static void admin() throws IOException {
		Scanner sc = new Scanner(System.in);
		FileIn.mainFileIn();
		String input = " ";
		int inputInt = 0;
		//nothing is in string but we need it to access a function
		String  blah = " ";
		while ( !("EXIT".equals(input))) {
			System.out.println(	"\n Welcome admin" +
								"\n What would you like to do?" +
								"\n Edit an account			EDIT"+
								"\n Approve an account			AP"+
								"\n Withdraw				DRAW"+
								"\n Depositing				DEPOS"+
								"\n Exit					EXIT"+
								"\n Delete account				DEL");
			

			input = sc.next();
			
				
			 if ("AP".equals(input)) {
				
				AP.addApplication();
			} else if ("DRAW".equals(input)) {
				
				System.out.println(	"\n What account would you like to Draw from?" +
									"\n Here are all of the accounts");
				System.out.println(FileIn.getLmao().keySet());
				inputInt = sc.nextInt();
				
				//nothing is in string but we need it to access a function
				Withdraw.withdraw(blah, inputInt);
				
			} else if ("DEPOS".equals(input)) {
				System.out.println(	"\n What account would you like to Draw from?" +
									"\n Here are all of the accounts");
				System.out.println(FileIn.getLmao().keySet());
				inputInt = sc.nextInt();
	
				
				Deposit.deposit(blah, inputInt);
				
			} else if ("EXIT".equals(input)) {
				
			} else if ("EDIT".equals(input)){
				System.out.println(	"\n What account would you like to edit from?" +
									"\n Here are all of the accounts");
				System.out.println(FileIn.getLmao().keySet());
				inputInt = sc.nextInt();
				EditAccount.editaccount(inputInt);
			} else if ("DEL".equals(input)){
				System.out.println(	"\n What account would you like to delete from?" +
						"\n Here are all of the accounts");
						System.out.println(FileIn.getLmao().keySet());
						inputInt = sc.nextInt();
				DeleteAccount.deleteAccount(inputInt);
			} else {
				System.out.println("Try again");
			}
		}
	}
}
