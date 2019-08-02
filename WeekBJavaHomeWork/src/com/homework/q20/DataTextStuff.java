package com.homework.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class DataTextStuff {
    //Write a program that would read from the file and print it out to the screen in the following format:
   	 //Name: Mickey Mouse
   	 //Age: 35 years
   	 //State: Arizona State


    public static void main(String[] args)throws Exception
      {
     
      File file = new File("C:\\Users\\Dylan\\Documents\\Revature Bootcamp\\WeekBJavaHomeWork\\src\\com\\homework\\q20\\Data.txt");
   //   "C:\\Users\Dylan\\Documents\\RevatureBootcamp\\Data.txt"
      BufferedReader br = new BufferedReader(new FileReader(file));
      
      ArrayList<String> aList = new ArrayList<String>();
      
      Stack<Character> aStack = new Stack<>();
      int flag = 0;
      String buffer = "";
      String st;
      while ((st = br.readLine()) != null)
     	 for (int i = 0 ; i < st.length() ; i ++) {
     		
     		 
     		 //checks for next char Capitalization
     		 if ( (st.charAt(i) >= 'A') & (st.charAt(i) <= 'Z')) {
     			 while (!(aStack.empty())) {
     				 buffer = aStack.pop() + buffer;
     			 }
     			 
     			 //pushes buffer into AList
     			 aList.add(buffer);
     			 
     			 
     			 buffer = "";
     			 
     			 //pushfirst element into stack
     			 aStack.push(st.charAt(i));
     			 
     		 //checking if the next element is a colon
     		 } else if ( !(st.charAt(i) == ':')) {
     			 aStack.push(st.charAt(i));
      
     		 }
     		 else if (st.charAt(i) == ':'){ //if element is a colon then push into an array
     			 while (!(aStack.empty())) {
     				 buffer = aStack.pop() + buffer;
     			 }
     			 aList.add(buffer);//Clears buffer field
     			 buffer = "";
     		 }else {
     			 continue;
     		 }
     		 
     	 }
     
      
      //Prints lines appropriate to document Format
      for (int i = 1; i < aList.size() - 18; i = i + 6) {
   	   System.out.println("Name: " + aList.get(i) + " " + aList.get(i+2) );
   	   System.out.println("Age: " + aList.get(i+3));
   	   System.out.println("State: " + aList.get(i+5) + " State");
   	   }
      }
}
