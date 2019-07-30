package com.homeworkcoreJava.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Answers to Question 20:
//Create a notepad file called Data.txt and enter the following: 
//Mickey:Mouse:35:Arizona
//Hulk:Hogan:50:Virginia
//Roger:Rabbit:22:California
//Wonder:Woman:18:Montana

//Write a program that would read from the file and print it out to the screen in the following format:

//Name: Mickey Mouse
//Age: 35 years
//State: Arizona State

public class Question20 {

	public static void main(String[] args) {
		
		//Try-Catch for file not found
		try {
			printFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void printFile() throws FileNotFoundException {
		
		// We need to provide file path as the parameter: 
		// double backquote is to avoid compiler interpret words 
		File file = new File("C:\\Users\\lbcar\\Documents\\workspace-sts-3.9.4.RELEASE\\HomeWork\\src\\com\\homeworkcoreJava\\q20\\Data.txt"); 
		
		//Prints out the contents of the file as requested
		BufferedReader br = new BufferedReader(new FileReader(file));   
		String st;
		
		//Try-Catch for IOException
		try {
			while ((st = br.readLine()) != null) {
		
				String[] str = st.split(":");
				System.out.println("Name: " + str[0] + " " + str[1]);
				System.out.println("Age: " + str[2] + " " + "years");
				System.out.println("State: " + str[3] + " " + "State");
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
}