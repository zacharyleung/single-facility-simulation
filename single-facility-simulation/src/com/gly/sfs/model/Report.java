package com.gly.sfs.model;

import java.util.Arrays;

public class Report {
	/** The period when the report is written. */
    private int period;
    /** The inventory level at the beginning of the period. */
    private int inventory;
    /** pastDemand[k] = demand during period "period" - 1 - k. */
    private int[] pastDemand;

    private int arrivalPeriod = NOT_SET;
    
    private static int NOT_SET = Integer.MIN_VALUE;
    
    public Report(Builder builder) {
        this.period = builder.period;
        this.inventory = builder.inventory;
        this.pastDemand = builder.pastDemand;
    }

    public void setArrivalPeriod(int t) {
    	arrivalPeriod = t;
    }
    
    public int getArrivalPeriod() {
    	return arrivalPeriod;
    }
    
    public static class Builder {
        private int period;
        private int inventory;
        private int[] pastDemand;

        public Builder withPeriod(int period) {
            this.period = period;
            return this;
        }

        public Builder withInventory(int inventory) {
            this.inventory = inventory;
            return this;
        }

        public Builder withPastDemand(int[] pastDemand) {
            this.pastDemand = Arrays.copyOf(pastDemand, pastDemand.length);
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}
