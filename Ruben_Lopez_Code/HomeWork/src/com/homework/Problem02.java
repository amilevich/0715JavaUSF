package com.homework;

public class Problem02 {
	
	public static void main(String[] args) {
		
		//Simple for loop for printing items
		for (int i = 0; i < 26 ; i++) {
			System.out.println(fib(i));
		}
	}
	
	//the true recursion function
	static int fib(int n) {
		if (n==0) {
			return 0;
		} else if ( n== 1) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
}
