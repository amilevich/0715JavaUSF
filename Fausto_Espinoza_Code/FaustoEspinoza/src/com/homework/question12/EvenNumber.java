package com.homework.question12;

import java.util.ArrayList;
import java.util.ListIterator;

public class EvenNumber {
	//Method evenNumber
	static void populatenumber(int[] arr) {
		
		
		for(int i = 1; i <= 100; i++ ) {
			
			arr[i-1] = i;
			System.out.print(arr[i-1] + " ");
		}
		System.out.print("\n");
	}
	
	
	//Method printList
	static void evenNum(int[] arr) {
		
		for(int a : arr) {
			if(a % 2 == 0) {
				System.out.print(a + " ");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] arr  = new int[100];
		
		System.out.println("Numbers 1 to 100");
		populatenumber(arr);
		//Get the even number
		System.out.println("Even Numbers");
		evenNum(arr);
		
		
		
	}

}
