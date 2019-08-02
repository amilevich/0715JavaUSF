package core.java.assignment.main;

import core.java.assignment.question1.BubbleSort;
import core.java.assignment.question10.TernaryMin;
import core.java.assignment.question11.FloatPrinter;
import core.java.assignment.question12.EvenNumberPrinter;
import core.java.assignment.question13.TrianglePrinter;
import core.java.assignment.question14.SwitchCases;
import core.java.assignment.question15.ArithmaticDefinition;
import core.java.assignment.question17.InterestCalculator;
import core.java.assignment.question18.StringChecker;
import core.java.assignment.question19.ArrayListActions;
import core.java.assignment.question2.Fibonacci;
import core.java.assignment.question20.FileReader;
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
import java.util.Scanner;


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

        //Q14. Write a program that demonstrates the switch case. Implement the following
        //functionalities in the cases:
        //Case 1: Find the square root of a number using the Math class method.
        //Case 2: Display today’s date.
        //Case 3: Split the following string and store it in a string array.
        System.out.println("Please enter an action (sqrt, split, date): ");
        Scanner scanner = new Scanner(System.in);
        SwitchCases.checkCases(scanner.nextLine());

        //Q15. Write a program that defines an interface having the following methods: addition,
        //subtraction, multiplication, and division. Create a class that implements this interface
        //and provides appropriate functionality to carry out the required operations. Hard code
        //two operands in a test class having a main method that calls the implementing class.
        int x = 12;
        int y = 4;
        ArithmaticDefinition definition = new ArithmaticDefinition();
        System.out.println("Question 15: " + definition.add(x,y) + " " + definition.subtract(x,y) + " "
                + definition.multiply(x,y) + " " + definition.divide(x,y));

        //Q16. Write a program to display the number of characters for a string input. The string
        //should be entered as a command line argument using (String [ ] args).

        //Q17. Write a program that calculates the simple interest on the principal, rate of interest
        //and number of years provided by the user. Enter principal, rate and time through the
        //console using the Scanner class.
        //Interest = Principal* Rate* Time
        System.out.println("Question 17: " + InterestCalculator.calculateInterest(1000,.04, 80));

        //Q18. Write a program having a concrete subclass that inherits three abstract methods
        //from a superclass. Provide the following three implementations in the subclass
        //corresponding to the abstract methods in the superclass:
        //1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
        //if any are found.
        //2. Convert all of the lower case characters to uppercase in the input string, and
        //return the result.
        //3. Convert the input string to integer and add 10, output the result to the console.
        //Create an appropriate class having a main method to test the above setup.
        StringChecker checker = new StringChecker();
        System.out.print("Question 18: " + checker.convertToUppercase("sTrIng") + " ");
        System.out.print(checker.convertStringToInt("18") + " ");
        System.out.print(checker.checkForUppercase("String"));
        System.out.println();

        // Q19 . Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
        //the even numbers up and display the result. Add all the odd numbers up and display the
        //result. Remove the prime numbers from the ArrayList and print out the remaining
        //ArrayList.
        ArrayListActions actions = new ArrayListActions(10);
        System.out.println("Question 19: ");
        actions.displayArrayList();
        actions.addAllEvens();
        actions.displayArrayList();
        actions.removePrimes();
        actions.displayArrayList();

        //Q20. Create a notepad file called Data.txt and enter the following:
        //Mickey:Mouse:35:Arizona
        //Hulk:Hogan:50:Virginia
        //Roger:Rabbit:22:California
        //Wonder:Woman:18:Montana
        //Write a program that would read from the file and print it out to the screen in the
        //following format:
        //Name: Mickey Mouse
        //Age: 35 years
        //State: Arizona State
        System.out.println("Question 20: ");
        FileReader.readTextFromFile("/Users/Nick/JavaTraning/0715JavaUSF/CoreJavaAssignment/Recources/Data.txt");


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
