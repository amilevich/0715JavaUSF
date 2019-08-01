package q6.no.modulus;

public class Even 
{
	static int x; //integer variable declaration
	static void evenChecker(int x) //even or odd method checker, accepts integer value
	{		   
		    if ((x/2)*2 == x) //checks if number is even, if it is not, then the number is odd, e.g 10/2 = 5, 5 * 2 = 10, 10 is the same is 10, so even, if 3, 3/2 = 1, 1 * 2 = 2, 2 is not equal to 3, so odd 
		    {
		      System.out.println("Even");
		    }
		    else
		    {
		      System.out.println("Odd");
		    }
	}
	
	public static void main(String[] args) //program start execution 
	{
		evenChecker(99); //method call with integer input to parameter that accepts an integer value
	}

}
