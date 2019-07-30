package com.homework.q14;

import java.util.Calendar;

public class QuestionFourteen
{
	/*
	 * Demonstrate switch case
	 */
	
	public static void main(String[] args)
	{
		//integer variable to decide case of switch to execute
		int i = 3;
		
		//switch statement on value of variable i
		switch(i)
		{
		case 1: //block to execute if i is equal to 1
			System.out.println("Square root of 9: " + Math.sqrt(9.0)); //print out the square root of nine using java Math libraries
			break; //exit switch statement
		case 2: //block to execute if i is equal to 2
			System.out.println("Today's date: " + Calendar.getInstance().getTime()); //print out date using calendar libraries
			break; //exit switch statement
		case 3: //block to execute if i is equal to 3
			String str = "I am learning Core Java"; //given string to split apart into string array
			String[] arr = str.split(" "); //string array populated by elements of str split by whitespace character
			//for-each loop to print out each element of string array
			for(String s : arr) 
				System.out.println(s);
			
			break; //exit switch statement
		}
	}
}