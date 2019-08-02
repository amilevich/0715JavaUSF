package q14;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
public class Switch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number between 1 and 3.");
		int cnum =sc.nextInt(); //assign the value to the variable.
		switch (cnum) {
		case 1:
			SquareNumber();
			break;
		case 2:
			TodayDate();
			break;
		case 3:
			stringarray();
			break;
		default: //Default output if the above statements are not met.
			System.out.println("Wrong Entry.");

		}

	}

	public static void SquareNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to find out it's square naumber");
		int num = sc.nextInt();
		int square = num * num; // Find the square number
		System.out.println("The Square Number Of the " + num + " is = " + square);

	}

	public static void TodayDate() {
		Date date = new Date(); // Display the today date.
		System.out.println(date);
	}

	public static void stringarray() {
		ArrayList<String> wordsplit = new ArrayList<>();

		String mystring = "I am learning Core Java";
		for (int i = 0; i < mystring.length(); i++) {
			int charat = mystring.charAt(i); // Find the ASCII value in the location.
			char word = (char) charat; // Convert that ASCII to Char.
			wordsplit.add(Character.toString(word)); // Convert from Char to String and stores in ArrayList.
		}
		System.out.println(wordsplit);

	}
}
