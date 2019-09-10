package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.VillainDao;
import com.example.model.Villain;

/*
 * component(parent), repository, controller, service, configuration...
 * all of these annotations are known as stereotypes
 */

@Service("villainService")
public class VillainServiceImpl implements VillainService{
	
	//Old way, without Dependency Injection
	//private VillainDao vDao = new VillainDao();
	
	//with DI
	private VillainDao villainDao;

	public List<Villain> getAllVillains(){
		return villainDao.selectAll();
	}
	
	public VillainServiceImpl() {
		System.out.println("no args constructor");
	}
	
	public VillainDao getVillainDao() {
		return villainDao;
	}
	
	@Autowired
	//the autowired annotation tells Spring to attempt autowiring
	//using the below method, can be a setter, can also be a constructor
	public void setVillainDao(VillainDao vDao) {
		this.villainDao=vDao;
	}
		
	}
	
