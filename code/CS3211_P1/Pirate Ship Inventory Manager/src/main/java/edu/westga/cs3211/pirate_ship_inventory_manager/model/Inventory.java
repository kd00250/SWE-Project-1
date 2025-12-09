package edu.westga.cs3211.pirate_ship_inventory_manager.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The Inventory class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class Inventory {
	private ArrayList<Compartment> compartments;
	
	/**
	 * Creates a new instance of inventory
	 */
	public Inventory() {
		this.compartments = new ArrayList<Compartment>();
		Set<SpecialQuality> qualities = new HashSet<>();
		qualities.add(SpecialQuality.LIQUID);
        Stock stock = new Stock(1, new HashSet<>(), "Paper", "perfect", null);
        Stock stock2 = new Stock(1, qualities, "Oil", "perfect", null); 
        Stock stock3 = new Stock(2, new HashSet<>(), "Apple", "perfect", null, StockType.FOOD);
		Compartment regular1 = new Compartment("Boxes", 30, false);
		Compartment regular2 = new Compartment("Shelves", 30, false);
		Compartment special1 = new Compartment("Flammable Storage", 25, true);
		Compartment special2 = new Compartment("Liquid Storage", 25, true);
		Compartment special3 = new Compartment("Perishable Storage", 25, true);
		regular1.addStock(stock);
		regular2.addStock(stock3);
		special2.addStock(stock2);
		
		this.compartments.add(regular1);
		this.compartments.add(regular2);
		this.compartments.add(special1);
		this.compartments.add(special2);
		this.compartments.add(special3);
	}
	
	/**
	 * Gets the list of inventory
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of inventory
	 */
	public ArrayList<Compartment> getCompartments() {
		return this.compartments;
	}
	
	/**
	 * Gets the normal storage names
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * @param compartments the compartments
	 * @return a list of normal storage compartment names
	 */
	public ArrayList<String> getNormalStorage(ArrayList<Compartment> compartments, Stock stock) {
		if (compartments == null) {
			throw new IllegalArgumentException("Compartments cannot be null");
		}
		
		ArrayList<String> compartmentNames = new ArrayList<String>();
		for (Compartment currentCompartment : compartments) {
			if (!currentCompartment.getIsSpecialQualitiesStorage()) {
				if (currentCompartment.getRemainingCapacity() >= stock.getQuantity()) {
				compartmentNames.add(currentCompartment.getName());
				}
			}
		}
		return compartmentNames;
	}
	
	/**
	 * Gets the special storage names that a stock can be stored in
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to be added
	 * @param compartments the compartments
	 * @return a list of special storage compartment names
	 */
	public ArrayList<String> getSpecialStorage(ArrayList<Compartment> compartments, Stock stock) {
		if (compartments == null) {
			throw new IllegalArgumentException("Compartments cannot be null");
		}
		if (stock == null) {
			throw new IllegalArgumentException("Stock cannot be null");
		}
		 
		ArrayList<String> compartmentNames = new ArrayList<String>();
		for (Compartment currentCompartment : compartments) {
			if (stock.isFlammable() && currentCompartment.getName().equals("Flammable Storage")) {
				if (currentCompartment.getRemainingCapacity() >= stock.getQuantity()) {
				compartmentNames.add(currentCompartment.getName());
				}
			}
			if (stock.isLiquid() && currentCompartment.getName().equals("Liquid Storage")) {
				if (currentCompartment.getRemainingCapacity() >= stock.getQuantity()) {
				compartmentNames.add(currentCompartment.getName());
				}
			}
			if (stock.isPerishable() && currentCompartment.getName().equals("Perishable Storage")) {
				if (currentCompartment.getRemainingCapacity() >= stock.getQuantity()) {
				compartmentNames.add(currentCompartment.getName());
				}
			}
		}
		return compartmentNames;
	}

}
