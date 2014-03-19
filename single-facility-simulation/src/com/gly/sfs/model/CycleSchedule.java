package com.gly.sfs.model;

import com.gly.sfs.util.MathUtils;

/**
 * Let C denote the number of periods in a cycle.
 * The supplier is scheduled to ship to the facility in the periods
 * t ≡ 0 (mod C).
 * Let d denote the number of period of delay for a report.
 * The facility is scheduled to submit a report to the supplier in
 * the periods t ≡ -d (mod C).
 * @author zacleung
 *
 */
public class CycleSchedule extends AbstractSchedule {

	/** An integer greater than or equal to one. */
	private int cycle;
	/** An integer greater than or equal to zero.*/
	private int delay;
	
	private CycleSchedule(Builder builder) {
		this.delay = builder.delay;
		this.cycle = builder.cycle;
		
		if (delay < 0) {
			throw new IllegalArgumentException("delay >= 0 violated!");
		}
		if (cycle < 1) {
			throw new IllegalArgumentException("cycle >= 1 violated!");
		}
	}
	
	@Override
	public boolean isReportingPeriod(int t) {
		return MathUtils.positiveModulo(-delay, cycle) == 
				MathUtils.positiveModulo(t, cycle);
	}

	@Override
	public int getDelay() {
		return delay;
	}

	public static class Builder {
		private int cycle;
		private int delay;
		
		public Builder withCycle(int cycle) {
			this.cycle = cycle;
			return this;
		}
		
		public Builder withDelay(int delay) {
			this.delay = delay;
			return this;
		}
		
		public CycleSchedule build() {
			return new CycleSchedule(this);
		}
	}
	
}
