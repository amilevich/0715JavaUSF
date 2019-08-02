package com.Switch.assignments;

import java.util.Date;        //importing of scanner and date allows for the use of out put information
import java.util.Scanner;	  //of date via the input of the scanner

public class MySwitch {

	public static Scanner scan = new Scanner(System.in);  //Using the scanner for input information
	
	public static void main(String args[]){		//Main method
	switchStatement();} //Initializing the beginning of a switch method
	
	public static void switchStatement(){ 
		
	    System.out.println("Find the square root of a number."); //Required input information
	    System.out.println("Display today's date.");
	    System.out.println("I am learning Core Java");
	    
	    int n = scan.nextInt();
	    
	    switch(n){
	    case 1:{
		    	System.out.print("Find the square root of a number: ");
		    	int i = scan.nextInt();//calling upon the scanner to scan nxtint.
		    	System.out.println(Math.sqrt(i)); //Telling the system to print out
		    	// the square root of i
	    break;
	    }
	    case 2:{
		    	Date d = new Date();//establishing a new variable
				System.out.println("Display today's date: "+d);
	    break;
	    }
	    case 3:{
	    	String s1="I am learning Core Java";  //Telling the system that s1 can be used to reference
	    	//"I am learning Core Java"
	    	String[] words=s1.split("\\s"); 
	    	for(String s3:words){  
	    	System.out.println(s3);  
	    	break;
	    	}  
	    	
	    }
	    
	    }
		
	}

}
