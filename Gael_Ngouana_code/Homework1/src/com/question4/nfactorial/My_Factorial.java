package com.question4.nfactorial;

public class My_Factorial {

	public static void main(String[] args) {
		
		my_Fact(5);
		
		
	}
		
		
		static void my_Fact(int numb) {
			
			long temp = 1;
			
			//Loop that will implement the product of all the numbers
			// between 0 and the inclusive inserted number.
			for(int i = 1; i <= numb; i++) {
				 temp = temp * i;
				
				
				}
			
			System.out.println("The factorial of " + numb + " is " + temp);
			
			}

}
	
