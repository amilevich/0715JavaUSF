package q11ptone;
// in order to use the two floats from the other package, the other package had to be imported
import q11pttwo.FloatPrison;
public class FloatFreedom {
	
	
	public static void main(String[] args) {
		//the first two sys outs proved they were imported, and the 3rd sys out was to demonstrate the values could be used for local operations
		System.out.println("BadBoy has escaped! His prisoner # is: " + FloatPrison.BadBoy);
		System.out.println("BaddestBoi has escaped! His prisoner # is: " + FloatPrison.BaddestBoi);
		System.out.println(FloatPrison.BadBoy + FloatPrison.BaddestBoi);
	}
}
