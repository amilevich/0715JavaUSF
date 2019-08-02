package com.example.question2;

// Example from class

public class Fibonacci {
	public static void main(String[] args) {

		// Print 0 1, Fibo sequence continues by adding to it
		System.out.print(n1 + " " + n2);
		printFibo(25);

	}

	// static so can be called in the main method
	static int n1 = 0, n2 = 1;

	// method to perform the fibo sequence

	static void printFibo(int count) {
		if (count > 2) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibo(count - 1);

		}
	}
}