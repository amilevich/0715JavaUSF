package com.revature.dao;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.revature.model.ErsReimbursement;





public interface ErsReimbursementDao {
	
	
	//CREATE
	public int insertErsReimbursement(ErsReimbursement newreimbursement);
	//READ
	public ErsReimbursement selectErsReimbursementbyId(int reimbId);
	
	public static List<ErsReimbursement> selectAllReimbursement() {
		return null;
	}
	public static List<ErsReimbursement> selectByUserID(int userid){
		return null;
	}
	
	//UPDATE
	public int updateReimbursement(ErsReimbursement p);
	//DELETE
	public int deleteById(int p);
}
