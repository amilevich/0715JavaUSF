package com.assignment1.q18;

public class Parent {
	/*
	 * Q18. Write a program having a concrete subclass that inherits three abstract
	 * methods from a superclass. Provide the following three implementations in the
	 * subclass corresponding to the abstract methods in the superclass:
	 * 
	 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’
	 * depending if any are found. 2. Convert all of the lower case characters to
	 * uppercase in the input string, and return the result. 3. Convert the input
	 * string to integer and add 10, output the result to the console. Create an
	 * appropriate class having a main method to test the above setup.
	 * 
	 */

	static String input;
	private static int i;
	static char c = input.charAt(i);

	static boolean checkLetter(String str) {
		if (Character.isUpperCase(c)) {
			return true;
		} else {
			return false;
		}
	}

	static void lowToCapital() {
		char ch;
		for (int i = 0; i < 10; i++) {
			ch = (char) ('a' + i);
		}
	}
	
	static void convert() {
		String number = "10";
		Integer result = Integer.valueOf(number);	
		result = Integer.valueOf(number) + 10;
		System.out.println(result);
	}

}
