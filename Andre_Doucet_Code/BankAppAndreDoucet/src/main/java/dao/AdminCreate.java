package dao;

import com.drivers.DataDBDriver;
import com.mainmenu.MainScreen;
import com.uncertainty.Admin;

public class AdminCreate {
	public boolean addtoDB(Admin admin) {
		String filename = "./admin.txt";
		DataDBDriver<Admin> driveDB = new DataDBDriver<>();
		return driveDB.writerFile(admin, filename);
		
	}
}
