package com.example.scanner;

import java.util.Scanner;

public class MyClass {
	
	//The Scanner class is used to get user input through the console
	//It is found in the java.util package
	
	public static void main(String[] args) {
		//creates a scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username: ");
		
		String username = sc.nextLine();
		
		System.out.println("Please enter your password: ");
		String password = sc.nextLine();
		
		System.out.println("Please enter your age: ");
		int age = sc.nextInt();
		
		System.out.println("Please enter your phone number: ");
		long phoneNumber = sc.nextLong();
		
		System.out.println("Username: " + username);
		System.out.println("Age: " + age);
		System.out.println("Phone number: " + phoneNumber);
		
		
	}

}
