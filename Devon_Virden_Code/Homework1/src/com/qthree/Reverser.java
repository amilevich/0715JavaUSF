package com.qthree;

//making a class to simplify Q8
public class Reverser {
	public static String reverse(String string) {
		// adds the last element of the original string and tags in onto the end of the
		// string
		for (int x = 0; x < (string.length() - x); x++) {
			// by removing x above we prevent stack overflow, since the string would grow
			// indefinately
			string = string + string.charAt(string.length() - (2 * x) - 1);// will point to the wanted value of the
																			// original array
		}
		// makes string the second half of string, ie the reversed bit
		string = string.substring(string.length() / 2, string.length());

		return string;
		// I probably made this more complicated than I had to, but a brute force
		// solution is still a solution
	}
}
