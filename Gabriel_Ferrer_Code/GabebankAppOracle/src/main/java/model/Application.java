package model;

import java.util.ArrayList;

import value.ApplicationStatus;

public class Application {
	private Integer number;
	private ApplicationStatus appStatus;
	private AccountDetail accountDetail;
	private ArrayList<Applicant> applicants = new ArrayList<Applicant>();

	public Application() {}
	
	public Application(Integer number, ApplicationStatus appStatus, 
			ArrayList<Applicant> applicants, AccountDetail accountDetail) {
		this.number = number;
		this.appStatus = appStatus;
		this.applicants = applicants;
		this.accountDetail = accountDetail;
		
	}

	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}

	public AccountDetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	public ArrayList<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(ArrayList<Applicant> applicants) {
		this.applicants = applicants;
	}

	public void addApplicant(Applicant applicant) {
		this.applicants.add(applicant);
	}
	
	public ApplicationStatus getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(ApplicationStatus appStatus) {
		this.appStatus = appStatus;
	}

	@Override
	public String toString() {
		return "Application [applicants=" + applicants + ", accountDetail=" + accountDetail + "]";
	}
	
}

