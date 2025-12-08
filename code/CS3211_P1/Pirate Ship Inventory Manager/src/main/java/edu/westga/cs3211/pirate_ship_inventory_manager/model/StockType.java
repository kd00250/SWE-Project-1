package edu.westga.cs3211.pirate_ship_inventory_manager.model;

/**
 * Defines the range of valid stock types.
 * 
 * @author CS3211
 * @version Fall 2025
 */
public enum StockType {
	DEFAULT("Default"), FOOD("Food"), MUNITION("Munition");

	private final String name;

	StockType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
