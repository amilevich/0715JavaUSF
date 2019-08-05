package com.homework.quesone;

import java.util.Scanner;

// Write a program to display the first 25 Fibonacci numbers beginning at 0

public class QuesTwo {
	
	static int x = 0, y = 1;

	public static void main(String[] args) { // Main method
		
		Scanner scan = new Scanner(System.in); // creat a new object for class Scanner
		System.out.println("Input digit of Fibonacci: ");
		int n = scan.nextInt(); // assign variable n with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		
		if(n <= 0) System.out.println("0");
		else System.out.print(x + " " + y); //printout first and second Fibonacci digit
		
		Fibonacci(n); // invoke Fibonacci method
	}
	
	public static void Fibonacci(int n) {
		
		if(n > 0) { // if inputed "n" more than 0
			int z = x + y; // assign to variable "z" sum of "x" & "y"
			x = y; // assign to variable x value of y
			y = z; // assign to variable y value of z			
			System.out.print(" " + z); // print out sequence of Fibonacci digit divided by space
			Fibonacci(n - 1); //we do cycle inside of Fibonacci method by invoke one inside itself
		}
	}
}
