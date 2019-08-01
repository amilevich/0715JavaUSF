package com.qnine;
// print the prime numbers

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			nums.add(i);
		}
		System.out.println("Primes:");
		for(int i = 0; i< nums.size(); i++) {
			if(isPrime(nums.get(i))) {
				System.out.println("\t"+nums.get(i));
			}
		}
	}
	static boolean isPrime(int num) {
		//Linear search of decreasing size that returns true if the input integer is prime, false if not.
		for (int i = 2; i <= num / i; i++) {
			if (num % i == 0) {
				return false;

			}
		}
		return true;
	}
}



