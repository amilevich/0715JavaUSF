package homework.question.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "src/homework/question/q20/Data.txt";
		String currentLine = null;
		
		try {
			BufferedReader reader = new BufferedReader( new FileReader(file) ); // read file using BufferedReader
			while((currentLine = reader.readLine()) != null) { // if reader has not reached the end of file keep reading
				String[] cells = currentLine.split(":"); // split the read line with every :
				System.out.println("Name: "+ cells[0] + " " + cells[1]);
				System.out.println("Age: "+ cells[2] + " years");
				System.out.println("State: "+ cells[3] + " State");
				System.out.println(""); // add space for every record
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
