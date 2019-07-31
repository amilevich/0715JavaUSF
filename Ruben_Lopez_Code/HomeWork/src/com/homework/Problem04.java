package com.homework;

public class Problem04 {
	
	public static void main(String[] args) {
		int factorial = 8; //Lets do for 8 laugh out loud
		
		//calls find factorial
		factorial = findFactorial(factorial);
		
		System.out.println(factorial);
	}

	private static int findFactorial(int factorial) {
		// TODO Auto-generated method stub
		
		//instantiates first factorial
		int N = 1;
		for (int i = 1 ; i <= factorial; i++) {
			N = N * i;

		}
		
		
		return N;
	}

}
