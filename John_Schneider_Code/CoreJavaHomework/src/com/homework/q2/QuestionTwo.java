package com.homework.q2;

public class QuestionTwo
{
	/*
	 * Display the first 25 numbers of the Fibonacci sequence
	 */
	
	static int twoBack = 0, oneBack = 1; //class level int variables to hold previous two Fibonacci numbers
	
	//Recursive method to print numbers of the Fibonacci sequence to a given stopping point n
	public static void printFibonacci(int n)
	{
		if(n<=2) return; //base case to end recursion once number of remaining numbers to print is 2, as first two numbers have already been printed
		
		int current = oneBack + twoBack;
		
		System.out.print(current + " "); //print out the current number of the sequence
		
		int temp = oneBack; //temporary integer for use in iterating up in the sequence
		oneBack = current; //previous number in the sequence for use in next iteration is current iterations equated Fibonacci number
		twoBack = temp; //number in sequence two steps back for use in next iteration is current iterations one step back
		
		printFibonacci(n-1); //recursive call to method to continue calculating and printing out numbers of the sequence
	}
	
	public static void main(String[] args)
	{
		System.out.print("0 1 "); //prints out the first two numbers of the sequence
		printFibonacci(25); //print the next 25-2 numbers in the sequence
	}
}