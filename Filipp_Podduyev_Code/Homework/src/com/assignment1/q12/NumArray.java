package com.assignment1.q12;

import java.util.stream.IntStream;

public class NumArray {
	/*
	 * Q12. Write a program to store numbers from 1 to 100 in an array. Print out
	 * all the even numbers from the array. Use the enhanced FOR loop for printing
	 * out the numbers.
	 */
	public static void main(String[] args) {
		int[] arr = IntStream.range(1, 100).toArray();

		for (int i: arr) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}
}