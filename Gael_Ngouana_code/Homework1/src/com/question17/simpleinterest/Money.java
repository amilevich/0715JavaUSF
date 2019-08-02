package com.question17.simpleinterest;

import java.util.Scanner;

public class Money {

	public static void main(String[] args) {
		
		//getting user input through the console
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the principal:");
		int x = sc.nextInt();
		System.out.println("please enter the rate:");
		float y = sc.nextFloat();
		System.out.println("Please enter the number of years:");
		int z = sc.nextInt();
		
		mySimpleInterest(x, y, z);

	}
	
	//Method to compute the interest
	
	static void mySimpleInterest(int x, float y, int z) {
		
		float w = (float)y / 100;
	   float interest = ((float)(x * w) * z);
		
		//prints out the value of the variable interest
		System.out.println(interest);
	}

}
