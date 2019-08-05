package com.homework.quesone;

import java.util.Scanner;

// Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
// Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs

public class QuesFive {

	public static void main(String[] args) {
				
		subStr(); // invoke subStr method		
	}
	
	public static void subStr() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner		
		System.out.print("Input string: "); // ask user to input string
		String str = scan.nextLine(); // assign variable str with type String to string that was inputed from console
		
		System.out.print("Input number: "); // ask user to input string
		int idx = scan.nextInt(); // assign variable idx with type integer to digit that was inputed from console		
		scan.close(); // close Scanner class if no more input from console
		System.out.print("Your result is: ");
		for (int i = 0; i <= idx - 1; i++) System.out.print(str.charAt(i)); // print out our result
	}
}
