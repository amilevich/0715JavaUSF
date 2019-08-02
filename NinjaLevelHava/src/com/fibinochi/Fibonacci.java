package com.fibinochi;

public class Fibonacci {
//Write a program to display the first 25 Fibonacci numbers beginning at 0. 

	public static void main(String[] args) {
		
		int x1 = 0, x2 = 1, x3 ,counter = 25;//manually setting the first two numbers
		System.out.print(x1 + " "+ x2);//printing out the begining of the sequence
		for(int i = 0; i < counter-1; i++) {
			x3 = x1 + x2;
			System.out.print(" "+ x3);
			x1 = x2;
			x2 = x3;
		}
		
		

	}

}
