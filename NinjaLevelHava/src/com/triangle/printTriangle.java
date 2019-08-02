package com.triangle;

public class printTriangle {

	/*
	 * Q13. Display the triangle on the console as follows using any type of loop.
	 *   Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

	 */
	public static void main(String[] args) {
		
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(((i+j)%2)+" ");
			}System.out.println();
		}

	}

}