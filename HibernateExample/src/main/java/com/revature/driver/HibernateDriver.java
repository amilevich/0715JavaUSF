package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.domains.HoneyPot;
import com.revature.util.SessionFactoryUtil;

public class HibernateDriver {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	public static void main(String[] args) {
<<<<<<< HEAD
		Session sess=sf.openSession();
		System.out.println("Everything fine");
=======
		Session sess = sf.openSession();
		System.out.println("Everything fine!!");
>>>>>>> 21cceb2b1d40776928090920f1be666132271c52
		sess.close();
	}
	
}
