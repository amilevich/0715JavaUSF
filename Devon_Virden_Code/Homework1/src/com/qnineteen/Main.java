package com.qnineteen;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int x = 1; x <= 10; x++) {
			nums.add(x);
		}
		System.out.println("Original:\t" + nums);
		int evenSum = 0;
		int oddSum = 0;
		int x = 0;
		// I have my reasons for using a while loop here
		while (x < nums.size()) {
			// increment evens or odds
			if ((nums.get(x) % 2) == 0) {
				evenSum += nums.get(x);
			} else {
				oddSum += nums.get(x);
			}
			// might as well combine both the increment and prime search into one loop
			if (isPrime(nums.get(x))) {
				nums.remove(x);
				// by removing an element, I bring the end closer to x, and the new index at x
				// was at x+1, so I don't want to increment x
			} else {
				x++;
			}
		}
		//print it all out
		System.out.println("Even Sum:\t"+evenSum);
		System.out.println("Odd Sum:\t"+oddSum);
		System.out.println("Primeless:\t"+nums);

	}

	static boolean isPrime(int num) {
		// Linear search of decreasing size that returns true if the input integer is
		// prime, false if not.
		for (int i = 2; i <= num / i; i++) {
			if (num % i == 0) {
				return false;

			}
		}
		return true;
	}

}
