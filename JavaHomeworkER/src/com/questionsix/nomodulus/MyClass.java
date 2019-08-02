package com.questionsix.nomodulus;

import java.util.Scanner;

public class MyClass {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		
		/*
		 *Since integer numbers are represented as 2's complement and even number has 0 as the Least Significant Bit, 
		 *if we perform a bitwise AND between 1 and number, result will be 0.
		 */
		
		int number = sc.nextInt();
		if((number & 1) == 0){ // using bitwise AND operator
			System.out.println("Even number"); }  //output if the number entered was even 
		else {
			System.out.println("Not even number"); //output if the number entered was odd 
		}
	}

}