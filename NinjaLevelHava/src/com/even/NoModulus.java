package com.even;

import java.util.Scanner;

public class NoModulus {
//Write a program to determine if an integer is even without using the modulus operator (%)

	public static void main(String[] args) {
		System.out.println("Type in an Integer >>>");
		Scanner input = new Scanner(System.in);
		
		int x = input.nextInt();
		
		//I figured out that if you can solve this problem by 
		//dividing a number by two then multiplying the dividend by two
		//In this situation, an even number will keep its value and an odd will not. 
		
		if(((x/2)*2)==x) {
			System.out.println("Number is EVEN!!!!!");
		}else {
			System.out.println("Number is ODD!!!");
		}
			
		

	}

}
