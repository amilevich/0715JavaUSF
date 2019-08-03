package com.homework2.fibonacci;

public class FibonacciDisplay {
	
	//To display the first 25 fibonacci numbers begining at 0
	
	

	
	
	
	static int j = 1;
	//Method  that generate Fibonacci numbers
	//will set static int condition
	//will write method that takes int count
	static void getFibonacci(int nr, int i, int k) {
		if(nr > 0) {
			System.out.print(i + " "); //Print the Fibonacci 
			j +=k;
			getFibonacci(nr-1, j, i); //Call recurrence
		}
	}
	
//	 0 1 1 2 3 5 8 13 21 34 55 89
	//will construct a main method to use conditions in int count 
	public static void main(String[] args) {
		
		int number = 25;
		//Send the number and two values start at zero
		getFibonacci(number, 0, 0);		
		
	}

}
