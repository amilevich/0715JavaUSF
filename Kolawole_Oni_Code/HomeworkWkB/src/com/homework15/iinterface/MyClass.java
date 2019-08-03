package com.homework15.iinterface;

import java.io.IOException;
import java.util.Scanner;

class InterfaceClass implements Operations {

	// Method add numbers
	
    @Override
	public double setAddition(double... a) {
		double i = 0.0;
		if (a.length - 1 > 0) {
			for (double number : a) {
				i += number;
			}
		} else
			i = a[a.length - 1];
		return i;
	}

	// Method subtract numbers
	public double setSubtraction(double... a) {
		double i = 0.0;
		if (a.length - 1 > 0) {			
			for (int number = 0 ; number < a.length ; number++) {				
				if(number == 0) i = a[number];
				else i -= a[number];
			}
		} else
			i = a[a.length - 1];
		return i;
	}

	// Method multiply numbers
	public double setMultiplication(double... a) {
		double i = 1.0;
		if (a.length - 1 > 0) {
			for (double number : a) {
				i *= number;
			}
		} else
			i = a[a.length - 1];
		return i;
	}

	// Method divide numbers

	public double setDivision(double... a) {
		double i = 1.0;
		if (a.length - 1 > 0) {			
			for (int number = 0 ; number < a.length ; number++) {
				
				if( a[number] == 0) {
					System.out.println("You can't divide zero");
					return a[number];
				}
				if(number == 0) i = a[number];
				else i /= a[number];
			}
		} else
			i = a[a.length - 1];
		return i;
	}
}

public class MyClass {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		InterfaceClass calc = new InterfaceClass();
		int op;

		do {
			System.out.println(" 1 -> Addition ");
			System.out.println(" 2 -> Sustraction ");
			System.out.println(" 3 -> Multiplication ");
			System.out.println(" 4 -> division ");
			System.out.println(" 5 -> Salir ");
			int count = 0;
			int number;
			double[] arr ;
			System.out.print("Select the option ");
			op = scn.nextInt();
			switch (op) {
				case 1:
					count = 0;
					do {
						System.out.print("How many numbers at least you have to enter one numbers ");
						number = scn.nextInt();
						if (number < 0) {
							System.out.println("number has to be bigger than 1");
						}
					} while (number < 0);
					//Enter the number to make operation
					arr = new double[number];
					do {
						System.out.print("Enter number: " + (count + 1) + " ");
						double add = scn.nextDouble();
						//Store a array
						arr[count] = add;
						count++;
					} while (count < number);
	
					System.out.println("The addition is: " + calc.setAddition(arr));
					scn.nextLine();
					break;					
				case 2:
					count = 0;
					do {
						System.out.print("How many numbers at least you have to enter one numbers ");
						number = scn.nextInt();
						if (number < 0) {
							System.out.println("number has to be bigger than 1");
						}
					} while (number < 0);
					//Enter the number to make operation
					arr = new double[number];
					do {
						System.out.print("Enter number: " + (count + 1) + " ");
						double add = scn.nextDouble();
						//Store a array
						arr[count] = add;
						count++;
					} while (count < number);
	
					System.out.println("The subtraction is: " + calc.setSubtraction(arr));
					scn.nextLine();
					break;
				case 3:
					count = 0;
					do {
						System.out.print("How many numbers at least you have to enter one numbers ");
						number = scn.nextInt();
						if (number < 0) {
							System.out.println("number has to be bigger than 1");
						}
					} while (number < 0);
					//Enter the number to make operation
					arr = new double[number];
					do {
						System.out.print("Enter number: " + (count + 1) + " ");
						double add = scn.nextDouble();
						//Store a array
						arr[count] = add;
						count++;
					} while (count < number);
	
					System.out.println("The multiplication is: " + calc.setMultiplication(arr));
					scn.nextLine();
					break;
				case 4:
					count = 0;
					do {
						System.out.print("How many numbers at least you have to enter one numbers ");
						number = scn.nextInt();
						if (number < 0) {
							System.out.println("number has to be bigger than 1");
						}
					} while (number < 0);
					//Enter the number to make operation
					arr = new double[number];
					do {
						System.out.print("Enter number: " + (count + 1) + " ");
						double add = scn.nextDouble();
						//Store a array
						arr[count] = add;
						count++;
					} while (count < number);
	
					System.out.println("The division is: " + calc.setDivision(arr));
					scn.nextLine();
					break;
				

			}

		} while (op != 5);
		
		

		scn.close();
	}
	
	
}