package com.bankdb.project.screen;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.bankdb.project.dao.person.FindPersonByIdDao;
import com.bankdb.project.model.Person;

public class AccesJointAccount {
	final static Logger loggy = Logger.getLogger(AccesJointAccount.class);
	public Person accsesSystem(String TypePerson, Person psn) {
		FindPersonByIdDao person = new FindPersonByIdDao();
		Scanner scanner = new Scanner(System.in);
		
		Person crdPerson = new Person();		
		System.out.println("Username: ");
		String user = scanner.nextLine();
		System.out.println("Password: ");
		String pwd = scanner.nextLine();
		
		crdPerson.setUser(user);
		crdPerson.setPwd(pwd);
		crdPerson.setKindPerson(TypePerson);
		crdPerson = person.findById(crdPerson);
		if(crdPerson != null) {
			if(!psn.getUser().equals(crdPerson.getUser())) {
				loggy.info("Logg in: " + psn.getNmPerson() + " " + crdPerson.getNmPerson());
				return crdPerson;
			}else {
				System.out.println("You can't joint account with the same person");
				loggy.info("You can't joint account with the same person");
				return null;
			}
			 	
		}else {
			loggy.fatal("User does not exist");}
		
		return null;
	}
}
