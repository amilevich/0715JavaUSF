package com.homework.q10;

public class QuestionTen
{
	/*
	 * Find the minimum of two numbers using ternary operators
	 */
	
	//Method to return the minimum of two given ints
	public static int findMin(int x, int y)
	{
		//Ternary operator -> simplified if statement
		//condition is if x is greater than y, signified by ?
		//if condition is true, return y
		//if false, return x
		return x > y ? y : x;
	}
	
	public static void main(String[] args)
	{
		//initialize two integers x and y
		int x = 10, y = 100;
		
		//print out the values of each integer
		System.out.println("x = " + x + ", y = " + y);
		
		//find the minimum of x and y and store it in another integer
		int min = findMin(x,y);
		
		//another ternary operator to set string to "x" or "y" if x or y is lower int
		String minXY = (min == x ? "x" : "y");
		
		//print out the minimum value and associated variable name
		System.out.println("Minimum: " + minXY + " = " + min);
	}
}