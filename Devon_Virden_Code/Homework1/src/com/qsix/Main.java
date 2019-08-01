package com.qsix;

//Q6: figure if even or odd without modulus
public class Main {

	public static void main(String[] args) {
		int x = 68;
		evenChecker(x);
		int y = 79;
		evenChecker(y);
	}

	static void evenChecker(int x) {
		// if x is even, then (10x)/2 should be equal to x/2 rounded down then
		// multiplied by 10
		// I know we haven't used Math yet, but hopefully it's ok I used it
		if (((x * 10) / 2) == (Math.floor(x / 2) * 10)) {
			System.out.println(x + " is even.");
		} else {
			System.out.println(x + " is odd.");
		}
	}
}