package com.assignment1.q6;

public class EvenInteger {

	public static void main(String[] args) {
		int number = 4;

		int quotient = number / 2;
		if (quotient * 2 == number) {
			System.out.println(number + " is an even number");
		} else {
			System.out.println("This integer is not even");
		}
	}
}
