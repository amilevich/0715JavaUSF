package bank.running;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import bank.accounts.Employee;
import bank.accounts.Joint;
import bank.accounts.Personal;
import bank.accounts.User;

public class Serial 
{
	public void writeToFile(User x) throws IOException
	{
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("User.txt"));
		object.writeObject(x);
	}
	
	public void readFile() throws IOException, ClassNotFoundException
	{
		ObjectInputStream object = new ObjectInputStream(new FileInputStream("User.txt"));
		
		User x = (User) object.readObject();
		System.out.println(x);
	}

	public void writeTofile(Employee pAcc) throws IOException {
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("User.txt"));
		object.writeObject(pAcc);
		
	}

	public void writeTofile(Personal pAcc) throws IOException {
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("User.txt"));
		object.writeObject(pAcc);
		
	}

	public void writeTofile(Joint jAcc) throws IOException {
		ObjectOutputStream object = new ObjectOutputStream(new FileOutputStream("User.txt"));
		object.writeObject(jAcc);
		
	}
}
