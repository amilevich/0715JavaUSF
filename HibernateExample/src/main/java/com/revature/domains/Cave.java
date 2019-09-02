package com.revature.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CAVE")
public class Cave {
	
	@Id
	@Column(name="CAVE_ID")
	@SequenceGenerator(name="CAVE_ID_SQ", sequenceName="CAVE_ID_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CAVE_ID_SQ")
	private int caveId;
	
	@Column(name="CAVE_TYPE")
	private String caveType;
	
	@Column(name="SQ_FOOTAGE")
	private double caveSqFt;

	public int getCaveId() {
		return caveId;
	}

	public void setCaveId(int caveId) {
		this.caveId = caveId;
	}

	public String getCaveType() {
		return caveType;
	}

	public void setCaveType(String caveType) {
		this.caveType = caveType;
	}

	public double getCaveSqFt() {
		return caveSqFt;
	}

	public void setCaveSqFt(Float caveSqFt) {
		this.caveSqFt = caveSqFt;
	}

	public Cave() {
		super();
	}

	public Cave(int caveId, String caveType, double caveSqFt) {
		super();
		this.caveId = caveId;
		this.caveType = caveType;
		this.caveSqFt = caveSqFt;
	}

	@Override
	public String toString() {
		return "Cave [caveId=" + caveId + ", caveType=" + caveType + ", caveSqFt=" + caveSqFt + "]";
	}
	
	
}
