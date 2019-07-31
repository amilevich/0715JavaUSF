package com.homework;

public class Problem06 {
	
	public static void main(String[] args) {
		
		//instantiates variables 
		int A = 3;
		int B = 4;
		
		//checks if variables are even
		System.out.println(isEven(A));
		System.out.println(isEven(B));
	}

	private static boolean isEven(int a) {
		
		// TODO Auto-generated method stub
		
		//since we are performing integer division and multiplication
		//no mod value will be carried
		if ( a == ((a/2)* 2)){
			return true;
		} else {
			return false;
		}
	}

}
