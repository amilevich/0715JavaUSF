package com.example.question4;

public class Factorial {
	
	public static void main(String[] args) {
		
		System.out.println("Factorial of 4 is: " + factorial(4));
		
	}
	
	// method will compute factorial
	
	static int factorial(int n) {
		if (n == 1) { // factorial of 1 is 1
			return 1;
		
	}
		else {
			
			return(n * factorial(n-1));
		}
}

}
