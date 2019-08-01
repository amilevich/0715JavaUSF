package q15.interfacing;

public class Test 
{
	public static void main(String[] args) //main method start of execution
	{
		Calc cal = new Calc(); //new instance of the Calc class
		
		cal.addition(2, 5); //call to the addition method in the Calc class, passing in the values of 2 and 5
		cal.subtraction(4, 2); //call to the subtraction method in the Calc class, passing in the values of 4 and 2
		cal.multiplication(5, 5); //call to the multiplication method in the Calc class, passing in the values of 5 and 5
		cal.division(10, 2); //call to the division method in the Calc class, passing in the values of 10 and 2
	}
}
