package com.mybank.app;

import java.util.Scanner;

import CustomerDAO.IndividualDaoImpl;

public class RegistrationPortal {
	static String firstname;
	static String lastname;
	static long   socialSec;
	static String username;
	static String password;
	
	public static void myCustRegistration() {
		IndividualDaoImpl ind = new IndividualDaoImpl();
		Individual indvd = new Individual();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("First Name:");
		firstname = sc.nextLine();
		System.out.println("Last Name:");
		lastname = sc.nextLine();
		System.out.println("Social Security:");
		socialSec = sc.nextLong();
		sc.nextLine();
		System.out.println("Create Username:");
		username = sc.nextLine();
		System.out.println("Create Password:");
		password = sc.nextLine();
		
		//Populating the Pojo!
		indvd.setFirst_name(firstname);
		indvd.setLast_name(lastname);
		indvd.setPassword(password);
		indvd.setType(3);
		indvd.setUsername(username);
		
		
		ind.insertIndividual(indvd);
		
		
		
		
	}
	
	//public static void main(String[] args) {
		//myCustRegistration();
	//}

}
