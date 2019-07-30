package com.homeworkcoreJava.q2;

//Answer to Question 2:
//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.
//Barton Carson
public class Question2 {

	
	static int n1 = 0, n2 = 1;
	public static void main(String[] args) {
		
		System.out.print(n1 + " ");
		System.out.print(n2 + " ");
		Fibonacci(23);
	}
	
	// Function to calculate the third Fibonacci number onwards, assuming the first two are printed in the main function 
	static void Fibonacci(int count) {
		
		// if count is above two, calculate sum of the previous two numbers
		// uses recursion to terminate
		if (count > 2) {
			int n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");
			Fibonacci(--count);
		}	
	}
}