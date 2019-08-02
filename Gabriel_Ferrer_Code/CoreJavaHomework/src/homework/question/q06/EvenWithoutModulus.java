package homework.question.q06;

public class EvenWithoutModulus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer num = 4666; // input number
		
		String printString = isEven(num) ? "even" : "odd";
		
		System.out.println("Number is " + printString);
	}
	
	public static boolean isEven(Integer num) {
		char[] cs = String.valueOf(num).toCharArray(); // converting int into an array of chars
		int lengthLessOne = cs.length - 1; // gets the index of length minus 1
		
		switch( cs[ lengthLessOne ] ) {
			// '0','2','4','6','8'
			case '0':
			case '2':
			case '4':
			case '6':
			case '8':
				return true; // if end digit matches even numbers return true
			// '1','3','5','7','9'
			case '1':
			case '3':
			case '5':
			case '7':
			case '9':
				return false; // if end digit matches odd numbers return false
		}
		
		return false;
	}
}
