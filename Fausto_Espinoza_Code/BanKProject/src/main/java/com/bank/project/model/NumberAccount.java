package com.bank.project.model;

import java.io.Serializable;

public class NumberAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1627994754563601180L;
	private long count;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "NumberAccount [count=" + count + "]";
	}
	
	

}
