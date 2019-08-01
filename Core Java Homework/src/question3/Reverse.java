package question3;

public class Reverse {
	public static void main(String[] args)
	{
	    String str = "Reverse me you coward";

	    int len = str.length();
	    
	    for (int i = (len-1); i >= 0; --i) 
	    {
	        str += str.charAt(i);
	    }
	    
	    str = str.substring(len);
	    
	    System.out.println(str);
	}
}
