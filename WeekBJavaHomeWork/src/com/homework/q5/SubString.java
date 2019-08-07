package com.homework.q5;

import java.io.UnsupportedEncodingException;

public class SubString {

	public static void main(String[] args) {
		
		subStrings("This is bonkers", 5);
	}
	

	
	
	public static void subStrings(String words, int index) {
		for (int i = 0; i < index-1; i++) {
			System.out.print(words.charAt(i));
		}
	}
	}
	

