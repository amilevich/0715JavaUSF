package com.homework.q4;

public class Factorial {

	public static void main(String[] args) {

		// factorial(25);
		System.out.println(factorial(25));

	}

	static int factorial(int n) {
		if (n == 1) {
			return (1);  //because factorial 1 is 1
		} else {
			return (n * factorial(n - 1)); //Recursive call to method, uses original parameter to multiply 
		}                                  //to new parameter which is one less than the previouse parameter
		
	}

}
