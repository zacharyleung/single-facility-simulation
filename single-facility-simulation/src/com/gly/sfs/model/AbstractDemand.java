package com.gly.sfs.model;

public abstract class AbstractDemand {
	/**
	 * The demand at the facility during period t.
	 * @param t
	 * @return
	 */
	public abstract int getDemand(int t);
}
