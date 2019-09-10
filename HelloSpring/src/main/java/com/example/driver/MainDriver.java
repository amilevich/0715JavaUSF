package com.example.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.VillainService;

public class MainDriver {
	
	//before DI
	//private static VillainServiceImpl vServ = new VillainServiceImpl();
	//but we don't need to create our own instance when we have DI

	private static VillainService vServ;
	
	public static void main(String[] args) {

	ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		vServ = appContext.getBean("villainService", VillainService.class);
		System.out.println(vServ.getAllVillains());
	}

}
