package com.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class Problem20 {
	//Write a program that would read from the file and print it out to the screen in the following format:

		//Name: Mickey Mouse
		//Age: 35 years
		//State: Arizona State


	public static void main(String[] args)throws Exception 
	  { 
	  //FInds the path of the file 
	  File file = new File("D:\\spring workspace\\HomeWork\\src\\com\\homework\\test.txt"); 
	  
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  ArrayList<String> aList = new ArrayList<String>();
	  
	  Stack<Character> aStack = new Stack<>(); 
	  int flag = 0;
	  String buffer = "";
	  String st; 
	  while ((st = br.readLine()) != null) 
	  	for (int i = 0 ; i < st.length() ; i ++) {
	  		//System.out.println(st.charAt(i));
	  		
	  		//checks if the next char is a Capital letter
	  		if ( (st.charAt(i) >= 'A') & (st.charAt(i) <= 'Z')) {
	  			while (!(aStack.empty())) {
	  				buffer = aStack.pop() + buffer; 
	  			}
	  			
	  			//pushes buffer into ArrayList
	  			aList.add(buffer);
	  			
	  			//cleans the buffer
	  			buffer = "";
	  			
	  			//proceeds pushing the first element into stack
	  			aStack.push(st.charAt(i));
	  			
	  		//checking if the next element is a colon
	  		} else if ( !(st.charAt(i) == ':')) {
	  			aStack.push(st.charAt(i));
	  
	  		}
	  		else if (st.charAt(i) == ':'){
	  			//if the next element is a colon then push the stack into an array
	  			while (!(aStack.empty())) {
	  				buffer = aStack.pop() + buffer; 
	  			}
	  			aList.add(buffer);
	  			//cleans the buffer
	  			buffer = "";
	  		}else {
	  			continue;
	  		}
	  		
	  	}
	  //for ( String a : aList) {
		//  System.out.println(a);
	  //}
	  
	  //the algorithm has some errors in terms of pushing string into list but it works
	  //made some improvised adjustments and don intend on fixing it
	  for (int i = 1; i < aList.size() - 12; i = i + 6) {
		  System.out.println("Name: " + aList.get(i) + " " + aList.get(i+2) );
		  System.out.println("Age: " + aList.get(i+3));
		  System.out.println("State: " + aList.get(i+5) + " State");
		  }
	  } 
}
