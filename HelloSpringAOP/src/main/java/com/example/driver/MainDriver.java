package com.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.myapp.MyAppProxy;

/*
 * Spring AOP - Aspect Oriented Programming, a module of Spring
 * framework that solves cross-cutting concerns.
 * 
 * Cross-cutting concern - operations that do not follow best 
 * practices in the modularization and separation of concerns
 * regard and take place frequently across the application.
 * Two types:
 * 1)Code tangling - specific piece of code performs multiple
 * functions
 * 2)Code scattering - code performing a specific function that is 
 * fragmented and appears in more than one class/place. 
 * Examples: logging, exception handling, transaction management
 * and caching.
 * 
 * Aspect - a modularization of a concern that cuts across multiple
 * objects. (@Aspect above class)
 * 
 * Inside of an aspect you will find a collection of advice.
 * Advice - action taken by an aspect at a particular join point.
 * Join point - a point during the execution of the program, in 
 * 				Spring AOP, a join point is always a method
 * 				execution.
 * Pointcut - a set of one or more join points where an advice
 * 			  can be executed.
 * 
 */

public class MainDriver {

	public static void main(String[] args) {
		
	ApplicationContext appCon = new ClassPathXmlApplicationContext("Ruben.xml");
	MyAppProxy app = appCon.getBean("appProxy", MyAppProxy.class);
	
	app.drawCartoon();
	app.drawMiniCartoon(5);
	app.drawNature();
	app.sculptPottery();

	}
}
