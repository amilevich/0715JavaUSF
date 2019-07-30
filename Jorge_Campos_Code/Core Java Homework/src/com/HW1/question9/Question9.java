package com.HW1.question9;

import java.util.ArrayList;

public class Question9 {
	// Create an ArrayList which stores numbers from 1 to 100
	// and prints out all the prime numbers to the console

	static boolean isPrime(int n) { 	// method to check if integer is prime, returns true if is
		if(n == 1)						// prime, false if it is not
				return false;
		for (int i = 2; i < n; i++) { 	
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 1; i <= 100; i++)					//create ArrayList with numbers 1 to 100
			arrList.add(i);

		System.out.println("Prime numbers: ");
		for (int i = 0; i < arrList.size(); i++) { // for loop to check all elements one by one
			if (isPrime(arrList.get(i)))			// if they are a prime integer it is printed to the console
				System.out.print(arrList.get(i) + " ");
		}
	}
}
