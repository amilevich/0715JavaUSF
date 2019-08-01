package com.qfour;
//Q4: calculate n!
public class Main {

	public static void main(String[] args) {
		int x = 5;
		System.out.println(factorial(x));
	}
	//recursive method to compute
	static int factorial(int num) {
		//break condition
		if(num == 1) {
			return 1;
		}
		//passes the number one less back into the method
		else {
			return num*factorial(num-1);
		}
	}

}
