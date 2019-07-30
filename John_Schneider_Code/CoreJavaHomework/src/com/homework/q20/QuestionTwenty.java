package com.homework.q20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class QuestionTwenty
{
	/*
	 * Read from a text file and print data to console
	 */
	
	//Throws Exception as FileReader has possibility of throwing an exception
	public static void main(String[] args) throws Exception
	{
		//Defining a file object with location of text file to be read
		File file = new File("/Users/john/Desktop/teststs/CoreJavaHomework/src/com/homework/q20/Data.txt");
		
		//Creating a bufferedreader to read in data from the Data.txt file
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str; //To hold an individual line from Data.txt
		String[] strs; //To hold individual strings from each line, split at :
		
		//Loop to read in each line from Data.txt into String str, until there are no lines left to read
		while((str = br.readLine()) != null)
		{
			//fill the string array with individual strings from str split at :
			strs = str.split(":");
			
			//Print out data from each line of Data.txt in given format
			System.out.println("Name: " + strs[0] + " " + strs[1]);
			System.out.println("Age: " + strs[2]);
			System.out.println("State: " + strs[3] + " State");
			
			//Print an empty line for better readability
			System.out.println();
		}
		
		//close the bufferedreader when finished
		br.close();
	}
}