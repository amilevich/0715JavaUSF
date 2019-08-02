package com.example.question6;

import java.util.Scanner;

public class EvenWithoutModulus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter a number: ");

		int num = sc.nextInt();
		
		// logic of getting Modulus without us the % Operator

		if (num / 2 * 2 == num) {

			System.out.print("Even number: ");

		} else

			System.out.print("Odd number:  ");

	}

}
