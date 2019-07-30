package com.HW1.question4;

import java.util.Scanner;

public class Question4 {

	static int factorial(int n) {			// recursively calculate factorial
		if(n==1) {
			return 1;
		}
		else
			return (n * factorial(n-1));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter integer to calculate factorial: ");
		int input = sc.nextInt();							//collect number to calculate factorial from user
		
		System.out.println(input + "! = " + factorial(input));
		
		sc.close();
	}

}
