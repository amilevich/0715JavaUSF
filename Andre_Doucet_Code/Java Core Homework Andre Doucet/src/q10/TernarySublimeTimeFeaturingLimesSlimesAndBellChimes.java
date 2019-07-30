package q10;

public class TernarySublimeTimeFeaturingLimesSlimesAndBellChimes {
	
	public static void main(String[] args) {
// this is where the variables are all declared
int derp = 500, herp = 420, burp = 1, yurp, birbs;


//one of the ternary operators was made to figure out the max, the second finds the minimum
yurp = ((derp > herp)
			? (derp > burp)
					? derp
					: burp
			: (herp > burp)
			
			? herp
			: burp);

birbs = ((herp > derp)
		? (herp > burp)
				? herp
				: burp
			: (derp < burp)
			
			?derp
			: burp


	);

//max and min ternary nightmares are printed to the console
System.out.println("Max number of Yurps detected = " + yurp);
System.out.println("Min number of Birbs detected = " + birbs);

	}
}
