package com.homework.quesone;

import java.util.Scanner;

// Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
// Enter principal, rate and time through the console using the Scanner class.
// Interest = Principal* Rate* Time


public class QuesSeventeen {

	public static void main(String[] args) {
		
		simpleInterest();
	}
	
	public static void simpleInterest() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner		
		System.out.print("Input your principal: "); 
		double prinCipal = scan.nextDouble(); // assign variable n with type integer to digit that was inputed from console
		System.out.print("Input your rate: "); 
		double rate = scan.nextDouble(); // assign variable n with type integer to digit that was inputed from console
		System.out.print("Input your time: "); 
		double time = scan.nextDouble(); // assign variable n with type integer to digit that was inputed from console
		double interest = prinCipal * rate * time;
		System.out.println(interest);
		scan.close();
	}

}
