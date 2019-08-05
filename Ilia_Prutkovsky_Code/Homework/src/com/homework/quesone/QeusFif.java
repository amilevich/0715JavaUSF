package com.homework.quesone;

import java.util.Scanner;

public class QeusFif implements QuesFifteen {
	
	public static void main(String[] args) {
		
		QuesFifteen obj = new QeusFif();
		Scanner scan = new Scanner(System.in); // create a new object for class Scanner
		System.out.print("Input first number: ");
		int num1 = scan.nextInt(); // assign variable num1 with type integer to digit that was inputed from console
		System.out.print("Input second number: ");
		int num2 = scan.nextInt(); // assign variable num2 with type integer to digit that was inputed from console
		scan.close(); // close Scanner class if no more input from console
		
		obj.addition(num1, num2);
		
		obj.subtraction(num1, num2);
		
		obj.multiplication(num1, num2);
		
		obj.division(num1, num2);
	}
	
	@Override
	public void addition(int num1, int num2) {		
		System.out.println(num1 + num2);
	}
	
	@Override
	public void subtraction(int num1, int num2) {		
		System.out.println(num1 - num2);
	}
	
	@Override
	public void multiplication(int num1, int num2) {		
		System.out.println(num1 * num2);		
	}
	
	@Override
	public void division(int num1, int num2) {		
		System.out.println(num1 / num2);
	}
}
