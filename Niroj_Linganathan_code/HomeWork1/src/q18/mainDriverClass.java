package q18;

import java.util.Scanner;

public class mainDriverClass {

	public static void main(String[] args) {
		upperCaseAbstract obj = new upperExtendsClass(); //Create object for the subclass.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word to check the uppercase characters :");
		String word = sc.nextLine();
		obj.findUpper(word); //call the find upper method and pass the user input as the argument.
		

		System.out.println("Enter a lowercase word to convert to uppercase :");
		String word1 = sc.nextLine();
		obj.converUpper(word1); //call the convert upper method and pass the user input as the argument.

		System.out.println("Enter a numer to conver from string to Int and add 10 :");
		String num = sc.nextLine();
		obj.converInteger(num);  //call the convert integer method and pass the user input as the argument.
	}
}
