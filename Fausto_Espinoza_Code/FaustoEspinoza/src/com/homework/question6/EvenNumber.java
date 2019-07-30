package com.homework.question6;

import java.util.Scanner;

public class EvenNumber {
	
	//Method Even number
//	static void getEven(long number) {
//		
//		//Divide for 2 
//		long r = number /2;
//		//Compare if the new number is equal zero the number is even
//		if(number - (r * 2) == 0) {
//			System.out.println("number " + number + " is even... ");
//		}else {
//			System.out.println(number + " is not even");
//		}
//	}
	//Method Even number
	static void getEven1(long number) {
		//Divide for 2 
		double r = (double) number /2;
		//Compare if the new number is equal zero the number is even
		if(Math.ceil(r) == Math.floor(r)) {
			System.out.println("number " + number + " is even... ");
		}else {
			System.out.println(number + " is not even");
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter number: ");
		long number = scn.nextLong();
		//Call method
		getEven1(number);
		scn.close();

	}

}
