package com.testing.project0;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.project.zero.BankAccount;
import com.project.zero.ObjectStorage;

public class Testing0 {
	
		@Test
		public void test() {
			assertEquals("Literally the only non-void", true, (BankAccount.Load()!=null));
		}
}
