package com.assignment1.q2;

public class FiboNacci {
	
	public static void main(String[] args) {
		int count = 25;
		System.out.print(n1 + " " + n2);
		printFibo(count - 2);
	}
	
	
	static int n1 = 0, n2 = 1;

	static void printFibo(int count) {
		if (count > 0) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			
			printFibo(count-1);
		}
	}

}
