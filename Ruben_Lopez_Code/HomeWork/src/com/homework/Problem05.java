package com.homework;


public class Problem05 {
    public static void main(String args[]) {        
    	// Initializing String
        String str = new String("Welcome to Tamerial");
        
        //this prints  out only 5 characters
        System.out.println(Something(str, 5));
    }
    static String Something(String str, int idx) {
        String str2 = new String("");
        for (int i = 0; i < idx; i++) {
            str2 += (str.charAt(i));
            
        }
        //returns a string thats has only appended the chars up to str2
        return str2;    }
}