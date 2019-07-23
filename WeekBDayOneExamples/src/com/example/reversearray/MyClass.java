package com.example.reversearray;

public class MyClass {
	/*
	 * reverse the elements in an array
	 */
	// Solution by NickTM
	// public static void main(String[] args) {
	// int[] arr = { 1, 5, 8, 5, 500, 3, 23, 66 };
	// reverse(arr);
	// }
	//
	// static void reverse(int[] original) {
	// for(int i=original.length -1; i >= 0; i--) {
	// System.out.println(original[i]);
	// }
	// }


	
//	static void reverseRecur(int index, int [] original, int[] reversed) {
//		
//	}
	
//	static void reverseJohn(int[] original) {
//		for(int i = 0; i<original.length/2; i++) {
//			int temp = original[original.length - 1 - i];
//			original[original.length -1 -i] = original[i];
//			original[i] = temp;
//		}
//	}
	public static void main(String[] args) {
		int[] arr = { 1, 5, 8, 5, 500};
		//reverseJohn(arr);
		//printArray(arr);
		reverseNick2(arr, arr.length-1);
	}
	
	static void reverseNick2(int[] original, int n) {
		if(n>=0) {
			System.out.println(original[n]);
			reverseNick2(original, n-1);
		}
	}
	
	static void printArray(int arr[]) {
		int n = arr.length;
		for(int i = 0; i< n; i++) {
			System.out.println(arr[i]);
		}
	}

}

