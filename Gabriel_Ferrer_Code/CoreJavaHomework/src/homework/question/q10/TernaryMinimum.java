package homework.question.q10;

public class TernaryMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 67;
		int b = 49;
		
		System.out.println("The minimum between two numbers is "+ ternary(67,49));
	}

	static int ternary (int a, int b) {
		return a < b ? a : b; // if a is less than b return a else b
	}
}
