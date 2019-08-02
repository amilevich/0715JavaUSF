package com.charactersargs;

import java.util.Scanner;

public class CharacterCounter {

	/*
	 * Q16. Write a program to display the number of characters for a string input.
	 *  The string should be entered as a command line argument using (String [ ] args).

	 */
	public static void main(String[] args) {
		/*
		 * Things I Need...
		 * 
		 * 1.Scanner for input
		 * 2.A string
		 * 3.A loop to count the index of the string
		 * 4.Coffee
		 */
		Scanner input = new Scanner(System.in);
		int counter = 0;
		System.out.println("Please enter a String");
		String myString = input.nextLine();
		for(int i = 0; i < myString.length(); i++) {
			counter++;
		}System.out.println("You typed in "+counter+" characters...including spaces!");
	}
	
	
	

}
