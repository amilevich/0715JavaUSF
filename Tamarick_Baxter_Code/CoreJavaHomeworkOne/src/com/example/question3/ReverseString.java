package com.example.question3;

public class ReverseString {

	public static void main(String[] args) {
		 String str = "Rainbow"; 
		  
	        // convert String to character array 
	        // by using toCharArray 
	        char[] strConvert = str.toCharArray(); // This method converts string to character array
	        
	        // for loop reverses the string
	  
	        for (int i = strConvert.length-1; i>=0; i--) 
	            System.out.print(strConvert[i]); 
	    } 

	}


