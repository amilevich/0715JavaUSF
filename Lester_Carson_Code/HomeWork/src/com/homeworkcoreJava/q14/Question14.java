package com.homeworkcoreJava.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Answers to Question 14:
//Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
//Case 1: Find the square root of a number using the Math class method. 
//Case 2: Display today’s date.
//Case 3: Split the following string and store it in a string array. 
//		“I am learning Core Java”
//Barton Carson
public class Question14 {

	public static void main(String[] args) {
		
		switchCases();

	}
	
	public static void switchCases() {
		
		int count = 3;
		switch (count) {
		
		//Case 1: square root
		case 1:
			double num = 64;
			System.out.println(Math.sqrt(num));
			break;
			
		//Case 2: Today's Date
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
			
		//Case 3: Broken up string
		case 3:
			String str = "I am learing Core Java";
			String[]  array = str.split(",");
		    for(int i=0;i<array.length;i++) {
		           System.out.println(array[i]);
		    }	
		    break;
		}	
	}
}