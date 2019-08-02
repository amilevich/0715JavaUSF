package com.example.question17;

import java.util.Scanner;

public class InterestRateCalculator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter principle amount :");
		float principle = scanner.nextFloat(); // accept the amount money loaned
		
		System.out.println("Enter time in years : ");
		float time = scanner.nextFloat(); // accept time in years
		
		System.out.println("Enter rate annually : ");
		float rate = scanner.nextFloat(); // accept time for annual interest rate
		
		float interest = (principle * rate * time) / 100; // calculate interest
		
		System.out.println("Interest rate: " + interest); // print the interest of loan
	}
}

