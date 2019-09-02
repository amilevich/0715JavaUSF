package com.ers.project.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EnDeCrypt {
	
	public static String enCrypt(String s) {
        try {
			return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encrypt Error: " + e.getMessage());
		}
        
        return "";
    }
    
    public static String deCrypt(String s) {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        try {
			return new String(decode, "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Decrypt Error: " + e.getMessage());
		}
        return "";
    }

}
