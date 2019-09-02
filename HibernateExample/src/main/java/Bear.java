import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.revature.domains.HoneyPot;

public class Bear {
	
	private int bearId;
	@Column(name="BEAR_COLOR")
	private String color;
	@Column
	private String breed;
	@Column
	private double height;
	@Column
	private double weight;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="BEAR_HOME")
	private Cave bearHome;
	@OneToOne()
	@JoinColumn(name="HONEYPOT_ID")
	private HoneyPot honeypot;
	
	public int getBearId() {
		return bearId;
	}
	public void setBearId(int bearId) {
		this.bearId = bearId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Cave getBearHome() {
		return bearHome;
	}
	public void setBearHome(Cave bearHome) {
		this.bearHome = bearHome;
	}
	public HoneyPot getHoneypot() {
		return honeypot;
	}
	public void setHoneypot(HoneyPot honeypot) {
		this.honeypot = honeypot;
	}
	public Bear(int bearId, String color, String breed, double height, double weight, Cave bearHome,
			HoneyPot honeypot) {
		super();
		this.bearId = bearId;
		this.color = color;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.bearHome = bearHome;
		this.honeypot = honeypot;
	}
	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", color=" + color + ", breed=" + breed + ", height=" + height + ", weight="
				+ weight + ", bearHome=" + bearHome + ", honeypot=" + honeypot + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bearHome == null) ? 0 : bearHome.hashCode());
		result = prime * result + bearId;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((honeypot == null) ? 0 : honeypot.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bear other = (Bear) obj;
		if (bearHome == null) {
			if (other.bearHome != null)
				return false;
		} else if (!bearHome.equals(other.bearHome))
			return false;
		if (bearId != other.bearId)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (honeypot == null) {
			if (other.honeypot != null)
				return false;
		} else if (!honeypot.equals(other.honeypot))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	
	

}
