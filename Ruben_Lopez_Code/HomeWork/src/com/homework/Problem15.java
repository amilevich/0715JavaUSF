package com.homework;

import com.problem11.SomeInterface;

public class Problem15 implements SomeInterface {
	
	//makes an object where the element contains is a double primitive data type
	private double b1 = 0.0;
	//private double b2 = 0.0;
	
	public Problem15(double b1){
		this.b1 = b1;
		//this.b2 = b2;
	}
	
	public String toString() {
		
		return " " + this.b1;
	}
	
	
	

	@Override
	public Problem15 addition(Problem15 other) {
		// TODO Auto-generated method stub
		this.b1 += other.b1;
        //this.b2 += other.b2;
        return this;
	}

	@Override
	public Problem15 substraction(Problem15 other) {
		// TODO Auto-generated method stub
		this.b1 -= other.b1;
		//this.b2 -= other.b2;
		return this;
	}

	@Override
	public Problem15 multiplication(Problem15 other) {
		// TODO Auto-generated method stub
		this.b1 *= other.b1;
		//this.b2 *= other.b2;
		return this;
	}

	@Override
	public Problem15 division(Problem15 other) {
		// TODO Auto-generated method stub
		this.b1 /= other.b1;
		//this.b2 /= other.b2;
		return this;
	}
	//Write a program that defines an interface having the following methods:
	//addition, subtraction, multiplication, and division.  
	//Create a class that implements this interface and provides appropriate functionality to carry out the required operations.
	//Hard code two operands in a test class having a main method that calls the implementing class.
	public static void main(String[] args) {
		System.out.println("oi");
		Problem15 a = new Problem15(3);
		Problem15 b = new Problem15(2);
		//3 + 2
		
		a = a.addition(b);
		
		System.out.println(a);
		
		//5 * 2
		b = b.multiplication(a);
		
		System.out.println(b);
		
		//Actual operandOverwriting is not possible
	}
}
