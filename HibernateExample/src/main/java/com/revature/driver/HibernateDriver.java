package com.revature.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.domains.HoneyPot;
import com.revature.util.SessionFactoryUtil;

public class HibernateDriver {

	private static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	public static void main(String[] args) {
		Session sess=sf.openSession();
		System.out.println("Everything fine");
		sess.close();
	}
	
}
