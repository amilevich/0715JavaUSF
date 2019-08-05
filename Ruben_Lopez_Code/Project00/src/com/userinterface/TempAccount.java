package com.userinterface;

public class TempAccount {
	//account number
		private int tempAccountNumber = 5;
		//balance
		private double tempbalance = 5000.0;
		//first name
		private String tempFirstName = "Nick";
		//last name
		private String tempLastName = "Cannon";
		//address
		private String tempAddress = "312 2nd Street";
		//City
		private String tempCity = "Los Angles";
		//User Name
		private String tempUser = "Ruben1234";
		//Password
		private String tempPassword = "12345";
		
		public TempAccount() {
			
		}
		
		
		public TempAccount(int tempAccountNumber, double tempbalance, String tempFirstName, String tempLastName,
				String tempAddress, String tempCity, String tempUser, String tempPassword) {
			super();
			this.tempAccountNumber = tempAccountNumber;
			this.tempbalance = tempbalance;
			this.tempFirstName = tempFirstName;
			this.tempLastName = tempLastName;
			this.tempAddress = tempAddress;
			this.tempCity = tempCity;
			this.tempUser = tempUser;
			this.tempPassword = tempPassword;
		}
		
		
		public int getTempAccountNumber() {
			return tempAccountNumber;
		}
		public void setTempAccountNumber(int tempAccountNumber) {
			this.tempAccountNumber = tempAccountNumber;
		}
		
		
		
		
		public double getTempbalance() {
			return tempbalance;
		}
		public void setTempbalance(double tempbalance) {
			this.tempbalance = tempbalance;
		}
		
		
		
		
		public String getTempFirstName() {
			return tempFirstName;
		}
		public void setTempFirstName(String tempFirstName) {
			this.tempFirstName = tempFirstName;
		}
		
		
		
		public String getTempLastName() {
			return tempLastName;
		}
		public void setTempLastName(String tempLastName) {
			this.tempLastName = tempLastName;
		}
		
		
		
		public String getTempAddress() {
			return tempAddress;
		}
		public void setTempAddress(String tempAddress) {
			this.tempAddress = tempAddress;
		}
		
		
		
		
		public String getTempCity() {
			return tempCity;
		}
		public void setTempCity(String tempCity) {
			this.tempCity = tempCity;
		}
		
		
		
		
		public String getTempUser() {
			return tempUser;
		}
		public void setTempUser(String tempUser) {
			this.tempUser = tempUser;
		}
		
		
		
		//
		public String getTempPassword() {
			return tempPassword;
		}
		public void setTempPassword(String tempPassword) {
			this.tempPassword = tempPassword;
		}
		
		
}
