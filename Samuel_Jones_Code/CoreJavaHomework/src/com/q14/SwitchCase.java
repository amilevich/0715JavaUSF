package com.q14;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
public class SwitchCase {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please select a menu option"); // prompt user for input
		showMenu(); //show the menu
		int userChoice = sc.nextInt(); //collect the user's choice
		runProgram(userChoice); //pass the choice to the runProgram switch case method
		
		
	}
	
	//displays a menu to users
	public static void showMenu() {
		
		System.out.println("Menu Options: ");
		String[] menuOptions = {"1. Find the SQRT of a number.", "2. Find today's date.", "3. Split a string."};
		for(int i =0; i<menuOptions.length;i++) {
			System.out.println(menuOptions[i]);
		}
		
			
	}
	
	// contains the switch case, and the actual meat of the program
	public static  void runProgram(int userChoice) {
		switch(userChoice) { // on the basis of userChoice, determine which code to execute
		case 1: // if choice is 1...
			System.out.println("Please enter a number"); //prompt the user for input
			int num = sc.nextInt(); // capture the input as a variable
			System.out.println("Square root of " + num + " is " + Math.sqrt(num)); //find the square root of the input and print it
			break;
		case 2:
			Date today = Calendar.getInstance().getTime(); // method chaining to return the current time... the Calendar library contains useful methods for this
			System.out.print("Today's date is: " + today); // print the date.
			break;
		case 3:
			String str = "I am learning Core Java"; // string to split
			System.out.println("Splitting this string: " + str); // print the original
			String[] splitStr = new String[4]; // create a string array
			splitStr = str.split("\\s"); // split across whitespace
			for(String s: splitStr) { // loop through the strings in the array and print them out
				System.out.println(s);
			}
			System.out.println("String split and stored in String[] array.");
		}
		
	}

}


