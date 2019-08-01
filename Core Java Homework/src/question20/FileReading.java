package question20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReading
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("C:\\Users\\minqi\\Desktop\\Revvie\\Spring\\Core Java Homework\\src\\question20\\Data.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String string; 
		String[] strings; 
		while((string = reader.readLine()) != null)
		{
			strings = string.split(":");
			System.out.println("Name: " + strings[0] + " " + strings[1]);
			System.out.println("Age: " + strings[2]);
			System.out.println("State: " + strings[3] + " State");
			System.out.println();
		}
		reader.close();
	}
}