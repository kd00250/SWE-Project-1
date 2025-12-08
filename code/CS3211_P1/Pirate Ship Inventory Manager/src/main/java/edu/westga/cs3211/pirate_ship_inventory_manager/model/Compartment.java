package edu.westga.cs3211.pirate_ship_inventory_manager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the list of stocks in the compartment
	 */
	public ArrayList<Stock> getStorage() {
		return this.storage;
	}
	
	/**
	 * Gets the name of the compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the compartment
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the capacity of the compartment
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the capacity of the compartment
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * gets the total remaining capacity
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the total remaining capacity
	 */
	public int getRemainingCapacity() {
		int total = 0;
		for (Stock currentStock : this.storage) {
			total += currentStock.getQuantity();
		}
		return this.getCapacity() - total;
	}
	
	/**
	 * Gets if the compartment is special qualities storage or not
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true/false depending on if the compartment is special qualities storage
	 */
	public boolean getIsSpecialQualitiesStorage() {
		return this.isSpecialQualitiesStorage;
	}
	
	/**
	 * Checks if there is free space for the stock
	 *
	 * @precondition stock != null
	 * @postcondition none
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
		 * Adds stock to the compartment
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

			if (stock.getHasSpecialQualities() != this.isSpecialQualitiesStorage) {
				return false; 
			}

			if (!this.hasFreeSpace(stock)) {
				return false; 
			}
			this.storage.add(stock);
			return true;
		}
		
		/**
		 * removes the desired quantity from the compartment
		 * 
		 * @precondition stock != null || quantityToRemove > 0
		 * @postcondition none
		 * 
		 * @param stock the stock to be removed
		 * @param quantityToRemove quantity of the stock to be removed
		 * @return true/false depending on if the stock was removed
		 * 
		 */
		public boolean removeStock(Stock stock, int quantityToRemove) {
			if (stock == null) {
				throw new IllegalArgumentException("Stock cannot be null");
			}
			if (quantityToRemove <= 0) {
				throw new IllegalArgumentException("Quantity must be greater than 0");
			}
			
			Stock stockToRemove = null;
			for (Stock currentStock : this.getStorage()) {
				if (currentStock.getName().equals(stock.getName())) {
					stockToRemove = currentStock;
				}
			}
			
			if (stockToRemove == null) {
				return false;
			}
			
			if (stockToRemove.getQuantity() < quantityToRemove) {
				return false;
			}
			
			if (quantityToRemove == stockToRemove.getQuantity()) {
				this.storage.remove(stockToRemove);
			} else {
				stockToRemove.setQuantity(stockToRemove.getQuantity() - quantityToRemove);
			}
			
			return true;	
		}
		
		/**
		 * Gets the stock of given type.
		 * @param type the type
		 * @return A list of all stock items of given type
		 */
		public List<Stock> getStockOfType(StockType type) {
			if (type == null) {
				throw new IllegalArgumentException("Type cannot be null");
			}
			return this.storage.stream().filter(stock -> stock.getType() == type).collect(Collectors.toList());
		}
		
		/**
		 * Checks if container contains StockType
		 * 
		 * @precondition none
		 * @postcondition none
		 * 
		 * @param type the StockType
		 * @return True if contains Stock of StockType, false otherwise.
		 */
		public boolean doesContainStockOfType(StockType type) {
			for (var currStock : this.storage) {
				if (currStock.getType().equals(type)) {
					return true;
				}
			}
			return false;
		}
}
