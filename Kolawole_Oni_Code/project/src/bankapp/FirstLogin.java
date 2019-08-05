package bankapp;

import java.util.Scanner;

import items.CustomerLogin;


public class FirstLogin{
	
	public static void main(String[]args) {
	
		
		
	//Create prompts to ask if they are customers or employees 
		System.out.println("Welcome to MyBank");
		//int input =  ;
		System.out.println("Are you a customer, Employee or manager");
		System.out.println("Press A if you are a returning customer");
		System.out.println("Press B if you are an employee;");
	    System.out.println("Press C if you are an administrator");
	    //String a = " ";
	    Scanner scanner = new Scanner(System.in);
	    //a = new Scanner();
		String a = scanner.nextLine();
		
		//Ask for username and password and set

	switch(a) {
	case "A":
		CustomerLogin customerLogin = new CustomerLogin();
	    //customerLogin.run();//username scanned in
	    System.out.println("YO");
	    ApprovedApplication aa = new ApprovedApplication();
	    CustomerLogin.actionMenu(aa);
		break;		
	case "B":
			//EmpL  employeelogin = new EmpLogin;
			//EmpOne empOne = new EmpOne; //EmpOne login method is called .
			//empOne.run(); //username and password 
		
		break;		
	case "C":
		//AdminOne adminOne = new Adminone();
		//adminOne.run(); //AdminOne login methods are called 
	}
	
	
	
		//To enter username and password here 
		//Call the Login method with getters and setters
		   System.out.println("Please enter a user name");
		    //String username = " ";
		    Scanner userName = new Scanner(System.in);
		    String Name = userName.nextLine();
		    
		    
		    System.out.println("Please enter a password");
			//String password  = " ";
			Scanner userPassword = new Scanner(System.in);
		   String Password = userPassword.nextLine();
	}
}
	
	     //A method that will call Login and
	        // System.out.print.ln()
	      //  Login login = new Login(userName, Password);
	        //
	        //login
	     //Another method that will prompt user for 
	        
		//A method that will call the AdminOneLogin

