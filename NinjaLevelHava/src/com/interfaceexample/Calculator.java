package com.interfaceexample;

public class Calculator implements CalculatorInterface {
	
	

	public static void main(String[] args) {
		
		int ten = 10;
		int two = 2;
		
		Calculator testInterface = new Calculator();
		
		testInterface.addition(ten, two);
		testInterface.subtraction(ten, two);
		testInterface.multiplication(ten, two);
		testInterface.division(ten, two);
		

	}

	@Override
	public void addition(int x, int y) {
		// TODO Auto-generated method stub
		int sum = x + y;
		System.out.println(sum);
	}

	@Override
	public void subtraction(int x, int y) {
		// TODO Auto-generated method stub
		int remainder = x - y;
		System.out.println(remainder);
	}

	@Override
	public void multiplication(int x, int y) {
		// TODO Auto-generated method stub
		int product = x * y;
		System.out.println(product);
	}

	@Override
	public void division(int x, int y) {
		// TODO Auto-generated method stub
		int divideeAnswer = x / y;
		System.out.println(divideeAnswer);
	}

}
