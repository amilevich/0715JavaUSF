package com.revature.dao;

import java.util.List;

import static org.hibernate.criterion.Restrictions.*;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.domains.Bear;
import com.revature.domains.HoneyPot;
import com.revature.util.SessionFactoryUtil;

public class BearDaoI implements BearDao {
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	public void queryDemo() {
		Session sess = sf.openSession();
		String hql= "From Bear as b WHERE b.breed = :type";
		
		Query query = sess.createQuery(hql);
		
		query.setParameter("type", "polar");
		
		List<Bear> bears = query.list();
		
		String breed = "grizzly";
		
		SQLQuery nativeSQLQuery = sess.createSQLQuery
				("select * from bears where breed = " + breed);
		
		nativeSQLQuery.addEntity(Bear.class);
		
		bears = nativeSQLQuery.list();
		
		Query query2 = sess.getNamedQuery("get_bears_by_weight");
		double weight = 850.0;
		
		query2.setDouble("weight", weight);
		bears = query2.list();
		
		sess.close();
	}
	
	public List<Bear> getAllBears() {
		Session sess = sf.openSession();
		
		Criteria criteria = sess.createCriteria(Bear.class);
		
		List<Bear> result = criteria.list();
		sess.close();
		
		return result;
	}
	
	public List<Bear> getBearsByBreed(String breed) {
		Session sess = sf.openSession(); 
		Criteria criteria = sess.
				createCriteria(Bear.class).add(Restrictions.eq("breed", breed));
		List<Bear> result = criteria.list();
		sess.close();
		return result;
	}
	
	public List<Bear> getBearsByBreedAndWeightLessThan(String breed, double weight) { 
		Session sess = sf.openSession(); 
		Criteria criteria = sess.
				createCriteria(Bear.class)
				.add( and( eq("breed", breed), lt("weight", weight) ));
		
		List<Bear> result = criteria.list();
		sess.close();
		return result;
	}
	
	@Override
	public void updateBear(Bear bear) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		sess.update(bear);
		sess.close();
	}

	@Override
	public void insertBear(Bear bear) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(bear);
		tx.commit();
		sess.close();
	}

	@Override
	public void deleteBear(Bear bear) {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		sess.delete(bear);
		sess.close();
	}

	@Override
	public Bear getBearById(int id) {
		Session sess = sf.openSession();
		Bear result = (Bear) sess.get(Bear.class, id);
		return result;
	}
	
	public List<Bear> getAllHoneyPots() {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Bear.class);
		List<Bear> result = crit.list();
		sess.close();
		return result;
	}

}
