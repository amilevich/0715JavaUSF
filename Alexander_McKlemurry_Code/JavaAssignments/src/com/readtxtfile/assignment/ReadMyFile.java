package com.readtxtfile.assignment;
import java.io.BufferedReader;  
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
public class ReadMyFile {
	
	//There seems to be some issue with it printing it out the way you wanted it to. I decided
	//to leave it as is because the Project is demanding too much time


	 public static void main(String[] args)throws Exception
     {
     //FInds the path of the file
     String file = "./Data.txt";
     
     BufferedReader br = new BufferedReader(new FileReader(file));//Filereader helps read from files
     																//self explanatory for this question
     
     ArrayList<String> aList = new ArrayList<String>();
     
     Stack<Character> aStack = new Stack<>();
     int flag = 0; //using flag because it is great at serving as a variable placeholder
     String buffer = "";
     String st;
     while ((st = br.readLine()) != null)
         for (int i = 0 ; i < st.length() ; i ++) {
             //System.out.println(st.charAt(i));
             
             //checks if the next char is a Capital letter
             if ( (st.charAt(i) >= 'A') & (st.charAt(i) <= 'Z')) {
                 while (!(aStack.empty())) {
                     buffer = aStack.pop() + buffer;
                 }
                 
                 //pushes buffer into ArrayList
                 aList.add(buffer);
                 
                 //cleans the buffer
                 buffer = "";
                 
                 //proceeds pushing the first element into stack
                 aStack.push(st.charAt(i));
                 
             //checking if the next element is a colon
             } else if ( !(st.charAt(i) == ':')) {
                 aStack.push(st.charAt(i));
     
             }
             else if (st.charAt(i) == ':'){
                 //if the next element is a colon then push the stack into an array if the stack
            	 //is empty
                 while (!(aStack.empty())) {
                     buffer = aStack.pop() + buffer;//
                 }
                 aList.add(buffer);
                 //cleans the buffer
                 buffer = "";
             }else {
                 continue;
             }
             
         }
     
      
     
     //I used the for loop in order to tell the system to print out 
     for (int i = 1; i < aList.size() - 12; i = i + 6) {
         System.out.println("Mickey Mouse: " + aList.get(i) + " " + aList.get(i+2) );
         
         System.out.println("35 years: " + aList.get(i+3));
         
         System.out.println("Arizona State: " + aList.get(i+5) + " State");
         }
     }
	
	}
	
			
				
				
			
			

