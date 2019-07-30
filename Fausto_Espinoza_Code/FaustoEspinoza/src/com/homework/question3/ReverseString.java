package com.homework.question3;

public class ReverseString {
	
	//Method reversString
	static String reversString(String arr) {
		String reverse = new String();
		//Loop reverse the original string
		for(int i = arr.length() - 1; i >= 0 ; i-- ) {
			reverse += arr.charAt(i);
		}
		
		return reverse;
		
	}

	public static void main(String[] args) {
		
		String arr = "Hello everybody how are you? I hope you are ok...";
		System.out.println(arr);
		//Call reversString(arr)
		System.out.print(reversString(arr));
			

	}

}
