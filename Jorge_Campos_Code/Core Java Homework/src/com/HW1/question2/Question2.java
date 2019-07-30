package com.HW1.question2;

public class Question2 {
	
	static int n1  = 0, n2 = 1;		//initial two fibonacci numbers
	
	static void printFibo(int count) {		
		if(count == 1) {
			System.out.print("0 ");
		}else if( count == 2) {			
			printFibo(count-1);
			System.out.print("1 ");
		}else if(count > 2) {			
			printFibo(count-1);		//recursively call method to generate fibonacci  
			int n3 = n1+n2;			// sequence of desired length
			n1 = n2;
			n2 = n3;
			System.out.print( n3 + " ");		
		}else
			System.out.println("Error, enter an integer greater than 0!");
	}

	public static void main(String[] args) {
		printFibo(25);
	}
}
