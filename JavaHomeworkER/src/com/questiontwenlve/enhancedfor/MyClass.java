package com.questiontwenlve.enhancedfor;

public class MyClass {
	public static void main(String[] args) {

        int arraySize = 100;
        int[] myArray = new int[arraySize];

        //populate array with numbers 1 to 100
        for(int i=0; i < myArray.length;i++){
            myArray[i]=i+1;  
        }

       //iterate through array and find the even numbers using for each loop
        for (int even : myArray) {
            //if the value is divisible by two then it's even
            if(even % 2 == 0)
               System.out.println("Even: " +even); //print the even numbers
            }
        }

    }
