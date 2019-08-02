package com.questiontwo.fibonacci;

public class MyClass {

static int n1 = 0, n2 = 1; //Declaring the first two values in the sequence
	
	static void printFibo(int count) { 
		
		if(count > 0) {
			int n3 = n1 + n2; //base case
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibo(count -1);
			
		}
	}
	//Printing the sequence of first 25 numbers
	public static void main(String[] args) {
		System.out.print(n1 + " " + n2);
		printFibo(23);
	}
}
