package com.HW1.question10;

import java.util.Scanner;

public class Question10 {
	// Find the minimum of two numbers using ternary operators.

	public static void main(String[] args) {
		int x = 0, y = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st number to compare: ");
		x = sc.nextInt();
		System.out.println("Enter 2nd number to compare: ");
		y = sc.nextInt();

		int minimum = (x < y) ? x : y; 				// checks which number is least with
		System.out.println("Minimum: " + minimum); 	// ternary operators and outputs it

		sc.close();
	}
}
