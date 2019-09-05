package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Director;
import com.example.util.HibernateUtil;

public class DirectorDao {

	public DirectorDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(Director dirc) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(dirc);
		
		tx.commit();
	}
	

	public void update(Director dirc) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(dirc);
		
		tx.commit();
	}
	

	public Director selectById(int id) {
		Session ses = HibernateUtil.getSession();
		
		Director myDirc = ses.get(Director.class, id);
		//ses.close();
		return myDirc;
	}
	

	public List<Director> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		List<Director> dircList = ses.createQuery("from Director").list();
		return dircList;
	}
	
}
