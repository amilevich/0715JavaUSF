package com.assignment1.q13;

public class Triangle {
	
	/*
	 * Q13. Display the triangle on the console as follows using any type of loop.
	 * Do NOT use a simple group of print statements to accomplish this. 
	 * 
	 * 0 
	 * 1 0 
	 * 1 0 1
	 * 0 1 0 1
	 * 
	 */
	
	public static void main(String[] args) {
		for (int i=1; i<5; i++)
		{
		    for (int j=0; j<i; j++)
		    {
		        System.out.print("0");
		    }
		    System.out.println("1");
		}
		
	}

}
