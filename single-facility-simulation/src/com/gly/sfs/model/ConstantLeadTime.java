package com.gly.sfs.model;

public class ConstantLeadTime extends AbstractLeadTime {

	private int leadTime;
	
	public ConstantLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}
	
	@Override
	public int getLeadTime(int t) {
		return leadTime;
	}

}
