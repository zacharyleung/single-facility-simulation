package com.gly.sfs.model;

public abstract class AbstractLeadTime {
	/**
	 * The lead time for a shipment sent by the supplier in period t
	 * to the facility.
	 */
	public abstract int getLeadTime(int t);
}
