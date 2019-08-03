package com.homework16.stringdisplay;

import java.util.Scanner;

public class Sixteen {
	
	//To write a program to display the number of characters of a string input 
	//input will be taken from the command line 
	
    //String a = new String;
	
	
	public static void stringCount(){
	System.out.println(" Please enter the word you wish");
	Scanner scanner = new Scanner(System.in);
	String a = scanner.nextLine();
	a.length();
	
	//for(int a = 0; a < arr.length; a++) {

	}
	public void helloSam() {
		System.out.println("Hello Sam");
	}
	  public static void main(String[] args)
	  {
		  stringCount(); //static
		  Sixteen six = new Sixteen();
		 six.helloSam(); //non-static
	    
	  }
	
	

}
