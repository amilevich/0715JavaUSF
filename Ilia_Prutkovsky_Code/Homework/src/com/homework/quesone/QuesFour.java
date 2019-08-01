package com.homework.quesone;

import java.util.Scanner;

// Write a program to compute N factorial f(n) = n * f(n - 1)

public class QuesFour {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // creat a new object for class Scanner		
		System.out.print("Input Factorial number: "); // ask user to input Factorial number
		int n = scan.nextInt(); // assign variable n with type integer to digit that was inputed from console		
		scan.close(); // close Scanner class if no more input from console
		
		System.out.print("Your result is: " + facFunc(n)); // print out our result
	}	
	
	static int facFunc(int n) { // declaration of our Method
		if(n == 1) return 1; // check if input digit not equal 1 
		else return n * facFunc(n - 1);	// if not then invoke method facFunc	
	}
}
