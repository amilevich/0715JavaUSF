package com.examples.arrays;

public class MyClass {
	/*
	 * array - collection of elements of the same type 
	 * and a fixed size
	 * 
	 */

	public static void main(String[] beardedLady) {
		
		int tempOne[] = { 1,2,3,4 };
		
//		System.out.println(tempOne[1]); //index starts at 0
		
		tempOne[2] = 8;
//		
//		System.out.println(tempOne[0] + " " + tempOne[3]);
		
		int tempTwo[] = new int[9004];
		//an array of size 9004
		//System.out.println(tempTwo);
		//int arrays are initialized as 0 by default
		
		
//		for(int i=0; i<tempTwo.length; i++) {
//			System.out.println(tempTwo[i]);
//		}
		
		//float -> 0.0f
		//boolean -> false
		//char -> '/u0000'/ unicode null character
		
		//.length - the length of the array
		//the easiest way to iterate over an array is a for loop
		//by using the arrayName.length as the end parameter
		
		
		Object objArray[] = new Object[5];
		
		String[] planets = { "Mercury", "Venus", "Earth", "Mars",
				"Jupiter"};
		
//		for(int i = 0; i<planets.length; i++) {
//			System.out.println(planets[i]);
//		}
//		System.out.println("In reverse: ");
//		
//		for(int i = planets.length - 1; i >= 0; i--) {
//			//since indexing is zero based,
//			//the last element has index array length minus one
//			System.out.println(planets[i]);
//		}

		int tempFour[][] = { {9,10,11}, {4,2,7}, {6,6,5} };
		//System.out.println(tempFour[1][0]);
		
		int tempFive[][][][][][][]; //totally possible
		
		int tempSix[][] = new int[10][12];
		tempSix[5][8] = 80;
		System.out.println(tempSix[5][8]);
	}

}
