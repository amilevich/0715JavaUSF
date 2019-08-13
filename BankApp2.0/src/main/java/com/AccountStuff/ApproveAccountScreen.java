package com.AccountStuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApproveAccountScreen {
	
	public static void myApproval(String individual) {
		Scanner sc = new Scanner(System.in);
		
		IndividualAccountDAO indivaccdao = new IndividualAccountDAO();
		List<Accounts> na = new ArrayList<>();
		na = indivaccdao.defineindiv(individual);
		if(na != null) {
			for(Accounts a:na) {
				System.out.println(a.getAccount_number());
			}
		}

		
	}

}
