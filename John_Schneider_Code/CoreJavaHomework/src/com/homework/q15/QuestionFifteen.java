package com.homework.q15;

public class QuestionFifteen
{
	/*
	 * Test class for implemented interface
	 */
	
	public static void main(String[] args)
	{
		//Create an instance of the interface's implementation
		Maths mather = new Maths();
		
		//Perform the addition and division methods
		int sum = mather.addition(1,2);
		int division = mather.division(10,2);
		
		//Print out results of the methods
		System.out.println("Addition of 1 and 2: " + sum);
		System.out.println("Division of 10 and 2: " + division);
	}
}