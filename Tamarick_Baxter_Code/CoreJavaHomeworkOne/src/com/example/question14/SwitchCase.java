package com.example.question14;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		
		// Will give 3 options in the console, utilizes the switch case
		int choice;
		Scanner sc = new Scanner(System.in);
		
		// console output prompting user to enter a choice 
		System.out.println("Enter your choice:\n1)Find the square root of number\n2)Display today's date\n3)Split the string and store in array\n");
		
		choice = sc.nextInt();
		
		
		switch(choice) {
		
		// Square root case
		case 1:
			// This case will give another prompt asking for a number to compute for the square root
			System.out.println("Enter the number\n");
			int n = sc.nextInt();
			double squareRoot = Math.sqrt(n);
			System.out.println("Square root of "+n+" is "+squareRoot);
			break;
			
		// Today's date case
		case 2:
			LocalDateTime date = LocalDateTime.now();
			System.out.println(date.toString());
			break;
			
		// Split String case
		case 3:
			// Hard coded a string here and prints the on a seperate line
			String st="I am learning Core Java";
			String[] stArray=st.split(" ");
			for(int i=0;i<stArray.length;i++){
			System.out.println(stArray[i]);
			}
			  
			}
		}

	}

