package com.q17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// prompts user for a principal, interest rate, and time in years (it's important that interest is entered as a decimal)
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a principal.");
		double principal = sc.nextDouble();
		System.out.println("Please enter an interest rate (enter the rate as a decimal. E.g. 6% should be entered as .06.");
		double rate = sc.nextDouble();
		System.out.println("Please enter a number of years.");
		int time = sc.nextInt();
		sc.close();
		double simpleInterest = calculateInterest(principal, rate, time);
		System.out.print("Interest is: ");
		System.out.println(simpleInterest);
	}
	
	public static double calculateInterest(double principal, double rate, int time) {
		return principal*rate*time;
	}

}
