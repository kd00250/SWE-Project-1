package edu.westga.cs3211.pirate_ship_inventory_manager.model;

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
	private StockType type;

	/**
	 * Creates a new instance of stock
	 * 
	 * @precondition quantity != 0 || name != null || condition != null ||
	 *               expirationDate != null || !name.isEmpty() || !name.isBlank() ||
	 *               !condition.isEmpty() || !conditon.isBlank() ||
	 *               !expirationDate.isEmpty() || !expirationDate.isBlank()
	 * @postcondition none
	 * 
	 * @param quantity         the quantity of the stock
	 * @param specialQualities the special qualities of the stock
	 * @param name             the name of the stock
	 * @param condition        the condition of the stock
	 * @param expirationDate   the expiration date of the stock
	 */
	public Stock(int quantity, Set<SpecialQuality> specialQualities, String name, String condition,
			String expirationDate) {
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
		this.type = StockType.DEFAULT;
	}

	/**
	 * Initializes a stock with various properties.
	 * 
	 * @param quantity         the quantity
	 * @param specialQualities the special qualities
	 * @param name             the name
	 * @param condition        the condition
	 * @param expirationDate   the expiration date
	 * @param type             the type
	 */
	public Stock(int quantity, Set<SpecialQuality> specialQualities, String name, String condition,
			String expirationDate, StockType type) {
		this(quantity, specialQualities, name, condition, expirationDate);
		if (type == null) {
			throw new IllegalArgumentException("Stock type cannot be null");
		}
		this.type = type;
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

	/**
	 * Gets the stock type.
	 * @return the type
	 */
	public StockType getType() {
		return this.type;
	}

	/**
	 * Sets the stock type.
	 * @param type the type
	 */
	public void setType(StockType type) {
		if (type == null) {
			throw new IllegalArgumentException("Stock type cannot be null");
		}
		this.type = type;
	}

	/**
	 * Sets the quantity of the stock
	 * 
	 * @precondition quantity > 0
	 * @postcondition none
	 * 
	 * @param quantity the new quantity of the stock
	 */
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return (this.getName() + " Quantity: " + this.getQuantity());
	}
}
