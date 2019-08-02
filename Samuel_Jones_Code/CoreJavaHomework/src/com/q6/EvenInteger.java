package com.q6;

public class EvenInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 77;
		int s = 20;
		
		isEven(i); // is i even?
		isEven(s); // is s even?
	}
	
	static void isEven(int n) { // primary method
		boolean flag = true; //set up a boolean flag
		for(int x = 0; x<n; x++) { //swap the flag to its opposite n-1 number of times
			flag = !flag;
			
		}
		
		if(flag) { // if the flag is true, then the loop ran an even number of times, and the number is even
			System.out.println("Even");
		}
		else {
			System.out.println("Odd"); // if flag is false, the loop ran an odd number of times, and the number is odd.
		}
	}

}
