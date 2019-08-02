package core.java.assignment.question15;

public class ArithmaticDefinition implements Arithmatic
{
    /*
     * Adds two numbers together.
     */
    @Override
    public int add(int a, int b)
    {
        return a + b;
    }

    /*
     * Subtracts one number from the other.
     */
    @Override
    public int subtract(int a, int b)
    {
        return a - b;
    }

    /*
     * Multiplies two numbers together.
     */
    @Override
    public int multiply(int a, int b)
    {
        return a * b;
    }

    /*
     * Divides one number by the other.
     */
    @Override
    public double divide(double a, double b)
    {
        return a / b;
    }
}
