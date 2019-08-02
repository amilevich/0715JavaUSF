package com.q2;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFibo(25);
	}
	
	
	public static void printFibo(int count) {
		int n1 = 0; //first fibo number is 0
		int n2 = 1; // second fibo number is 1
		int n3; // n3 will store the moving "next" value of the sequence, which changes every iteration
		int counter = 0; // this counter is for verifying the number of fibo numbers printed.
		if(count == 1) {
			System.out.println(n1); // if someone enters 1, then print 0;
		}
		if(count>1) {
			System.out.print(n1+" "); // if the count is greater than 0, then print 0
			counter++; // increment the counter.
			for(int i=0; i<count-1;i++) { // for as many iterations as it takes to reach the entered count
				n3 = n1 + n2; // add the prior two numbers in the sequence, save the sum as n3
				System.out.print(n3 + " "); // print n3
				n1 = n2; // for the next iteration, n1 will be n2
				n2 = n3; // n2 will be n3
				counter++; // increment the counter & repeat until count-1 is attained
			}
			System.out.println("\n this many numbers printed: " + counter); //finish off the print statements with a new line and the value of counter
		}
		
	}
}
