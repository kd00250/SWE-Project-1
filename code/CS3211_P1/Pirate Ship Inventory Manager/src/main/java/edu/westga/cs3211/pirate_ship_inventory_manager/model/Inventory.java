package edu.westga.cs3211.pirate_ship_inventory_manager.model;

import java.util.ArrayList;

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
		Compartment regular1 = new Compartment("Boxes", 10, false);
		Compartment regular2 = new Compartment("Shelves", 10, false);
		Compartment special1 = new Compartment("Flammable Storage", 15, true);
		Compartment special2 = new Compartment("Liquid Storage", 15, true);
		Compartment special3 = new Compartment("Perishable Storage", 15, true);
		
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
	 * @param compartments the compartments
	 * @return a list of normal storage compartment names
	 */
	public ArrayList<String> getNormalStorage(ArrayList<Compartment> compartments) {
		if (compartments == null) {
			throw new IllegalArgumentException("Compartments cannot be null");
		}
		
		ArrayList<String> compartmentNames = new ArrayList<String>();
		for (Compartment currentCompartment : compartments) {
			if (!currentCompartment.getIsSpecialQualitiesStorage()) {
				compartmentNames.add(currentCompartment.getName());
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
				compartmentNames.add(currentCompartment.getName());
			}
			if (stock.isLiquid() && currentCompartment.getName().equals("Liquid Storage")) {
				compartmentNames.add(currentCompartment.getName());
			}
			if (stock.isPerishable() && currentCompartment.getName().equals("Perishable Storage")) {
				compartmentNames.add(currentCompartment.getName());
			}
		}
		return compartmentNames;
	}

}
