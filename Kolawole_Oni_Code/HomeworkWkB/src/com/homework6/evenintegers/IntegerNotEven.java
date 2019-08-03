package com.homework6.evenintegers;

import java.util.Scanner;

public class IntegerNotEven {

	
	public static void NumIsEven() {
		System.out.println("Please enter the Number you wish to use");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		//int number = 0; 
		int quotient = number/2;
		
		if(quotient*2==number) {
			System.out.println("Your number is Even");
		}
		else {
		     System.out.println("Your number is odd");
		}
		scanner.close();
	}
	public static void main(String[]args) {
		
		NumIsEven();
	}
}
