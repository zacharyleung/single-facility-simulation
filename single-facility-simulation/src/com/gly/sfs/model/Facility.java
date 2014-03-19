package com.gly.sfs.model;

import java.util.Iterator;
import java.util.LinkedList;

import com.gly.sfs.util.*;

public class Facility {
	
	private LinkedList<Shipment> shipmentList = new LinkedList<>();
	private NegativeArray<Integer> demandArray;
	private NegativeArray<Integer> unmetDemandArray;
	/** Inventory level at the beginning of the period */
	private NegativeArray<Integer> inventoryBeginArray;
	
	private int inventory = 0;

	public Facility(int startPeriod, int endPeriod) {
		demandArray = new NegativeArray<Integer>(startPeriod, endPeriod);
		unmetDemandArray = new NegativeArray<Integer>(startPeriod, endPeriod);
		inventoryBeginArray = new NegativeArray<Integer>(startPeriod, endPeriod);
	}

	/**
	 * It is the beginning of this period, so log the beginning of
	 * period inventory level.
	 * @param period
	 */
	public void beginningOfPeriod(int period) {
		inventoryBeginArray.set(period, inventory);
	}
	
	public void receiveShipments(int period) {
		Iterator<Shipment> iter = shipmentList.iterator();
		while (iter.hasNext()) {
			Shipment shipment = iter.next();
			if (shipment.getArrivalPeriod() == period) {
				inventory += shipment.getQuantity();
				iter.remove();
			}
		}
	}
	
	public Report getReport(int t) {
		int[] pastDemand = new int[0];
		
		return new Report.Builder()
		.withInventory(inventory)
		.withPeriod(t)
		.withPastDemand(pastDemand)
		.build();
	}
	
	public void demandArrives(int period, int demand) {
		demandArray.set(period, demand);
		int consumption = Math.min(inventory, demand);
		inventory -= consumption;
		int unmetDemand = demand - consumption;
		unmetDemandArray.set(period, unmetDemand);
	}
	
	public void addShipment(Shipment shipment) {
		shipmentList.add(shipment);
	}

	public int getDemand(int period) {
		return demandArray.get(period);
	}
	
	public int getBeginningOfPeriodInventory(int period) {
		return inventoryBeginArray.get(period);
	}
	

}
