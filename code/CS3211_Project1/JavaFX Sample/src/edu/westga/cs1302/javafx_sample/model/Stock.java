package edu.westga.cs1302.javafx_sample.model;

/**
 * The stock class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class Stock {
	private int size;
	private boolean hasSpecialQualities;
	private String name;
	private String condition;
	private String expirationDate;
	
	/**
	 * Creates a new instance of stock
	 * 
	 * @precondition size != 0 || name != null || condition != null || expirationDate != null || !name.isEmpty() || !name.isBlank()
	 * 					|| !condition.isEmpty() || !conditon.isBlank() || !expirationDate.isEmpty() || !expirationDate.isBlank()
	 * @postcondition none
	 * 
	 * @param size the size of the stock
	 * @param hasSpecialQualities the special qualities of the stock
	 * @param name the name of the stock
	 * @param condition the condition of the stock
	 * @param expirationDate the expiration date of the stock
	 */
	public Stock(int size, boolean hasSpecialQualities, String name, String condition, String expirationDate) {
		if (size == 0) {
			throw new IllegalArgumentException("Size cannot be zero");
		}
		if (name == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (condition == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (expirationDate == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		if (name.isEmpty() || name.isBlank()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		if (condition.isEmpty() || condition.isBlank()) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		if (expirationDate.isEmpty() || expirationDate.isBlank()) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		
		this.size = size;
		this.hasSpecialQualities = hasSpecialQualities;
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
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Gets is the stock has special qualities
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return if the stock has special qualities
	 */
	public boolean getHasSpecialQualities() {
		return this.hasSpecialQualities;
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
