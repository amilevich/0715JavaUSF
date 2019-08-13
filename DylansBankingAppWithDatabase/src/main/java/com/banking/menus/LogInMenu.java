package com.banking.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.banking.dao.CustomerDao;
import com.banking.dao.EmployeeDao;

public class LogInMenu {
	final static Logger loggy = Logger.getLogger(LogInMenu.class);
	static Scanner scanner = new Scanner(System.in);
	static EmployeeDao employeeDao = new EmployeeDao();
	static CustomerDao customerDao = new CustomerDao();
	static String username;
	static int customerid;
	
	public LogInMenu() {
		username = logIn();
		logIn();
		//printMenu();
	}
	
	
	
	

	
	public static String logIn() {
		System.out.println("Please input your Username...or enter 0 to back out ");
		username = scanner.nextLine();
		if(username.contentEquals("0")) {MainMenu mainMenu = new MainMenu();}
		System.out.println("Please input your Password: ");
		String password = scanner.nextLine();
		if(username.equals("boss") | username.equals("Boss")) {
			AdminMenu adminMenu = new AdminMenu("boss");
		}else if(username.equals("employee") | username.equals("Employee")) {
		EmployeeMenu empMenu = new EmployeeMenu("employee");
	}else {
		checkForValidAccount(username);
		}
		return username;
		
	}
	
	protected static void checkForValidAccount(String username) {
		try {
		if(username.equals(((customerDao.selectCustomerByUsername(username)).getUsername()))) {
			customerid = (customerDao.selectCustomerByUsername(username)).getCustomerID();
			loggy.info(username + " Logged In");
			CustomerMenu menuCustomer = new CustomerMenu(username,customerid);
//		}else if(username.equals(((employeeDao.selectEmployeeByUsername(username)).getUsername()))){
//			
//					if(((employeeDao.selectEmployeeByUsername(username)).getType()) == 2) {
//					EmployeeMenu empMenu = new EmployeeMenu(username);
//					}else if(((employeeDao.selectEmployeeByUsername(username)).getType()) == 3) {
//						AdminMenu adminMenu = new AdminMenu(username);
//					}
//					
		}else {
			System.out.println("No Account found for Given Username\n");
			logIn();
				}
			
		}catch(Exception e) {
			System.out.println("Please Input a Valid Entry\n");
			System.out.println("\t Re-routing...press Enter");
			scanner.nextLine();
			MainMenu mainMenu = new MainMenu();
		}
	}
	
	
	//Will be used to check the title in the Employee table, The title if Admin or Employee will dictate which menu is loaded. 
	//VVVV
//	public static void checkEmployeeTitle();{		
//	}
	
	
	
	
	////////////////////////////////////////TESTING///////////////////////////////
	
	protected static void TESTcheckForValidAccount(String username) {
		try {
		if(username.equals(((employeeDao.selectEmployeeByUsername(username)).getUsername()))){
			
			if(((employeeDao.selectEmployeeByUsername(username)).getType()) == 2) {
			EmployeeMenu empMenu = new EmployeeMenu(username);
			}else if(((employeeDao.selectEmployeeByUsername(username)).getType()) == 3) {
				AdminMenu adminMenu = new AdminMenu(username);
			
			
		
		}else if(username.equals(((customerDao.selectCustomerByUsername(username)).getUsername()))) {
			customerid = (customerDao.selectCustomerByUsername(username)).getCustomerID();
			loggy.info(username + " Logged In");
			CustomerMenu menuCustomer = new CustomerMenu(username,customerid);
		
		}else {
			System.out.println("No Account found for Given Username\n");
			logIn();
				}
		
		}
		}catch(Exception e) {
			e.printStackTrace();
//			System.out.println("Please Input a Valid Entry\n");
//			System.out.println("\t Re-routing...press Enter");
//			scanner.nextLine();
//			MainMenu mainMenu = new MainMenu();
		}
	
	
	}
	
}
