package com.filereader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
/*
 * Q20. Create a notepad file called Data.txt and enter the following: 
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the following format:

Name: Mickey Mouse
Age: 35 years
State: Arizona State

 */

public class MyFileReader {

	
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String>list = new ArrayList<String>();
		
		FileReader x = new FileReader("C:/Users/Melanie/Desktop/Coding/Data.txt");
		int i;
		while((i=x.read())!= -1) {
		System.out.print((char)i);
		}
	}
}
	