package com.gly.sfs;

import com.gly.sfs.model.*;

public class BasicTest {

	public static void main(String[] args) {
		AbstractDemand demand = new ConstantDemand(10);
		AbstractLeadTime leadTime = new ConstantLeadTime(2);
		AbstractSchedule schedule = 
				new CycleSchedule.Builder()
		.withCycle(5)
		.withDelay(2)
		.build();
		AbstractReplenishmentPolicy replenishmentPolicy =
				new ConstantReplenishmentPolicy(30);

		Simulator simulator = new Simulator.Builder()
		.withDemand(demand)
		.withLeadTime(leadTime)
		.withReplenishmentPolicy(replenishmentPolicy)
		.withSchedule(schedule)
		.build();
		
		Simulator.Parameters parameters = new Simulator.Parameters.Builder()
		.withStartPeriod(0)
		.withEndPeriod(10)
		.build();
		simulator.runSimulation(parameters);
	}

}
