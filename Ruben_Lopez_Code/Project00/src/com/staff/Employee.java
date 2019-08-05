package com.staff;

import java.io.IOException;
import java.util.Scanner;

import com.lopez.drive1.Customer;
import com.lopez.drive1.FileIn;

public class Employee extends Customer {

	
//	Employees of the bank should be able to view all of their customers information
//	This includes, 
//	1.Account information
//	2.Account balances
//	3.Personal information
//	Employees should be able to approve/deny open applications for accounts

	/**
	 * 
	 */
	private static final long serialVersionUID = -3965459793588118247L;
	
	

	


public Employee(double balance, String fName , String lName, String address, String city , String userName, String passWord) {
		
		// TODO Auto-generated constructor stub
		
		super(balance, fName, lName, address, city, userName, passWord);
		// TODO Auto-generated constructor stub
	}

	
	public static void empolyeeMenu() throws IOException {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = " ";
		
		//FileIn.mainFileIn();
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		while ( !("EXIT".equals(input))) {
		
			System.out.println(	"\n What would you like to do? ");
			System.out.println(	"\n Here are all of the account numbers " +
								"\n");
			System.out.println(FileIn.getLmao().keySet());
			System.out.println(	"\n What would you like to do?" +
								"\n View account balance? 		VAB" +
								"\n View account information? 	VAI" +
								"\n View personnal information?	VPI"  +
								"\n Approve application		AP"  +
								"\n Approve joint accounts		AJA" +
								"\n Exit?				EXIT");
		
			input = sc.next();
			//2.Account balances
			if ("VAB".equals(input)) {
				
				//View account balance
				VAB.vAB();
			//1.Account information	
			} else if ("VAI".equals(input)) {
				
				VAI.vAI();
			
			//3.Personal information
			} else if ("VPI".equals(input)) {
				
				VPI.vPI();
				
			} else if ("AP".equals(input)) {
				
				AP.addApplication();
				
			} else if ("EXIT".equals(input)){
				
				input = "EXIT";
			} else if("AJA".equals(input)) {
				
				AJA.approve();
				
			} else {
				System.out.println("Try again!");
			}
			
			/////////////////////////////////////////////////////////////////////////////////////
		}
		
	}

	
}
