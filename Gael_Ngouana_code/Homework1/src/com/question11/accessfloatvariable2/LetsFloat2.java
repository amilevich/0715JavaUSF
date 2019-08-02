package com.question11.accessfloatvariable2;

//importing the LetsFLoat1 class from the other package.
import com.question11.accessfloatvariable1.LetsFloat1;

//Extending LetsFloat1 class so that its variables can be inherited by LetsFloat2 class. 
public class LetsFloat2 extends LetsFloat1 {

//Main Method
	public static void main(String[] args) {

		System.out.println("The float-variables have been accessed and their values are " + x + " "+"and"+ " "+ y); 
	}
}
