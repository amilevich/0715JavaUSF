package utility.print;

import model.BankAccount;
import java.text.DecimalFormat;


public class Balance {
	static DecimalFormat df = new DecimalFormat("#,###,##0.00");
	public static void run(BankAccount ba) {
		System.out.println("Account Balance of Acct# " + ba.getNumber() + ": " + ba.getCurrency() + " " + df.format( ba.getAmount()));
	}
}
