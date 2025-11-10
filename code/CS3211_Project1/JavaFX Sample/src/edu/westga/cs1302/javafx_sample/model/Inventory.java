package edu.westga.cs1302.javafx_sample.model;

import java.util.ArrayList;

/**
 * The Inventory class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class Inventory {
	private static final int STORAGE_LIMIT = 100;
	private static final int SPECIAL_STORAGE_LIMIT = 25;
	private ArrayList<Stock> storage;
	
	/**
	 * Creates a new instance of inventory
	 */
	public Inventory() {
		this.storage = new ArrayList<Stock>();
	}
	
	/**
	 * Gets the list of inventory
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of inventory
	 */
	public ArrayList<Stock> getInventory() {
		return this.storage;
	}
	
	/**
	 * Determines if the storage has free space for stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to see if there is space for it
	 * 
	 * @return true/false depending on if the inventory has space for stocks
	 */
	public boolean hasFreeSpace(Stock stock) {
		int storageTotal = 0;
		for (Stock currentStock : this.storage) {
			storageTotal += currentStock.getSize();
		}
		storageTotal += stock.getSize();
		return storageTotal < STORAGE_LIMIT;
	}
	
	/**
	 * Determines if the storage has free space for stock with special qualities
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param stock the stock to see if there is space for it
	 * 
	 * @return true/false depending on if the inventory has space for special quality stocks
	 */
	public boolean hasSpecialQualityFreeSpace(Stock stock) {
		int storageTotal = 0;
		for (Stock currentStock : this.storage) {
			storageTotal += currentStock.getSize();
		}
		storageTotal += stock.getSize();
		return storageTotal < SPECIAL_STORAGE_LIMIT;
		
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
		if (stock.getHasSpecialQualities()) {
			if (this.hasSpecialQualityFreeSpace(stock)) {
				this.storage.add(stock);
				return true;
			}
		} else {
			if (this.hasFreeSpace(stock)) {
				this.storage.add(stock);
				return true;
			}
		}
		
		return false;
		
	}

}
