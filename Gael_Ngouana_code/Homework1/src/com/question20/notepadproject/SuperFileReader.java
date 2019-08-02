package com.question20.notepadproject;

import java.io.File;
import java.util.Scanner;
public class SuperFileReader {
 
 Scanner readMe;
 
 //Method that reads the file
 public void popitOpen() {
  try {
	  
	  //Scanner that will go through the file.
   readMe= new Scanner(new File("/Users/gael_ng/Documents/Data.txt"));
  }catch(Exception e) {
   e.printStackTrace();
  }
  
 }
 
 public void supereadFile() {
	 
	 //Loop created to go through line of the file
  while(readMe.hasNext()) {
   String a = readMe.next();
   System.out.println(a);      
   System.out.print("Name: ");
   for(int i = 0 ; i < 2; i++){
    int j = a.indexOf(":");
    System.out.print(a.substring(0, j) + " ");
    a = a.substring(j + 1, a.length());
   }
   System.out.println("");
   int i = a.indexOf(":");
   System.out.println("Age: " + a.subSequence(0, i) + " years");
   a = a.substring(i + 1, a.length());
   System.out.println("State: " + a + " State");
   System.out.println("");
   System.out.println("");
   
  }
  
  readMe.close();
 }
 
 
}

