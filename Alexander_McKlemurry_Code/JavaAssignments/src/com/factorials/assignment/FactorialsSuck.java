package com.factorials.assignment;

public class FactorialsSuck { //I was a little stressed 

	
		public static void main(String[] args) { //main method
			
			factorial(10); //(10*9*8*7*6*5*4*3*2*1) 
			
		}

		public static void factorial(int y) {
			int times = 1; // starting point for the count. I do not use 0 because
			// anything times 0 is 0 so we would get nowhere in factorials.
			for(int g = 1; g <= y; g++) { //(for) keyword to start a loop and (g++) to 
				//increment the numbers
				times = times * g; //tells the system what times means
			}
			
			System.out.println(times); //tells the system to print out times * g which means the
			//system will print out the total number.
		}
	 
		
}
