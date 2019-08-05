package com.project.members;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class NewCustomer implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -8911322715995313318L;
//	HashMap<Integer, ArrayList<String>> customerMap = new HashMap<Integer, ArrayList<String>>();
		
	private String firstName = "";		
	private String lastName = "";
	private String address = "";				
	private int customerID = 0;
	
		
	public NewCustomer(String firstName, String lastName, String address, int customerID) {		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.customerID = customerID;
		this.newCustomer();
	}
		
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void newCustomer() {
		
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		int num = 0;
				
		System.out.println("Input your First Name: ");
		this.firstName = scan.nextLine();		
		
		System.out.println("Input your Last Name: ");
		this.lastName = scan.nextLine();
				
		System.out.println("Input your address: ");
		this.address = scan.nextLine();
				
		System.out.println("To get your customerID. \nPlease input digit from 100 to 199: ");
		num = scan.nextInt();
		scan.close();
		this.customerID = rand.nextInt(num * 100000);
	}

	@Override
	public String toString() {
		return "NewCustomer \n FirstName: " + getFirstName() + "\n LastName: " + getLastName() + "\n Address: "
				+ getAddress() + "\n CustomerID: " + getCustomerID();
	}	
}
