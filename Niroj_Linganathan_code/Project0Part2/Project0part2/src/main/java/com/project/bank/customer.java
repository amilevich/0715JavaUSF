package com.project.bank;

public class customer {
	String userName;
	String passWord;
	String fName;
	String lName;
	String address;
	String accType;
	int uniqueNo;
	String accStatus;
	
	public customer() {
		super();
	}

	public customer(String userName, String passWord, String fName, String lName, String address, String accType,
			int uniqueNo, String accStatus) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.accType = accType;
		this.uniqueNo = uniqueNo;
		this.accStatus = accStatus;
	}

	
	public customer(String accType) {
		super();
		this.accType = accType;
	}

	public customer(String userName, String accStatus) {
		super();
		this.userName = userName;
		this.accStatus = accStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public int getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(int uniqueNo) {
		this.uniqueNo = uniqueNo;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	/*@Override
	public String toString() {
		return "customer [userName=" + userName + ", passWord=" + passWord + ", fName=" + fName + ", lName=" + lName
				+ ", address=" + address + ", accType=" + accType + ", uniqueNo=" + uniqueNo + ", accStatus="
				+ accStatus + "]";
	}*/

	@Override
	public String toString() {
		return "UserName ==> " + userName + "  First Name ==> " + fName + ", Last Name ==>" + lName
				+ " Address ==> " + address + " Account Type ==> " + accType + "  Account Status ==> "
				+ accStatus;
	}
	

}
