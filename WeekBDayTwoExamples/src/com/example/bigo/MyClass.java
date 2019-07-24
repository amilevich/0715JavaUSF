package com.example.bigo;

public class MyClass {

	public static void main(String[] args) {

	}
	
	void foo(int[] array) {		//O(A+B) = O(N)
		int sum = 0;
		int product = 1;
		for(int i = 0; i<array.length; i++) {
			sum = +array[i];
		}
		for(int i = 0; i<array.length; i++) {
			product *= array[i];
		}
		System.out.println(sum + ", " + product);
	}
	
	void printPairs(int[] array) {
		for(int i=0; i <array.length; i++) {
			for(int j=0; j<array.length; j++) {
				System.out.println(array[i] + ", " + array[j]);
			}
		}
	}
	//the inner for loop has O(N) iterations and it is called
	// N times.
	//O(N^2)

}
