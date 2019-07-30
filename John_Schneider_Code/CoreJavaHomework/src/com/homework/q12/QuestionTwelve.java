package com.homework.q12;

public class QuestionTwelve
{
	/*
	 * Store numbers from 1 to 100 in an array and print out the even numbers with for-each loop
	 */
	
	public static void main(String[] args)
	{
		//new array of integers of size 100
		int[] arr = new int[100];
		
		//for loop to fill int array with numbers 1 to 100
		for(int i=0; i<100; i++)
			arr[i] = i+1;
		
		//for-each loop to iterate over every element in the int array
		for(int i : arr)
		{
			//if the division of the given number and 2 does not result in a remainder, it is even
			//print the number out if it is even
			if(i % 2 == 0)
				System.out.print(i + " ");
		}
	}
}