package homework.question.q18;

public class SubClass extends SuperClass {

	@Override
	public boolean containsUppercase(String str) {
		// TODO Auto-generated method stub
		for (int i = 0; i < str.length(); i++) {
			String stringToCheck = str.substring(i, i+1);
			if ( stringToCheck.charAt(0) >= 65 || stringToCheck.charAt(0) <= 90) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUppercase(String str) {
		// TODO Auto-generated method stub
		return str.toUpperCase();
	}

	@Override
	public Integer addTen(String str) {
		// TODO Auto-generated method stub
		
		return Integer.valueOf(str) + 10;
	}

}
