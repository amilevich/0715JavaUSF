package com.qfive;
//Q5: create a substring

public class Main {

	public static void main(String[] args) {
		String str = "Homework...";
		System.out.println(str);
		System.out.println(substring(str, 5));
	}

	//creating a static method to do it.n
	static String substring(String string, int idx) {
		// create a blank string
		String sub = new String();

		if (idx <= string.length()) {
			// takes us to idx-1
			for (int i = 0; i < idx; i++) {
				// adds the character at i to the substring
				sub += string.charAt(i);
			}
		} else {
			// human proofing it
			sub = "Nice try...";
		}

		return sub;
	}

}
