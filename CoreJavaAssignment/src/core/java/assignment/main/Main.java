package core.java.assignment.main;

import core.java.assignment.question1.BubbleSort;
import core.java.assignment.question10.TernaryMin;
import core.java.assignment.question11.FloatPrinter;
import core.java.assignment.question12.EvenNumberPrinter;
import core.java.assignment.question13.TrianglePrinter;
import core.java.assignment.question2.Fibonacci;
import core.java.assignment.question3.StringReverse;
import core.java.assignment.question4.Factorial;
import core.java.assignment.question5.Substring;
import core.java.assignment.question6.OddOrEven;
import core.java.assignment.question7.Employee;
import core.java.assignment.question7.SortByAge;
import core.java.assignment.question7.SortByDepartment;
import core.java.assignment.question7.SortByName;
import core.java.assignment.question8.PalindromeSeperator;
import core.java.assignment.question9.PrimePrinter;

import java.util.ArrayList;
import java.util.Collections;


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
        System.out.println("Question 5: " + Substring.getSubstring("Dictionary", 5));

        // Q6. Write a program to determine if an integer is even without using the modulus
        // operator (%)
        System.out.println("Question 6: " + OddOrEven.determineOddOrEven(6));

        // Sort two employees based on their name, department, and age using the
        //Comparator interface.
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("Nick", 24, "Software"));
        employeeList.add(new Employee("Toby", 32, "Human Recources"));
        employeeList.add(new Employee("Angela", 48, "Accounting"));
        employeeList.add(new Employee("Micheal", 45, "Management"));

        Collections.sort(employeeList, new SortByName());

        System.out.print("Question 7: ");

        for(Employee employee : employeeList)
        {
            System.out.print(employee.getName() + " ");
        }

        System.out.print(" | ");

        Collections.sort(employeeList, new SortByAge());

        for(Employee employee : employeeList)
        {
            System.out.print(employee.getAge() + " ");
        }

        System.out.print(" | ");

        Collections.sort(employeeList, new SortByDepartment());

        for(Employee employee : employeeList)
        {
            System.out.print(employee.getDepartment() + " ");
        }

        System.out.println();

        //Q8. Write a program that stores the following strings in an ArrayList and saves all the
        //palindromes in another ArrayList.
        PalindromeSeperator palindromeSeperator = new PalindromeSeperator();
        System.out.print("Question 8: ");
        printArray(palindromeSeperator.seperatePalindromes());
        System.out.println();

        // Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
        //numbers to the console.
        System.out.print("Question 9: ");
        PrimePrinter.printPrimes(100);
        System.out.println();

        // Q10. Find the minimum of two numbers using ternary operators.
        System.out.print("Question 10: " + TernaryMin.findMin(20,9));
        System.out.println();

        // Q11. Write a program that would access two float-variables from a class that exists in
        //another package. Note, you will need to create two packages to demonstrate the
        //solution.
        System.out.print("Question 11: ");
        FloatPrinter.printFloats();
        System.out.println();

        // Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even
        //numbers from the array. Use the enhanced FOR loop for printing out the numbers.
        System.out.print("Question 12: ");
        EvenNumberPrinter.printEvens();
        System.out.println();

        // Q13. Display the triangle on the console as follows using any type of loop. Do NOT use
        //a simple group of print statements to accomplish this.
        System.out.println("Question 13: ");
        TrianglePrinter.printTriangle(4);


    }

    private static void printArray(int[] array)
    {
        for (Integer i : array){
            System.out.print(i + " ");
        }
    }

    private static void printArray(ArrayList<String> strings)
    {
        for (String s : strings)
        {
            System.out.print(s + " ");
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
