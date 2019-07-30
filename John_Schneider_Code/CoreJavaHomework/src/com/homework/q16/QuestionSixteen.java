package com.homework.q16;

public class QuestionSixteen
{
	/*
	 * Display the number of characters from a string input through args in main method
	 */
	
	public static void main(String[] args)
	{
		for(String s : args) //for-each loop to iterate over every string in the string array args
		{
			System.out.println("String: " + s); //print out what the current string is
			
			System.out.println("Number of characters: " + s.chars().count()); //utilize string methods to get number of characters in the string
			
			System.out.println(); //extra space to make output easier to read
		}
	}
}