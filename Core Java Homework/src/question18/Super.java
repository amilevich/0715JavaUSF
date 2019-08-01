package question18;
/*
 * Very much not sure why, but on the recommendations of others, moving the main method to being the first 
 * on the file in terms of verticality fixed many bizarre "No enclosing instance of type Super is accessible"
 * errors. I'm not even going to question what the hell happened.
 */
public class Super 
{
	public static void main(String[] args)
	{
		Execution example = new Execution();
		String lower = "capitalization is for nerds";
		String upper = "but I'm a nerd though";
		System.out.println("Does this sentence \"" + lower + "\" have an uppercase character? " + example.uppercase(lower));
		System.out.println("Does this sentence \"" + upper + "\" have an uppercase character? " + example.uppercase(upper));
		System.out.println("Pre-magic: " + lower + "\n" + "Post magic: " + example.converter(lower));
		String num = "1327";
		example.addition(num);
	}
}

	abstract class TheAbstract
	{	
		abstract boolean uppercase(String str);
		abstract String converter(String str);
		abstract void addition(String str);
	}

	class Execution extends TheAbstract
	{		
		boolean uppercase(String str) 
		{
			for(int i=0; i<str.length(); i++)
			{
				if(Character.isUpperCase(str.charAt(i))) 
				{
					return true; 
				}
			}
			return false;
		}

		@Override
		String converter(String str)
		{
			return str.toUpperCase();
		}
		@Override
		void addition(String str) 
		{
			int result = Integer.parseInt(str);
			System.out.println("Your new number is " + (result + 10));
		}
		
	}

