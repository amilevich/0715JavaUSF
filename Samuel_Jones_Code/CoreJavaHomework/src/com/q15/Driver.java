package com.q15;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// calling all the methods to prove they work
		MathTeacher teach = new MathTeacher(); 
		double sum = teach.addition(1, 2);
		System.out.println("Sum: " + sum);
		
		double minus = teach.subtraction(2020, 1);
		System.out.println("Minus: " + minus);
		
		double product = teach.multiplication(40, 50);
		System.out.println("Product: " + product);
		
		double quotient = teach.division(40, 10);
		System.out.println("Quotient: " + quotient);
	}

}
