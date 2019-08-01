package q15.interfacing;

public class Calc implements Operations //implements the Operations interface, so has to implement all the methods defined in the Operations interface
{
	int sum;
	@Override
	public void addition(int x, int y) 
	{
		sum = x + y; //sum variable defined as the total after the sum of x and y variables
		System.out.println("The sum of " + x + " and " + y + " is " + sum);
	}

	@Override
	public void subtraction(int x, int y) 
	{
		sum = x - y; //sum variable defined as the total after the subtraction of x and y variables
		System.out.println("The difference of " + x + " and " + y + " is " + sum);
		
	}

	@Override
	public void multiplication(int x, int y) {
		sum = x * y; //sum variable defined as the total after the multiplication of x and y variables
		System.out.println("The multiplication of " + x + " and " + y + " is " + sum);
		
	}

	@Override
	public void division(int x, int y) {
		sum = x / y; //sum variable defined as the total after the division of x and y variables
		System.out.println("The division of " + x + " and " + y + " is " + sum);
		
	}
	//all methods above print to the console the x and y values used and the sum after the operation
}
