package com.HW1.question20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Question20 {
	//Write a program that would read from the file and print it out to the screen in the following format:
	// Name: Mickey Mouse
	// Age: 35 years
	// State: Arizona State
	
	
	public static ArrayList<String> readFileAsString(String fileName)throws Exception { 
	    
		File file = new File(fileName);
        FileReader fileRead = new FileReader(file);
        BufferedReader buffRead = new BufferedReader(fileRead); //set BufferReader to desired file
        String line;
        ArrayList<String> arrList = new ArrayList<String>();
        
		while((line = buffRead.readLine()) != null){		    //read line by line of file
			String[] data;			
			data = line.split(":");								//create temporary array of separated data		    
																
		    for(String s: data) {								//store data into ArrayList
		    	arrList.add(s);
		    }		    
		}
		buffRead.close();
	    return arrList; 										//return an ArrayList containing separated data
	  } 

	public static void main(String[] args) throws Exception{
		ArrayList<String> arrList = readFileAsString("C:\\Users\\Jorge Campos\\"	//calling file reader and saving data in ArrayList
				+ "Documents\\workspace-sts-3.9.4.RELEASE\\Core Java Homework\\"
				+ "src\\com\\HW1\\question20\\Data.txt"); 
	    for(int i = 0; i < arrList.size()-1; i += 4) {
	    	System.out.println("Name: " + arrList.get(i) + " " + arrList.get(i+1));	//displaying data in readable format by traversing 
	    	System.out.println("Age: "+ arrList.get(i+2));							// received ArrayList
	    	System.out.println("State: "+ arrList.get(i+3)+ "\n");
	    }
	}
}