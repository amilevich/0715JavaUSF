package com.homework.quesone;

//  Find the minimum of two numbers using ternary operators

import java.util.Scanner;

public class QuesTen {

	public static void main(String[] args) { // main method from where program start
				
		inputDigit(); // invoke Method with which we input our digits
	}
	
	public static void inputDigit() { // Method to input digit from console
		Scanner scan = new Scanner(System.in); // creat a new object for class Scanner
		System.out.print("Input X: "); // print out text for user
		int x = scan.nextInt(); // assign variable x with type integer to digit that was inputed from console 
		System.out.print("Input Y: ");// print out text for user
		int y = scan.nextInt(); // assign variable x with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console 
		System.out.print(ternaryMeth(x, y)); // print out our result to console invoked method that compare two digit
	}
	
	public static boolean ternaryMeth(int x, int y) { // method comparing two digit
		System.out.print("Compare two digits X < Y: ");
		Boolean t = true; // assign to Boolean variable t "true" 
		Boolean f = false; // assign to Boolean variable f "false"
		return (x < y) ? t : f; // use ternary operator to compare 2 digit ( condition ) (? evaluate our condition) check if our condition "true" return true : o 
	}   // otherwise return false

}
