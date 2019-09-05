package com.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Core Interfaces of Hibernate
 * 
 * CONFIGURATION (class)
 * - its job is to gather information from hibernate.cfg.xml and it is used to create
 * a session factory
 * 
 * SESSIONFACTORY
 * - its job is to create sessions and store information on how to make connections
 * to your db. Once it is configured, it is immutable.
 * 
 * SESSION
 * - its job is to manage the connection to your db and to provide the CRUD 
 * operations
 * 
 * TRANSACTION
 * - manages your transactions and cache (must be ACID)
 * 
 * CRITERIA API
 * - a criteria object is used to create and execute object-oriented criteria queries
 * to retrieve objects from the db. (also other things)
 * 
 * QUERY
 * - uses a combination of object-oriented programming and SQL.
 * Database independent.
 * 
 */
public class HibernateUtil {
	
	private static Session ses;
	private static SessionFactory sf = new Configuration().configure
			("hibernate.cfg.xml").buildSessionFactory();
	
	public static Session getSession() {
		if (ses == null)
			ses = sf.openSession();
		return ses;
	}
	
	public static void closeSes() {
		ses.close();
	}

}
