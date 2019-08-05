package com.project.actions;

import com.project.pjzero.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class EmployeeActions {
	
	HashMap<Integer, ArrayList<String>> storedBox = new HashMap<Integer, ArrayList<String>>(); 
	
	final static Logger logTracker = Logger.getLogger(EmployeeActions.class);
	
	Menu menu = new Menu();
	
	private int keySign;
	public int keyZ;
	private double balance;
	private double deposit;
	private double withdraw;
	
	public void adminLogin() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {		
		String username = "admin";
		String password = "admin123";
		
		Scanner scan = new Scanner (System.in);
		System.out.print("Please enter your \"User name\": ");
		String inputUser = scan.nextLine();
		System.out.print("Please enter your \"Password\": ");
	    String inputPass = scan.nextLine();
	    	    
	    if (inputUser.equals(username) && inputPass.equals(password)) {	    	
	    	System.out.print("Your in a system");
	    	System.out.println("\n");
	    	menu.adminMenu();
	    } else {
	    	System.out.print("Your \"UserName\" or \"Password\" don't match. Please try again.");
	    	System.out.println("\n");
	    	menu.loginMenu();
	    }
	    scan.close();
	}
	
	public void employeeLogin() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String username = "employ";
		String password = "employ123";
		
		Scanner scan = new Scanner (System.in);		
		System.out.print("Please enter your \"User name\": ");		
		String inputUser = scan.nextLine();
		System.out.print("Please enter your \"Password\": ");
	    String inputPass = scan.nextLine();
	    
	    
	    if (inputUser.equals(username) && inputPass.equals(password)) {	    	
	    	System.out.print("Your in a system");
	    	System.out.println("\n");
	    	menu.employeeMenu();
	    } else {
	    	System.out.print("Your \"UserName\" or \"Password\" don't match. Please try again.");
	    	System.out.println("\n");
	    	menu.loginMenu();
	    }
	    scan.close();
	}
	
	public void customerViewAdmin() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		NewCustomerWR newCustomwerWR = new NewCustomerWR();
		newCustomwerWR.readNewCustomer();
		System.out.println();
		Scanner scan = new Scanner (System.in);
		System.out.println("Please press \"1\" for returning to menu or \"0\" to return to main menu");
		int num = scan.nextInt();
		Menu menu = new Menu();
		if(num == 1) {
			menu.adminMenu();			
		} else {
			menu.mainMenu();			
		}
		scan.close();
	}
	
	public void customerView() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		NewCustomerWR newCustomwerWR = new NewCustomerWR();
		newCustomwerWR.readNewCustomer();
		System.out.println();
		Scanner scan = new Scanner (System.in);
		System.out.println("Please press \"1\" for returning to menu or \"0\" to return to main menu");
		int num = scan.nextInt();
		Menu menu = new Menu();
		if(num == 1) {
			menu.employeeMenu();			
		} else {
			menu.mainMenu();			
		}
		scan.close();
	}
	
	public void customerApprovementAdmin() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {		
		Scanner scan = new Scanner (System.in);
		System.out.println("For customer approvment. Please type \"1\" for approvment or \"0\" for rejection");		
		keySign = scan.nextInt();		
		if(keySign == 1) {
			System.out.println("Customer was approved");			
			Menu menu = new Menu();
			menu.adminMenu();			
		} else if(keySign == 0){
			System.out.println("Request was declined");			
			Menu menu = new Menu();
			menu.adminMenu();			
		}
		scan.close();			
	}
	
	public void customerApprovement() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {		
		Scanner scan = new Scanner (System.in);
		System.out.println("For customer approvment. Please input \"1\" for approvment or \"0\" for rejection");	
		keySign = scan.nextInt();		 
		if(keySign == 1) {			
			System.out.println("Customer was approved");
			logTracker.info("account was approved");
			keyZ = keySign;						
			Menu menu = new Menu();
			menu.employeeMenu();			
		} else {			
			System.out.println("Request was declined");
			logTracker.info("account was declined");
			Menu menu = new Menu();
			menu.employeeMenu();			
		}		
		scan.close();			
	}
	
	public void userLogin(int keyZ) throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Menu menu = new Menu();
		Scanner scan = new Scanner (System.in);
						
		if(keyZ == 1) {
			String username = "user";
			String password = "user123";
			
			System.out.print("Please enter your \"User name\": ");
			String inputUser = scan.nextLine();
			System.out.print("Please enter your \"Password\": ");
		    String inputPass = scan.nextLine(); 
		   
		    if (inputUser.equals(username) && inputPass.equals(password)) {	    	
		    	System.out.print("Your in a system");
		    	System.out.println("\n");
		    	logTracker.info("Customer log in the system");
		    	menu.customerMenu();
		    } else {
		    	System.out.print("Your \"UserName\" or \"Password\" don't match");
		    	System.out.println("\n");
		    	logTracker.warn("Customer tried to log in with wrong username\\password");
		    	menu.loginMenu();
		    }
		} else {			
			System.out.println("You are still pending \n");
			System.out.println("\n");
			logTracker.info("Customre wasn't approved yet");
			menu.mainMenu();			
		}
		 scan.close();
	 }
	
	public void putBalance() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Menu menu = new Menu();
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Please input amount of your deposit");
		deposit = scan.nextDouble();
		balance += deposit; 
		
		System.out.println("Your current balance on account is: " + balance);
		System.out.println("Please input \"1\" for returning to menu or \"0\" for returning to main menu");
		int num = scan.nextInt();
		if(num == 1) menu.customerMenu();
		else menu.mainMenu();
		scan.close();
	}
	
	public void withDraw() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Menu menu = new Menu();
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Please input amount that you want to withdraw from your balance");
		withdraw = scan.nextDouble();
		
		if(balance > withdraw) {
			balance -= withdraw;
			System.out.println("Your current balance is: " + balance);
			System.out.println("Please input \"1\" for returning to menu or \"0\" for returning to main menu");
			int num = scan.nextInt();
			if(num == 1) menu.customerMenu();
			else menu.mainMenu();			
		} else {
			System.out.println("Inputed amout exceeds your balance");
			System.out.println("Please input \"1\" for returning to menu or \"0\" for returning to main menu");
			int num = scan.nextInt();
			if(num == 1) menu.customerMenu();
			else menu.mainMenu();			
		}
		scan.close();
	}
	
	public void tarnsfer() {
		Scanner scan = new Scanner (System.in);
		scan.close();
	}
	
	public void joinAccount() {
		Scanner scan = new Scanner (System.in);
		scan.close();
	}
	
	public void cancelAccount() {
		Scanner scan = new Scanner (System.in);
		scan.close();		
	}
}
