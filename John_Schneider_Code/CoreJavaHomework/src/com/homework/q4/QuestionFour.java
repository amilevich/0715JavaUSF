package com.homework.q4;

public class QuestionFour
{
	/*
	 * Compute N factorial
	 */
	
	//Recursive method to calculate the factorial of a given number, n
	public static int factorial(int n)
	{
		return n==0 ? 1 : n*factorial(n-1);
		//Above statement is ternary operator including base case and recursive call
		//Ternary operator functions as simplified if statement with condition and true : false operation
		//Base case is to simply return 1 and end recursion when n is equal to zero
		//When n is not 0, multiply n by product of recursive call with n-1
		//this way n will be multiplied by all numbers less than it, decremented by 1, until there are no more positive integers
		//As such, a call to factorial(3) will return:
		// 3 * factorial(2) ->
		// 3 * 2 * factorial(1) ->
		// 3 * 2 * 1 * factorial(0) ->
		// 3 * 2 * 1 * 1 = 6
	}
	
	public static void main(String[] args)
	{
		//print out the factorial of 5
		System.out.println(factorial(5));
	}
}