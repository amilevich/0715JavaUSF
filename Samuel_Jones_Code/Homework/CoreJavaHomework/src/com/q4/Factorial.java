package com.q4;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fac = factorial(3); // save the returned value from the factorial method
		System.out.println(fac); // print this value
	}
	
	public static int factorial(int n) {
		if(n == 1) { // if n is one, just return 1;
			return 1;
		} else {
			return n * factorial(n-1); // otherwise, multiply n by one number less than itself (n-1), and repeat
		}
	}

}
