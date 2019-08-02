package q18;

public class upperExtendsClass extends upperCaseAbstract {

	@Override
	public boolean findUpper(String word) {
		boolean bool = false;
		for (int i = 0; i < word.length(); i++) { 
			if (Character.isUpperCase(word.charAt(i))) { //Check for upper case letters in the given string.
				bool = true;
			} else {
				bool = false;
			}

		}
		String result = String.valueOf(bool); // convert the boolean into string.
		System.out.println(result);
		return bool; // return boolean

	}

	@Override
	public void converUpper(String word) {
		String a = word;
		System.out.println(a.toUpperCase());  //Convert to upper case.

	}

	@Override
	public void converInteger(String word) {
		int num;
		String a = word;
		num = Integer.parseInt(a) + 10; //convert from String to Integer and add 10.
		System.out.println(num);

	}

}
