package core.java.assignment.question9;

public class PrimePrinter
{
    /*
     * Prints all numbers 1 to n that are primes.
     */
    public static void printPrimes(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            if(isPrime(i))
            {
                System.out.print(i + " ");
            }
        }
    }

    /*
     * Uses the modulus operator to determine whether a given number is prime.
     */
    public static boolean isPrime(int number)
    {
        boolean prime = true;
        if(number <= 1)
        {
            prime = false;
        }
        for(int i = 2; i < number; i++)
        {
            if((number % i) == 0)
            {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
