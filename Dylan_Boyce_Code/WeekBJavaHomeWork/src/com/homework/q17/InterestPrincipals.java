package com.homework.q17;

import java.util.Scanner;

public class InterestPrincipals {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Interest Calculator\nEnter your Principal Value:");
		double principal = scanner.nextInt(); // gets the principal value from the user and initializes it to variable
		System.out.println("Enter the rate of interest:");
		double rate = scanner.nextInt();  // gets the rate value from the user and initializes it to variable
		System.out.println("Enter the Time duratoin for interest period:");
		double time = scanner.nextInt();   // gets the time value from the user and initializes it to variable
		scanner.close();
		System.out.println("Your total interest value is: " + (principal*rate*time));//multiplies all factor's of the Interest together to get the product
	}
}
