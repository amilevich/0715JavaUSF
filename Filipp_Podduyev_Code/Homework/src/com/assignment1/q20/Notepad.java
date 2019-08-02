package com.assignment1.q20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Notepad {
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
	
public static void main(String[] args) {
		
		String filename = "./Data.txt";
		MainBean mainBean = new MainBean("Mickey Mouse", 35, "Arizona State");
		writeObject(filename, filename);
	}
	
	public static void writeObject(String filename, Object obj) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))){
			os.writeObject(obj);
		} catch(IOException exc){
			exc.printStackTrace();
		}
	
	}

}
