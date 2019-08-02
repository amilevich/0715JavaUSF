package com.example.question18;

import java.util.Scanner;

public class SuperConcrete extends Concrete {

	private static String name;

	private static String number;

	public static void main(String[] args) {

		SuperConcrete word = new SuperConcrete();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name: ");

		name = sc.nextLine();

		System.out.println("Enter a number: ");

		number = sc.nextLine();


		System.out.println("Any capital letters: " + word.hasUpperCase() + " " + name);


		word.toUpperCase();

		System.out.println("All Caps: " + name);


		System.out.println("Number plus 10: " + word.add());

	}

	@Override

	public boolean hasUpperCase() {

		for (int i = 0; i < name.length(); i++)

		{

			if (Character.isUpperCase(name.charAt(i)))

				return true;

		}

		return false;

	}

	@Override

	public void toUpperCase() {

		name = name.toUpperCase();

	}

	@Override

	public int add() {

		return Integer.parseInt(number) + 10;

	}

}
