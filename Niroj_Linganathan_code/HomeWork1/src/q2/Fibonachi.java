package q2;

public class Fibonachi {
	static int num1 = 0, num2 = 1, num3;

	static void FibinoFind(int count) {
		if (count > 2) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.print(" "+num3);
			FibinoFind(count-1);
		}

	}

	public static void main(String[] args) {
		System.out.print(num1+" "+num2);
		FibinoFind(25);

	}
}


