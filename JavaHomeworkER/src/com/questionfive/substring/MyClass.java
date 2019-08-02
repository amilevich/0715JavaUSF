package com.questionfive.substring;

public class MyClass {

	    public static void main(String[] args) {

	        int idx=8;
	        String str = "University of South Florida"; 
	        String a = SubString(idx, str);
	        System.out.println("The substring contained between O and -1 inclusive is: "+ a);
	        
	    }

	   static String SubString(int idx, String str){

	        char[] subString = new char[idx]; //declare a substring that is the length of the index specified

	        for(int i=0; i<=idx-1;i++) //iterate until you reach the given index
	        {
	            subString[i] = str.charAt(i); 	//iterate through the string and assign the character at idx-1 
	            								//to the substring character array
	        }
	        
	        String subS = new String(subString); //convert the subS character array to a string
	        
	        return subS; //return the substring
	    }

	}

