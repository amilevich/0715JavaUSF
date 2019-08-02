package com.interest;

import java.util.Scanner;

public class Interest {

	/*
	 * Q17. Write a program that calculates the simple interest on the principal, 
	 * rate of interest and number of years provided by the user. Enter principal,
	 *  rate and time through the console using the Scanner class.
	 *  
		Interest = Principal* Rate* Time

	 */
	public static void main(String[] args) {
		double principal;
		double rate ;
		double time;
		
		double interest;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter principal amount>>>");
		principal = input.nextDouble();
		System.out.println("Enter rate...This should be a decimal...that starts with zero>>>");
		rate = input.nextDouble();
		System.out.println("Enter the amount of years you have hated your job please>>>");
		time = input.nextDouble();
		
		interest = principal * rate * time;
		System.out.println("Con-Gra-Chu-Lay-She-Oh-Nez!!!\n Here is your check for $"+interest);

	}

}
