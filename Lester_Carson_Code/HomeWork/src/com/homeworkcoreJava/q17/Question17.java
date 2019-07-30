package com.homeworkcoreJava.q17;

import java.util.Scanner;

//Answers to Question 17:
//Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.
//Interest = Principal* Rate* Time
//Barton Carson
public class Question17 {

	public static void main(String[] args) {
		Interest();
	}
	
	public static void Interest() {
		
		Scanner sc = new Scanner(System.in);
		int principle, time;
		float rate;
		
		//Input for the interest calculation
		System.out.println("To calculate simple interest, first enter your principle amount: ");
		principle = sc.nextInt();
		System.out.println("Now enter the rate of the interest, (integer number): ");
		rate = sc.nextFloat()/100;
		System.out.println("Now enter the number of years: ");
		time = sc.nextInt();
		
		//Calculates simple interest
		float interest = principle*rate*time;
		System.out.println("The interest (in dollars) is: " + interest);
		sc.close();
		
	}

}
