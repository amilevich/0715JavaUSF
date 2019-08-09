package com.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\14072\\Documents\\workspace-sts-3.9.4.RELEASE\\CoreJavaHomework\\src\\data.txt");
		BufferedReader br = new BufferedReader(new FileReader(file)); // put the file into a BufferedReader
		String st; //create a dummy String
		
		while ((st = br.readLine()) != null ) { // read the lines from the file using br.readLine() as long as br.readLine() isn't null
			System.out.println(st); //print out the line
		}
		System.out.println(); //new line
		
	}

}
