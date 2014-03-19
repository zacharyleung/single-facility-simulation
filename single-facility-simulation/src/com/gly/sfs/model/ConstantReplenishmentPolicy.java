package com.gly.sfs.model;

import java.util.Iterator;

public class ConstantReplenishmentPolicy extends AbstractReplenishmentPolicy {

	private int quantity;

	public ConstantReplenishmentPolicy(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int getReplenishmentQuantity(int t) {
		boolean hasReport = false;
		Iterator<Report> iter = reportList.iterator();
		while (iter.hasNext()) {
			if (iter.next().getArrivalPeriod() == t) {
				iter.remove();
				hasReport = true;
			}
		}
		if (hasReport) {
			return quantity;
		} else {
			return 0;
		}
	}

}
