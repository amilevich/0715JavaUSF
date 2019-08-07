package com.homework.q1;

public class BuubleSort {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		int length = arr.length; // assigning array length to a variable named length for readability
		for (int i = 0; i < length - 1; i++) { 
			for (int j = 0; j < length - i - 1; j++) { 
				if (arr[j] > arr[j + 1]) {
					swap(arr, j);
				}
			}
		}

		for (int i = 0; i < length; i++) { // Prints the sorted array
			System.out.println(arr[i]);

		}
	}

	static void swap(int[] arr, int j) {
		int temp = arr[j]; // Lines 12-14 swap elements in adjacent index locations if the
		arr[j] = arr[j + 1]; // the first element is larger than the element to the right of it
		arr[j + 1] = temp;
	}
}
