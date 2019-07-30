package com.homework.question19;

import java.util.ArrayList;
import java.util.ListIterator;

public class MyClass {
	
	//Method  gets the prime numbers
	static ArrayList<Integer> setArray(ArrayList<Integer> arr){
		
		ListIterator<Integer>iterator = arr.listIterator();
		
		while(iterator.hasNext()) {
			int i = iterator.next();
			boolean flag = false;
			//Verify is a prime number
			for(int j = 2 ; j < i ; j++ ) {
				if((i % j) == 0) {
					flag = true;
					break;
				}
			}
			//Remove Element
			if(!flag) {
				iterator.remove();
			}			
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		//Add the elements an ArraList
		for(int i =1 ; i<= 10; i++) {
			arr.add(i);
		}
		//Print the origina ArrayList
		for(Integer a : arr) {
			System.out.print(a + " ");
		}
		System.out.print("\n");
		
		ListIterator<Integer> iterator = arr.listIterator();
		
		int count = 0;
		//Verify if the numbers are even
		while(iterator.hasNext()) {
			int i = iterator.next();
			if(i % 2 == 0) {
				//Add all even numbers
				count += i;
			}
		}		
		
		
		System.out.println("The addition even is : " + count);
			
		count = 0;
		
		iterator = arr.listIterator();
		//Verify if the numbers are odd
		while(iterator.hasNext()) {
			int i = iterator.next();
			if(i % 2 != 0) {
				//Add all odd numbers
				count += i;
			}
		}		
	
		
	    System.out.println("The addition odd is : " + count);
		
		arr = setArray(arr);
		
		for(Integer a : arr) {
			System.out.print(a + " ");
		}
		System.out.print("\n");
	}

}
