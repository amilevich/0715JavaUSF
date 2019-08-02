package com.questioneighteen.abstractmethods;

import java.util.Scanner;

public abstract class MyClass { //Declaration using abstract keyword

	public MyClass() {}; //constructor
	
	public String input; // string object
	Scanner in = new Scanner(System. in);
    abstract boolean isUpperCase();  //abstract method to check for upper case and return "true" if found any
    abstract String convertToUpperCase(); //abstract method to convert to upper case
    abstract int convertToInt();  //abstract method to convert to integers
}

