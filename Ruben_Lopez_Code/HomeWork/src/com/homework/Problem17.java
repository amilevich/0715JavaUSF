package com.homework;

import java.util.Scanner;

public class Problem17 {
	//Write a program that calculates the simple interest on the principal,
	//rate of interest and number of years provided by the user.
	//Enter principal, rate and time through the console using the Scanner class.
	//Interest = Principal* Rate* Time
	private static double principal = 0.0;
	private static double rate =0.0;
	private static double time = 0.0;
	
	
	public static void main(String[] args) {
		
		
		//simple scanner in operation
		//initiation scanner input
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Oi m8, how much was the car?");
		
		principal = sc.nextDouble();
		
		System.out.println("Oi m8, what was the rate per year?");
		
		rate = sc.nextDouble();
		
		System.out.println("Oi m8, How long was the contract?");
		
		time = sc.nextDouble();
		
		double intrest = time * rate * principal;
		
		System.out.println("Oi m8, You dun goofed. U owe " + intrest + "$");
		
		
	}


}
