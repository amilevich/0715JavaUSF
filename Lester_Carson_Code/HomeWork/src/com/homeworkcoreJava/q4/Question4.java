package com.homeworkcoreJava.q4;

//Answer to Question 4:
//Q4. Write a program to compute N factorial.
//Barton Carson
public class Question4 {

	public static void main(String[] args) {
		
		int N = 5;
		System.out.println(factorial(N));
	}
	
	//Function that uses recursion to calculate the factorial
	static int factorial(int n) {
		
		//Each time the function recurses, the result is multiplied to get the factorial
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return(n * factorial(n-1));
		}
	}
}