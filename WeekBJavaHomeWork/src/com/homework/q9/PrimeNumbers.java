package com.homework.q9;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	
	public static void main(String[] args) {
		List<Integer> oneHundred = new ArrayList<>();  //ArrayList of Integers from 1 to 100
		
		int count = 1;
		while(count<=100) { //loop that populates the Array with Integers
			oneHundred.add(count);
			count++;
		}
		
		findPrime(oneHundred);
	}
	
	
	static void findPrime(List<Integer> list) {
		for(int number : list) {
			if(number == 1) { //Omits 1 from list of primes
				continue;
			}else if(number == 2 || number == 3 || number == 5 || number ==7) { //Prints our first set of primes
			System.out.println(number);
		}else if(number%2 != 0 & number%3!=0 & number%5!=0 & number%7!=0) { //checks for non even division to identify primes
				System.out.println(number); //prints primes
			}else {
				continue;
			}
		}
	}

}
