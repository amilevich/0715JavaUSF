package com.question13.triangle;

import java.util.Scanner;

public class Mytriangle {

	// create method that will produce the triangle
	static void rightTriangle(int number, int i, boolean flag) {

		if (i <= number) {
			for (int j = 1; j <= i; j++) {
				if (flag) {
					System.out.print("0 ");
					flag = false;
				} else {
					System.out.print("1 ");
					flag = true;
				}
			}
			System.out.println("");
//Implementation of the recursion method.
			rightTriangle(number, i + 1, flag);
		}

	}

	public static void main(String[] args) {
		
		//Scanner to get user input through the console
		Scanner sc = new Scanner(System.in);
		boolean flag = true;

//requests the number of columns desired to create the triangle.
		System.out.println("Enter the number of columns: ");
		int number = sc.nextInt();

		if (number > 0) {
			rightTriangle(number, 1, flag);
		} else {
			System.out.println("Number's jump can not be negative or zero");
		}
	}
}