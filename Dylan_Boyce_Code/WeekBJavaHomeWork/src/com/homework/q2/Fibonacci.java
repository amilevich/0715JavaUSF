package com.homework.q2;

public class Fibonacci {
	
public static void main(String[] args) {
		
		System.out.print(n1 + " " + n2); //Prints out the first numbers of the fibonacci sequence
		sequenceDeFibo(25);
	}
	
	// Write a program to display the first 25 Fibonacci numbers beginning at 0
	
static int n1 = 0;
static int n2 = 1;
	
	static void sequenceDeFibo(int count) {
		if(count > 2) {  //We establish the condition "greater than two" because our instance variables take care of numbers 1 and 0 for us
			int sum = n1+n2; //Adding the last 2 numbers in the sequence to generate a new number
			n1 = n2; //moving the values up to maintain the tail end operations of sequence
			n2 = sum;
			System.out.print(" " + sum);
			sequenceDeFibo(count-1); //decreasing count, this method takes the max desired fibonacci sequence and works backwards.
		}
	}
	
	
	

}
