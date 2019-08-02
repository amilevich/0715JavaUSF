package com.q19;

import java.util.ArrayList;
import java.util.ListIterator;

public class Q19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create an arraylist object, loop through ints 1 through 10 and add them to the arrList
		ArrayList<Integer> arrList = new ArrayList<>();
		for(int i=1; i<=10;i++) {
			arrList.add(i);
			
		}
		
		// Add the even numbers from 1 to 10
		System.out.println("Adding even numbers...");
		addEvens(arrList);
		
		// Add the odd numbers from 1 to 10
		System.out.println("Adding odds...");
		addOdds(arrList);
		
		// Remove the primes from 1-10, and print the leftover values
		System.out.println("Removing primes...");
		removePrimes(arrList);
		
	}
	
	// Method to add even no.s from 1 to 10
	public static void addEvens(ArrayList<Integer> arrList) {
			Integer sum = 0; // sum to add to
		
			for(Integer i: arrList) {
				if(i%2==0) { // if the Integer is evenly divisible by 2, add the number to the sum 
					sum+=i;
				}
			}
			
			System.out.println("Sum of all even numbers is: " + sum);
}

	// Adds the odds from 1 to 10
	public static void addOdds(ArrayList<Integer> arrList) {
		Integer sum = 0; // rolling sum variable
		for(Integer i: arrList) { 
			if(i%2!=0) { // if remainder != 0, it is odd
				sum+=i; // add to rolling sum
			}
	}
		System.out.println("Sum of all odd numbers is: "  + sum);
	}
	
	public static void removePrimes(ArrayList<Integer> arrList) {
		int x, halfLen = 0, flag=0; 
		// x is for looping through the arrList
		// halfLen holds half of the value of the Integer i
		// flag increments whenever a number is not prime
		ListIterator<Integer> iter = arrList.listIterator();
		
		// iterate through the arrList
		while(iter.hasNext()) {
			flag=0;
			Integer i = iter.next();
			halfLen= i/2;
			
			if(i!=1) {
				for(x=2; x<=halfLen;x++) { // if any number from 2 to half of the value of i goes evenly into i...
					if(i%x==0) {
						flag=1; // that value is not prime
						break; // break the loop
					}
				}
				// otherwise, no value between 2 and i/2 inclusive went evenly into i... therefore, it is prime
				if(flag==0) {
					iter.remove(); // remove the prime value
				}
			}
			
		}
		
		System.out.println("arrList with primes removed: ");
		displayNumbers(arrList);
	}
	
	public static void displayNumbers(ArrayList<Integer> arrList) {
		for(Integer i: arrList) {
			System.out.println(i);
		}
	}
}
