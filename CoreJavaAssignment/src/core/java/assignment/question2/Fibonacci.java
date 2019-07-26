package core.java.assignment.question2;

public class Fibonacci
{
    public static int fibonacciNumber(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        else
        {
            return fibonacciNumber(n-1) + fibonacciNumber(n-2);
        }
    }
}
