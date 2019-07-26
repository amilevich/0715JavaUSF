package core.java.assignment.question4;

public class Factorial
{
    public static int computeFactorial(int n)
    {
        if (n >= 2)
        {
            return n * computeFactorial(n-1);
        }
        else
        {
            return n;
        }
    }
}
