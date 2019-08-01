package com.homework.quesone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Write a program that would read from the file and print it out to the screen in the following format:

// Mickey:Mouse:35:Arizona           Name: Mickey Mouse
// Hulk:Hogan:50:Virginia            Age: 35 years
// Roger:Rabbit:22:California	     State: Arizona State
// Wonder:Woman:18:Montana

public class QuesTwenty {

	public static void main(String[] args) throws IOException {
		
		String fileName = "/Revature_Projects/Homework/Data.txt"; // assign our text file to variable filename
		readF(fileName);		
    }
    
	public static void readF(String fileName) throws IOException { // create and check our method with exception in i/o
		
		File file = new File(fileName); // create a new class file that gives path to our file 
        FileReader fr = new FileReader(file); // create class FileReader that read our file
        BufferedReader br = new BufferedReader(fr); // class for reading text from our file
        StringBuffer sb = new StringBuffer(); // class for working with string 
        String line; // Initialized string       
        while((line = br.readLine()) != null){ // check when we read lines from our file and when it exists put them to buffer 
        	sb.append(line); //  join every line starting from new line from our file to variable "line" 
			sb.append("\n");            
			String[] data; // Initialized string array
			data = line.split(":"); // put read lines from file separated it by ":"
			ArrayList<String> arrList = new ArrayList<String>(); // create empty ArrayList
	        for(String s: data) { // read from string "data" every element one by one
	            arrList.add(s); // add to our ArrayList
	        }	        
	        for(int i = 0; i < arrList.size() - 1; i += 4) { // loop to print out DATA that was read from file with step 4
	        	System.out.println("Name:  " + arrList.get(i) + " " + arrList.get(i+1));        	
	        	System.out.println("Age:   " + arrList.get(i + 2));
	        	System.out.println("State: " + arrList.get(i + 3));
	        	System.out.println();
	        }
        }
        br.close(); // close buffer of reading
        fr.close(); // close file reader
		
	}
}
