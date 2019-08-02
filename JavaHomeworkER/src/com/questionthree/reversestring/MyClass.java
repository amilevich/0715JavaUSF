package com.questionthree.reversestring;

public class MyClass {

	public static void main(String[] args) {
		String s = "Hi Alex!"; { //string to reverse
			for(int i = 0; i < s.length(); i++) //initiating the counter i and specifying condition (i will start at/equals 0, 
												//while i is less than the number of the "s" array length, increase it by one) 
			{
			    s = s.substring(1, s.length() - i) + s.charAt(0) + s.substring(s.length() - i); //returns he string in reverse order
			}
				System.out.println(s); // !!xelA iH
			}
		}
}
