package com.homework.quesone;

import java.util.Scanner;

// Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
// Use the enhanced FOR loop for printing out the numbers.

public class QuesTwelve {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input size of Array: ");
		int num = scan.nextInt(); // assign variable n with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		
		arrayEven(num); // invoke arrayEven method
	}
	
	public static int arrayEven(int num) { // create method arrayEven with argument int num
			
		int[] arrEven = new int[num]; // create new int Array arrEven with size num
		for(int i = 0; i < arrEven.length; i++) { // create loop for put all number inside of our array 
			arrEven[i] = i; // put all number inside
			if(arrEven[i] % 2 == 0) System.out.print(arrEven[i] + " "); // check if number is even then print it out
		}
		return num; // return input number
	}
}
