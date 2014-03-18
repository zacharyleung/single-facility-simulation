package com.gly.sfs.model;

public class Simulator {
	private AbstractSchedule schedule;
	private AbstractReplenishmentPolicy replenishmentPolicy;
	private Facility facility;
	private AbstractLeadTime leadTime;
	private AbstractDemand demand;
	
	public void runSimulation(SimulationParameters params) {
		for (int t = params.startPeriod; t < params.endPeriod; ++t) {
			// facility receives shipments that are due to arrive
			facility.receiveShipments(t);
			
			// submit a report if the facility is scheduled to 
			if (schedule.isReportingPeriod(t)) {
				Report report = facility.getReport(t);
				report.setArrivalPeriod(t + schedule.getDelay());
				replenishmentPolicy.addReport(report);
			}
			
			// replenish the facility			
			int quantity = replenishmentPolicy.getReplenishmentQuantity(t);
			Shipment shipment = new Shipment.Builder()
					.withQuantity(quantity)
					.withArrivalPeriod(t + leadTime.getLeadTime(t))
					.build();
			facility.addShipment(shipment);
			
			// demand arrives at the facility 
			facility.demandArrives(t, demand.getDemand(t));
			
			
		}
	}
	
	public static class SimulationParameters {
		private int startPeriod;
		private int endPeriod;
	}
}
