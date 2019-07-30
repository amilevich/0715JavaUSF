package com.HW1.question14;

import java.util.Scanner;

public class Question14 {
	// Write a program that demonstrates the switch case. Implement the following
	// functionalities in the cases:
	// Case 1: Find the square root of a number using the Math class method.
	// Case 2: Display today’s date.
	// Case 3: Split the following string and store it in a string array.
	// 		“I am learning Core Java”

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1: Calculate Squareroot \n2: Printout Date \n3: Printout String \n");
		System.out.println("Enter Desired Feature, 1, 2 or 3: ");
		int input = sc.nextInt();

		switch (input) {
		case (1):
			System.out.println("Enter number to get squareroot of: ");
			input = sc.nextInt();
			System.out.println("Square root of " + input + " is: " + Math.sqrt(input));
			break;

		case (2):
			java.util.Date date = new java.util.Date();
			System.out.println("Today is: " + date);
			break;

		case (3):
			String arr[] = { "I ", "am ", "learning ", "Core ", "Java" };
			for (String i : arr)
				System.out.print(i);
			break;
		default:
			System.out.println("Sorry, Case not found, please try again");
		}
		sc.close();
	}
}
