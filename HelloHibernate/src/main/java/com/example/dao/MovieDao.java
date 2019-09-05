package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Movie;
import com.example.util.HibernateUtil;

public class MovieDao {
	
	public MovieDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(Movie mov) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(mov);
		tx.commit();
	}
	
	public void update(Movie mov) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(mov);
		tx.commit();
	}
	
	public Movie selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Movie myMov = ses.get(Movie.class, id);
		return myMov;
	}
	
	public List<Movie> selectAll() {
		Session ses = HibernateUtil.getSession();
		
		List<Movie> movList = ses.createQuery("from Movie").list();
		return movList;
		
	}

}
