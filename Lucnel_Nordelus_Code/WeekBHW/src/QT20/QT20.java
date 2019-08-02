package QT20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Create a notepad file called Data.txt and enter the following: 
 * 
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * 
 * Write a program that would read from the file and print it out to the screen in the following format:
 * 
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * 
 * 
 * 
 */

public class QT20 {

	public static void main(String[] args)throws IOException  {
		// read the data .txt
		BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
		
		String doc;
		
	 while((doc = reader.readLine()) != null) {
		 
		 //splits text gather from doc and prints it out 
		 
			String tokens[] = doc.split(":");
			
			System.out.println("Name: " + tokens[0] + tokens[1]);
			
			System.out.println("Age: " + tokens[2] + " years");
			
			System.out.println("State: " + tokens[3] + " State\n");
			
		
	}
	
	}
}
