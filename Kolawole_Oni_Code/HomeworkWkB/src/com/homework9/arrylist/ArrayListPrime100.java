package com.homework9.arrylist;

import java.util.ArrayList;

public class ArrayListPrime100 {
	
	public static void printprime () {
		
		 ArrayList<Integer> list;
	        list = new ArrayList<Integer>();
	
		for(int a = 1; a <=  100; a++) {
		if(a==2 || a==3 || a==5 || a==7) {
				//System.out.println(a);
	          if(a%2 != 0 && a%3 != 0 && a%5 != 0 && a%7 != 0) 
	        	System.out.println(a);
	          else 
				System.out.println(a); }}
				//else(System.out.println(a));}
				//To store my result in an array in print console
			
	}
	    public static void main(String[] args) {
	       
	       // System.out.println("Enter some non-zero integers.  Enter 0 to end.");
	        printprime();
	        }
	    }

	

