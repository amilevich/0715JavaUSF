package com.example.controlflow;

import java.util.Random;

public class MyClass {

	/*
	 * What is control flow? What are control flow statements? Control flow
	 * statements break up the flow of execution by employing decision making and
	 * loops, enabling the program to conditionally execute particular blocks of
	 * code
	 * 
	 * if -> runs block of code if true, "else if" is used to write mutually
	 * exclusive blocks of code, "else" will execute if nothing else did (or if no
	 * condition was met)
	 * 
	 * for -> typically used when you know for how long you want to loop
	 * 
	 * switch -> useful when you are checking a variable against a lot of values
	 * 
	 * while -> typically used when you do not know for how long you want to loop
	 * but have a condition that needs to be satisfied
	 * 
	 * do while -> same as while, but will definitely run at least once
	 * 
	 * "continue" -> go to the end of loop and starts the next iteration can be used
	 * with loops and in switch statement
	 * 
	 * "break" -> go to the end of the loop, can only be used in loops and switch
	 * statements
	 * 
	 */

	public static void main(String[] args) {
		
		//if statement
		//a random number generated, if the number is greater than 0,
		//we print a message to the console
		
		Random r = new Random();
		//we are instantiating an object "r" of type Random
		int num = r.nextInt();
		
		System.out.println(num);
		
		int num2 = 0;
		
		if(num2 > 0) {
			System.out.println("The number is positive.");
		} else if (num2 < 0 ){
			System.out.println("The number is negative.");
		}else {
			System.out.println("The number is zero.");
		}

	// else keyword used with if statements

	// else if keyword
	/*
	 * tests for another condition if and only if the previous condition was not met
	 * 
	 * we can use multiple of these
	 */
		
		//switch statement
		/*
		 * the switch keyword is used to test a value from the variable
		 * or the expression against a list of values.
		 * the list of values is presented with the "case" keyword
		 * if the values match, the case is executed
		 * 
		 * there is an optional default statement that is executed
		 * no matter if a match is found
		 * 
		 * break keyword is typically found at the end of each case to
		 * terminate the loop
		 */

		String country = "uk";
		
		switch(country) {
		case "us":
			System.out.println("United States");
			break;
		case "uk":
			System.out.println("United Kingdom");
			break;
		case "sy":
			System.out.println("Syria");
			break;
		default:
			System.out.println("Wrong entry");
			break;
		}
}

}
