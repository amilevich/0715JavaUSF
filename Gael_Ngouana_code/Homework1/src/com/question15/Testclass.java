package com.question15;

/*
 * Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division.  
 * Create a class that implements this interface 
 * and provides appropriate functionality to carry out the required operations. 
 * Hard code two operands in a test class having a main method that calls the implementing class.
 */

//class implementing the interface
public class Testclass implements MyMultipleOperations {
	
	//Main method
	public static void main(String[] args) {
		
		//Instantiation of the class Testclass
		Testclass y = new Testclass();
		int a = 6;
		int b = 2;
		
		//prints out the results of the multiple operations
		System.out.println("Here we go:");
		y.addition(a,b);
		y.substraction(a,b);
		y.multiplication(a, b);
		y.division(a, b);
	
	}
	public static int a;
	public static int b;
	
	
	//addition method
	@Override
	public void addition(int a, int b) {
		int sum = a + b;
		System.out.println("Addition result:" +" "+sum);
		
	}
	//substraction method
	@Override
	public void substraction(int a, int b) {
		int substract = a - b;
		System.out.println("Substraction result:" +" "+substract);
	}
	//multiplication method
	@Override
	public void multiplication(int a, int b) {
		int product = a * b;
		System.out.println("Mutliplication result:" +" "+product);
	}
	//division method
	@Override
	public void division(int a, int b) {
		int quotient = a / b;
		System.out.println("Division result:" +" "+quotient);
	}
}
	


