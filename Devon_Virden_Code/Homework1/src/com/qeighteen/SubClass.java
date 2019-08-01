package com.qeighteen;

//I'm going to be using the fact each character has a defined ASCII value in this subclass a lot
public class SubClass extends SuperClass {

	@Override
	public boolean upperCase(String string) {
		for (int x = 0; x < string.length(); x++) {
			if (string.charAt(x) >= 65 && string.charAt(x) <= 90) {
				// figure if the value at each index is uppercase and return true if it is
				return true;
			}
		}
		return false;
	}

	@Override
	public String toUpperCase(String string) {
		String uppercase = new String();
		// I'm just going to assume using .toUpperCase is cheating given how the other
		// questions have been.
		for (int x = 0; x < string.length(); x++) {
			// using the ASCII values to determine if its uppercase or lower case, and
			// converting to upper if need be.
			char temp = string.charAt(x);
			if (temp >= 97 && temp <= 122) {
				// convert lower case to upper case
				uppercase += (char) (temp - 32);
			} else {
				// any other option
				uppercase += temp;
			}

		}
		return uppercase;
	}

	@Override
	public int toIntPlus10(String string) {
		int num = 0;
		// add each character up individually
		for (int x = 0; x < string.length(); x++) {
			num += string.charAt(x);
		}
		return num + 10;
	}

}
