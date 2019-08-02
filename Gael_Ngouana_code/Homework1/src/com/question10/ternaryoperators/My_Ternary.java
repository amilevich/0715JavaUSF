package com.question10.ternaryoperators;

//Q10. Find the minimum of two numbers using ternary operators.


public class My_Ternary {

	public static void main(String[] args) {
		int a = 1000, b = 510, result;

		// evaluate if a is less than b or vis versa
		// and based on the result of the evaluation
		// we will have a minimum between the numbers
		result = (a < b) ? a : b;
		System.out.println("The minimum of the two numbers is"+" "+ result);
	}
}