package com.example.question15;

public class Math implements MathOperations {

	public static void main(String[] args) {

		Math operation = new Math();
		
		// Calls two of the override methods to show functionality 


		System.out.println("The result of  a number added to another number: ");
		System.out.println(operation.addition(10, 20));


		System.out.println("The result of a number multiplied by another number: ");
		System.out.println(operation.multiplication(10, 5));
	}

	@Override
	public int addition(int x, int y) {
		int sum = x + y;
		return sum;
	}

	@Override
	public int subtraction(int x, int y) {
		int diff = x - y;
		return diff;
	}

	@Override
	public int multiplication(int x, int y) {
		int prod = x * y;
		return prod;

	}

	@Override
	public int division(int x, int y) {
		int divd = x / y;
		return divd;

	}
}
