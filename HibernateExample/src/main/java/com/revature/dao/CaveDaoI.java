package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.domains.Cave;
import com.revature.util.SessionFactoryUtil;

public class CaveDaoI implements CaveDao {
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	@Override
	public void updateCave(Cave cave) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		sess.update(cave);
		sess.close();
	}

	@Override
	public void insertCave(Cave cave) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(cave);
		tx.commit();
		sess.close();
	}

	@Override
	public void deleteCave(Cave cave) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		sess.delete(cave);
		sess.close();
	}

	@Override
	public Cave getCaveById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
