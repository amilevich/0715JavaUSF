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
	@Autowired
	private VillainDao villainDao;

	public List<Villain> getAllVillains(){
		return villainDao.selectAll();
	}
	
	public VillainServiceImpl() {
		System.out.println("no args constructor");
	}
	
	@Autowired
	public VillainDao getVillainDao() {
		return villainDao;
	}
	
	@Autowired
	//the autowired annotation tells Spring to attempt autowiring
	//using the below method, can be a setter, can also be a constructor
	public void setVillainDao(VillainDao vDao) {
		this.villainDao=vDao;
	}
	
	//@Autowired
	//tells spring to attempt autowiring using this constructor
	public VillainServiceImpl(VillainDao vDao) {
		System.out.println("in DI constructor");
		this.villainDao = vDao;
	}
		
	}
	
