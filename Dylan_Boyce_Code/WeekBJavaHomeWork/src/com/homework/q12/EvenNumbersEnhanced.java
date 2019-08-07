package com.homework.q12;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbersEnhanced {
	
	public static void main(String[] args) {
		List<Integer> oneHundred = new ArrayList<>();  //ArrayList of Integers from 1 to 100
		
		int count = 1;
		while(count<=100) { //loop that populates the Array with Integers
			oneHundred.add(count);
			count++;
		}
		
		findEven(oneHundred);
	}
	
	
	static void findEven(List<Integer> list) {
		for(int number : list) {
			if(number%2 ==0) {
				System.out.println(number);
			}
		}
	}
	

}
