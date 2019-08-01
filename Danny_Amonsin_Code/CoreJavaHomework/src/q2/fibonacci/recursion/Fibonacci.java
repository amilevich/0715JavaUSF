package q2.fibonacci.recursion;

public class Fibonacci 
{
	static int x0 = 0, x1 = 1; //starting variables for fibonacci 
	
	static void recursive(int x) //recursive method for calling itself until base case is reached
	{
		if(x > 2) //base case is 2 because we already have first 2 starting numbers so once base case is reached this recursive loop will end
		{
			int sum = x0 + x1; //adding the sum of the previous numbers in fibonacci sequence
			x0 = x1; //assigning x0 sum x1
			x1 = sum; //assigning x1 to sum
			System.out.print(" " + sum); //printing space and sum
			recursive(x - 1); //method calling itself with argument integer passed in minus 1 for every time we recurse 
		}
		
	}
	
	public static void main(String[] args) 
	{
		System.out.print(x0 + " " + x1); //prints out first 2 numbers for starting point of fibonacci
		recursive(25);

	}

}
