package com.homework.quesone;

// Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).

public class QuesSixteen {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) System.out.println("You input " + args[i].length() + " characters"); // print out # characters that was input
	}
}
