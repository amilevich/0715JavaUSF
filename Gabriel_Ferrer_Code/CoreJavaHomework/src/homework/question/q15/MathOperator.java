package homework.question.q15;

public class MathOperator implements MathOperable {

	@Override
	public int addition(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		// TODO Auto-generated method stub
		if (b == 0) {
			return b / a;
		}
		return a / b;
	}

}