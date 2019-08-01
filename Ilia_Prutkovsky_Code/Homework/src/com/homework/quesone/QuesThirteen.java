package com.homework.quesone;

import java.util.Scanner;

// Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
// 0
// 1 0
// 1 0 1
// 0 1 0 1


public class QuesThirteen {

	public static void main(String[] args) {
		
		tiangleShow();
	}
	
	public static void tiangleShow() {
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input size of Triangle: ");
		int num = scan.nextInt(); // assign variable num with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		
		for(int i = 1; i <= num; i++){ // loop for rows
			for(int j = 1; j <= i; j++){ // quantity of elements in a row
			  if((i + j) % 2 == 0) System.out.print("0"); // check in our sequence when we fill triangle out current element is even put 0
			  else System.out.print("1"); // otherwise 1
			}
			System.out.println();
		}
	}
}
