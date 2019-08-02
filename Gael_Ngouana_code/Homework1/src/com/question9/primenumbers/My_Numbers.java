package com.question9.primenumbers;

import java.util.ArrayList;

public class My_Numbers {

			
	public static void main(String[] args) {
		
		//Create arraylist where numbers are stored.
		
		ArrayList<Integer> numb = new ArrayList<>();
		
		//The loop populates the arraylist.
		
		for(int i = 1; i <= 100; i++) {
			
			numb.add(i);
			
		}
		
		//Nested For loop to identify prime numbers.
		
		for(int j = 2; j <= 100; j++) {
			
			int count = 0;
			
			for(int i = 1; i <= j; i++) {
				
				int numb1 = j%i;
				
				
				if(numb1 == 0) {
				
				
				 count = count + 1;
				 
				}
				 	 
					 
				 }
			
			if(count == 2) {
				
				
					 System.out.println(j);
					 
				 }
				
				
			
			}
		}
		
		
		
		

	}


