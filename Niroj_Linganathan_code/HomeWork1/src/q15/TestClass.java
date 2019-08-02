package q15;

public class TestClass implements MathOperations { //Inheriting MathOperations interface.
  static int result;
	@Override
	public void addition() {
		result= a+b;
		System.out.println(result);
	}

	@Override
	public void substraction() {
		
		result= a-b;
		System.out.println(result);
	}

	@Override
	public void multiply() {
		
		result= a*b;
		System.out.println(result);
	}

	@Override
	public void divide() {
		result= a/b;
		System.out.println(result);
		
	}

	
		
	}

