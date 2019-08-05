package com.project.pjzero;

import com.project.actions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

	public void mainMenu() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		NewCustomerWR newCustomerWR = new NewCustomerWR();	
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Please choose one of menu point: \n");
				
		int num;

		do {
			System.out.println(" 1 - Register");
            System.out.println(" 2 - Log In");
            num = scan.nextInt();

		    switch (num)
		    {
		        case 1:		        	
		        	newCustomerWR.writeNewCustomer();
		            break;
		        case 2: 
		        	this.loginMenu();
		            break;		        
		        default:
		            System.out.println("You have to chose from 1 to 2 for contiue");
		    }   
		} while (num != 2);
		scan.close(); // close Scanner class if no more input from console		
	}	
	
	public void loginMenu() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {				
		EmployeeActions employeeActions = new EmployeeActions();
		int key = employeeActions.keyZ;
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner		
		System.out.print("Please choose one of menu point: \n");
		
		int num;

		do {
			System.out.println(" 1 - Log in as Customer");
            System.out.println(" 2 - Log in as Employee");
            System.out.println(" 3 - Log in as Admin");
            System.out.println(" 4 - Back to main menu");
            num = scan.nextInt();            

		    switch (num)
		    {
		        case 1:		        	
		        	employeeActions.userLogin(key);
		        	this.customerMenu();
		            break;
		        case 2:		        	
		        	employeeActions.employeeLogin();
		        	this.employeeMenu();
		            break;
		        case 3:		        	
		        	employeeActions.adminLogin();		        	
		        	this.adminMenu();
		            break;
		        case 4:
		        	this.mainMenu();
		            break;		        	
		        default:
		            System.out.println("You have to chose from 1 to 4 for contiue");
		    }   
		} while (num != 4);
		scan.close();
	}
	
	public void customerMenu() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		EmployeeActions employeeActions = new EmployeeActions();
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Please choose one of menu point: \n");
				
		int num;

		do {			
			System.out.println(" 1 - Deposit");
            System.out.println(" 2 - Withdraw");
            System.out.println(" 3 - Transfer");
            System.out.println(" 4 - Join another account");
            System.out.println(" 5 - Back to login menu (previous menu)");
            System.out.println(" 6 - Back to main menu");
            num = scan.nextInt();

		    switch (num)
		    {
		        case 1:
		        	employeeActions.putBalance();
		            break;
		        case 2:
		        	employeeActions.withDraw();		        	
		            break;
		        case 3:
		        	employeeActions.tarnsfer();		        	
		            break;
		        case 4: 
		        	employeeActions.joinAccount();
		            break;
		        case 5:
		        	this.loginMenu();
		            break;
		        case 6:
		        	this.mainMenu();
		            break;
		        default:
		            System.out.println("You have to chose from 1 to 6 for contiue");
		    }   
		} while (num != 6);
		scan.close(); // close Scanner class if no more input from console		
	}
	
	public void employeeMenu() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		EmployeeActions employeeActions = new EmployeeActions();
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Please choose one of menu point: \n");
				
		int num;

		do {
			System.out.println(" 1 - View customer info");
			System.out.println(" 2 - Make customer's approvment");
            System.out.println(" 3 - Back to login menu (previous menu)");
            System.out.println(" 4 - Back to main menu");
            num = scan.nextInt();

		    switch (num)
		    {
		        case 1:
		        	employeeActions.customerView();
		            break;
		        case 2:           
		        	employeeActions.customerApprovement();
		            break;
		        case 3:
		        	this.loginMenu();
		            break;
		        case 4:
		        	this.mainMenu();
		            break;
		        default:
		            System.out.println("You have to chose from 1 to 4 for contiue");
		    }   
		} while (num != 4);
		scan.close(); // close Scanner class if no more input from console		
	}
	
	public void adminMenu() throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		EmployeeActions employeeActions = new EmployeeActions();
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Please choose one of menu point: \n");
				
		int num;

		do {
			System.out.println(" 1 - View customer info");
			System.out.println(" 2 - Make customer's approvment");
			System.out.println(" 3 - Cancel customer's account");
            System.out.println(" 4 - Back to login menu (previous menu)");
            System.out.println(" 5 - Back to main menu");
            num = scan.nextInt();

		    switch (num)
		    {
		        case 1:
		        	employeeActions.customerViewAdmin();
		            break;
		        case 2:
		        	employeeActions.customerApprovementAdmin();
		            break;
		        case 3:
		        	employeeActions.cancelAccount();
		            break;
		        case 4:
		        	this.loginMenu();
		            break;
		        case 5:
		        	this.mainMenu();
		            break;
		        default:
		            System.out.println("You have to chose from 1 to 5 for contiue");
		    }   
		} while (num != 5);
		scan.close(); // close Scanner class if no more input from console
		
	}	
}
