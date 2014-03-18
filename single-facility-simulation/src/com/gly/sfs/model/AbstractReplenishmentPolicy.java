package com.gly.sfs.model;

public abstract class AbstractReplenishmentPolicy {
	public abstract void addReport(Report report);
	
	public abstract int getReplenishmentQuantity(int t);
}
