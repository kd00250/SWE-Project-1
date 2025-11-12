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
		Compartment special1 = new Compartment("Special Storage 1", 15, true);
		Compartment special2 = new Compartment("Special Storage 2", 15, true);
		
		this.compartments.add(regular1);
		this.compartments.add(regular2);
		this.compartments.add(special1);
		this.compartments.add(special2);
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

}
