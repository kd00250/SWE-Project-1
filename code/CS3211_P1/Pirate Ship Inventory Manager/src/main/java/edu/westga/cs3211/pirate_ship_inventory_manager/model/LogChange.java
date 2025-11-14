package edu.westga.cs3211.pirate_ship_inventory_manager.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The log changes class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public class LogChange {
	private User user;
	private Stock stock;
	private Compartment compartment;
	String time;
	
	/**
	 * Creates a new instance of log change
	 * 
	 * @precondition user != null || stock != null || compartment != null
	 * @postcondition none
	 * 
	 * @param user the user that added the stock
	 * @param stock the stock that was added 
	 * @param compartment the compartment that the stock was added too
	 */
	public LogChange(User user, Stock stock, Compartment compartment) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		if (stock == null) {
			throw new IllegalArgumentException("Stock cannot be null");
		}
		if (compartment == null) {
			throw new IllegalArgumentException("Compartment cannot be null");
		}
		
		this.user = user;
		this.stock = stock;
		this.compartment = compartment;
		this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
	
	/**
	 * gets the user
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * gets the stock
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the stock
	 */
	public Stock getStock() {
		return this.stock;
	}
	
	/**
	 * gets the compartment 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the compartment
	 */
	public Compartment getCompartment() {
		return this.compartment;
	}
	
	/**
	 * gets the time 
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the time
	 */
	public String getTime() {
		return this.time;
	}
	
	@Override
	public String toString() {
		return "User: " + this.getUser().getUsername() + " (" + this.getUser().getRole() + ")\n" 
				+ "Stock Info: \n" + "Name: " + this.getStock().getName() + "\n" + "Quantity: " + this.getStock().getQuantity() + "\n"
				+ "Condition: " + this.getStock().getCondition() + "\n" + "Flammable: " + this.getStock().isFlammable() + "\n"
				+ "Liquid: " + this.getStock().isLiquid() + "\n" + "Perishable: " + this.getStock().isPerishable() + "\n" 
				+ "Expiration Date: " + this.getStock().getExpirationDate() + "\n" + "Storage Compartment: " + this.getCompartment().getName() + "\n"
				+ "Remaining Capacity: " + this.getCompartment().getRemainingCapacity() + "\n" 
				+ "Date Added: " + this.getTime();
	}
	
}

