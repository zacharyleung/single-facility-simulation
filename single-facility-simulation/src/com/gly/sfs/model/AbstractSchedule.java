package com.gly.sfs.model;

public abstract class AbstractSchedule {
	public abstract boolean isReportingPeriod(int t);
	
	public abstract int getDelay();
}
