package com.ers.project.model;

public class ReimbursementTypes {
	private long typeId;
	private String typeName;
	
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "ReimbursementType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	

}
