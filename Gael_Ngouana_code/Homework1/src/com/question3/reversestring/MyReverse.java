package com.question3.reversestring;

//import java.util.Scanner;

public class MyReverse {
	
	static String str;
	
	//* Creating a Method to implement the reverse of the string.
	 static void reverseStr(String str) {
		
		 //Loop to sequentially read the string from the right side to the left side
		 // Prints out index value as it reads.
		 
		for(int i = str.length()-1; i >= 0; i--) {
			
			System.out.print(str.charAt(i));
			
		}
		
	}

//static String reverseStr(String str) {
//		
//		for(int i = str.length()-1; i >= 0; i--) {
//			
//			System.out.print(str.charAt(i));
//			
//		}
//		return "";
		
	//}
	public static void main(String[] args) {
		
		String str = "Hello Alex, my code is working.";
		
		//Scanner sc= new Scanner(System.in);
		//System.out.println("Please enter a word or a sentence");
		
		//String str= sc.nextLine();
		
		//System.out.print("You entered: " + str);
		//System.out.print(reverseStr(str));
		reverseStr(str);
		
		
		
		//reverseStr(str);
		
		
		

	}

}
