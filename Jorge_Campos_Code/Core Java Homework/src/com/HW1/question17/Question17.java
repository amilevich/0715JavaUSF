package com.HW1.question17;

import java.util.Scanner;

public class Question17 {
	// Write a program that calculates the simple interest on the principal, rate of
	// interest and number of years provided by the user. Enter principal, rate and time
	// through the console using the Scanner class.
	// Interest = Principal* Rate* Time

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter principle: ");			//requesting user input with scanner class
		double principle = sc.nextDouble();
		System.out.print("Please enter rate: ");
		double rate = sc.nextDouble();
		System.out.print("Please enter time: ");
		double time = sc.nextDouble();

		double interest = principle * rate * time;				//calculating interest
		
		System.out.println("The interest based of inputed data a is: "+ interest);
		
		sc.close();
	}
}
