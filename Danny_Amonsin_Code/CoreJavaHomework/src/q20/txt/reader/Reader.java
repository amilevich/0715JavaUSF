package q20.txt.reader;

import java.io.File;
import java.util.Scanner;

public class Reader 
{	    
	    Scanner readText; //variable of Scanner type
	    
	    public void openIt()  //method for opening the Data.txt file
	    {
	        try //try block for code to try
	        {
	        	readText = new Scanner(new File("/Users/danny/Documents/4_Revature_Training/Onsite_Training/Data.txt")); //file location for Data.txt file
	        }
	        catch(Exception opps)  //catch block to try and catch the exception if file location isn't accepted
	        {
	        	opps.printStackTrace(); //gives us info on what may have caused the exception
	        }
	        
	    }
	    
	    public void readingIt() //method for reading text and formatting it
	    {
	        while(readText.hasNext())  //loops through until there is no more items
	        {
	            String x = readText.next(); //stores values in x and prints each value
	            System.out.println(x);          //prints value of x with new line
	            System.out.print("Name: ");   //prints statement without new line
	            
	            for(int i = 0 ; i < 2; i++) //loops until i < 2
	            {
	                int j = x.indexOf(":");  //returns the index of the first location of the ":", this is set as an integer in variable "j"
	                System.out.print(x.substring(0, j) + " "); //prints out the substring starting from index 0 to the index we had at "j"
	                x = x.substring(j + 1, x.length()); //stores the substring from j + 1 to the length of the String values we see as we loop
	            }
	            
	            System.out.println(); //prints an empty line in the console
	            int i = x.indexOf(":"); ////returns the index of the first location of the ":", this is set as an integer in variable "j"
	            System.out.println("Age: " + x.substring(0, i) + " years"); //prints out the substring starting from index 0 to the index "i"
	            x = x.substring(i + 1, x.length()); //stores substring from i + 1 to the end of the String
	            System.out.println("State: " + x + " State"); //prints State, variable stored in x, then State again
	            System.out.println(); //prints an empty line in the console
	            System.out.println(); //prints an empty line in the console
	            
	        }
	        
	        readText.close(); //closes the scanner
	    }
	    
	    
	}
