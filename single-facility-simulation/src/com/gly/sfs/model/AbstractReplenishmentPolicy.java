package com.gly.sfs.model;

import java.util.LinkedList;

public abstract class AbstractReplenishmentPolicy {
	protected LinkedList<Report> reportList = new LinkedList<>();
	
	/**
	 * Schedule the report to arrive at the supplier at the arrival
	 * period specified by the report.
	 * @param report
	 */
	public void addReport(Report report) {
		reportList.add(report);
	}
	
	/**
	 * Based on the report or reports received in the period t,
	 * calculate a replenishment quantity to be sent to the facility.
	 * @param t
	 * @return
	 */
	public abstract int getReplenishmentQuantity(int t);
}
