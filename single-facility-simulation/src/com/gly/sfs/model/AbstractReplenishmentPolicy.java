package com.gly.sfs.model;

import java.util.LinkedList;

public abstract class AbstractReplenishmentPolicy {
	protected LinkedList<Report> reportList = new LinkedList<>();
	
	public void addReport(Report report) {
		reportList.add(report);
	}
	
	public abstract int getReplenishmentQuantity(int t);
}
