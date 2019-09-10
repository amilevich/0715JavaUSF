package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Villain;

/*
 * Spring annotations
 * - allow you to configure the dependency injection by moving
 * bean configuration into the class itself.
 * 
 * We have a Spring Bean named "villainDao"
 */


@Repository("villainDao")
public class VillainDaoImpl implements VillainDao{
	
	//this method is a mock DAO impl
	
	public List<Villain> selectAll(){
		List<Villain> vList = new ArrayList();
		
		vList.add(new Villain("Lex Luthor","Money, Brainz, Thyme", true));
		vList.add(new Villain("Depends on the Iteration","Depends", false));
		vList.add(new Villain("Eisenbherg","Science", true));
		vList.add(new Villain("Frank","Fire", true));
		return vList;
	}

}
