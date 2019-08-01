package com.qtwelve;

public class Main {

	public static void main(String[] args) {
		// initialize
		int arr[] = new int[100];
		// populate
		for (int x = 0; x < 100; x++) {
			arr[x] = (x + 1);
		}

		System.out.println("Evens:");
		// enhanced for loop
		for (int i : arr) {
			// determine if even.
			if ((i % 2) == 0) {
				System.out.println("\t" + i);
			}
		}

	}

}
