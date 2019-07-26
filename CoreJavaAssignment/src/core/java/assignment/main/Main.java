package core.java.assignment.main;

import core.java.assignment.question1.BubbleSort;
import core.java.assignment.question2.Fibonacci;
import core.java.assignment.question3.StringReverse;
import core.java.assignment.question4.Factorial;

import java.util.ArrayList;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        //Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
        System.out.print("Question 1: ");
        int[] array = {1,0,5,6,3,2,3,7,9,8,4};
        BubbleSort.bubbleSort(array, array.length);
        printArray(array);
        System.out.println();

        //Write a program to display the first 25 Fibonacci numbers beginning at 0.
        System.out.print("Question 2: ");
        printFibonacci(25);
        System.out.println();

        //Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer
        // or the StringBuilder APIs.
        String string = "random";
        System.out.print("Question 3: " + StringReverse.reverseString(string));
        System.out.println();

        //Write a program to compute N factorial.
        System.out.print("Question 4: " + Factorial.computeFactorial(5));
        System.out.println();

        //Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained
        // between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String,
        // StringBuilder, or StringBuffer APIs.
    }

    private static void printArray(int[] array)
    {
        for (Integer i : array){
            System.out.print(i + " ");
        }
    }

    private static void printFibonacci(int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(Fibonacci.fibonacciNumber(i) + " ");
        }
    }
}
