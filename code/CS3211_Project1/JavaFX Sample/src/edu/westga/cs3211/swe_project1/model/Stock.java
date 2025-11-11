package edu.westga.cs3211.swe_project1.model;

import java.util.HashSet;
import java.util.Set;

/**
 * The stock class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class Stock {
	private int quantity;
	private Set<SpecialQuality> specialQualities;
	private String name;
	private String condition;
	private String expirationDate;
	
	/**
	 * Creates a new instance of stock
	 * 
	 * @precondition quantity != 0 || name != null || condition != null || expirationDate != null || !name.isEmpty() || !name.isBlank()
	 * 					|| !condition.isEmpty() || !conditon.isBlank() || !expirationDate.isEmpty() || !expirationDate.isBlank()
	 * @postcondition none
	 * 
	 * @param quantity the quantity of the stock
	 * @param specialQualities the special qualities of the stock
	 * @param name the name of the stock
	 * @param condition the condition of the stock
	 * @param expirationDate the expiration date of the stock
	 */
	public Stock(int quantity, Set<SpecialQuality> specialQualities, String name, String condition, String expirationDate) {
		if (quantity == 0) { 
			throw new IllegalArgumentException("Quantity cannot be zero"); 
		}
		if (name == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (condition == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (name.isEmpty() || name.isBlank()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		if (condition.isEmpty() || condition.isBlank()) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		if (specialQualities.contains(SpecialQuality.PERISHABLE)) {
	        if (expirationDate == null || expirationDate.isBlank()) {
	            throw new IllegalArgumentException("Expiration date required for perishable items");
	        }
	    }
		
		this.quantity = quantity;
		this.specialQualities = new HashSet<>(specialQualities);
		this.name = name;
		this.condition = condition;
		this.expirationDate = expirationDate;
	}
	
	/**
	 * Gets the size of the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the size of the stock
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * Gets the stock's special qualities
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return true/false based on if the stock has special qualities
	 */
	public boolean getHasSpecialQualities() {
		return this.isFlammable() || this.isLiquid() || this.isPerishable();
	}
	
	/**
	 * Gets if the stock is flammable
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the stock is flammable
	 */
	public boolean isFlammable() {
		return this.specialQualities.contains(SpecialQuality.FLAMMABLE);
	}

	/**
	 * Gets if the stock is liquid
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the stock is liquid
	 */
	public boolean isLiquid() {
		return this.specialQualities.contains(SpecialQuality.LIQUID);
	}
	
	/**
	 * Gets if the stock is perishable
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the stock is perishable
	 */
	public boolean isPerishable() {
		return this.specialQualities.contains(SpecialQuality.PERISHABLE);
	}
	
	/**
	 * Gets the name of the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the stock
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the condition of the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the condition of the stock
	 */
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * Gets the expiration date of the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the expiration date of the stock
	 */
	public String getExpirationDate() {
		return this.expirationDate;
	}
}
