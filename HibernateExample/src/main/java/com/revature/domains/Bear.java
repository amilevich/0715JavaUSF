package com.revature.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEAR")
@NamedQueries({
	@NamedQuery
	(name="get_small_bears", query="FROM Bear as b where b.weight < 200"),
	@NamedQuery
	(name="get_bears_by_weight", query="FROM Bear as b where b.weight = :weight")
})
public class Bear {
	@Id
	@Column(name="BEAR_ID")
	@SequenceGenerator(name="BEAR_ID_SQ", sequenceName="BEAR_ID_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BEAR_ID_SQ")
	private int bearId;
	
	@Column(name="BEAR_COLOR")
	private String bearColor;
	
	@Column(name="BREED")
	private String bearBreed;
	
	@Column(name="HEIGHT")
	private double bearHeight;
	
	@Column(name="WEIGHT")
	private double bearWeight;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BEAR_HOME", nullable=true)
	private Cave bearHome;

	@OneToOne
	@JoinColumn(name="HONEYPOT_ID", nullable=true)
	private HoneyPot bearHoneypot;

	public Bear() {
		super();
	}

	public Bear(int bearId, String bearColor, String bearBreed, double bearHeight, double bearWeight, Cave bearHome,
			HoneyPot bearHoneypot) {
		super();
		this.bearId = bearId;
		this.bearColor = bearColor;
		this.bearBreed = bearBreed;
		this.bearHeight = bearHeight;
		this.bearWeight = bearWeight;
		this.bearHome = bearHome;
		this.bearHoneypot = bearHoneypot;
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getBearColor() {
		return bearColor;
	}

	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}

	public String getBearBreed() {
		return bearBreed;
	}

	public void setBearBreed(String bearBreed) {
		this.bearBreed = bearBreed;
	}

	public double getBearHeight() {
		return bearHeight;
	}

	public void setBearHeight(double bearHeight) {
		this.bearHeight = bearHeight;
	}

	public double getBearWeight() {
		return bearWeight;
	}

	public void setBearWeight(double bearWeight) {
		this.bearWeight = bearWeight;
	}

	public Cave getBearHome() {
		return bearHome;
	}

	public void setBearHome(Cave bearHome) {
		this.bearHome = bearHome;
	}

	public HoneyPot getBearHoneypot() {
		return bearHoneypot;
	}

	public void setBearHoneypot(HoneyPot bearHoneypot) {
		this.bearHoneypot = bearHoneypot;
	}
	
	
	
}
