package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dao.ReimbursementDAOImpl;
import com.dao.UserDAOImpl;
import com.models.Reimbursement;
import com.models.User;

public class TestCase {

	@Test
	public void createUser() {
		User u = new User(44, "userTest4", "passTest", "firstTest", "lastTest", "email4@Test", 0);
		UserDAOImpl udi = new UserDAOImpl();
		assertEquals("Creating User", true, udi.createUser(u));
	}
	
	@Test
	public void selectByUserId() {
		UserDAOImpl udi = new UserDAOImpl();
		User u = new User(45, "userTest5", "passTest", "firstTest", "lastTest", "email5@Test", 0);
		udi.createUser(u);
		User uTest = udi.selectUserById(45);
		assertEquals("Selecting User", u.toString(), uTest.toString());
	}
	
	@Test 
	public void selectAllUsers() {
		UserDAOImpl udi = new UserDAOImpl();
		ArrayList<User> ur = new ArrayList<User>();
		User u = new User(0, "user", "pass", "first", "last", "email", 0);
		ur.add(u);
		User u2 = new User(44, "userTest4", "passTest", "firstTest", "lastTest", "email4@Test", 0);
		ur.add(u2);
		User u3 = new User(45, "userTest5", "passTest", "firstTest", "lastTest", "email5@Test", 0);
		ur.add(u3);
		assertEquals("Selecting all Users", ur.toString(),  udi.selectAllUsers().toString());
	}
	
	@Test
	public void deleteUsers() {
		UserDAOImpl udi = new UserDAOImpl();
		assertEquals("Deleting Users", true, udi.deleteUser(44));
		assertEquals("Deleting Users", true, udi.deleteUser(45));
	}

	
	
	
	
	
	@Test
	public void createReimbursement() {
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		Reimbursement r = new Reimbursement(44, 1.0, d, d, "descriptionTest", "Blob", 0, 0, 0, 0);
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		assertEquals("Creating Reimbursement", true, rdi.createReimbursement(r));
	}
	
	@Test
	public void selectReimById() {
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		Reimbursement r = new Reimbursement(45, 1.0, d, d, "descriptionTest", "Blob", 0, 0, 0, 0);
		rdi.createReimbursement(r);
		Reimbursement rTest = rdi.selectReimById(45);
		assertEquals("Selecting Reimbursement", r.toString(), rTest.toString());
	}
	
	@Test 
	public void selectAllReimbursements() {
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		ArrayList<Reimbursement> rr = new ArrayList<Reimbursement>();
		Reimbursement r = new Reimbursement(44, 1.0, d, d, "descriptionTest", "Blob", 0, 0, 0, 0);
		rr.add(r);
		Reimbursement r2 = new Reimbursement(45, 1.0, d, d, "descriptionTest", "Blob", 0, 0, 0, 0);
		rr.add(r2);
		assertEquals("Selecting all Reimbursements", rr.toString(),  rdi.selectAllReimbursements().toString());
	}
	
	@Test
	public void deleteReimbursements() {
		ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
		assertEquals("Deleting Reimbursement", true, rdi.deleteReimbursement(44));
		assertEquals("Deleting Reimbursement", true, rdi.deleteReimbursement(45));
	}
}
