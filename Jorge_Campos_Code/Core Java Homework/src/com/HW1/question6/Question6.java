package com.HW1.question6;

import java.util.Scanner;

public class Question6 {
	//Write a program to determine if an integer is even 
	//without using the modulus operator
	
	static int greatestCommonFactor(int x, int y) {
		if(x == 0)							// calculate greatest common factor recursively
			return y;
		if(y == 0)
			return x;
		
		if(x == y)
			return x;
		else if(x > y)
			return greatestCommonFactor(x-y,y);
		return greatestCommonFactor(x,y-x);			
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an integer: ");
		int input = sc.nextInt();
		
		//Compare user int to 2, if the greatest common factor
		// is 2 then the user input is even 
		boolean even = (greatestCommonFactor(input,2) == 2);
		
		 if(even)
		 System.out.println(input + " is even");
		 else
			System.out.println(input + " is odd");
		
		 sc.close();
	}
}
