package com.homework;

import java.util.Scanner;

public class Problem16 {
	/*Write a program to display the number of characters for a string input. 
	 * The string should be entered as a command line argument using (String [ ] args).
	 */
	public static void main(String[] args) {
		
		//idk if im doing this right
		System.out.println("Oi, m8, IDK what the outcome of the program");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.println(input);
		int counter = 0;
		for (int i = 0; i < args.length ; i++) {
			counter = 1 + counter;
		}
		System.out.println(counter);
	}
}


