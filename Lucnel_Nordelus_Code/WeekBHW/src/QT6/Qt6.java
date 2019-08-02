package QT6;

import java.util.Scanner;

public class Qt6 {
	/*
	 * Write a program to determine if an integer is even without using the modulus
	 * operator (%)
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter a number: ");

		int n = sc.nextInt();
		
		if (n / 2 * 2 == n) {
			System.out.print("This is an even number: ");
		} else
			System.out.print("This is an odd number:  ");
		
		

	}
}