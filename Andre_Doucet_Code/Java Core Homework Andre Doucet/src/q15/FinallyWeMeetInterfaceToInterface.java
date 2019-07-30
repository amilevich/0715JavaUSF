package q15;

import q15.EnterFacebook.duh;

class FinallyWeMeetInterfaceToInterface implements duh {

	@Override
	public void addition(int num) {
	//(IN PIRATE VOICE)we be calling the addition part of the interface here... YAR...
		num = 2 + 2;
		System.out.println("Here's addition! " + num);
		
	}

	@Override
	public void subtraction(int num1) {
		// (IN PIRATE VOICE) Yar. Tally ho. We be calling subtraction here... So...
		num1 = 2 - 2;
		System.out.println("Here's subtraction! " + num1);
	}

	@Override
	public void multiplication(int num1) {
		// (ONCE AGAIN IN PIRATE VOICE) Here we be sending multiplication to be in the Davy Jones Locker(Driver method)
		num1 = 2 * 2;
		System.out.println("Here's multiplication! " + num1);
	}

	@Override
	public void division(int num1) {
		// (PIRATE V... You should know by now)YO HO HO. This be where we call the division part of the interface
		num1 = 2/2;
		System.out.println("Here's division! " + num1);
		
	}
	//this be the driver statement
	
	public static void main(String[] args) {
		FinallyWeMeetInterfaceToInterface t = new FinallyWeMeetInterfaceToInterface();
		int num = 2;
		int num1 = 2;
		System.out.println("These are all mathematical operations involving 2 \n");
		t.addition(num );
		t.subtraction(num1);
		t.multiplication(num1);
		t.division(num1);
		
	}

}
