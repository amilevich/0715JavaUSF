package com.HW1.question3;

import java.util.Scanner;

public class Question3 {
	// Reverse a string without using a temporary variable.
	// Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter string to reverse: ");
		String input = sc.nextLine();
		
		//Assuming that reverse does not mean to save in same variable 
		// reverse is printed out here
		
		System.out.println("Reverse: ");
		for(int i=input.length()-1; i >= 0 ;i--) {
			System.out.print(input.charAt(i));
		}
		sc.close();
	}
}
