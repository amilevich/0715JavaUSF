package com.questionfourteen.switchcase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyClass {
	
	
	public static void main(String[] args) {

        //this is where you would pick the case to output
        int pick = 2;

        //variable for the square root
        int number = 9;
        
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        //switch statement
        switch (pick) {
            case 1:
                System.out.println("The Square Root of "+number + " is: "+ Math.sqrt(number));
                break;
            case 2:
            	Calendar cal = Calendar.getInstance();
                System.out.println(sdf.format(cal.getTime()));
                break;
            case 3: String myString = "I am learning Core Java";
                   String[] spString = myString.split("");
                printArray(spString);
        }
    }

    //print the array sequence
    static void printArray(String myArray[])
    {
        //get array length
        int n = myArray.length;
        //iterate through array and print it out
        for (int i=0; i<n; ++i) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
}

