package com.revature.dao;

import java.util.List;

import static org.hibernate.criterion.Restrictions.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.revature.domains.Bear;
import com.revature.util.SessionFactoryUtil;

public class BearDaoImpl {
	
	SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	public void queryDemo() {
		
		Session sess = sf.openSession();
		
		String hql = "FROM Bear as b WHERE b.breed = :type";
		
		Query query = sess.createQuery(hql);
		
		query.setParameter("type", "polar");
		
		List<Bear> bears = query.list();
		
		String breed = "grizzly";
		
		SQLQuery nativeSQLQuery = sess.createSQLQuery("Select * from bears where breed = " + breed);
		
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
		
		Criteria crit = sess.createCriteria(Bear.class);
		
		List<Bear> result = crit.list();
		
		sess.close();
		
		return result;
	}
	
	public List<Bear> getBearsByBreed(String breed) {
		Session sess = sf.openSession();
		Criteria crit = sess.createCriteria(Bear.class).add(Restrictions.eq("breed", breed));
		List<Bear> result = crit.list();
		sess.close();
		return result;
	}
	
	public List<Bear> getBearsByBreedAndWeightLessThan(String breed, double weight) {
		Session sess = sf.openSession();
		
		Criteria crit = sess.createCriteria(Bear.class)
				.add(
						and(
								eq("breed", breed), 
								lt("weight", weight)
								));
		List<Bear> result = crit.list();
		sess.close();
		return result;
	}

}
