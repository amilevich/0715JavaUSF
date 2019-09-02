package com.ers.project.util;

import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Base64;

import com.ers.project.daoimpl.EmailDAOImpl;
import com.ers.project.model.Email;
import com.ers.project.model.ReimbursementStatus;


public class TestJson {
	
	public static void main(String[] args) {
//		List<ReimbursementStatus> statusList = new ArrayList<>();
//		List<ReimbursementStatus> statusList1 = new ArrayList<>();
//		ReimbursementStatus status = new ReimbursementStatus();
//		status.setStatusId(1);
//		status.setStatusName("Pendin");
//		statusList.add(status);
//		status = new ReimbursementStatus();
//		status.setStatusId(2);
//		status.setStatusName("Aprob");
//		statusList.add(status);
//		status = new ReimbursementStatus();
//		status.setStatusId(3);
//		status.setStatusName("Deny");
//		statusList.add(status);
//		
//		String JsonStatus = JsonUtil.convertJavaToJson(statusList);
//		
//		System.out.println(JsonStatus);
//		System.out.println("================================");
//		
////		statusList1 = JsonUtil.covertJsonToJava(JsonStatus, new TypeReference<List<ReimbursementStatus>>(){});
////		for(ReimbursementStatus r : statusList1) {
////			System.out.println(r.getStatusId() + " " + r.getStatusName());
////		}
//		String cadenaDeTexto = "Ruperto_01";
//        String cadenaEncriptada = "";
//		System.out.println("Cadena original > "+cadenaDeTexto);
//		cadenaEncriptada = EnDeCrypt.enCrypt(cadenaDeTexto);
//		System.out.println("Cadena encriptada > "+cadenaEncriptada);
//		String cadenaDesencriptada = EnDeCrypt.deCrypt(cadenaEncriptada);
//		System.out.println("Cadena desencriptada > "+cadenaDesencriptada);	
//		EmailDAOImpl emailDaoImpl = new EmailDAOImpl();
//		Email email = new Email();
//		email.seteMailId(1);
//		SendMail.sendMail(emailDaoImpl.findRecordById(email));
		
	}
	
	 

}
