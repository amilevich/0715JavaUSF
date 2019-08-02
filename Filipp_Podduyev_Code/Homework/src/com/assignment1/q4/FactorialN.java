package com.assignment1.q4;

public class FactorialN {
	static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return (n * factorial(n - 1));
	}

	public static void main(String args[]) {
		int i, factorial = 1;
		int number = 4;
		factorial = factorial(number);
		System.out.println("Factorial of " + number + " is: " + factorial);
	}
}
