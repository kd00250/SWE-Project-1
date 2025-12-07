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
	//private String time;
	private String date;
	private String time;
	private ChangeAction action;
	
	/**
	 * Creates a new instance of log change (defaults to ADDED action)
	 * 
	 * @precondition user != null || stock != null || compartment != null
	 * @postcondition none
	 * 
	 * @param user the user that added the stock
	 * @param stock the stock that was added 
	 * @param compartment the compartment that the stock was added too
	 */
	public LogChange(User user, Stock stock, Compartment compartment) {
		this(user,  stock,  compartment, ChangeAction.ADDED);
	}
	
	/**
	 * Creates a new instance of log change
	 * 
	 * @precondition user != null || stock != null || compartment != null
	 * @postcondition none
	 * 
	 * @param user the user that added the stock
	 * @param stock the stock that was added 
	 * @param compartment the compartment that the stock was added too
	 * @param action the action of the log change 
	 */
	public LogChange(User user, Stock stock, Compartment compartment, ChangeAction action) {
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
		//this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		this.action = action;
	}
	
	/**
	 * Gets the action of the log change
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the change action
	 */
	public ChangeAction getAction() {
		return this.action;
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
	public String getDate() {
		return this.date;
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
	
	/**
	 * sets the date (for testing purposes only)
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param date the date that the log
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Gets the display string for an individual change
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the string that displays a single list change
	 */
	public String getDisplayString() {
		String stockInfo = "(" + this.getAction() + ") " + this.getStock().getName() + ": " + this.getStock().getQuantity();
	    return String.format("%-40s %s", stockInfo, this.getUser().getUsername());
	}
	
	@Override
	public String toString() {
		return "User: " + this.getUser().getUsername() + " (" + this.getUser().getRole() + ")\n" 
				+ "Stock Info: \n" + "Name: " + this.getStock().getName() + "\n" + "Quantity: " + this.getStock().getQuantity() + "\n"
				+ "Condition: " + this.getStock().getCondition() + "\n" + "Flammable: " + this.getStock().isFlammable() + "\n"
				+ "Liquid: " + this.getStock().isLiquid() + "\n" + "Perishable: " + this.getStock().isPerishable() + "\n" 
				+ "Expiration Date: " + this.getStock().getExpirationDate() + "\n" + "Storage Compartment: " + this.getCompartment().getName() + "\n"
				+ "Remaining Capacity: " + this.getCompartment().getRemainingCapacity() + "\n" 
				+ "Date Added: " + this.getDate();
	}
	
}

