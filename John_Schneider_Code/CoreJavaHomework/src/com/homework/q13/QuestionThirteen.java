package com.homework.q13;

public class QuestionThirteen
{
	/*
	 * display triangle to console using loop
	 */
	
	public static void main(String[] args)
	{
		//Counter variable to keep track of even/odd iterations for printing 0/1
		int c = 0;
		
		//Nested for loops for printing triangle
		for(int i = 0; i < 4; i++) //There will be four layers to the triangle
		{
			for(int j = 0; j <= i; j++) //Each layer has same # of elements as # of layer
			{
				if(c%2==0) //if counter is even print a zero
					System.out.print("0 ");
				else //if counter is odd print a 1
					System.out.print("1 ");
				
				c++; //increment the counter
			}
			//skip to next line in console for next line of triangle
			System.out.println();
		}
	}
}