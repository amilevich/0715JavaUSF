//q20: reader
package com.qtwenty;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		try {
			// initialize arrays to hold the terms
			ArrayList<String> names1 = new ArrayList<String>();
			ArrayList<String> names2 = new ArrayList<String>();
			ArrayList<String> names3 = new ArrayList<String>();
			ArrayList<String> names4 = new ArrayList<String>();
			// initialize reader and misc variables
			FileReader rdr = new FileReader("./Data.txt");
			int n = 0;
			ArrayList<String> temp = new ArrayList<String>();
			String tempS = new String();
			int i;
			while ((i = rdr.read()) != (-1)) {
				// determines arrays to add the strings to
				if (n == 0) {
					temp = names1;
				} else if (n == 1) {
					temp = names2;
				} else if (n == 2) {
					temp = names3;
				} else if (n == 3) {
					temp = names4;
				}
				// determines what the char is at the current point. if it's a ":" or a line
				// feed, it cuts off the string, puts it into the array, and resets the string.
				// Otherwise it adds the character to the correct String.
				char c = (char) i;
				if (c == ':') {
					temp.add(tempS);
					tempS = "";
				} else if (c == '\n') {
					//still tacked on the line feed to the string, so I cut it off
					tempS = tempS.substring(0, tempS.length() - 1);
					temp.add(tempS);
					tempS = "";
					n++;
				} else {
					tempS += c;
				}
			}
			// the loop cuts off before the last string is added, so I add it here
			names4.add(tempS);
			rdr.close();
			//print them out
			printer(names1);
			printer(names2);
			printer(names3);
			printer(names4);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// just a printer to print it out
	static void printer(ArrayList<String> arr) {
		System.out.println("Name:\t" + arr.get(0) + " " + arr.get(1) + "\nAge:\t" + arr.get(2) + " years\nState:\t"
				+ arr.get(3) + " state\r");
	}

}
