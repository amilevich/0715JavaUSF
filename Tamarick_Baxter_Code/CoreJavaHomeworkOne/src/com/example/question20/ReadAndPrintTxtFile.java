package com.example.question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintTxtFile {

	public static void main(String[] args) throws IOException {
		
		// Utilizing BufferedReader
		BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			// Splits on white space
			String input[] = line.split(":");
			
			System.out.println("Name: " + input[0] + input[1]);
			System.out.println("Age: " + input[2] + " years");
			System.out.println("State: " + input[3] + " State\n");
		}

		reader.close();

	}
}
