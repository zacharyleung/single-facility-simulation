package com.gly.sfs.model;

class Shipment {
	private int quantity;
	private int arrivalPeriod;
	
	Shipment(Builder builder) {
		this.quantity = builder.quantity;
		this.arrivalPeriod = builder.arrivalPeriod;
	}
	
	static class Builder {
		private int quantity;
		private int arrivalPeriod;
		
		public Builder withQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Builder withArrivalPeriod(int arrivalPeriod) {
			this.arrivalPeriod = arrivalPeriod;
			return this;
		}
		
		public Shipment build() {
			return new Shipment(this);
		}
	}
}
