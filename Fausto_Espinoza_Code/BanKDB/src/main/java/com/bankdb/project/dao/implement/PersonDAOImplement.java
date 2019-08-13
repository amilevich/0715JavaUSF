package com.bankdb.project.dao.implement;

import java.util.List;

import com.bankdb.project.dao.person.CreatePersonDao;
import com.bankdb.project.dao.person.FindAllJointPeopleDao;
import com.bankdb.project.dao.person.FindAllPeopleDao;
import com.bankdb.project.dao.person.FindPersonByIdDao;
import com.bankdb.project.dao.person.FindPersonByUserDao;
import com.bankdb.project.inteface.GeneralRepository;
import com.bankdb.project.model.Person;

public class PersonDAOImplement implements GeneralRepository<Person>{
	public static CreatePersonDao personDAO  = new CreatePersonDao();
	public static FindPersonByIdDao findPerson  = new FindPersonByIdDao();
	public static FindAllPeopleDao findAllPeople = new FindAllPeopleDao();
	public static FindPersonByUserDao findbyUser = new FindPersonByUserDao();
	public static FindAllJointPeopleDao findAllJointPe = new FindAllJointPeopleDao();
	
	@Override
	public boolean createRegister(Person t) {		
		return personDAO.createPerson(t);
	}

	@Override
	public List<Person> finAllRegister() {
		return null;
	}
	
	public List<Person> finAllRegister(String t) {
		return findAllPeople.findAll(t);
	}
	
	public List<Person> finAllJntRegister(String t) {
		return findAllJointPe.findAll(t);
	}
	
	@Override
	public Person findById(Person t) {
		return findPerson.findById(t);
	}
	
	public Person findByUser(Person t) {
		return findbyUser.findByUser(t);
	}

	@Override
	public boolean updateRegister(Person t) {
		return false;
	}

	@Override
	public boolean deleteRegister(Person t) {
		return false;
	}

	

}
