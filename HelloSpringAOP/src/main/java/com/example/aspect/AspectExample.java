package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("aspect")
@Aspect
public class AspectExample {
	
	/*
	 * Types of advice:
	 * AfterReturning - execute if a method returns successfully
	 * Before - executes before a join point
	 * Around - most powerful type of advice, it executes before
	 * AND after a join point. Custom behavior for both before and 
	 * after.
	 * AfterThrowing - executes if a method exits via an exception 
	 * After (finally) - executes no matter on how a join point exits
	 */
	
	@After("execution(public int draw*(*))")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("snack break!");
	}
	//point cut is after the annotation
	/*
	 * "*" - a wildcard for return types and method naming
	 * ".." - a wildcard for our parameter list
	 * "*" - a wildcard for a SINGLE parameter in the parameter list
	 */
	
	@Before("execution(* *p*t*er*(..))")
	public void findPotteryMethod(JoinPoint jp) {
		System.out.println("next method will be pottery");
	}
	
	@Around("execution(* scul*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("putting on an apron");
		pjp.proceed();
		System.out.println("clean up");
	}

}
