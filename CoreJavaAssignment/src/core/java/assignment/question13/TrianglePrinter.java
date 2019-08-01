package core.java.assignment.question13;

public class TrianglePrinter
{
    /*
     * Prints a triangle of a given height. Uses a stored variable to keep track of which number to start each row with.
     */
    public static void printTriangle(int height)
    {
        int numberToStartRow = 0;
        for(int i = 1; i <= height; i++)
        {
            String lineToPrint = levelBuilder(i, numberToStartRow);
            System.out.println(lineToPrint);

            if(lineToPrint.charAt(lineToPrint.length() - 1) == '0')
            {
                numberToStartRow = 1;
            }
            else
            {
                numberToStartRow = 0;
            }
        }


    }

    /*
     * Creates the individual layers of the triangle. Constructs the row using a simple loop then returns the string.
     */
    private static String levelBuilder(int level, int start)
    {
        String triangleRow = "";
        int valueToPrint = start;
        for(int i = 0; i < level; i++)
        {
            triangleRow += String.valueOf(valueToPrint);
            if(valueToPrint == 1)
            {
                valueToPrint = 0;
            }
            else
            {
                valueToPrint = 1;
            }
        }

        return triangleRow;
    }
}
