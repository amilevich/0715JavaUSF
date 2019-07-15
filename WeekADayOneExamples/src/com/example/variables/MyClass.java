package com.example.variables;

public class MyClass {
	

	/*
	 * what are variables? container for a value that is stored and identified in
	 * memory
	 * 
	 * variables have a type -> determines what sort of value it stores variables
	 * have a name ->this is what makes it possible to access the value
	 * 
	 * Primitive data types - variables that store simple values
	 * 
	 * 8 in Java: number types: int - 32 bits short - 16 bits long - 64 bits byte -
	 * 8 bits
	 * 
	 * floating-point types: float - 32 bits double - 64 bits
	 * 
	 * logical types: boolean - no memory allocation (1 bit)
	 * 
	 * character types: char - 16 bits
	 * 
	 */

	public static void main(String[] args) {

		int x; // the simplest variable declaration
		int y = 5; // we can give variables their values at declaration
		// this is called initialization

		double w = 2.0;
		byte b = 7;
		boolean bool = false;

		float f = 993.99f;
		// if ther is no f, remains a double

		int i = 362_893;
		System.out.println(i);
		// underscores make it easier to read

		// naming variables
		// case sensitive
		// can only use number, letters, $ and _ characters
		// cannot begin with a number
		// cannot be a reserved Java keyword
	}

}
