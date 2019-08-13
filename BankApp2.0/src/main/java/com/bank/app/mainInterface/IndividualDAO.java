package com.bank.app.mainInterface;

import java.util.List;

import com.mybank.app.Individual;

public interface IndividualDAO {
	
	//CREATE
    public int insertIndividual(Individual individual);
    
    //READ
    public Individual selectIndividualByUsername(String username);
    public List<Individual> selectAllIndividual();
    
    //UPDATE
    public int updateIndividual(Individual individual);
    
    //DELETE    
    public int deleteIndividual(Individual individual);

}
