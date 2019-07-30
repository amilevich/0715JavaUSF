package com.homework.question2;

public class FibonacciNumber {
	
	static int j = 1;
	//Method  that generate Fibonacci numbers
	static void getFibonacci(int n, int i, int k) {
		if(n > 0) {
			System.out.print(i + " "); //Print the Fibonacci 
			j +=k;
			getFibonacci(n-1, j, i); //Call recurrence
		}
	}
	
//	 0 1 1 2 3 5 8 13 21 34 55 89

	public static void main(String[] args) {
		
		int number = 25;
		//Send the number and two values start at zero
		getFibonacci(number, 0, 0);		
		
	}

}
