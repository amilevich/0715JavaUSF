package com.HW1.question18;

import java.util.Scanner;

abstract class ModString {
	
	abstract boolean checkUpperCase(String str);
	abstract String toLowerCase(String str);
	abstract void convertToInt(String str);
	
}

public class Question18 extends ModString{
	// Write a program having a concrete subclass that inherits three abstract
	// methods from a superclass. Provide the following three implementations in the
	// subclass corresponding to the abstract methods in the superclass:
	//  1.	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	//	2.	Convert all of the lower case characters to uppercase in the input string, and return the result. 
	//	3.	Convert the input string to integer and add 10, output the result to the console

	boolean checkUpperCase(String str) {			//checks if string contains uppercase character
		for(int i = 0; i<str.length(); i++) {		// returning true is if contains, false if it doesn't
			if(Character.isUpperCase(str.charAt(i)))
				return true;
		}
		return false;
	}
	
	String toLowerCase(String str) {				//convert string to lowercase
		return str.toLowerCase();
	}
	
	void convertToInt(String str) {					//convert string to int value if have equivalent value
		int result = Integer.parseInt(str) + 10;	// for example will accept "12" but not "twelve"
		System.out.println("Conversion Result: " + result );
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Question18 tester = new Question18();
		System.out.println("Please enter a string to analyze: ");		//obtaining user input and desired operation
		String text = sc.nextLine();
		System.out.println("Please enter the operation number you want to perform:\n"
				+ "	1 to check if string contain uppercase characters\n\t"
				+ "2 to convert string to lowercase\n\t"
				+ "3 to convert to integer and add 10");
		int input = sc.nextInt();
		
		switch(input) {							//calling desired operation
		case(1):
			System.out.println("Checking uppercase: ");
			System.out.println(tester.checkUpperCase(text));
			break;
		case(2):
			System.out.println("Convering to LowerCase: ");
			System.out.println(tester.toLowerCase(text));
			break;
		case(3):
			tester.convertToInt(text);
			break;
		default:
			System.out.println("ERROR, option not available, please try again.");
			break;
		}
		sc.close();
	}
}
