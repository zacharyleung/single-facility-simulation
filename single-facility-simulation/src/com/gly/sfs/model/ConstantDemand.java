package com.gly.sfs.model;

public class ConstantDemand extends AbstractDemand {
	private int demand;
	
	public ConstantDemand(int demand) {
		this.demand = demand;
	}
	
	@Override
	public int getDemand(int t) {
		return demand;
	}
}
