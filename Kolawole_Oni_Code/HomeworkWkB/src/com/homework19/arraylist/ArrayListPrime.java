package com.homework19.arraylist;

public class ArrayListPrime {
	
	//Create int form 1 to 100 
	//Store them in an array
	//Extract the primes from your array 
	//Print out the primes from the array
	
	//static int[] arr = new int[100];
	
	//static int a = 0;
	//static int length = 100;
	
	public static void doSomething()
	{
	for(int a = 0; a <= 100; a++) {
		if (a%2 != 0 && a%3 !=0 && a%5 !=0 && a%7 != 0) {
			System.out.println(a);
		}
	}

}
	public static void main(String[]args) {
		// a = 0;
		doSomething();
	}
}