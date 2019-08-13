package data.dao;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import data.dao.ApplicationDAOI;
import model.AccountDetail;
import model.Applicant;
import model.Application;
import utility.ds.MapOps;
import value.AccountSharing;
import value.ApplicationStatus;
import value.Currency;

import static org.junit.Assert.assertEquals;

public class ApplicationDAOITest {
	ApplicationDAOI appdao = new ApplicationDAOI();
	@Test
	public void getOne() {
		// we don't like to display the passwords when giving a list of applicants
		Application appFromDB = appdao.getOne(1);
		AccountDetail acctDetail = new AccountDetail(2000.0, Currency.EUR, AccountSharing.JOINT);
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		applicants.add(new Applicant("GABRIEL","FERRER","gabferr",null));
		applicants.add(new Applicant("JASON","FERRER","jasonferr",null));
		Application appFromJava = new Application(1, ApplicationStatus.APPROVED, applicants, acctDetail);
		assertEquals(appFromJava.toString(), appFromDB.toString());
	}
	
	@Test
	public void getNull () {
		//appdao returns null because record doesn't exist in the database
		assertEquals(null, appdao.getOne(0));
	}
	
	@Test
	public void isUpdated() {
		Application app = new Application();
		app.setAppStatus(ApplicationStatus.APPROVED);
		app.setNumber(4);
		appdao.updateOne(app);
	}
	
	//@Test
	public void getPKJoint () {
		Integer numberFromJava = 6;  // must update this number every test is run
		Integer numberFromDB;
		AccountDetail acctDetail = new AccountDetail(1_000_000.00, Currency.USD, AccountSharing.JOINT);
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		applicants.add(new Applicant("NIKKI","LOVE","nikkilove","Nikkilove21("));
		applicants.add(new Applicant("WILLIAM","WALLACE","williamwal","William23@"));
		applicants.add(new Applicant("JOHN","MORGAN","johnmorgan","Johnmorgan123$"));
		
		Application appFromJava = new Application(numberFromJava, ApplicationStatus.PENDING, applicants, acctDetail);
		numberFromDB = appdao.insertOne(appFromJava);
		System.out.println( numberFromJava );
		System.out.println( numberFromDB );
		assertEquals("pks equal", true, numberFromJava.equals( numberFromDB));
	}

	public void getAll() {
		TreeMap<Integer, Application> applications = appdao.getAll();
		Set<Integer> applicationNumbers = MapOps.mapToSet(applications);
		
		assertEquals("[1, 2, 3]", applicationNumbers.toString());
	}
}
