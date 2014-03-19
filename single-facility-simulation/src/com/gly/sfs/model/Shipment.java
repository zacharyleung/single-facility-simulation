package com.gly.sfs.model;

class Shipment {
	private int quantity;
	private int arrivalPeriod;
	
	Shipment(Builder builder) {
		this.quantity = builder.quantity;
		this.arrivalPeriod = builder.arrivalPeriod;
	}
	
	int getArrivalPeriod() {
		return arrivalPeriod;
	}
	
	int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return String.format("Shipment{arrival period = %d, quantity = %d}",
				arrivalPeriod, quantity);
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
