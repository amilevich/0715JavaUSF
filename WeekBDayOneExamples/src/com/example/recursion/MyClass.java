package com.example.recursion;

public class MyClass {
	
	/*
	 * Recursion - is a process in which a method calls
	 * itself continuously. 
	 * A method in Java that calls itself is called a 
	 * recursive method.
	 * 
	 * The idea is to represent a problem in terms of 
	 * one or more smaller problems, and add one or more
	 * base conditions that stop the recursion.
	 */
	
//	static void hi(int x) {
//		if(x>0) {
//			hi(x-1);
//			System.out.println("hi XD");
//		}
//	}
	
	static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return(n * factorial(n-1));
		}
	}
	/*
	 * 4!
	 * factorial(4) -> 4 * factorial(3)
	 * -> 4 * 3 * factorial(2)
	 * -> 4 * 3 * 2 * factorial(1)
	 * -> 4 * 3 * 2 * 1
	 */
	


	
	/*
	 * fibonacci sequence:
	 * print out first 15 numbers
	 * 1, 1, 2, 3, 5, ...
	 */
	
	static int n1 = 0, n2 = 1;
	
	static void printFibo(int count) {
		if(count > 2) {
			int n3 = n1+n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibo(count - 1);
		}
	}
	public static void main(String[] args) {
		//hi(5);
		//System.out.println("Factorial of 4 is: " + factorial(4));
		//int count = 10;
		System.out.print(n1 + " " + n2);
		printFibo(10);
	}

}
