package com.bankdb.project.model;

public class ParametersDB {
	
	private long idparameter;
	private long seqaccount;
	private String nameparameter;
	public long getIdparameter() {
		return idparameter;
	}
	public void setIdparameter(long idparameter) {
		this.idparameter = idparameter;
	}
	public long getSeqaccount() {
		return seqaccount;
	}
	public void setSeqaccount(long seqaccount) {
		this.seqaccount = seqaccount;
	}
	public String getNameparameter() {
		return nameparameter;
	}
	public void setNameparameter(String nameparameter) {
		this.nameparameter = nameparameter;
	}
	@Override
	public String toString() {
		return "Parameters [idparameter=" + idparameter + ", seqaccount=" + seqaccount + ", nameparameter="
				+ nameparameter + "]";
	}
	
	
	

}
