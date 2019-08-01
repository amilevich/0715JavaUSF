package com.homework.quesone;

import java.util.Scanner;

// Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class QuesThree {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Input string: ");
		
		String s = scan.nextLine(); // original string
		scan.close(); // close Scanner class if no more input from console	
				
		char[] charS = s.toCharArray(); // convert our string to array of chars
		System.out.print("You got this: ");
		stringReverse(charS); // call method of reversing array of chars		
	}
	
	public static void stringReverse(char[] charS) { // create a method of reverse array of char		
		for (int i = charS.length - 1; i >= 0; i--) System.out.print(charS[i]); // loop for going through of our array of char & print what we got it
	}
}
