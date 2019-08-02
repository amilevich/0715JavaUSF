package com.switchexample;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SwitchExample {

	static //Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
	//Case 1: Find the square root of a number using the Math class method. 
	//Case 2: Display today’s date.
	//Case 3: Split the following string and store it in a string array. 
		//	“I am learning Core Java”

	Scanner input = new Scanner(System.in);
	//Below are 3 methods that I call in each of the switch cases.
	public static void case1() {
		System.out.print("Enter a Number>>>");
		int x = input.nextInt();
		System.out.println("The square root of "+ x + " is "+ Math.sqrt(x));
	}
	public static void case2() {
		Date today = Calendar.getInstance().getTime();
		System.out.println("Todays date is "+today);
		
	}
	public static void case3() {
		String original = "I am learning Core Java";
		
		String[] subs = new String[5];
		
		subs[0] = original.substring(0,2);
		subs[1] = original.substring(2,4);
		subs[2] = original.substring(5,13);
		subs[3] = original.substring(14,18);
		subs[4] = original.substring(19,23);
		
		for(int i = 0; i < subs.length; i++) {
		System.out.println(subs[i]);
		}
	}
	
	public static void justInCase() {
		System.out.println("Fine...Just do whatever YOU want...Im over it..");
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a case>>>123or0");
		
		int option = input.nextInt();
		
		switch(option) {
		case 1: case1();
			break;
		case 2: case2();
			break;
		case 3: case3();
			break;
		default: justInCase();
				
		}

	}

}
