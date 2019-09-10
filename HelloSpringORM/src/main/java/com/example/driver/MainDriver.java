package com.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Food;
import com.example.repository.FoodDao;

public class MainDriver {
	
	/*
	 * Spring ORM is a Spring Module that allows
	 * Spring to manage another ORM frameworks in 
	 * your place.
	 * In our case, we let Spring ORM manage Hibernate.
	 */
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	public static FoodDao foodDao = appContext.getBean("foodRepo", FoodDao.class);
	
	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("All our foods: " + foodDao.selectAll());
	}
	
	public static void insertInitialValues() {
		
		Food food1 = new Food("Papaya", true);
		foodDao.insert(food1);
		
		Food food2 = new Food("Pizza", false);
		foodDao.insert(food2);
		
		Food food3 = new Food("Ramen", true);
		foodDao.insert(food3);
		
		Food food4 = new Food("Lobster", false);
		foodDao.insert(food4);
	}

}
