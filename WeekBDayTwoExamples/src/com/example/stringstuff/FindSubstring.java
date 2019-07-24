package com.example.stringstuff;

public class FindSubstring {

	public static void main(String[] args) {

		String test = "Communications";
		
		CharSequence seq = "mom";
		boolean bool = test.contains(seq);
		System.out.println("Found the mom? " + bool);
	}

}
