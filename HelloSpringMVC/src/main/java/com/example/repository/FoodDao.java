package com.example.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Food;

@Repository("foodDao")
@Transactional
public class FoodDao {
	
	@Autowired
	private SessionFactory sesFact;
	public FoodDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(Food food) {
		sesFact.getCurrentSession().save(food);
	}
	
	public void update(Food food) {
		sesFact.getCurrentSession().update(food);
	}
	
	public Food selectById(int id) {
		return sesFact.getCurrentSession().get(Food.class, id);
	}
	
	public List<Food> selectAll(){
		return sesFact.getCurrentSession()
				.createQuery("from Food", Food.class).list();
	}

}
