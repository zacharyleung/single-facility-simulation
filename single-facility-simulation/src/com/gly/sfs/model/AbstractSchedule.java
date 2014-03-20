package com.gly.sfs.model;

public abstract class AbstractSchedule {
	/**
	 * Returns <code>true</code> if the facility is scheduled to
	 * submit a report in period t. 
	 * @param t
	 * @return
	 */
	public abstract boolean isReportingPeriod(int t);
	
	/**
	 * Returns the number of periods of delay between the facility
	 * submitting a report and the supplier receiving the report.
	 * @return
	 */
	public abstract int getDelay();
}
