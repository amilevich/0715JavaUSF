package q4;

class FactorialThing
{ 
	// this method declares what n is, and then performs the factorial operation on the number 
	static int factorialed(int n) 
	{ 
		if (n == 0) 
		return 1; 
		
		return n*factorialed(n-1); 
	} 
	
	// here the number to factorial(-ed?) is set, and the result is printed out in the console to the user
	public static void main(String[] args) 
	{ 
		int numba = 6; 
		System.out.println("Factorial of "+ numba + " is " + factorialed(6)); 
	} 
} 
