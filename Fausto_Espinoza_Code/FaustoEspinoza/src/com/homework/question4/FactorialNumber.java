package com.homework.question4;

public class FactorialNumber {
	
	static double j = 1; //initialization for j
	
	//Factorial method
	static double factorialN(int n) {
		if(n > 0) {
			j  *= (double) n;//multiplication j = j * k
			//call factorial recurrence and assign the value n-1 whe the method call itself
			factorialN(n-1);
		}
		return j;
	}

	public static void main(String[] args) {
		int n = 15;
		
		if(n > 0) {
			//Call the factorial method
			System.out.println("The factorial: " + n + " is " + factorialN(n));
		}else if(n == 0) {
			System.out.println("The factorial: " + n + " is " + 1);
		}else {
			System.out.println("Thhere is not factorial for negative numbers: " + n );
		}
			

	}

}
