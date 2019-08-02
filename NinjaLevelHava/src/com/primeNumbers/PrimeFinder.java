package com.primeNumbers;
import java.math.*;
import java.util.ArrayList;
public class PrimeFinder {
	//Q9. Create an ArrayList which stores numbers from 1 to 100
	//and prints out all the prime numbers to the console.

	//I did some research on java.math and found the BigInteeger class
	//that has a built in method that finds prime numbers.
	
	static boolean checkPrime(long n) //the checkPrime method will return true if the number is prime
    { 
        // Converting long to BigInteger 
        BigInteger b = new BigInteger(String.valueOf(n)); 
  
        return b.isProbablePrime(1); 
    } 
	public static void printPrime(int x) {  //the printPrime method calls the checkPrime method and prints the number only if it is true.
		if(checkPrime(x)) {
			System.out.print(x+" ");
		}
	}
	
	

	public static void main(String[] args) {
		

		ArrayList<Integer> drake = new ArrayList<Integer>();
		//I called my ArrayList drake because it goes from zero to 100...
		
		for(int i = 0; i <= 100; i++) {
			drake.add(i);
			printPrime(i);
			
		
		}
	}
}
	
	


