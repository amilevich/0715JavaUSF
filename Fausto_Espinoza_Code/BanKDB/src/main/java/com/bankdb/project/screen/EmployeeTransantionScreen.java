package com.bankdb.project.screen;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.bankdb.project.VerifyNumber;
import com.bankdb.project.dao.implement.PersonDAOImplement;
import com.bankdb.project.model.Person;

public class EmployeeTransantionScreen {
	
	public Person  transferEmployee() {
		long count = 1;
		HashMap<Long,Person> mapH = new HashMap<>();
		List<Person> personList = new ArrayList<>();
		VerifyNumber vf = new VerifyNumber();
		PersonDAOImplement personImpl = new PersonDAOImplement();
		Person person = new Person();
		Scanner  scnner = new Scanner(System.in);
		long accountTemp = 0;
		String idCustomer;
		long number = 0;
		
		
		personList = personImpl.finAllRegister("C");
		
		if(personList != null) {
			for(Person p : personList) {
				System.out.println(count + " -> Name: " + p.getNmPerson());
				mapH.put(count, p);
				++count;
			}
			accountTemp = --count;
			do {
				System.out.println("Select the cutomer: ");
				idCustomer = scnner.nextLine();				
			}while(!vf.verifyNum(accountTemp, idCustomer) );
			
			number = Long.parseLong(idCustomer);
			person = mapH.get(number);			
			return person;			
		}
		
		return null;
	}

}
