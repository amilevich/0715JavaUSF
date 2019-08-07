package com.homework.q10;

public class TernaryOperators {
	public static void main(String[] args) {
		isSmaller(45,88);
		
		
	}
	
	static void isSmaller(int num1, int num2) {
		int smallest=0;
		smallest = ((num1>num2) ? num2 : num1); //If the condition is true or false it prints the smaller number
		System.out.println(smallest);
	}
}
