package com.question6.evenorodd;

public class EvenOrOdd {

	public static void main(String[] args) {
		
		numbCheck(4);
		

	}
	
	static void numbCheck(int numb) {
		
		// divides the input by two and get the result in float form.
		
		float numb1 = (float)numb / 2;
		
		/*
		 * Checks to see if the ceiling of numb1 is equal to its floor.
		 * If the ceiling and the floor are equal, the number input is even. if not, the number input is odd. 
		 */
		if (Math.ceil(numb1) == Math.floor(numb1)){
			
			System.out.println(numb + " is even");
			
		}
			else {System.out.println(numb + " is odd");
		
		
		
		

}
}
}