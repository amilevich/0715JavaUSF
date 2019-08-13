package com.bankdb.project.screen;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.bankdb.project.dao.person.FindPersonByIdDao;
import com.bankdb.project.model.Person;

public class AccesScreen {
	final static Logger loggy = Logger.getLogger(AccesScreen.class);
	public Person accsesSystem(String TypePerson) {
		FindPersonByIdDao person = new FindPersonByIdDao();
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println("********************************************************");
		System.out.println("");
		System.out.println("");
		System.out.println("A C C E S S    S Y S T E M    S C R E E N");
		System.out.println("");
		System.out.println("");
		System.out.println("********************************************************");
		
		Person crdPerson = new Person();		
		System.out.println("Username: ");
		String user = scanner.nextLine();
		System.out.println("Password: ");
		String pwd = scanner.nextLine();
		
		crdPerson.setUser(user);
		crdPerson.setPwd(pwd);
		crdPerson.setKindPerson(TypePerson);
		crdPerson = person.findById(crdPerson);
		if(crdPerson != null)
			loggy.info("Logg in: " + crdPerson.getNmPerson() );	
		else
			loggy.fatal("User does not exist");
		
		return crdPerson;
	}
}
