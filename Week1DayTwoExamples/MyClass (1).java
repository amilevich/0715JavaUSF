package com.example.strings;

public class MyClass {

	public static void main(String[] args) {

	 String stringOne = "BirdPerson";
	 String stringTwo = new String("BirdPerson");
	 String stringThree = "BirdPerson";
	 String stringFour = new String("BirdPerson");
	 
	 if(stringOne == stringTwo) {
		 System.out.println("objects are equal");
	 }
	 
	 if(stringTwo == "BirdPerson") {
		 System.out.println("hooray inside the if statement");
	 }
	 
	 if(stringTwo.equals(stringOne)) {
		 //System.out.println(".equals returned true");
	 }
	 
	 if(stringOne.equals(stringTwo)) {
		 //System.out.println(".equals reverse worked");
	 }
	 /*
	  * == compares the address/memory location
	  * .equals checks the actual value
	  */
	 
	 //strings are immutable
	 String sOne = "Roger";
	 String sTwo = sOne.concat(" Rabbit");
	// System.out.println(sOne);
	// System.out.println(sTwo);
	 sOne = sTwo;
	 System.out.println(sOne);
	 
	 /*
	  * StringBuilder - mutable
	  * StringBuffer - mutable, thread-safe/synchronized
	  */
	 
	 String sTen = "Running";
	 StringBuilder sBuilderOne = new StringBuilder(sTen);
	 sBuilderOne.append(" from my responsibilities...");
	 System.out.println(sBuilderOne);
	 
	 String sEleven = "Uhhh";
	 StringBuffer sBufferOne = new StringBuffer(sEleven);
	 sBufferOne.append(" and whoops");
	 System.out.println(sBufferOne);
	 sEleven = "um i don't know";
	 
	 System.out.println(sTen);
	 System.out.println(sEleven);
	 
	}

}
