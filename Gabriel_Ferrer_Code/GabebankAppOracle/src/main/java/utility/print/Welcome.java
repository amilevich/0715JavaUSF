package utility.print;

import java.io.IOException;

import com.github.lalyos.jfiglet.FigletFont;


public class Welcome {
	public static void run() {
		String asciiArt1;
		String asciiArt2;
		try {
			asciiArt1 = FigletFont.convertOneLine("Welcome to Gabe Bank");
			asciiArt2 = FigletFont.convertOneLine("http://www.figlet.org/fonts/small.flf", "    The Most Trusted Bank");
			System.out.println(asciiArt1);
			System.out.println(asciiArt2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	    
	}
}
