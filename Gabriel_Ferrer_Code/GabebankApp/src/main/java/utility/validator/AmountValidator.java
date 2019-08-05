package utility.validator;

public class AmountValidator extends Validator{
	private static int digitSize = 2;

	public static boolean isValid(double amount) {
		return hasDigitSize(amount) && amount > 0.0;
	}

	private static boolean hasDigitSize(double amount) {
		String[] digit = new Double(amount).toString().split("\\.");
		return digit[1].length() <= digitSize && digit[0].length() > 0;
	}

	public static void setDigitSize(int size) {
		digitSize = size;
	}
}
