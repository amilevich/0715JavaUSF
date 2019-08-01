package core.java.assignment.question6;

public class OddOrEven
{
    /*
     * Determines whether a number is odd or even. Runs a loop starting at zero going to the number and toggles true and
     * false in each iteration. The end result will be a boolean value representing whether the number is even or not.
     */
    public static boolean determineOddOrEven(int number)
    {
        boolean isEven = true;
        for(int i = 0; i < number; i++)
        {
            if(isEven)
            {
                isEven = false;
            }
            else
            {
                isEven = true;
            }
        }

        return isEven;
    }
}
