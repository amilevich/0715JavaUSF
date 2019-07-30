package q20;

import java.io.*;
import java.util.ArrayList;
public class ReadinStuff {
	public static void main(String[] args) throws IOException {
		//first the filepath has to be determined in order to point to where the text is that we need.
		File file = new File("C:\\Users\\Andre Doucet\\Documents\\workspace-sts-3.9.4.RELEASE\\Java Core Homework Andre Doucet\\src\\q20\\Data");
		
		//LinkedHashMap<String, String> meow = new LinkedHashMap<String, String>();
		ArrayList aListSpace = new ArrayList();
		
		//the BufferedReader allows the class to read the text file
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		
		//Everytime a colon(:) is found we cut out the word and chuck it into the string array is put into an array list
		while ((st = br.readLine()) !=null) {
			String[] specialString = st.split(":" ,20);
			//System.out.println("Name: " + "Age: " +"State: " + st);
			for(int i= 0; i< specialString.length ; i++){
				//System.out.println(specialString[i]);
				aListSpace.add(specialString[i]);
			}
			
			
			
	}
		//This prints out the stuff in the string array
		for(int i =0; i < aListSpace.size(); i= i +4) {
			System.out.print("Name: " + aListSpace.get(i) + " " );
			System.out.println(aListSpace.get(i + 1));
			System.out.println("Age: " + aListSpace.get(i + 2));
			System.out.println("State: " + aListSpace.get(i + 3));
		}
}
	
	}
