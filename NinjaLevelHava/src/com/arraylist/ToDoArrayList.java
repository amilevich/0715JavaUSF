package com.arraylist;

import java.math.BigInteger;
import java.util.ArrayList;

import com.primeNumbers.PrimeFinder;

public class ToDoArrayList {
/*
 * Q19. Create an ArrayList and insert integers 1 through 10.
 *  Display the ArrayList.
 *   Add all the even numbers up and display the result.
 *    Add all the odd numbers up and display the result. 
 *    Remove the prime numbers from the ArrayList and print out the remaining ArrayList.

 */
	public static void main(String[] args) {
		
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println("Here is the original list"+list);
		
		int even = 0, odd = 0;
		for(int i = 0; i <= list.size(); i++) {
			if((i%2)==0) {
			even +=i;	
			}else {
				odd +=i;
			}
		}System.out.println("The sum of the even numbers is "+even);
		System.out.println("The sum of the odd numbers is "+odd);
		
		
		for(int i = 0; i <= list.size()-1; i++) {
			if(checkPrime(i)) {
				list.remove(i);
			}
		}System.out.println("Here is the list without prime numbers "+list);

		
				

	}
	 public static boolean checkPrime(long n) //the checkPrime method will return true if the number is prime
	    { 
	        // Converting long to BigInteger 
	        BigInteger b = new BigInteger(String.valueOf(n)); 
	  
	        return b.isProbablePrime(1); 
	    } 


}
