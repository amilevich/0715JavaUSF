package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Application;
import model.BankAccount;

public class Counter {
	public static Integer readTest(String str) {
		Integer[] integer = read();
		if (str == "Application") {
			return integer[0];
		} else {
			return integer[1];
		}
	}
	
	public static Integer[] read() {
		String file = "src/main/counter.txt";
		String currentLine = null;
		Integer[] integer = new Integer[2];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((currentLine = reader.readLine()) != null) {
				String[] cells = currentLine.split(":");

				if (cells[0].equals("Application")) {
					integer[0] = Integer.valueOf(cells[1]);
				
					Application.setCounter( Integer.valueOf(integer[0]) );
				} else {
					integer[1] = Integer.valueOf(cells[1]);
					
					BankAccount.setCounter( Integer.valueOf(integer[1]) );
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return integer;
	}

	public static void write() {
		String file = "src/main/counter.txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write("Application:"+Application.getCounter());
			writer.newLine();
			writer.write("BankAccount:"+BankAccount.getCounter());
			
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
