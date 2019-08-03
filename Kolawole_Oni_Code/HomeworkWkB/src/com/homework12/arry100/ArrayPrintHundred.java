package com.homework12.arry100;

public class ArrayPrintHundred {
	//Declare the array
	//Populate array /
	//Test it to check which ones are even
	//print the array of even 
   //static int[] arr = new int[100];
	
	//static int a = 0;
	//static int length = 100;
	
	public static void doSomething()
	{
	for(int a = 0; a <=  100; a++) {
		if (a%2 == 0) {
			System.out.println(a);
			//To store my result in an array in print console
		}
	}
}
	public static void main (String[]args) {
		
		doSomething();
	}
}