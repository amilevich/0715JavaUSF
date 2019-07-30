package com.homework.q17;

import java.util.Scanner;

public class QuestionSeventeen
{
	/*
	 * Calculate simple interest using principle, interest rate, and years accrued provided by the user
	 */
	
	public static void main(String[] args)
	{
		//Create a new scanner object to get user input from the console
		Scanner in = new Scanner(System.in);
		
		//prompt user to input principle and utilize scanner to take in value
		System.out.println("Please enter principle: ");
		int principle = in.nextInt();
		
		//prompt user to input interest rate and utilize scanner to take in value
		System.out.println("Please enter interest rate: ");
		int rate = in.nextInt();
		
		//prompt user to input number of years and utilize scanner to take in value
		System.out.println("Please enter number of years: ");
		int time = in.nextInt();
		
		//calculate interest based on formula principle * rate * time
		int interest = principle * rate * time;
		
		//print out the calculated interest
		System.out.println("Interest calculated at: " + interest);
		
		//close the scanner
		in.close();
	}
}