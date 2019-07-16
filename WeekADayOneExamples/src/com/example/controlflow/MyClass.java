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

		// if statement
		// a random number generated, if the number is greater than 0,
		// we print a message to the console

		Random r = new Random();
		// we are instantiating an object "r" of type Random
		int num = r.nextInt();

		// System.out.println(num);

		// int num2 = 0;

		// if(num2 > 0) {
		// System.out.println("The number is positive.");
		// } else if (num2 < 0 ){
		// System.out.println("The number is negative.");
		// }else {
		// System.out.println("The number is zero.");
		// }

		// else keyword used with if statements

		// else if keyword
		/*
		 * tests for another condition if and only if the previous condition was not met
		 * 
		 * we can use multiple of these
		 */

		// switch statement
		/*
		 * the switch keyword is used to test a value from the variable or the
		 * expression against a list of values. the list of values is presented with the
		 * "case" keyword if the values match, the case is executed
		 * 
		 * there is an optional default statement that is executed no matter if a match
		 * is found
		 * 
		 * break keyword is typically found at the end of each case to terminate the
		 * loop
		 */

		String country = "uk";

		// switch(country) {
		// case "us":
		// System.out.println("United States");
		// break;
		// case "uk":
		// System.out.println("United Kingdom");
		// break;
		// case "sy":
		// System.out.println("Syria");
		// break;
		// default:
		// System.out.println("Wrong entry");
		// break;
		// }

		// while
		// allows code to be executed repeatedly based on a
		// given boolean condition

		int var = 0; // first part is initialization
		int sum = 0;

		// second part is testing
		// while(var < 10) {
		// //the statement will be executed until var = 10
		// var++; //third part is updating, we increment
		// // the counter
		// sum = sum + var; //same thing as sum += var
		// System.out.println("the sum is: " + sum);
		// }

		// do while
		// modified version of the while statement
		// it is guaranteed to run at least once, even
		// if the condition is not met

//		int count = 0;
//		do {
//			System.out.println(count);
//		} while (count != 0); // != means not equals

		
		//for loop
		//used when the number of cycles is known before the 
		//loop is initiated
		//3 parts to the loop:
		/*
		 * 1)initiate the counter i (i=0)
		 * 2)specify a condition. when it is met, the statement
		 * inside the block is executed
		 * 3)counter is increased
		 * repeat phases 2 and 3 until the condition is no longer met
		 */
		
		
//		for(int i=0; i<10; i++) {
//			System.out.println(i);
//		}
		
		//let's talk about break
		Random ran = new Random();
		
//		while(true) {
//			
//			int num3 = ran.nextInt(30);
//			//choose a random value from 1-30 and print it
//			System.out.print(num3 + " ");
//			
//			if(num3 == 22) {
//				break;
//			}
//		}
		
		//continue keyword
		//let us print a list of numbers that cannot be divided
		//by 2 without a remainder
		//print all odd numbers
		int num4 = 0;
		
		while(num4 < 100) {
			num4++; //increment by 1 and assign back to variable
			
			if((num4 % 2) == 0) { // = -> assignment, == -> comparison
				continue;
			}
			System.out.print(num4 + "");
		}
		
		
		
		
	}

}
