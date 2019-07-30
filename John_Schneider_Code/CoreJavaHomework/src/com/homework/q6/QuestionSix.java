package com.homework.q6;

public class QuestionSix
{
	/*
	 * Determine if an integer is even without using %
	 */
	
	//Method to check if a given integer is even
	//Works by checking if given integer divided by two is whole number or not
	public static boolean isEven(int n)
	{
		double d = n / 2.0; //double variable to hold raw value of n / 2
		int n2 = n / 2; //int variable to hold rounded value of n / 2
		
		return d == (double)n2; //if the raw and rounded value of n / 2 is the same, there is no remainder and n is even
	}
	
	public static void main(String[] args)
	{
		//Print out status as even of given integer 10
		System.out.println("Is even? " + isEven(10));
		//Print out status as even of given integer 9
		System.out.println("Is even? " + isEven(9));
	}
}