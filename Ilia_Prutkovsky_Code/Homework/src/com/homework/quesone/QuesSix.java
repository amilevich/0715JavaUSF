package com.homework.quesone;

import java.util.Scanner;

// Write a program to determine if an integer is even without using the modulus operator (%)

public class QuesSix {

	public static void main(String[] args) {
		
		checkEven(); // invoke method checkEven
	}
	
	public static void checkEven() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input number: "); // ask user to input string
		int num = scan.nextInt(); // assign variable even with type integer to digit that was inputed from console		
		scan.close(); // close Scanner class if no more input from console
		if((num & 1) == 0) System.out.println("Even"); // check if our digit from console Even (use bitwise operand we do comparing bit by bit - 
														// if 1 in one bit match another 1 keep it, otherwise 0
		// for example 3 - (0000 0011) & = 0000 0001 | 6 - (0000 0110) & = 0000 0000
		//             1 - (0000 0001)				 | 1 - (0000 0001)
		else System.out.println("Odd"); // otherwise print out Odd
	}

}
