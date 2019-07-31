package com.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problem14 {
	//Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
		//Case 1: Find the square root of a number using the Math class method. 
		//Case 2: Display today’s date.
		//Case 3: Split the following string and store it in a string array. 
		        //“I am learning Core Java”
	public static void main(String[] args) {
		
		//Initialization of the following array in the description
		String condition = "I am learning Core Java";
	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("oi, m8 trying to do Math?, find todays date? \nor are you tring to append a string");
		
		String input = sc.next() ;
		
		switch(input) {
			case "Math" :
				
				//performs the square root operation if called 
				System.out.println("What number do you want to fint the root number");
				int inputInt = sc.nextInt();
				System.out.println(Math.sqrt(inputInt));
				break;
			case "Date" :
				//getting todays date
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				break;
			default : 
				//simple append operation
				//condition = condition + " " + input;
				String stringArray[] = new String[5];
				stringArray[0] = "I";
				stringArray[1] = "am";
				stringArray[2] = "learning";
				stringArray[3] = "core";
				stringArray[4] = "java";
				
				for ( int i = 0 ; i < stringArray.length ; i++) {
					System.out.println(stringArray[i]);
				}
				break;
				
				
		}
		
		System.out.println(input);
		
	}
}
