package src.com.john.ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.com.john.core.AccountManager;
import src.com.john.core.UserManager;

public class Serializer
{
	String um_Filename;
	String am_Filename;
	
	public UserManager um;
	public AccountManager am;
	
	public Serializer()
	{
		um_Filename = "./userManager.txt";
		am_Filename = "./accountManager.txt";
		
		um = loadUserManager();
		am = loadAccountManager();
	}
	
	private UserManager loadUserManager()
	{
		UserManager loaded_UM = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(um_Filename))) {
			loaded_UM = (UserManager)ois.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return loaded_UM;
	}
	
	private AccountManager loadAccountManager()
	{
		AccountManager loaded_AM = null;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(am_Filename))) {
			loaded_AM = (AccountManager)ois.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return loaded_AM;
	}
	
	public void store(UserManager u_m, AccountManager a_m)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(um_Filename))) {
			oos.writeObject(u_m);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(am_Filename))) {
			oos.writeObject(a_m);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}