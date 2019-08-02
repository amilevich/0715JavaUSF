package com.question19.myarraylist;

import java.util.ArrayList;
import java.util.ListIterator;

public class MyObject {
	
	static boolean b = false;

	public static void main(String[] args) {
		
		ArrayList<Integer> my_Arr = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			
			my_Arr.add(i);
			
			//Displays the arraylist containing numbers from 1 ton 10
		} System.out.println("Display of arraylist:" + " "+ my_Arr);
		
		int evenNumb = 0;
		int oddNumb = 0;
		
		//Loop that traverses the arraylist.
		for (int i=0; i<my_Arr.size(); i++) {
		    
			//Try to determine whether the number is even or odd.
		    if(my_Arr.get(i)%2 == 0) {
		    	
		    	//Add even numbers to the arraylist when condition is satisfied.
		    	evenNumb += my_Arr.get(i);
		    	
		    	//Add odd number to the arraylist.
		    } else { oddNumb += my_Arr.get(i);}
		    
		}
		System.out.println("The sum of all even numbers is:" +" "+ evenNumb);
		System.out.println("The sum of all odd numbers is:" + " "+ oddNumb);
		
		ListIterator<Integer> iterator = my_Arr.listIterator();
		
		//traverses the arralist.
		while(iterator.hasNext()) {
			
			int x = iterator.next();
			
			//Checks if number is prime.
			if(isPrime(x)) {
				iterator.remove();
			}
			
			
		}
		System.out.println("Display of arraylist with no prime numbers:" + " "+my_Arr);
	}
	
	//Creates a method that identifies prime numbers.
	static boolean isPrime(int n) {
		
		int count = 0;
		for(int j = 1; j <= n; j++) {	
				
			if(n%j == 0) {
				 count = count + 1;
				 
				}
				 	 
					 
				 }
		if(count == 2) {
			
			return true;
					 
				 }
				
				return false;
			
			}
		
}

		
