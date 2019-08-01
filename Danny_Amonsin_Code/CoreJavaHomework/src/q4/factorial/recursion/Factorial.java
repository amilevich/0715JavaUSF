package q4.factorial.recursion;

public class Factorial {

	
	static int recursive(int n) //method computes N factorial
	{
		if(n == 1) //base case, stops recursion and returns 1 and starts the return value multiplication
		{
			return 1;
		}
		else
		{			
			return n * recursive(n - 1); //method calling itself causing several returns to stack up until final recursion call and then all return values are multiplied and returns the calculated factorial value
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(recursive(5)); //prints the value returned for the factorial calculation
			
	}
}
