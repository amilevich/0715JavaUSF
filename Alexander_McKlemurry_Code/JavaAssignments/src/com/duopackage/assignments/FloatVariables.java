package com.duopackage.assignments;

public class FloatVariables {

	 public int seta1;
	public int b1;
	public String getb1;
	public int getb11;
	private int sata1;

	 public FloatVariables() {
	        this.satA1();			//input my integers for sata1 and get getb1
	        //I am leaving them as 0 and null because it is simple
	        this.getB1();
	    }

	public void satA1(int i) {  //public is its access level while void simply means it has no return
		//value
		// TODO Auto-generated method stub
		
	}

	
	public int satA1() {				//The list below serves as the storing of information that
		//the second package can pull from. 
		return sata1; //Since void is not being used in the method, a return value must be provided
	}

	
	public void setA1(int seta1) { //void here serves to inform the system that there is no
		this.sata1 = seta1;			//return value
	}

	
	public String getB1() {		//same as above
		return getb1;
	}

	
	public void getB1(String getb1) {	//void rules apply here as well
		this.getb1 = getb1;
	}

	

	
	}
	
		
		
		
	


