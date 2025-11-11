package edu.westga.cs3211.swe_project1.model;

import java.util.ArrayList;

/**
 * The compartment class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class Compartment {
	private ArrayList<Stock> storage;
	private String name;
	private boolean isSpecialQualitiesStorage;
	private int capacity;
	
	/**
	 * Creates a new instance of Compartment
	 * 
	 * @precondition capacity != 0 
	 * @postcondition none
	 * 
	 * @param name the name of the compartment
	 * @param capacity the capacity of the compartment
	 * @param isSpecialQualitiesStorage if the compartment is able to hold items with special qualities
	 */
	public Compartment(String name, int capacity, boolean isSpecialQualitiesStorage) {
		if (capacity == 0) {
			throw new IllegalArgumentException("Capacity cannot be null");
		}
		
		this.name = name;
		this.storage = new ArrayList<Stock>();
		this.isSpecialQualitiesStorage = isSpecialQualitiesStorage;
		this.capacity = capacity;
	}
	
	/**
	 * Gets the list of stocks in the compartment
	 * 
	 * @return the list of stocks in the compartment
	 */
	public ArrayList<Stock> getStorage() {
		return this.storage;
	}
	
	/**
	 * Gets the name of the compartment
	 * 
	 * @return the name of the compartment
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the capacity of the compartment
	 * 
	 * @return the capacity of the compartment
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * Gets if the compartment is special qualities storage or not
	 * 
	 * @return true/false depending on if the compartment is special qualities storage
	 */
	public boolean getIsSpecialQualitiesStorage() {
		return this.isSpecialQualitiesStorage;
	}
	
	/**
	 * Checks if there is free space for the stock
	 *
	 * @param stock the stock to check space for
	 * @return true if there is space, false otherwise
	 */
	public boolean hasFreeSpace(Stock stock) {
	    int currentQuantity = 0;
	    for (Stock currentStock : this.storage) {
	        currentQuantity += currentStock.getQuantity(); 
	    }
	    
	    return (currentQuantity + stock.getQuantity()) <= this.capacity;
	}
		
		/**
		 * Adds stock to the inventory
		 * 
		 * @precondition stock != null
		 * @postcondition none
		 * 
		 * @param stock the stock to be added 
		 * @return true/false depending on if the stock was added 
		 */
		public boolean addStock(Stock stock) {
			if (stock == null) {
				throw new IllegalArgumentException("Stock cannot be null");
			}

			if (stock.getHasSpecialQualities() && !this.isSpecialQualitiesStorage) {
				return false; 
			}

			if (!this.hasFreeSpace(stock)) {
				return false; 
			}
			this.storage.add(stock);
			return true;
		}
}
