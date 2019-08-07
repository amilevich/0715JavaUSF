package com.homework.q20;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataDotTxt {

	static String filename = "Data.txt";
	String name;
	String age;
	String state;
	
	
	public static void readLines(File f) throws IOException{
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		fr.close();
	}
	public static void main(String[] args) {
		File f = new File("C:\\Users\\Dylan\\Documents\\Revature Bootcamp\\Data.txt");
		try {
			readLines(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}