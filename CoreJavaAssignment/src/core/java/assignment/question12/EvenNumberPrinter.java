package core.java.assignment.question12;

import core.java.assignment.question6.OddOrEven;

public class EvenNumberPrinter
{
    // Returns an array of values from 0 to n.
    private static int[] populateArray(int n)
    {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++)
        {
            arr[i] = i;
        }
        return arr;
    }

    // Utilizes the determineOddOrEven method from question six to print all even numbers in an array.
    public static void printEvens()
    {
        for(int i : populateArray(100))
        {
            if(OddOrEven.determineOddOrEven(i))
            {
                System.out.print(i + " ");
            }
        }
    }
}
