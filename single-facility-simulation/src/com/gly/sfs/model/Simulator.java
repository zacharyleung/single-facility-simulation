package com.gly.sfs.model;

public class Simulator {
	private AbstractSchedule schedule;
	private AbstractReplenishmentPolicy replenishmentPolicy;
	private AbstractLeadTime leadTime;
	private AbstractDemand demand;

	private Facility facility;

	private Simulator(Builder builder) {
		this.schedule = builder.schedule;
		this.replenishmentPolicy = builder.replenishmentPolicy;
		this.leadTime = builder.leadTime;
		this.demand = builder.demand;
	}
	
	public void runSimulation(Parameters params) {
		int startPeriod = params.startPeriod;
		int endPeriod = params.endPeriod;
		
		facility = new Facility(startPeriod, endPeriod);
		for (int t = startPeriod; t < endPeriod; ++t) {
			// log the beginning of period inventory level
			facility.beginningOfPeriod(t);
			
			// submit a report if the facility is scheduled to 
			if (schedule.isReportingPeriod(t)) {
				Report report = facility.getReport(t);
				report.setArrivalPeriod(t + schedule.getDelay());
				replenishmentPolicy.addReport(report);
			}

			// replenish the facility			
			int quantity = replenishmentPolicy.getReplenishmentQuantity(t);
			if (quantity > 0) {
				Shipment shipment = new Shipment.Builder()
						.withQuantity(quantity)
						.withArrivalPeriod(t + leadTime.getLeadTime(t))
						.build();
				System.out.println(shipment);
				facility.addShipment(shipment);
			}

			// facility receives shipments that are due to arrive
			facility.receiveShipments(t);

			// demand arrives at the facility 
			facility.demandArrives(t, demand.getDemand(t));
		}
		
		System.out.printf("%8s%10s%8s\n", "Period", "InvBegin", "Demand");
		for (int t = startPeriod; t < endPeriod; ++t) {
			System.out.printf("% 8d% 10d% 8d\n", t,
					facility.getBeginningOfPeriodInventory(t),
					facility.getDemand(t));
		}
	}

	public static class Parameters {
		private int startPeriod;
		private int endPeriod;
		
		private Parameters(Builder builder) {
			this.startPeriod = builder.startPeriod;
			this.endPeriod = builder.endPeriod;
		}
		
		public static class Builder {
			private int startPeriod;
			private int endPeriod;
			
			public Builder withStartPeriod(int startPeriod) {
				this.startPeriod = startPeriod;
				return this;
			}
			
			public Builder withEndPeriod(int endPeriod) {
				this.endPeriod = endPeriod;
				return this;
			}
			
			public Parameters build() {
				return new Parameters(this);
			}
		}
	}
	
	public static class Builder {
		private AbstractSchedule schedule;
		private AbstractReplenishmentPolicy replenishmentPolicy;
		private AbstractLeadTime leadTime;
		private AbstractDemand demand;
	
		public Builder withSchedule(AbstractSchedule schedule) {
			this.schedule = schedule;
			return this;
		}
		
		public Builder withReplenishmentPolicy(AbstractReplenishmentPolicy replenishmentPolicy) {
			this.replenishmentPolicy = replenishmentPolicy;
			return this;
		}
		
		public Builder withLeadTime(AbstractLeadTime leadTime) {
			this.leadTime = leadTime;
			return this;
		}
		
		public Builder withDemand(AbstractDemand demand) {
			this.demand = demand;
			return this;
		}
		
		public Simulator build() {
			return new Simulator(this);
		}
	}
}
