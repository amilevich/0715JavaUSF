package com.questionfour.factorial;

public class MyClass {

static int factorial(int n){    
	  if (n == 1)    //base case
	    return 1;    
	  else    
	    return(n * factorial(n-1));    //Recursive method calling itself
	 }    
	 public static void main(String args[]){  
			System.out.println("Factorial of 5 is: " + factorial(5)); //prints a factorial of 5
			
   
	 }  
	}  
