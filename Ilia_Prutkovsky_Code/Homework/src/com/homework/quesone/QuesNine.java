package com.homework.quesone;

import java.util.ArrayList;
import java.util.Scanner;

// Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console

public class QuesNine {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input size of ArrayList: ");
		int num = scan.nextInt(); // assign variable num with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		
		primeNum(num); // invoke primeNum method with number that was got from console
	}
	
	public static void primeNum(int num) {	
		ArrayList<Integer> arrL = new ArrayList<>(); // create empty ArrayList
		for (int i = 2; i <= num; i++) if (primeCheck(i)) arrL.add(i); // use loop to fill out our ArrayList & check every number if is prime by invoke primeCheck method
		System.out.println("Prime number from 2 to " + num + " is " + arrL); // print out all our prime number
	}
	
	static boolean primeCheck(int num) { // primeCheck - method for checking number is prime or not		
		for (int j = 2; j < num; j++) if(num % j == 0) return false; // loop help us to go through & do checking number is not prime return false
		return true; // if yes , return true		
	}
}
