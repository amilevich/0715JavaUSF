package com.HW1.question13;

import java.util.Scanner;

public class Question13 {
	//Display the triangle on the console using any type of loop

	public static void main(String[] args) {
		int row = 0;
		boolean bool = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of row: ");
		row = sc.nextInt();
		
		for(int i = 0; i<row; i++) {		//nested for loop to manage row and digits separately
			for(int j = 0; j<=i; j++) {
				if(bool) {					//boolean variable used to alternate between 0 and 1
					System.out.print("0 ");
					bool = !bool;
				}
				else {
					System.out.print("1 ");
					bool = !bool;
				}
				if(j==i)
					System.out.println();
			}
		}
		sc.close();
	}
}
