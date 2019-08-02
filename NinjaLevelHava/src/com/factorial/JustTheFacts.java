package com.factorial;

public class JustTheFacts {
	//Write a program to compute N factorial
	public static void main(String[] args) {
		
		factorial(4);

	}
	public static void factorial(int x) {
		int fact = 1;//setting this variable to one so I can use it to multiply
		for (int i = 1; i <= x; i++ ) {
			fact = fact * i; 
			 
		}
		System.out.print(fact);
	}

}
