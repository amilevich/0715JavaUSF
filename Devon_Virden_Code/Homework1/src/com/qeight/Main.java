package com.qeight;

import java.util.ArrayList;

//importing reverser from question 3
import com.qthree.Reverser;

//palindromes

public class Main {

	public static void main(String[] args) {
		//initialize arrays
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> pals= new ArrayList<String>();
		//fill original
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("sexes");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		for(int x = 0; x<strings.size();x++) {
			//using the reverse function from Reverser to compare the reverse to the original
			if(strings.get(x).equals(Reverser.reverse(strings.get(x)))) {
				pals.add(strings.get(x));
			}
		}
		//print them out
		System.out.print("Originals:\t[");
		for(int x = 0; x<strings.size();x++) {
			System.out.print(" "+strings.get(x)+" ");
		}
		System.out.print("]\nPalindromes:\t[");
		for(int x = 0; x<pals.size();x++) {
			System.out.print(" "+pals.get(x)+" ");
		}
		System.out.println("]");
	}

}
