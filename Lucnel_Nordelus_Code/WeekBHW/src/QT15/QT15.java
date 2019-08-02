package QT15;

/*
 * Write a program that defines an interface having the following methods: 
 * addition, subtraction, multiplication, and division. 
 * Create a class that implements this interface and provides appropriate 
 * functionality to carry out the required operations. Hard code two operands 
 * in a test class having a main method that calls the implementing class.
 */

public class QT15 implements Math {
	
	public static void main(String[] args) {
		
		
		QT15  qt15 = new QT15();
		qt15.addition(5, 20); // does the  addition of two ints
		System.out.println("The result of Addition");
		System.out.println(qt15.addition(5, 20));
		
		qt15.multiplication(100, 5);// does the multiplication of two ints
		System.out.println("The result of multiplication");
		System.out.println(qt15.multiplication(100, 5));
		
		
		
	}

	@Override // override the addition method 
	public int addition(int x, int y) {
		int sum = x + y;
		return sum;
	}

	@Override // override the subtraction method 
	public int subtraction(int x, int y) {
		int diff = x-y;
		return diff;
	}

	@Override // override the multiplication method 
	public int multiplication(int x, int y) {
		int prod = x * y;
		return prod;
	}

	@Override // override the division method 
	public int division(int x, int y) {
		int divd = x/y;
		return divd;
	}

}
