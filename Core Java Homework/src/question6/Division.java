package question6;
import java.util.Scanner;
public class Division 
{
    static boolean Even(int n) 
    { 
        boolean Even = true; 
          
        for (int i = 1; i <= n; i++) 
        {
            Even = !Even;  
        }
        return Even; 
    } 
    public static void main(String args[]) 
    { 
    	Scanner s = new Scanner(System.in);
    	System.out.println("Type a whole number.");
        int n = s.nextInt(); 
        s.close();
        if(Even(n)) 
            System.out.println("This number is even."); 
        else
            System.out.println("This number is odd."); 
          
    } 
}
