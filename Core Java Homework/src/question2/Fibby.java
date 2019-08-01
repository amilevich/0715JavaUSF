package question2;
import java.util.Scanner;

public class Fibby {
    public static void main(String[] args) {
        int i = 1; 
        int n;
        int t1 = 0; 
        int t2 = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("How many terms of the Fibonacci sequence would you like to see?");
        n = s.nextInt();
        s.close();
        System.out.print("First " + n + " terms: ");
        while (i <= n)
        {
        	if(i<n)
        	{
            System.out.print(t1 + " + ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
            i++;
        	}
        	else
        	{
                System.out.print(t1);
                int sum = t1 + t2;
                t1 = t2;
                t2 = sum;
                i++;
        	}
        }
    }
}
