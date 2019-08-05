package com.homework.quesone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
// Case 1: Find the square root of a number using the Math class method. 
// Case 2: Display today’s date.
// Case 3: Split the following string and store it in a string array. 
//		“I am learning Core Java”

public class QuesFourteen {

	public static void main(String[] args) {
		
		menuSwitch(); // invoke method menuSwitch
	}	
		
	public static void menuSwitch() { // create menuSwitch
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner		
		System.out.print("Input from 1 to 3: "); 
		int num = scan.nextInt(); // assign variable n with type integer to digit that was inputed from console
				
		switch (num) { // create control flow statement (decision making) "num" and take inputed "num" from console
		case 1:	
			
			System.out.print("Input digit for f(n^2): "); // print out message for user			
			int sqrtN = scan.nextInt(); // take inputed "sqrtN" from console
			System.out.print(Math.sqrt(sqrtN)); // print out result						
			break; // break out statement
			
		case 2:
			DateTimeFormatter curDate = DateTimeFormatter.ofPattern("MMMM dd yyyy"); // create new object curDate from class DateTimeFormatter
			LocalDate lDate = LocalDate.now(); // create object lDate from class LocalDate 
			System.out.print("Today is: " + curDate.format(lDate));
			break;
			
		case 3:
			String str = "I am learning Core Java";
			System.out.println(str);
			String[] str2 = str.split(" ", 0);
			for(String s: str2) System.out.println(s);
			break;
		}
		scan.close();
	}
}
