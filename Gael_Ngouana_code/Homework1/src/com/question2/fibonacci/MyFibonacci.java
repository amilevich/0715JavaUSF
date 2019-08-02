package com.question2.fibonacci;

public class MyFibonacci {
	
	//declaring variables
	static int x1= 0;
	static int x2= 1;
	
	//Method implementing the Fibonacci.
	public static void myFib(int counter) {
	
		if(counter > 2) {
		
		int x3 = x2 + x1;
		 
		//Updating the variables
		x2 = x3;
		 x1 = x2;
		
		System.out.print(" "+ x3);
		
		//Updating the count
		myFib(counter - 1);
		
	
		}

	}
	
	public static void main(String[] args) {
		
		System.out.print(x1+ " "+ x2 );
		
		myFib(25);
		
	}
	
}	
	


