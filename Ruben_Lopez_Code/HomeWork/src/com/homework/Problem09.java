package com.homework;

import java.util.*;

public class Problem09 {
	
	//creates new array
	public static void main(String[] args) {
		
		//creates new array
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		//for loop of filling
		for (int i = 0 ; i < 101; i++) {
			aList.add(i);
		}
		for (int a : aList) {
			if (aList.get(a) == 0) {
				continue;
			}
			//throws a message just in case of error
			if (aList.get(a) == 101) {
				System.out.println("wat u doing m8");
			}
			//if the number is prime then print
			if (isPrime(aList.get(a))) {
				System.out.println(a);
			}
		}
	}

	private static boolean isPrime(Integer integer) {
		// TODO Auto-generated method stub
		
		//generates a series of numbers to check if true
		for ( int j = 3; j < integer; j++) {
			if (integer % j == 0) {
				return false;
			}
		}
		return true;
	}
	

}
