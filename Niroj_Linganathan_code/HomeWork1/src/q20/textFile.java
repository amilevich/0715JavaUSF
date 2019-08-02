package q20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class textFile {
	public static void main(String[] args) {
		String filename="./Data.txt";
		details D=new details("Mickey","Mouse","Arizona",35);
		writeObject(filename,D);
		readobject(filename);
		
	}

public static void writeObject(String filename,Object obj) {
	try(ObjectOutputStream oops=new ObjectOutputStream(new FileOutputStream(filename))){
		oops.writeObject(obj);
	}catch(IOException e) {
		e.printStackTrace();
	}
}
public static void readobject(String filename) {
	try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename))){
		Object obj=ois.readObject();
		System.out.println(obj);
			}catch(IOException e) {
		e.printStackTrace();
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
}
}
