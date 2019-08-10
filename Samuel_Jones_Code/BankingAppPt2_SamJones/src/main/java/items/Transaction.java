//package items;
//
//import beans.Account;
//import dao.AccountDimple;
//
//public class Transaction {
//	AccountDimple adi = new AccountDimple();
//	public void deposit(String aid, Double amount) {
//		Account a = adi.findAccountByAID(aid);
//		Double currBalance = a.getBalance();
//		Double newBalance = currBalance + amount;
//		a.setBalance(newBalance);
//		adi.updateAccountBalance(a);
//		
//	}
//	
//	public void withdraw(String aid, Double amount) {
//		Account a = adi.findAccountByAID(aid);
//		Double currBalance = a.getBalance();
//		if((currBalance - amount>0)){
//			Double newBalance = currBalance - amount;
//			a.setBalance(newBalance);
//			adi.updateAccountBalance(a);
//			System.out.println("Withdrawal Successful");
//			
//		}
//		else {
//			System.out.println("Insufficient funds to withdraw.");
//		}
//	}
//	
//	public void deleteAccountByAID(String aid) {
//		Account a = adi.findAccountByAID(aid);
//		adi.deleteAccount(a);
//	}
//	
//	public void approveAccountByAID(String aid) {
//		Account a = adi.findAccountByAID(aid);
//		adi.updateAccountApproval(a);
//	}
//	
//	public void transferAmount(String aid1, String aid2, Double amount) {
//		Account a1 = adi.findAccountByAID(aid1);
//		Account a2 = adi.findAccountByAID(aid2);
//		Double balanceOne = a1.getBalance();
//		Double balanceTwo = a2.getBalance();
//		if((balanceOne-amount)>0) {
//			a1.setBalance(balanceOne-amount); // subtract the amount from the first account
//			a2.setBalance(balanceTwo+amount); // add the amount to the second balance
//			adi.updateAccountBalance(a1);
//			adi.updateAccountBalance(a2);
//		}
//		else {
//			System.out.println("Insufficient funds to complete transfer.");
//		}
//		
//	}
//}
