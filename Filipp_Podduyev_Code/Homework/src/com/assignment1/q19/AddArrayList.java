package com.assignment1.q19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AddArrayList {
	/*
	 * Q19. Create an ArrayList and insert integers 1 through 10. Display the
	 * ArrayList. Add all the even numbers up and display the result. Add all the
	 * odd numbers up and display the result. Remove the prime numbers from the
	 * ArrayList and print out the remaining ArrayList.
	 */
	static int evenSum;
	static int oddSum;

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(arrList);
		System.out.println("Sum of Even Numbers: ");
		for (Iterator<Integer> iterator = arrList.iterator(); iterator.hasNext();) {
			Integer number = iterator.next();
			if (number % 2 == 0) {
				evenSum += number;
			}
			System.out.println(evenSum);
		}

		System.out.println("");
		System.out.println("Sum of Odd Numbers: ");
		for (Iterator<Integer> iterator = arrList.iterator(); iterator.hasNext();) {
			Integer number = iterator.next();
			if (number % 2 != 0) {
				oddSum += number;
			}
			System.out.println(oddSum);
		}

		boolean isPrime = false;
		for (int i = 0; i < arrList.size(); i++) {
			isPrime = checkPrime(arrList.get(i));
		}
		if (isPrime) {
			//arrList.remove(i);
		}
		System.out.println(arrList);
	}

	static boolean checkPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}
}
